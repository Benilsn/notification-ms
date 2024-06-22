package br.com.reykon.notification_ms.controller;

import br.com.reykon.notification_ms.exception.NotificationException;
import br.com.reykon.notification_ms.model.NotificationDto;
import br.com.reykon.notification_ms.service.NotificationService;
import br.com.reykon.notification_ms.validator.NotificationValidator;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RateLimiter(name = "notification-limiter", fallbackMethod = "fallback")
public class NotificationController {

  private final NotificationValidator notificationValidator;

  @Autowired
  public NotificationController(NotificationValidator notificationValidator) {
    this.notificationValidator = notificationValidator;
  }


  @PostMapping("/v1/notify")
  public ResponseEntity<?> notify(@RequestBody NotificationDto input) {
    NotificationService service = notificationValidator.validate(input);

    service.notify(input);

    return ResponseEntity.noContent().build();
  }

  private void fallback(){
    throw new NotificationException("Fallback while trying to request", HttpStatus.TOO_MANY_REQUESTS);
  }

}
