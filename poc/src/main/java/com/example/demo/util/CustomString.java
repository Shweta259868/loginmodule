
package com.example.demo.util;

import java.io.Serializable;

/**
 * @author 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CustomString implements Serializable{
	
	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int COMPARE_IGNORE_CASE = 1;
	private static final int COMPARE_DO_NOT_IGNORE_CASE = 2;
	
	private StringBuffer phxString;
	
	public CustomString() {
		setValue(new StringBuffer());
	}
	
	public CustomString(char[] phxCharArray) {
		setValue(phxCharArray);
	}

	private StringBuffer getPhxString() {
		return phxString;
	}

	private synchronized void setPhxString(StringBuffer phxStringBuffer) {
		this.phxString = null;
		this.phxString = new StringBuffer(phxStringBuffer);
//		this.phxString = phxString;
	}
		
	public synchronized void setValue(StringBuffer phxStringBuffer) {
		if (this.phxString != null) this.clear();
		if (phxStringBuffer == null) return;
		char[] tChar = new char[phxStringBuffer.length()];
		phxStringBuffer.getChars(0, phxStringBuffer.length(), tChar, 0);
		this.setPhxString(phxStringBuffer);
	}
	
	public synchronized void setValue(char[] phxCharArray) {
		if (this.phxString != null) this.clear();
		this.phxString = new StringBuffer();
		this.phxString.append(phxCharArray);
	}
	
	public synchronized CustomString clear() {
		if (this.phxString == null) return null;
		this.phxString.replace(0, this.phxString.length(), "0");
		this.phxString = null;
		return this;
	}
	
	public synchronized char[] getChars() {
		if (this.phxString == null) return null;
		char[] tChar = new char[this.phxString.length()];
		this.phxString.getChars(0, this.phxString.length(), tChar, 0);
		return tChar;
	}
	
	public synchronized CustomString replace(int start, int end, String string) throws CustomStringException {
		try {
			this.phxString.replace(start, end, string);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString reverse() throws CustomStringException {
		try {
			this.phxString.reverse();
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	public synchronized CustomString append(StringBuffer phxStringBuffer) throws CustomStringException {
		try {
			this.phxString.append(phxStringBuffer);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}

	public synchronized CustomString append(char[] phxCharArray) throws CustomStringException {
		try {
			this.phxString.append(phxCharArray);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(char value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(double value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(float value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(int value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(long value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(Object value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString append(boolean value) throws CustomStringException {
		try {
			this.phxString.append(value);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString delete(int start, int end) throws CustomStringException {
		try {
			this.phxString.delete(start, end);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized CustomString deleteCharAt(int location) throws CustomStringException {
		try {
			this.phxString.deleteCharAt(location);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public synchronized char charAt(int index) throws CustomStringException {
		char b = '\0'; //non printable character with ascii value 0
		try {
			b = this.phxString.charAt(index);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return b;
	}
	
	public synchronized char[] subString(int start, int end) throws CustomStringException {
		char[] b = new char[end-start];
		try {
			b = this.phxString.substring(start, end).toCharArray();
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return b;
	}
	
	public char[] subString(int start) throws CustomStringException {
		return subString(start, this.phxString.length());
	}
	
	private boolean equals(char[] otherCharArr, int ignoreCase) throws CustomStringException {
		boolean returnVal = false;
		try {
			char[] currentCharArr = new char[this.phxString.length()];
			this.phxString.getChars(0, this.phxString.length(), currentCharArr, 0);
			if (otherCharArr.length == currentCharArr.length) {
				for (int i=0; i<currentCharArr.length; i++) {
					if ((ignoreCase == COMPARE_IGNORE_CASE ? Character.toUpperCase(currentCharArr[i]) : currentCharArr[i]) == (ignoreCase == COMPARE_IGNORE_CASE ? Character.toUpperCase(otherCharArr[i]) : otherCharArr[i])) {
						returnVal = true;
					} else {
						returnVal = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return returnVal;
	}
	
	public boolean equals(char[] otherCharArr) throws CustomStringException {
		return equals(otherCharArr, COMPARE_DO_NOT_IGNORE_CASE);
	}
	
	public boolean equalsIgnoreCase(char[] otherCharArr) throws CustomStringException {
		return equals(otherCharArr, COMPARE_IGNORE_CASE);
	}
	
	public boolean equals(CustomString otherPHXString) throws CustomStringException {
		if (otherPHXString == null) return false;
		if (otherPHXString == this) return true;
		return equals(otherPHXString.getChars(), COMPARE_DO_NOT_IGNORE_CASE);
	}

	public boolean equals(Object obj) {
		try {
			if (!(obj instanceof CustomString || obj instanceof String)) 
				return false;
			if (obj instanceof CustomString) 
				return equals(((CustomString)obj).getChars(), COMPARE_DO_NOT_IGNORE_CASE);
			else if (obj instanceof String) 
				return equals(((String) obj).toCharArray(), COMPARE_DO_NOT_IGNORE_CASE);
			else 
				throw new IllegalArgumentException("PHXString.equals() cannot compare the referenced object since the Object Type is unknown.");
		} catch (CustomStringException phe) {
			throw new IllegalArgumentException("PHXStringException in PHXString.equals(Object). "  +phe.getMessage());
		} catch (Exception e) {
			throw new IllegalArgumentException("Exception in PHXString.equals(Object). "  +e.getMessage());
		}
	}

	public long length() throws CustomStringException {
		long length = -1L;
		try {
			length = this.phxString.length();
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return length;
	}
	
	public int indexOf(String string) throws CustomStringException {
		int index = -1;
		try {
			index = this.phxString.indexOf(string);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return index;
	}
	
	public synchronized int lastIndexOf(String string) throws CustomStringException {
		int index = -1;
		try {
			index = this.phxString.lastIndexOf(string);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return index;
	}
	
	public boolean equalsIgnoreCase(CustomString otherPHXString) throws CustomStringException {
		if (otherPHXString == null) return false;
		if (otherPHXString == this) return true;
		return equals(otherPHXString.getChars(), COMPARE_IGNORE_CASE);
	}
	
	public CustomString trim(char dataToTrim) {
		if (this.phxString == null) return null;
		this.phxString.reverse();
		char[] c = new char[this.phxString.length()];
		this.phxString.getChars(0, this.phxString.length(), c, 0);
		this.phxString = new StringBuffer();
		boolean validCharFound = false;
		for (int i=0; i<c.length; i++) {
			if (!validCharFound) {
				if (c[i] != dataToTrim) {
					this.phxString.append(c[i]);
					validCharFound = true;
				}
			} else {
				this.phxString.append(c[i]);			}
		}
		this.phxString.reverse();
		this.phxString.trimToSize();
		return this;
	}

	public CustomString trim() {
		return trim(' ');
	}
	
	public CustomString replace(String oldText, String newText) throws CustomStringException {
		try {
			int start = this.phxString.indexOf(oldText);
			int end = start + oldText.length();
			if (start > -1 && start <= this.phxString.length() && end > start && end <= this.phxString.length()) {
				this.phxString.replace(start, end, newText);
			}
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public CustomString replaceAll(String oldText, String newText) throws CustomStringException {
		try {
			this.phxString = new StringBuffer(this.phxString.toString().replaceAll(oldText, newText));
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public CustomString replaceAll(char oldChar, char newChar) throws CustomStringException {
		try {
			StringBuffer sb = new StringBuffer();
			char[] oldPhxString = new char[this.phxString.length()];
			this.phxString.getChars(0, this.phxString.length(), oldPhxString, 0);
			for (int i=0; i<this.phxString.length(); i++){ 
				if (oldPhxString[i] == oldChar) {
					sb.append(newChar);
				} else {
					sb.append(oldPhxString[i]);
				}
			}
			this.clear();
			this.setPhxString(sb);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public CustomString removeAll(char charsToRemove) throws CustomStringException {
		try {
			StringBuffer sb = new StringBuffer();
			char[] oldPhxString = new char[this.phxString.length()];
			this.phxString.getChars(0, this.phxString.length(), oldPhxString, 0);
			for (int i=0; i<this.phxString.length(); i++){ 
				if (oldPhxString[i] != charsToRemove) {
					sb.append(oldPhxString[i]);
				}
			}
			this.clear();
			this.setPhxString(sb);
		} catch (Exception e) {
			throw new CustomStringException(e.getMessage());
		}
		return this;
	}
	
	public boolean isContentNull() {
		return (this.phxString == null);
	}

	public boolean isContentEmpty() {
		return (this.phxString.length() == 0);
	}
	
	public boolean isContentNullOrEmpty() {
		return (isContentNull() || isContentEmpty());
	}
	public CustomString ltrim(char dataToTrim) {
		if (this.phxString == null) return null;
		char[] c = new char[this.phxString.length()];
		this.phxString.getChars(0, this.phxString.length(), c, 0);
		this.phxString = new StringBuffer();
		boolean validCharFound = false;
		for (int i=0; i<c.length; i++) {
			if (!validCharFound) {
				if (c[i] != dataToTrim) {
					this.phxString.append(c[i]);
					validCharFound = true;
				}
			} else {
				this.phxString.append(c[i]);			}
		}
		this.phxString.trimToSize();
		return this;
	}
	@Override
	public String toString() {
		// Cannot throw Exception from this method as super.toString() doesnt throw one. Returning null instead.
		return null;
	}
}

