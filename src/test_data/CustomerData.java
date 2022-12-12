package test_data;

import java.util.Random;



public class CustomerData {

	// ========= Customer definition ==============
	// each customer need to have a unique e-mail
	public static String customerName = "Randomname";
	public static String gender = "male"; // "female"; // "male"; //female
	public static String dateOfbirth = "01/01/1991";
	public static String expectedDOB = "1991-01-01";
	public static String address = "Random Road 00";
	public static String city = "Random City";
	public static String state = "Random State";
	// public static Integer pin = 123456; // has to be string
	public static String pin = "123456"; // has to be string
	public static String mobileNumber = "123456";
	static Random random = new Random();
	public static int numberRandom = random.nextInt(100);  // 54266
	// numberRandom is random only for the first call, then it is alway that particular one, constant 
	//System.out.println(numberRandom);
	public static String email = "user_email"+numberRandom+"@random.com"; //cnmc54266@guru99.com
	//System.out.println(email);
	public static String customerPassword = "1234567";
			
}
