package locators;

import org.openqa.selenium.By;

public class FundTransferLoc {
	// Locators for the input fields and buttons on the "Fund Transfer" page.
	public static By payersAccountInputField = By.name("payersaccount");
	public static By payeesAccountInputField = By.name("payeeaccount");
	public static By amountInputField  = By.name("ammount"); 
	public static By descriptionInputField = By.name("desc");	
	public static By submitButtonLocator = By.name("AccSubmit");
	public static By resetButtonLocator = By.name("res");
	
	// after the transfer 
	public static By successMessage = By.xpath("/html/body/table/tbody/tr[1]/td/p");
	
}
