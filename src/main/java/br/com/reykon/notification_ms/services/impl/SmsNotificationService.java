package br.com.reykon.notification_ms.services.impl;

import br.com.reykon.notification_ms.models.NotificationDto;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import br.com.reykon.notification_ms.services.NotificationService;

@Service
public class SmsNotificationService implements NotificationService {

  private final JavaMailSender mailSender;

  public SmsNotificationService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void notify(NotificationDto input) {

  }
}
