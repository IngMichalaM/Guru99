package locators;

import org.openqa.selenium.By;

public class HomePage {
	// Include all locators and other variables used for the test on the main login page
	
	public static String bankGuru99HomePage = "https://demo.guru99.com/v4/";
 
	public static By usernameIDLocator = By.name("uid");
	public static By passwordLocator = By.name("password");
	public static By loginButtonLocator = By.name("btnLogin");
	
	// Include all locators and other variables used for the test on the Login page
	public static By welcomeMessageLocator = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");
		
}
