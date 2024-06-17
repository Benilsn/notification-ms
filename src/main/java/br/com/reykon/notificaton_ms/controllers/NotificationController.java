package br.com.reykon.notificaton_ms.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.reykon.notificaton_ms.models.NotificationDto;
import br.com.reykon.notificaton_ms.services.NotificationService;
import br.com.reykon.notificaton_ms.strategy.NotificationStrategy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1")
public class NotificationController {

    private NotificationService service;

    @PostMapping("/notify")
    public ResponseEntity<?> notify(@RequestBody NotificationDto input) {
        ResponseEntity<?> response;
        service = NotificationStrategy.getStrategy(input.type());

        try {
            service.notify();
            response = ResponseEntity.noContent().build();
        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return response;
    }

}
