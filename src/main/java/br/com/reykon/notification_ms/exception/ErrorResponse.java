package br.com.reykon.notification_ms.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.time.Instant;

@Getter
public class ErrorResponse {

  private final Instant timestamp;

  private final HttpStatusCode status;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private final String error;

  private final String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private final String path;

  public ErrorResponse(HttpStatusCode status, String message) {
    this.timestamp = Instant.now();
    this.status = status;
    this.error = null;
    this.message = message;
    this.path = null;
  }


  public ErrorResponse(HttpStatusCode status, String message, String path) {
    this.timestamp = Instant.now();
    this.status = status;
    this.error = null;
    this.message = message;
    this.path = path;
  }

  public ErrorResponse(HttpStatusCode status, String error, String message, String path) {
    this.timestamp = Instant.now();
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }
}
