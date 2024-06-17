package br.com.reykon.notification_ms.controllers;

import br.com.reykon.notification_ms.services.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.reykon.notification_ms.models.NotificationDto;
import br.com.reykon.notification_ms.services.NotificationService;
import br.com.reykon.notification_ms.strategy.NotificationStrategy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/v1/notify")
    public ResponseEntity<?> notify(@RequestBody NotificationDto input) {
        ResponseEntity<?> response;
        service = NotificationStrategy.getStrategy(input.getType());

        try {
            service.notify(input);
            response = ResponseEntity.noContent().build();
        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return response;
    }

    @PostMapping("/v1/get")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok().body("Test");
    }

}
