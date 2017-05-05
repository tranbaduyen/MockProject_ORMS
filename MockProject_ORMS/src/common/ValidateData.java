package common;

/**
 * ValidateData.java
 *
 * Version 1.0
 *
 * Date: 04-05-2017
 *
 * Copyright
 *
 * Modification Logs: 
 * DATE 			AUTHOR 		DESCRIPTION
 * -----------------------------------------------------------------------
 * 04-05-2017 		DuyenTB 	Create
 */

public class ValidateData {

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * 
	 * @param s
	 * @return String
	 */
	public static String getValidString(String s) {
		if (s == null)
			return "";
		return s;
	}

	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		System.out.println("s = ["+s +"]");
		
		if (s == null || s.length() == 0  || " ".equals(s))
			return true;
		return false;
	}

	 /**
	 * @param n
	 * @return
	 */
	public static boolean isEmpty(int n){
		 if(n==0) 
			 return true;
		 return false;
	 }
	/**
	 * @param n
	 * @return
	 */
	public static boolean isEmpty(float n) {
		if (n == 0)
			return true;
		return false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom tat ca chu so hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean isAllNumber(String s) {
		String regex = "[0-9]+";
		if (s.matches(regex))
			return true;
		return false;
	}

	 /**
	 * @param s
	 * @return
	 */
	public static boolean isNumberOnly(int s){
		 if(s>0) 
			 return true;
		 return false;
	 }
	
	/**
	 * @param s
	 * @return
	 */
	public static boolean isFloatNumber(float s){
		 if(s>0) 
			 return true;
		 return false;
	 }
	
	/**
	 * @param s
	 * @return
	 */
//	public static boolean isNumberOnly(String s) {
//		try {
//			int d = Integer.parseInt(s);
//			// or Integer.parseInt(text), etc.
//			// OK, valid number.
//			if (d != 0)
//				return true;
//			return false;
//		} catch (NumberFormatException nfe) {
//			// Not a number.
//			return false;
//		}
//	}

	/**
	 * @param n
	 * @return
	 */
	public static boolean isMoreThan500Seats(int n) {
		if (n > 500)
			return true;
		return false;
	}

	/**
	 * @param n
	 * @return
	 */
	public static boolean isNegative(int n) {
		if (n < 0)
			return true;
		return false;
	}

	/**
	 * @param n
	 * @return
	 */
	public static boolean isNegative(float n) {
		if (n < 0)
			return true;
		return false;
	}
}