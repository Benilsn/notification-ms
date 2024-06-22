package br.com.reykon.notification_ms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class NotificationException extends RuntimeException {

  private final String message;
  private final HttpStatusCode errorCode;

  public NotificationException(String message, HttpStatusCode errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }
}
