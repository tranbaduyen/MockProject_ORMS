package common; 

/**
 * StringProcess.java
 *
 * Version 1.0
 *
 * Date: Jan 20, 2015
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Jan 20, 2015        	DaiLV2          Create
 */

public class StringProcess {

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * @param s
	 * @return String
	 */
	public static String getValidString(String s) {
		if(s==null) return "";
		return s;
	}
	
	/**
	 * Ham kiem tra xau rong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean isEmpty(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	public static boolean isEmpty(int n){
		if(n==0) return true;
		return false;
	}
	public static boolean isEmpty(float n){
		if(n==0) return true;
		return false;
	}
	
	/**
	 * Ham kiem tra xem xau co bao gom tat ca chu so hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean isAllNumber(String s){
		String regex = "[0-9]+"; 
		if(s.matches(regex)) return true;
		return false;
	}
//	public static boolean isNumberOnly(String s){
//		String regex = "[0-9]+"; 
//		if(s.matches(regex)) return false;
//		return true;
//	}
	public static boolean isNumberOnly(String s){
		try {
		    int d = Integer.parseInt(s); 
		    // or Integer.parseInt(text), etc.
		    // OK, valid number.
		    if(d==0)
		    	return false;
		    return true;
		  } catch (NumberFormatException nfe) {
		    // Not a number.
			  return false;
		  }
	}
	public static boolean isMoreThan500Seats(int n){
		if(n>500)
			return true;
		return false;
	}
}

