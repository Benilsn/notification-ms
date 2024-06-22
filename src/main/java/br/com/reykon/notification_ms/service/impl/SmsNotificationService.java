package br.com.reykon.notification_ms.service.impl;

import br.com.reykon.notification_ms.config.SmsSenderConfig;
import br.com.reykon.notification_ms.model.NotificationDto;
import br.com.reykon.notification_ms.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsNotificationService implements NotificationService {

  private final SmsSenderConfig senderConfig;

  @Autowired
  public SmsNotificationService(SmsSenderConfig senderConfig) {
    this.senderConfig = senderConfig;
  }

  @Override
  public void notify(NotificationDto input) {
    final String PLUS = "+";

    log.info("Sending SMS...");
    senderConfig.send(
            PLUS.concat("14696851949"),
            PLUS.concat(input.getSendTo()),
            input.getText());
  }
}
