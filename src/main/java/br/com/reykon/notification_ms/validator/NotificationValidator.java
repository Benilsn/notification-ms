package br.com.reykon.notification_ms.validator;

import br.com.reykon.notification_ms.config.EmailSenderConfig;
import br.com.reykon.notification_ms.config.SmsSenderConfig;
import br.com.reykon.notification_ms.exception.NotificationException;
import br.com.reykon.notification_ms.model.NotificationDto;
import br.com.reykon.notification_ms.model.NotificationType;
import br.com.reykon.notification_ms.service.NotificationService;
import br.com.reykon.notification_ms.service.impl.EmailNotificationService;
import br.com.reykon.notification_ms.service.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class NotificationValidator {

  private final EmailSenderConfig emailSenderConfig;
  private final SmsSenderConfig smsSenderConfig;

  @Autowired
  public NotificationValidator(EmailSenderConfig emailSenderConfig, SmsSenderConfig smsSenderConfig) {
    this.emailSenderConfig = emailSenderConfig;
    this.smsSenderConfig = smsSenderConfig;
  }

  public NotificationService validate(NotificationDto input) {
    NotificationService service = null;

    if (input.getType() == NotificationType.EMAIL) {
      boolean validEmail = input.getSendTo().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

      if (validEmail) {
        service = new EmailNotificationService(emailSenderConfig.getJavaMailSender());
      } else {
        throw new NotificationException("Invalid email!", HttpStatus.BAD_REQUEST);
      }
    } else if (input.getType() == NotificationType.SMS) {
      boolean validPhoneNumber = input.getSendTo().matches("^\\+?[1-9]\\d{1,14}$");

      if (validPhoneNumber) {
        service = new SmsNotificationService(smsSenderConfig);
      } else {
        throw new NotificationException("Invalid phone number!", HttpStatus.BAD_REQUEST);
      }
    } else {
      throw new NotificationException("Invalid notification type: " + input.getType() + "it's either EMAIL or SMS!", HttpStatus.BAD_REQUEST);
    }

    return service;
  }
}
