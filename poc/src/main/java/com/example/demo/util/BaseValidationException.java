
package com.example.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Base exception for all validation exceptions.
 * 
 * @author 
 */
public class BaseValidationException extends BaseApplicationException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private List messageList;

  public void finalize() throws Throwable {
    super.finalize();
  }

  /**
   * Default constructor.
   */
  public BaseValidationException() {
    super();
  }

  /**.
   * 
   * @param errorCode
   */
  public BaseValidationException(String errorCode) {
    super(errorCode);
  }

  /**.
   * 
   * @param className
   * @param errorCode
   */
  public BaseValidationException(String className, String errorCode) {
    super(className, errorCode);
  }

  /**
   * .
   * @param message
   * @param className
   * @param errorCode
   */
  public BaseValidationException(String className, String message, 
    String errorCode) {
    super(className, message, errorCode);
  }

  /**
   * .
   * @param message
   * @param throwable
   */
  public BaseValidationException(String message, Throwable throwable) {
    super(message, throwable);
  }

  /**.
   * 
   * @param className
   * @param message
   * @param errorCode
   * @param throwable
   */
  public BaseValidationException(String className, String message,
    String errorCode, Throwable throwable) {
    super(className, message, errorCode, throwable);
  }


  /**
   * Constructor with list of messages.
   * @param messageList
   */
  public BaseValidationException(List messageList) {
    super();
    setMessageList(messageList);
  }

  /**
   * Adds a message to the message list.
   * 
   * @param stMessage
   */
  public void addMessageList(String stMessage) {
    if (null == messageList) {
      messageList = new ArrayList();
    }
    messageList.add(stMessage);
  }

  /**
   * Adds a message to the message list with its params.
   * 
   * @param stMessage
   * @param obj1
   */
  public void addMessageList(String stMessage, Object[] obj) {
    if (null == messageList) {
      messageList = new ArrayList();
    }
    HashMap hmMessage = new HashMap();
    hmMessage.put(stMessage, obj);
    messageList.add(hmMessage);
  }

  /**
   * Returns the list of messages added to the validation error.
   * 
   * @return
   */
  public List getMessageList() {
    return messageList;
  }

  /**
   * .
   * 
   * @param list
   */
  public void setMessageList(List list) {
    this.messageList = list;
  }

}

/*
 * Revision History
 * 
 * $Log: 
 *
 */