package br.com.reykon.notification_ms.service;

import br.com.reykon.notification_ms.model.NotificationDto;

public interface NotificationService {

    void notify(NotificationDto input);
}
