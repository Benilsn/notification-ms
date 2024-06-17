package br.com.reykon.notification_ms.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "notification.email.config")
public class NotificationConfig {

    private String username;
    private String password;
    private String host;
    private Integer port;
    private String protocol;
    private String smtpAuth;
    private String starttlsEnabled;
    private String debug;

//  @Getter
//  @Setter
//  public static class Credentials {
//  }
//
//  @Getter
//  @Setter
//  public static class Server {
//  }
}