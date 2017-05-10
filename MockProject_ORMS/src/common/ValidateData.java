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
	 * Method print 1 string, null print ""
	 * 
	 * @param str
	 * @return String
	 */
	public static String getValidString(String str) {
		String temp = "";
		return (str == null)?temp:str;
	}
	
	/**
	 * Ham chuan hoa chuoi string
	 * Method format String
	 * 
	 * @param str
	 * @return str
	 */
	public static String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
	
	/**
	 * Ham kiem tra truong kieu string co rong hay khong ?
	 * Method check string is empty ?
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		str = chuanHoa(str);
		return (str == null || str.length() == 0  || " ".equals(str))?true:false;
	}

	 /**
	  * Ham kiem tra kieu int co rong hay khong ?
	 * Method check number type is empty ?
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isEmpty(int n){
		return (n==0)?true:false;
	 }
	/**
	 * Ham kiem tra truong kieu float co rong hay khong ?
	 * Method check float type is empty ?
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isEmpty(float n) {
		return (n==0)?true:false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom tat ca chu so hay khong
	 * Method check 
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
	 * Ham kiem tra co phai la kieu Int hay khong ?
	 * Method check is number ?
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumberOnly(int s){
		 return (s>0)?true:false;
	 }
	
	/**
	 * Ham kiem tra co phai la kieu Float hay khong ?
	 * Method check is float ?
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isFloatNumber(float s){
		return (s>0)?true:false;
	 }

	/**
	 * Ham kiem tra so ghe > 500
	 * Method check RoomSeats > 500 ?
	 * 
	 * @param roomSeats
	 * @return boolean
	 */
	public static boolean isMoreThan500Seats(int roomSeats) {
		return (roomSeats > 500)?true:false;
	}

	/**
	 *  Ham kiem tra so am (int) hay khong ?
	 *  Method check number is negative value?
	 *  
	 * @param n
	 * @return boolean
	 */
	public static boolean isNegative(int n) {
		return (n < 0)?true:false;
	}

	/**
	 * Ham kiem tra so am (float) hay khong ?
	 * Method check float is negative value?
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isNegative(float n) {
		return (n < 0)?true:false;
	}
	
	/**
	 * Ham kiem tra xau co do dai lon hon 50 ki tu khong ?
	 * Method check string have maxlength > 50 ?
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isMaxlength50String(String str) {
		str = chuanHoa(str);
		return (str.length() >=50)?true:false;
	}
	
	/**
	 * Ham kiem tra xau co ki tu dac biet hay khong ?
	 * Method check string use special characters ?
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isSpecialCharacters(String str) {
		str = chuanHoa(str);
		String regex = ("[0-9a-zA-Z\\s]*");
		return (str.matches(regex))?false:true;
	}
	
	/**
	 * Ham kiem tra input co ki tu dac biet hay khong ?
	 * Method check input use special characters ?
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isSpecialCharactersNumber(int n) {
		return (n>0)?false:true;
	}
	
	/**
	 * Ham kiem tra input co ki tu dac biet hay khong ?
	 * Method check input use special characters ?
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isSpecialCharactersFloat(float n) {
		return (n>0)?false:true;
	}
}
