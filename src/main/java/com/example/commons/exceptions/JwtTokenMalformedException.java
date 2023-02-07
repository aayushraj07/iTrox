package com.example.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.naming.AuthenticationException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class JwtTokenMalformedException extends AuthenticationException {

  private static final long serialVersionUID = 1L;

  public JwtTokenMalformedException(String msg) {
    super(msg);
  }
}
