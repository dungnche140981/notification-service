package vn.fpt.edu.notification.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import vn.fpt.edu.notification.config.MailSenderConfig;
import vn.fpt.edu.notification.dto.request.SendEmailRequest;
import vn.fpt.edu.notification.service.EmailService;

import java.util.Objects;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 12/04/2023 - 02:19
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    @Value("${notification.mail.default}")
    private String mailDefault;

    @Override
    public void sendEmail(SendEmailRequest request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        if(Objects.nonNull(request.getBcc()))
            simpleMailMessage.setBcc(request.getBcc());
        if(Objects.nonNull(request.getCc()))
            simpleMailMessage.setCc(request.getCc());
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setFrom(mailDefault);
        simpleMailMessage.setText(request.getText());
        simpleMailMessage.setTo(request.getTo());
        try{
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            log.error("Failed to send simple mail: {}", e.getMessage());
        }
    }
}
