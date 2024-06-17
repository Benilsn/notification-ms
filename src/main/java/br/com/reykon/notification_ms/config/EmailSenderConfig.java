package br.com.reykon.notification_ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class EmailSenderConfig {

    @Autowired
    private NotificationConfig config;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(config.getHost());
        mailSender.setPort(config.getPort());

        mailSender.setUsername(config.getUsername());
        mailSender.setPassword(config.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", config.getProtocol());
        props.put("mail.smtp.auth", config.getSmtpAuth());
        props.put("mail.smtp.starttls.enable", config.getStarttlsEnabled());
        props.put("mail.debug", config.getDebug());

        return mailSender;
    }

}