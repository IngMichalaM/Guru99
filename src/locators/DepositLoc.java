package locators;

import org.openqa.selenium.By;

public class DepositLoc {
	// Locators for the input fields and buttons on the "Deposit" page.
	public static By accountNoInputField   = By.name("accountno");
	public static By amountInputField = By.name("ammount"); 
	public static By descriptionInputField = By.name("desc");	
	public static By submitButtonLocator = By.name("AccSubmit");
	public static By resetButtonLocator = By.name("res");
}
