package org.example.util;


import java.util.function.Supplier;

/**
 * @author Lager.Tang create: 2022-05-01 00:27
 **/
public class NotFoundException extends RuntimeException implements Supplier<RuntimeException> {

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }

  public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  @Override
  public RuntimeException get() {
    return this;
  }
}
