package br.com.reykon.notificaton_ms.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1/notify")
public class NotifyController {

    @GetMapping
    public String get() {
        return "Notified!";
    }

}
