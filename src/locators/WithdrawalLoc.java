package locators;

import org.openqa.selenium.By;

public class WithdrawalLoc {
	// Locators for the input fields and buttons on the "Withdrawal" page.
	public static By accountnoFieldLocator = By.name("accountno");
	public static By amountFieldLocator = By.name("ammount");
	public static By descriptionFieldLocator = By.name("desc");
	public static By submitButtonLocator = By.name("AccSubmit");
	public static By resetButtonLocator = By.name("res");
	
	// after the submit button is clicked 
	public static By successMessageLocator = By.xpath("//*[@id=\"withdraw\"]/tbody/tr[1]/td/p");
	// text after successful withdrawal: Transaction details of Withdrawal for Account
	
	
	
}
