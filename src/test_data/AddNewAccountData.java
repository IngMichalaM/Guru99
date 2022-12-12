package test_data;

import java.util.Random;

public class AddNewAccountData {
	// customer ID is dynamically generated when needed
	
	public static String[] s = {"Savings", "Current"};
	static Random ran = new Random(); // problem with Random - is random only for the first 
									  // run, then it is constant for all
	public static String accountType  = s[ran.nextInt(s.length)];
	// public static String accountType  = "Current";
	static Random random = new Random();	
	public static int initDepotInt = random.nextInt(100000);  // e.g. 54266		
	public static String initDepot = String.valueOf(initDepotInt);
}

