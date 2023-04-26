package vn.fpt.edu.notification.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;

import java.time.LocalDateTime;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:05
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {
    private Integer status;
    private String code;
    private String message;
    private String displayMessage;
    private LocalDateTime responseDate;

    public ResponseStatus(Integer status, String code) {
        this.status = status;
        this.code = code;
        this.message = null;
        this.displayMessage = null;
        this.responseDate = LocalDateTime.now(LocaleContextHolder.getTimeZone().toZoneId());
    }

    public ResponseStatus(Integer status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.displayMessage = null;
        this.responseDate = LocalDateTime.now(LocaleContextHolder.getTimeZone().toZoneId());
    }

    public ResponseStatus(ResponseStatusEnum statusEnum) {
        this.status = statusEnum.getStatus();
        this.code = statusEnum.getCode();
        this.message = null;
        this.displayMessage = null;
        this.responseDate = LocalDateTime.now(LocaleContextHolder.getTimeZone().toZoneId());
    }
}
