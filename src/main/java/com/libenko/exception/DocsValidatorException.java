package com.libenko.exception;

public class DocsValidatorException extends RuntimeException {
  public DocsValidatorException() {
    super();
  }

  public DocsValidatorException(String message) {
    super(message);
  }

  public DocsValidatorException(String message, Throwable cause) {
    super(message, cause);
  }

  public DocsValidatorException(Throwable cause) {
    super(cause);
  }
}
