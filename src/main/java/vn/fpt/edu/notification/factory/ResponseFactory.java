package vn.fpt.edu.notification.factory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import vn.fpt.edu.notification.constant.ResponseStatusEnum;
import vn.fpt.edu.notification.dto.common.GeneralResponse;
import vn.fpt.edu.notification.dto.common.ResponseStatus;

import java.util.Objects;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:08
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Component
public class ResponseFactory {

 public <T> ResponseEntity<GeneralResponse<T>> response(T data, ResponseStatusEnum status, String message){
  ResponseStatus responseStatus = new ResponseStatus();
  responseStatus.setStatus(status.getStatus());
  responseStatus.setCode(status.getCode());
  if(Objects.nonNull(message)){
   responseStatus.setMessage(message);
  }

  return ResponseEntity
          .status(status.getStatus())
          .body(createResponse(data, responseStatus));
 }
 public <T> ResponseEntity<GeneralResponse<T>> response(T data, ResponseStatusEnum status){
  return response(data, status, null);
 }

 public <T> ResponseEntity<GeneralResponse<T>> response(T data){
  return response(data, ResponseStatusEnum.SUCCESS, null);
 }

 public ResponseEntity<GeneralResponse<Object>> response(ResponseStatusEnum status, String message){
  return response(null, status, message);
 }

 public ResponseEntity<GeneralResponse<Object>> response(ResponseStatusEnum status){
  return response(null, status, null);
 }

 private <T> GeneralResponse<T> createResponse(T data, ResponseStatus status){
  GeneralResponse<T> generalResponse = new GeneralResponse<>();
  generalResponse.setStatus(status);
  generalResponse.setData(data);
  return generalResponse;
 }
}

