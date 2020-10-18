
package com.example.demo.util;

import java.beans.PropertyEditorSupport;

import com.example.demo.util.CustomString;

/**
 * @author 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StringBufferEditor extends PropertyEditorSupport {
	
	public StringBufferEditor() { 
	}	

	public String getAsText() {
		StringBuffer sbf=new StringBuffer();
		if(getValue()!=null){
			char [] tChar=((CustomString)getValue()).getChars();
			for (int i=0;i<tChar.length;i++){
				sbf.append(tChar[i]);
			}
		}
		return sbf.toString();
	}
	public void setAsText(String inString) {
		if (inString == null) return;
		StringBuffer sb=new StringBuffer();
		sb.append(inString);
		char tChar[] = new char[sb.length()];
		sb.getChars(0,sb.length(),tChar,0);
		setValue(new CustomString(tChar));
	}
	
	
}
/* 
 * Revision History
 * 
 * $Log$
 */
