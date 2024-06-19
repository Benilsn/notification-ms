package br.com.reykon.notification_ms.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "notification.config")
public class NotificationConfig {

  private final Email email = new Email();
  private final Sms sms = new Sms();

  @Getter
  @Setter
  public static class Email {
    private String username;
    private String password;
    private String host;
    private Integer port;
    private String protocol;
    private String smtpAuth;
    private String starttlsEnabled;
    private String debug;
  }

  @Getter
  @Setter
  public static class Sms {
  }
}