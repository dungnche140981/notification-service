package vn.fpt.edu.notification.service;

import vn.fpt.edu.notification.dto.request.SendEmailRequest;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 12/04/2023 - 02:18
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
public interface EmailService {

    void sendEmail(SendEmailRequest request);
}
