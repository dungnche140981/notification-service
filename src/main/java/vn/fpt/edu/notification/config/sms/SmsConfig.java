package vn.fpt.edu.notification.config.sms;

import com.twilio.Twilio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:18
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@ConfigurationProperties(prefix = "app.sms")
@Setter
@Getter
@Configuration
public class SmsConfig {

    private String accountSid;
    private String authToken;

    @Bean
    public void initTwilio(){
        Twilio.init(accountSid, authToken);
    }
}
