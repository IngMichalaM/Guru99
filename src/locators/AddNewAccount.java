package locators;


import org.openqa.selenium.By;


public class AddNewAccount {
	// Locators for the input fields, buttons and select menu on the "New Account" page.
	public static By customerIDInputField = By.name("cusid");
	public static By accountType = By.name("selaccount");  // select - type of the savings account 
	public static By initialDepositInputField = By.name("inideposit");	
	public static By submitButtonLocator = By.name("button2");
	public static By resetButtonLocator = By.name("reset");
	
	// message after the login
	public static By successMessage = By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p");
	public static By accountID = By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]");
	public static By customerID =  By.xpath("//*[@id=\"account\"]/tbody/tr[5]/td[2]");
}


