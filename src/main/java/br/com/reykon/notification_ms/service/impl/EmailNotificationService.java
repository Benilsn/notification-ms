package br.com.reykon.notification_ms.service.impl;

import br.com.reykon.notification_ms.model.NotificationDto;
import br.com.reykon.notification_ms.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotificationService implements NotificationService {

  private final JavaMailSender mailSender;

  @Autowired
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
