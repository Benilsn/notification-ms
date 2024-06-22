package br.com.reykon.notification_ms.exception;

import com.twilio.exception.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class NotificationErrorHandler {

  @ExceptionHandler(NotificationException.class)
  public ResponseEntity<?> handleNotificationException(NotificationException e, HttpServletRequest request) {

    var errorResponse = new ErrorResponse(
            e.getErrorCode(),
            e.getMessage(),
            request.getServletPath());

    logError(e.getMessage());
    return new ResponseEntity<>(errorResponse, e.getErrorCode());
  }

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<?> handleApiException(ApiException e, HttpServletRequest request) {
    var errorStatusCode = HttpStatusCode.valueOf(e.getStatusCode());

    var errorResponse = new ErrorResponse(
            errorStatusCode,
            String.valueOf(e.getCode()),
            e.getMessage(),
            request.getServletPath());

    logError(e.getMessage());
    return new ResponseEntity<>(errorResponse, errorStatusCode);
  }

  private void logError(String errorMsg) {
    log.error("Error sending notification: {}", errorMsg);
  }
}
