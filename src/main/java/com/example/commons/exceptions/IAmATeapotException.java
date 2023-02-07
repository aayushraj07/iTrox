package com.example.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IAmATeapotException extends RuntimeException {
  public IAmATeapotException(String message) {
    super(message);
  }
}
