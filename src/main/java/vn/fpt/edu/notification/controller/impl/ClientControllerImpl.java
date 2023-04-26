package vn.fpt.edu.notification.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;
import vn.fpt.edu.notification.controller.ClientController;
import vn.fpt.edu.notification.dto.common.GeneralResponse;
import vn.fpt.edu.notification.dto.request.RegisterDeviceTokenRequest;
import vn.fpt.edu.notification.factory.ResponseFactory;
import vn.fpt.edu.notification.service.ClientService;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:01
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;
    private final ResponseFactory responseFactory;

    @Override
    public ResponseEntity<GeneralResponse<Object>> registerDeviceToken(RegisterDeviceTokenRequest request) {
        clientService.registerDeviceToken(request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }
}
