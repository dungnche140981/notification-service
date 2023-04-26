package vn.fpt.edu.notification.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.notification.dto.request.RegisterDeviceTokenRequest;
import vn.fpt.edu.notification.entity.DeviceToken;
import vn.fpt.edu.notification.repository.DeviceTokenRepository;
import vn.fpt.edu.notification.service.ClientService;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:35
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final DeviceTokenRepository deviceTokenRepository;

    @Override
    public void registerDeviceToken(RegisterDeviceTokenRequest request) {
        DeviceToken deviceToken = deviceTokenRepository.findFirstByUserId(request.getUserId())
                .orElse(new DeviceToken());
        deviceToken.setUserId(request.getUserId());
        deviceToken.setToken(request.getDeviceToken());

        deviceTokenRepository.save(deviceToken);
    }
}
