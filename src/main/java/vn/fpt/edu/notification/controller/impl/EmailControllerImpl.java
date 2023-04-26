package vn.fpt.edu.notification.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;
import vn.fpt.edu.notification.controller.EmailController;
import vn.fpt.edu.notification.dto.common.GeneralResponse;
import vn.fpt.edu.notification.dto.request.SendEmailRequest;
import vn.fpt.edu.notification.factory.ResponseFactory;
import vn.fpt.edu.notification.service.EmailService;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:18
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@RestController
@RequiredArgsConstructor
public class EmailControllerImpl implements EmailController {

    private final ResponseFactory responseFactory;
    private final EmailService emailService;

    @Override
    public ResponseEntity<GeneralResponse<Object>> sendEmail(SendEmailRequest request) {
        emailService.sendEmail(request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }
}
