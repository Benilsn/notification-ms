package br.com.reykon.notification_ms.controllers;

import br.com.reykon.notification_ms.utils.NotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import br.com.reykon.notification_ms.models.NotificationDto;
import br.com.reykon.notification_ms.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NotificationController {

  private final NotificationUtils notificationUtils;

  @Autowired
  public NotificationController(NotificationUtils notificationUtils) {
    this.notificationUtils = notificationUtils;
  }

  @PostMapping("/v1/notify")
  public ResponseEntity<?> notify(@RequestBody NotificationDto input) {
    ResponseEntity<?> response;
    NotificationService service = notificationUtils.validateNotification(input);

    try {
      service.notify(input);
      response = ResponseEntity.noContent().build();
    } catch (Exception e) {
      response = ResponseEntity.internalServerError().body(e.getMessage());
    }

    return response;
  }

}
