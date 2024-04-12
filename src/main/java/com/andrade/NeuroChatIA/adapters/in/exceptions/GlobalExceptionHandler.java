package com.andrade.NeuroChatIA.adapters.in.exceptions;

import com.andrade.NeuroChatIA.domain.excepion.ChampionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(ChampionNotFoundException.class)
  public ResponseEntity<ApiError> handleException(ChampionNotFoundException exp) {
    //return ResponseEntity.status(404).body(new ApiError(exp.getMessage()));
    return ResponseEntity.status(404).body(new ApiError(exp.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleException(Exception exp) {
    String message = "Ops! Something went wrong. Try again later!";
    logger.error(message, exp);
    return ResponseEntity
            .internalServerError()
            .body(new ApiError(message));
  }


  public record ApiError(String message) {
  }
}
