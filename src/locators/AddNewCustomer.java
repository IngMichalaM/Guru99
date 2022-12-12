package locators;

import org.openqa.selenium.By;


public class AddNewCustomer {
	// Locators for the input fields, buttons and select menu on the "New Customer" page.
	public static By nameInpuFieldLocator = By.name("name");
	public static By maleRadioButtonLocator = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
	public static By femaleRadioButtonLocator = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");			
	public static By dOdInpuFieldLocator = By.id("dob");
	public static By addrInpuFieldLocator = By.name("addr");
	public static By cityInpuFieldLocator = By.name("city");
	public static By stateInpuFieldLocator = By.name("state");
	public static By pinInpuFieldLocator = By.name("pinno");
	public static By mobileInpuFieldLocator = By.name("telephoneno");
	public static By emailInpuFieldLocator = By.name("emailid");
	public static By passInpuFieldLocator = By.name("password");
	public static By submitButtonLocator = By.name("sub");
	public static By resetButtonLocator = By.name("res");
	
	// after the login
	public static By successMessageLocator = By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p");
	
}
