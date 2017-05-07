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
	 * @param str
	 * @return String
	 */
	public static String getValidString(String str) {
		String temp = "";
		return (str == null)?temp:str;
	}
	
	public static String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
	
	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		str = chuanHoa(str);
		return (str == null || str.length() == 0  || " ".equals(str))?true:false;
	}

	 /**
	  * Ham kiem tra du lieu trong
	 * @param n
	 * @return
	 */
	public static boolean isEmpty(int n){
		return (n==0)?true:false;
	 }
	/**
	 * Ham kiem tra du lieu trong
	 * @param n
	 * @return
	 */
	public static boolean isEmpty(float n) {
		return (n==0)?true:false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom tat ca chu so hay khong
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isAllNumber(String str) {
		str = chuanHoa(str);
		String regex = "[0-9]+";
		return (str.matches(regex))?true:false;
	}

	 /**
	  * Ham kiem tra kieu Int
	 * @param s
	 * @return
	 */
	public static boolean isNumberOnly(int s){
		 return (s>0)?true:false;
	 }
	
	/**
	 * Ham kiem tra kieu Float
	 * @param s
	 * @return
	 */
	public static boolean isFloatNumber(float s){
		return (s>0)?true:false;
	 }

	/**
	 * Ham kiem tra so ghe > 500
	 * @param n
	 * @return
	 */
	public static boolean isMoreThan500Seats(int n) {
		return (n > 500)?true:false;
	}

	/**
	 *  Ham kiem tra so am (int)
	 * @param n
	 * @return
	 */
	public static boolean isNegative(int n) {
		return (n < 0)?true:false;
	}

	/**
	 * Ham kiem tra so am (float)
	 * @param n
	 * @return
	 */
	public static boolean isNegative(float n) {
		return (n < 0)?true:false;
	}
	
	/**
	 * Ham kiem tra xau co do dai lon hon 20 ki tu
	 * @param str
	 * @return boolean
	 */
	public static boolean isMaxlength50String(String str) {
		if(str.length() >=50) return true;
		return false;
	}
	
	/**
	 * Ham kiem tra xau co ki tu dac biet hay khong
	 * @param str
	 * @return
	 */
	public static boolean isSpecialCharacters(String str) {
		str = chuanHoa(str);
		String regex = ("[0-9a-zA-Z\\s]*");
		return (str.matches(regex))?false:true;
	}
}
