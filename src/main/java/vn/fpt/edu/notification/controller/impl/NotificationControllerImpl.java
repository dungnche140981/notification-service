package vn.fpt.edu.notification.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;
import vn.fpt.edu.notification.controller.NotificationController;
import vn.fpt.edu.notification.dto.common.GeneralResponse;
import vn.fpt.edu.notification.dto.request.SendNotificationRequest;
import vn.fpt.edu.notification.factory.ResponseFactory;
import vn.fpt.edu.notification.service.NotificationService;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:18
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@RestController
@RequiredArgsConstructor
public class NotificationControllerImpl implements NotificationController {

    private final ResponseFactory responseFactory;
    private final NotificationService notificationService;

    @Override
    public ResponseEntity<GeneralResponse<Object>> sendNotification(SendNotificationRequest request) {
        notificationService.sendNotification(request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }


}
