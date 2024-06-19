package br.com.reykon.notification_ms.utils;

import br.com.reykon.notification_ms.config.EmailSenderConfig;
import br.com.reykon.notification_ms.exception.NotificationException;
import br.com.reykon.notification_ms.models.NotificationDto;
import br.com.reykon.notification_ms.models.NotificationType;
import br.com.reykon.notification_ms.services.NotificationService;
import br.com.reykon.notification_ms.services.impl.EmailNotificationService;
import br.com.reykon.notification_ms.services.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationUtils {

  private final EmailSenderConfig emailSenderConfig;

  @Autowired
  public NotificationUtils(EmailSenderConfig emailSenderConfig) {
    this.emailSenderConfig = emailSenderConfig;
  }

  public NotificationService validateNotification(NotificationDto input) {
    NotificationService service = null;

    if (input.getType() == NotificationType.EMAIL) {
      boolean validEmail = input.getSendTo().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

      if (validEmail) {
        service = new EmailNotificationService(emailSenderConfig.getJavaMailSender());
      } else {
        throw new NotificationException("Invalid email!");
      }
    } else if (input.getType() == NotificationType.SMS) {
      boolean validPhoneNumber = input.getSendTo().matches("^\\+?[1-9]\\d{1,14}$\n");

      if (validPhoneNumber) {
        service = new SmsNotificationService(emailSenderConfig.getJavaMailSender());
      } else {
        throw new NotificationException("Invalid phone number!");
      }
    } else {
      throw new NotificationException("Invalid notification type: " + input.getType() + "it's either EMAIL or SMS!");
    }

    return service;
  }
}
