package br.com.reykon.notification_ms.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class NotificationDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 59881906946686945L;

    private String sendTo;
    private String subject;
    private String text;
    private NotificationType type;
}
