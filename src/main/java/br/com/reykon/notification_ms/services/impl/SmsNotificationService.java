package br.com.reykon.notification_ms.services.impl;

import br.com.reykon.notification_ms.config.SmsSenderConfig;
import br.com.reykon.notification_ms.models.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import br.com.reykon.notification_ms.services.NotificationService;

@Slf4j
@Service
public class SmsNotificationService implements NotificationService {

  private final SmsSenderConfig senderConfig;
  private final String PLUS = "+";

  public SmsNotificationService(SmsSenderConfig senderConfig) {
    this.senderConfig = senderConfig;
  }

  @Override
  public void notify(NotificationDto input) {
    log.info("Sending SMS...");
    senderConfig.send(PLUS.concat(input.getSendTo()), PLUS.concat("14696851949"), input.getText());
  }
}
