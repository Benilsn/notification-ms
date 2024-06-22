package br.com.reykon.notification_ms.config;

import br.com.reykon.notification_ms.exception.NotificationException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsSenderConfig {

  private final NotificationConfig notificationConfig;

  public SmsSenderConfig(NotificationConfig notificationConfig) {
    this.notificationConfig = notificationConfig;
  }

  public void send(String fromNumber, String toNumber, String textToSend) {

    Twilio.init(
            notificationConfig.getSms().getAccount_sid(),
            notificationConfig.getSms().getAuth_token());

    var msg = Message.creator(
            new PhoneNumber(toNumber),
            new PhoneNumber(fromNumber),
            textToSend).create();


    if (msg.getErrorCode() == null && msg.getErrorMessage() == null) {
      log.info("SMS sent successfully!");
    } else {
      throw new NotificationException(msg.getErrorMessage(), HttpStatus.resolve(msg.getErrorCode()));
    }
  }
}
