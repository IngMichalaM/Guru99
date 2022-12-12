package locators;

import org.openqa.selenium.By;

public class LeftMenu {
	// Locators for the urls, buttons and text for all the buttons in the left Menu.
	
	// New customer 
	public static By addCustomerLocator = By.partialLinkText("New Customer");
	public static String addCustomerURL = "https://demo.guru99.com/v4/manager/addcustomerpage.php"; 
	public static By addCustomerPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Edit Customer 
	public static By editCustomerLocator = By.partialLinkText("Edit Customer ");
	public static String editCustomerURL = "https://demo.guru99.com/v4/manager/EditCustomer.php"; 
	public static By editCustomerPageTitleLocator = By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Delete Customer
	public static By deleteCustomerLocator = By.partialLinkText("Delete Customer");
	public static String deleteCustomerURL = "https://demo.guru99.com/v4/manager/DeleteCustomerInput.php"; 
	public static By deleteCustomerPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// New Account
	public static By newAccountLocator = By.partialLinkText("New Account");
	public static String newAccountURL = "https://demo.guru99.com/v4/manager/addAccount.php"; 
	public static By newAccountPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	
	// Edit Account
	public static By editAccountLocator = By.partialLinkText(" Edit Account");
	public static String editAccountURL = "https://demo.guru99.com/v4/manager/editAccount.php"; 
	public static By editAccountPageTitleLocator = By.cssSelector("");
	
	// Delete Account
	public static By deleteAccountLocator = By.partialLinkText("Delete Account");
	public static String deleteAccountURL = "https://demo.guru99.com/v4/manager/deleteAccountInput.php"; 
	public static By deleteAccountPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Deposit
	public static By depositLocator = By.partialLinkText("Deposit");
	public static String depositURL = "https://demo.guru99.com/v4/manager/DepositInput.php"; 
	public static By depositPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Withdrawal
	public static By withdrawalLocator = By.partialLinkText("Withdrawal");
	public static String withdrawalURL = "https://demo.guru99.com/v4/manager/WithdrawalInput.php"; 
	public static By withdrawalPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Fund Transfer
	public static By fundTransferLocator = By.partialLinkText("Fund Transfer");
	public static String fundTransferURL = "https://demo.guru99.com/v4/manager/FundTransInput.php"; 
	public static By fundTransferPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Change Password
	public static By changePasswordLocator = By.partialLinkText("Change Password");
	public static String changePasswordURL = "https://demo.guru99.com/v4/manager/PasswordInput.php"; 
	public static By changePasswordPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Balance Equiry
	public static By balanceEquiryLocator = By.partialLinkText("Balance Equiry");
	public static String balanceEquiryURL = "https://demo.guru99.com/v4/manager/BalEnqInput.php"; 
	public static By balanceEquiryPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Mini Statement
	public static By miniStatementLocator = By.partialLinkText("Mini Statement");
	public static String miniStatementURL = "https://demo.guru99.com/v4/manager/MiniStatementInput.php"; 
	public static By miniStatementPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Customised Statement 
	public static By customisedStatementLocator = By.partialLinkText("Customised Statement");
	public static String customisedStatementURL = "https://demo.guru99.com/v4/manager/CustomisedStatementInput.php"; 
	public static By customisedStatementPageTitleLocator = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p");
	
	// Log out 
	public static By logOutLocator = By.partialLinkText("Log out");
	// public static String logOutURL = ""; 
	// public static By logOutPageTitleLocator = By.cssSelector("");
	
	
	
}
