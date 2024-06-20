package br.com.reykon.notification_ms.config;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class SmsSenderConfig {

  private final NotificationConfig notificationConfig;

  public SmsSenderConfig(NotificationConfig notificationConfig) {
    this.notificationConfig = notificationConfig;
  }

  public void send(String from, String to, String msg) {

    Twilio.init(notificationConfig.getSms().getAccount_sid(), notificationConfig.getSms().getAuth_token());

    Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), msg).create();
  }
}
