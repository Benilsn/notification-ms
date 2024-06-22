package br.com.reykon.notification_ms.controller;

import br.com.reykon.notification_ms.model.NotificationDto;
import br.com.reykon.notification_ms.service.NotificationService;
import br.com.reykon.notification_ms.validator.NotificationValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  private final NotificationValidator notificationValidator;

  public NotificationController(NotificationValidator notificationValidator) {
    this.notificationValidator = notificationValidator;
  }

  @PostMapping("/v1/notify")
  public ResponseEntity<?> notify(@RequestBody NotificationDto input) {
    NotificationService service = notificationValidator.validate(input);

    service.notify(input);

    return ResponseEntity.noContent().build();
  }

}
