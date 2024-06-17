package br.com.reykon.notification_ms.strategy;

import br.com.reykon.notification_ms.models.NotificationType;
import br.com.reykon.notification_ms.services.NotificationService;
import br.com.reykon.notification_ms.services.impl.EmailNotificationService;

public class NotificationStrategy {

    public static NotificationService getStrategy(NotificationType type) {

        if (type == NotificationType.SMS) {
            return null;
        } else {
            return new EmailNotificationService();
        }
    }
}