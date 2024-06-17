package br.com.reykon.notification_ms.services;

import br.com.reykon.notification_ms.models.NotificationDto;

public interface NotificationService {

    void notify(NotificationDto input);
}
