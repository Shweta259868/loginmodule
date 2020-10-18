
package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class contains utility methods
 * @author 
 *
 */
public class CustomUtility {
	
	private static final String EMPTY_STR="";
  

  /**
   * Removes leading  zero and return the string.
   * @param str
   * @return
   */

  public static String removeLeadingZeros(String str) {
    if (str == null) {
      return null;
    }
    char[] chars = str.toCharArray();
    int index = 0;
    for (; index < str.length();index++) {
      if (chars[index] != '0') {
        break;
      }
    }
    return (index == 0) ? str :
      str.substring(index);
  }
  /**
   * convert string to PHXString type.
   * @param inString
   * @return
   */

  public static CustomString convertToPHXString(String inString){	 

    if (inString == null || "".equals(inString)){
      return null;
    }
    StringBuffer strBuffer = new StringBuffer();
    strBuffer.append(inString);
    char[] c = new char[strBuffer.length()];
    strBuffer.getChars(0, strBuffer.length(), c, 0);
    CustomString phxString=new CustomString(c);
    return phxString;
  }
  /**
   * convert PHXString to string object.
   * @param inString
   * @return
   */
  public static String convertToString(CustomString inString){
    if (inString == null || "".equals(inString)){
      return null;
    }
    char[] tChar=inString.getChars();
    if(tChar!=null && tChar.length>0){ 
      StringBuffer strBuffer = new StringBuffer();
      for(int i=0;i<tChar.length;i++){
        strBuffer.append(tChar[i]);
        tChar[i]='0';
      }
      tChar =null;
      return strBuffer.toString() ;
    }  	
    return EMPTY_STR;
  }
  public static boolean validatePassword(CustomString inString){
    Pattern p = Pattern.compile( "^(?=.*\\d)(?=.*[a-zA-Z])([@#$%^&*])?.{6,10}$");
    if(EMPTY_STR.equals(convertToString(inString)) ||convertToString(inString)==null){
      return false;
    }else{
      Matcher m = p.matcher(convertToString(inString));
      if(m.matches()){
        return true;
      }else{
        return false;
      }
    }
  }
  public static boolean validateSecurityAnswer(CustomString inString){
    Pattern p = Pattern
        .compile("^([a-zA-Z0-9\\s])+([a-zA-Z0-9~!@#$%^&*])*$");
    if(EMPTY_STR.equals(convertToString(inString))){
      return false;
    }else{
      Matcher m = p.matcher(convertToString(inString));
      if(m.matches()){
        return true;
      }else{
        return false;
      }
    }
  }
  /**
   * convert PHXString to masked string object.it will
   * mask only first five character.
   * @param inString
   * @return
   */
  public static String convertToMaskedString(CustomString inString){
    if (inString == null || EMPTY_STR.equals(inString))
      return null;
    char[] tChar=inString.getChars();
    if(tChar!=null && tChar.length>0){ 
      StringBuffer strBuffer = new StringBuffer();
      for(int i=0;i<tChar.length;i++){
        if(i<=4){
          strBuffer.append("*");
        }else{
          strBuffer.append(tChar[i]);
        }
        tChar[i]='0';
      }
      tChar =null;
      return strBuffer.toString() ;
    }  	
    return EMPTY_STR;
  }

  /**
   * convert PHXString to masked string object.it will
   * mask only first five character.
   * @param inString
   * @return
   */
  public static String maskString(CustomString inString){
    if (inString == null || EMPTY_STR.equals(inString))
      return null;
    char[] tChar=inString.getChars();
    if(tChar!=null && tChar.length>0){ 
      StringBuffer strBuffer = new StringBuffer();
      for(int i=0;i<tChar.length;i++){
        strBuffer.append("*");
        tChar[i]='0';
      }
      tChar =null;
      return strBuffer.toString() ;
    }  	
    return EMPTY_STR;
  }
  /**
   * convert PHXString to masked string object.it will
   * mask all but the last 4 digits of credit card number.
   * @param inString
   * @return
   */
  public static String maskCreditCardNo(CustomString inString){
    if (inString == null || EMPTY_STR.equals(inString))
      return null;
    char[] tChar=inString.getChars();
    if(tChar!=null && tChar.length>0){ 
      StringBuffer strBuffer = new StringBuffer();
      for(int i=0;i<tChar.length;i++){
        if(i<=tChar.length-5){
          strBuffer.append("*");
        }else{
          strBuffer.append(tChar[i]);
        }
        tChar[i]='0';
      }
      tChar =null;
      return strBuffer.toString() ;
    }  	
    return EMPTY_STR;
  }

  /*  Story 402:HCR_PQE_Display updated customer service hours
   *  Description:Changing customer service hours for logged in user */
  /**
   * setting customer service hours for logged in user in userVO
   * used to display in PhxHeader.jsp
   * @param userVO
   * @param quoteSearchCriteriaVO
   * @param applicationDetailVO
   * @return userVO
   */
  
}

/* 
 * Revision History
 * 
 * $Log$
 */