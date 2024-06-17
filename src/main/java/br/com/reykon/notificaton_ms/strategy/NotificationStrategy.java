package br.com.reykon.notificaton_ms.strategy;

import br.com.reykon.notificaton_ms.models.NotificationType;
import br.com.reykon.notificaton_ms.services.NotificationService;
import br.com.reykon.notificaton_ms.services.impl.EmailNotificationService;
import br.com.reykon.notificaton_ms.services.impl.SmsNotificationService;

public class NotificationStrategy {

    public static NotificationService getStrategy(NotificationType type) {

        if (type == NotificationType.SMS) {
            return new SmsNotificationService();
        } else {
            return new EmailNotificationService();
        }
    }
}