package br.com.reykon.notification_ms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class EmailSenderConfig {

    private final NotificationConfig notificationConfig;

    public EmailSenderConfig(NotificationConfig notificationConfig) {
        this.notificationConfig = notificationConfig;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(notificationConfig.getEmail().getHost());
        mailSender.setPort(notificationConfig.getEmail().getPort());

        mailSender.setUsername(notificationConfig.getEmail().getUsername());
        mailSender.setPassword(notificationConfig.getEmail().getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", notificationConfig.getEmail().getProtocol());
        props.put("mail.smtp.auth", notificationConfig.getEmail().getSmtpAuth());
        props.put("mail.smtp.starttls.enable", notificationConfig.getEmail().getStarttlsEnabled());
        props.put("mail.debug", notificationConfig.getEmail().getDebug());

        return mailSender;
    }

}