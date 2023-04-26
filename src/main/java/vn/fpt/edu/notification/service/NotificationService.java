package vn.fpt.edu.notification.service;

import vn.fpt.edu.notification.dto.request.SendNotificationRequest;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:34
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
public interface NotificationService {

    void sendNotification(SendNotificationRequest request);
}
