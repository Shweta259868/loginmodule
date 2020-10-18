

package com.example.demo.util;


/**
 * Base exception for all the exceptions.
 * 
 * @author 
 *
 */
public class BaseApplicationException extends java.lang.Exception {


  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * <code>className</code> Stores class name
   * from where the constructor has been called.
   */
  private String className;
  /**
   * <code>errorCode</code> Stores the errorCode.
   */
  private String errorCode;
  /**
   * <code>nestedException</code> Stores nested Exception object.
   */
  private Exception nestedException;



  /**
   * Default constructor.
   */
  public BaseApplicationException() {
    super();
    this.className = this.getClass().getName();
    this.errorCode = null;
    nestedException = null;
    logInitialization(this.className, null, this);
  }


  /**
   * Constructor with errorCode parameter.
   * @param errorCode
   */
  public BaseApplicationException(String errorCode) {
    super(errorCode);
    this.className = this.getClass().getName();
    this.errorCode = errorCode;
    nestedException = null;
    logInitialization(this.className, errorCode, this);
  }


  /**
   * Constructor with className and errorCode as parameter.
   * @param className
   * @param errorCode
   */
  public BaseApplicationException(String className, String errorCode) {
    super(errorCode);
    this.className = className;
    this.errorCode = errorCode;
    nestedException = null;
    logInitialization(this.className, "The error code is " + errorCode, this);
  }


  /**
   * Constructor with className, message and errorCode as parameter.
   * @param className
   * @param message
   * @param errorCode
   */
  public BaseApplicationException(String className, String message,
                                  String errorCode) {
    super(message);
    this.className = className;
    this.errorCode = errorCode;
    nestedException = null;
    logInitialization(this.className, 
        "The error code is " + errorCode
         + " and message is " + message, this);
  }

  /**
   * Constructor with message and throwable as parameter.
   * @param message
   * @param throwable
   */
  public BaseApplicationException(String message, Throwable throwable) {
    super(message, throwable);
    this.className = this.getClass().getName();
    this.errorCode = null;
    nestedException = (Exception) throwable;
    logInitialization(this.className, message, throwable);
  }


  /**
   * Constructor with className, message, errorCode and throwable
   * as parameter.
   * @param className
   * @param message
   * @param errorCode
   * @param throwable
   */
  public BaseApplicationException(String className, String message,
                                  String errorCode, Throwable throwable) {
    super(message, throwable);
    this.className = className;
    this.errorCode = errorCode;
    nestedException = (Exception) throwable;
    logInitialization(this.className, 
            "The error code is " + errorCode
             + " and message is " + message, throwable);
  }


  /**
   * Returns error code.
   * @return errorCode
   */
  public String getCode() {
    return errorCode;
  }


  /**
   * Returns nestedException.
   * @return Exception
   */
  public Exception getNestedException() {
    return this.nestedException;
  }


  /**
   * This method is used to log whenever this class is instantiated.
   * @param className
   * @param stMessage
   * @param exception
   */
  private void logInitialization(String className, String stMessage,
                                 Throwable exception) {
    
  }


  /**
   * To set errorCode value.
   * @param code
   */
  public void setCode(String code) {
    this.errorCode = code;
  }

}

/*
 * Revision History
 * $Log
 */
