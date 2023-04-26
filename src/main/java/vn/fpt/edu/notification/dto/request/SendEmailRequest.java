package vn.fpt.edu.notification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 12/04/2023 - 02:11
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SendEmailRequest {

    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String text;
}
