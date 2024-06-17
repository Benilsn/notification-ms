package br.com.reykon.notification_ms.services.impl;

import br.com.reykon.notification_ms.config.EmailSenderConfig;
import br.com.reykon.notification_ms.models.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import br.com.reykon.notification_ms.services.NotificationService;

@Service
public class EmailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void notify(NotificationDto input) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("benilson.smtr@gmail.com");
            message.setTo("benilson.smtr@gmail.com");
            message.setSubject("Test");
            message.setText("Test");
            mailSender.send(message);

        } catch (MailException e) {
            System.out.println(e.getCause());
        }
    }

}
