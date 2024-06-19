package br.com.reykon.notification_ms.services.impl;

import br.com.reykon.notification_ms.models.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import br.com.reykon.notification_ms.services.NotificationService;

@Slf4j
@Service
public class EmailNotificationService implements NotificationService {

  private final JavaMailSender mailSender;

  public EmailNotificationService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void notify(NotificationDto input) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom("noreply.notification.servic3@gmail.com");
      message.setTo(input.getSendTo());
      message.setSubject(input.getSubject());
      message.setText(input.getText());

      log.info("Sending email to: {} ...", input.getSendTo());
      mailSender.send(message);
      log.info("Email sent successfully");

    } catch (MailException e) {
      log.error("Error: {}, while sending email to: {}", e.getMessage(), input.getSendTo());
    }
  }

}
