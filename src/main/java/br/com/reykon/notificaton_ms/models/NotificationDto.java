package br.com.reykon.notificaton_ms.models;

public record NotificationDto(NotificationType type, String sendTo, String message) {
}
