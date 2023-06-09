package vn.fpt.edu.notification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:18
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SendSmsRequest {

    private String phoneNumber;
    private String message;
}
