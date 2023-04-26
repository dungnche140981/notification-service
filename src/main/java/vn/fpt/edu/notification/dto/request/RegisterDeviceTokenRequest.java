package vn.fpt.edu.notification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 12/04/2023 - 00:29
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterDeviceTokenRequest {

    private String userId;
    private String deviceToken;
}
