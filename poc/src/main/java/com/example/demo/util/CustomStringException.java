package com.example.demo.util;;




public class CustomStringException extends BaseApplicationException {
	/**
   * 
   */
  private static final long serialVersionUID = 1L;


  public CustomStringException(String message, Throwable throwable) {
	    super(message, throwable);
	  }

	  public CustomStringException(String className, String message,
	                               String errorCode, Throwable throwable) {
	    super(className, message, errorCode, throwable);
	  }

	  public CustomStringException(String message, String className,
	                               String errorCode) {
	    super(message, className, errorCode);

	  }

	  public CustomStringException() {
	    super();
	  }

	  public CustomStringException(String className, String errorCode) {
	    super(className, errorCode);
	  }


	  public CustomStringException(String errorCode) {
	    super(errorCode);
	  }
}
