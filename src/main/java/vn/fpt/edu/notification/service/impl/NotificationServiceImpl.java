package vn.fpt.edu.notification.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;
import vn.fpt.edu.notification.dto.request.SendNotificationRequest;
import vn.fpt.edu.notification.entity.Connector;
import vn.fpt.edu.notification.entity.DeviceToken;
import vn.fpt.edu.notification.entity.NotificationHistory;
import vn.fpt.edu.notification.exception.BusinessException;
import vn.fpt.edu.notification.repository.ConnectorRepository;
import vn.fpt.edu.notification.repository.DeviceTokenRepository;
import vn.fpt.edu.notification.repository.NotificationHistoryRepository;
import vn.fpt.edu.notification.service.NotificationService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:41
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final ConnectorRepository connectorRepository;
    private final DeviceTokenRepository deviceTokenRepository;
    private final NotificationHistoryRepository notificationHistoryRepository;

    @Override
    public void sendNotification(SendNotificationRequest request) {
        DeviceToken deviceToken = deviceTokenRepository.findFirstByUserId(request.getUserId())
                .orElseThrow();
        Connector connector = connectorRepository.findByCode("FCM")
                .orElseThrow();
        FirebaseMessaging firebaseMessaging;
        try {
            firebaseMessaging = initFirebaseConnection(connector);
        } catch (Exception e) {
            log.error("Initialization failed Firebase connection: {}", e.getMessage());
            throw new BusinessException(ResponseStatusEnum.INTERNAL_SERVER_ERROR, "Error initializing Firebase connection");
        }
        boolean isSuccess = true;
        try {
            firebaseMessaging.send(Message.builder()
                    .putAllData(new HashMap<>())
                    .setNotification(
                            Notification.builder()
                                    .setTitle(request.getTitle())
                                    .setBody(request.getBody())
                                    .setImage(request.getImage())
                                    .build())
                    .setToken(deviceToken.getToken())
                    .setApnsConfig(ApnsConfig.builder()
                            .setAps(
                                    Aps.builder()
                                            .setMutableContent(true)
                                            .build()
                            )
                            .build())
                    .build());
        } catch (Exception e) {
            log.error("Can't send notification to FCM: {}", e.getMessage());
            isSuccess = false;
        }
        NotificationHistory notificationHistory = NotificationHistory.builder()
                .connectorId(connector.getId())
                .title(request.getTitle())
                .message(request.getBody())
                .image(request.getImage())
                .userId(request.getUserId())
                .status(isSuccess)
                .createdDate(LocalDateTime.now())
                .build();

        notificationHistoryRepository.save(notificationHistory);
    }

    private FirebaseMessaging initFirebaseConnection(Connector connector) {
        if (checkFirebaseInstanceNotExist(connector.getCode())) {
            log.info("SDK config: {}", connector.getSdkConfiguration());
            try (InputStream configInputStream = new ByteArrayInputStream(connector.getSdkConfiguration().getBytes(StandardCharsets.UTF_8))) {
                FirebaseOptions firebaseOptions = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(configInputStream))
                        .build();
                FirebaseApp.initializeApp(firebaseOptions, connector.getCode());
            } catch (Exception e) {
                log.error("Could not config firebase: {}", e.getMessage());
            }
        }
        return FirebaseMessaging.getInstance(FirebaseApp.getInstance(connector.getCode()));
    }

    private boolean checkFirebaseInstanceNotExist(String code) {
        try {
            FirebaseApp.getInstance(code);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
