package vn.fpt.edu.notification.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;
import vn.fpt.edu.notification.dto.request.SendSmsRequest;
import vn.fpt.edu.notification.entity.SmsHistory;
import vn.fpt.edu.notification.exception.BusinessException;
import vn.fpt.edu.notification.repository.SmsHistoryRepository;
import vn.fpt.edu.notification.service.SmsService;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:18
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class SmsServiceImpl implements SmsService {

    private final SmsHistoryRepository smsHistoryRepository;

    @Override
    public void sendSms(SendSmsRequest request) {
        log.info("Sending SMS with request: {}", request);
        SmsHistory smsHistory = new SmsHistory();
        smsHistory.setMessage(request.getMessage());
        smsHistory.setPhoneNumber(request.getPhoneNumber());
        try {
            Message twilioMessage = Message.creator(
                            new com.twilio.type.PhoneNumber(request.getPhoneNumber()),
                            new com.twilio.type.PhoneNumber("+16318660844"),
                            request.getMessage())
                    .create();
            log.info("Send sms {} with sid: {}", twilioMessage.getStatus(), twilioMessage.getSid());
            smsHistory.setStatus("SUCCESS");
        } catch (Exception ex) {
            smsHistory.setStatus("FAILED");
            log.error("Sens sms error: {}", ex.getMessage());
        }finally {
            try {
                smsHistoryRepository.save(smsHistory);
            }catch (Exception ex){
                log.error("Can't save sms history to db: "+ ex.getMessage());
            }
        }
    }
}
