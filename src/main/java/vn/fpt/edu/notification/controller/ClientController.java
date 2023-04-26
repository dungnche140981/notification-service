package vn.fpt.edu.notification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpt.edu.notification.dto.common.GeneralResponse;
import vn.fpt.edu.notification.dto.request.RegisterDeviceTokenRequest;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:00
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@RequestMapping("${spring.application.name}/api/v1/clients")
public interface ClientController {

    @PostMapping("/device-token")
    ResponseEntity<GeneralResponse<Object>> registerDeviceToken(@RequestBody RegisterDeviceTokenRequest request);

}
