/**
* Final project for the Prague/Dublin Coding school, course Automated testing 
* https://prahacoding.cz/courses/automation-testing-course-praha-coding-school/
* Smoke test for the Guru99 bank app (https://demo.guru99.com/v4/)
* 
* About me: no prior Java knowledge. But I have some manual testing experinece, 
* as well as medium Python knowledge and I also did few projects using Python and Selenuym WebBDriver. 
*/

package test_classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import locators.AddNewAccount;
import locators.BalanceEnquiryForm;
import locators.HomePage;
import test_data.LoginCredentials;
import locators.LeftMenu;
import pages.CreateNewAccount;
import locators.DepositLoc;  // locators for the deposit page
import locators.FundTransferLoc;
import test_data.DepositData; // data for the deposit page 
import test_data.FundTransferData;
import test_data.WithdrawalData; // test data 
import locators.WithdrawalLoc; // locators 

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmokeTest {
	
	// Declare the virtual browser
	public static WebDriver driver = null;
	
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();	
	}
	
	@AfterAll
	public static void afterAll() {		
		driver.close();
		}
	
	@Test
	@Order(1)
	@DisplayName("(TS001/TC001) The bank URL leads to the page, where the manager can login.")
	public void ts001_tc001() throws InterruptedException {		
		driver.get(HomePage.bankGuru99HomePage);
		driver.manage().window().maximize();
		Thread.sleep(2000); 															   // better to use explicit wait		
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click(); // get pass the GDPR window
			
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(HomePage.bankGuru99HomePage, currentURL); 							   // check the URL
				 
		Boolean idInputIsPresent = driver.findElements(HomePage.usernameIDLocator).size() > 0; // check the user ID input field
		assertTrue(idInputIsPresent);
				
		Boolean passwordInputIsPresent = driver.findElements(HomePage.passwordLocator).size() > 0; // check the user password input field
		assertTrue(passwordInputIsPresent);				
	}
	
	@Test
	@Order(2)
	@DisplayName("(TS002/TC002) Check welcome message on the login homepage after entering valid manager's ID and Password")
	public void ts002_tc002() throws InterruptedException {
		driver.findElement(HomePage.usernameIDLocator).sendKeys(LoginCredentials.userID);
		driver.findElement(HomePage.passwordLocator).sendKeys(LoginCredentials.password);
		driver.findElement(HomePage.loginButtonLocator).click();
		
		WebElement welcomeMessageElement = driver.findElement(HomePage.welcomeMessageLocator);
		
		String expectedResult = "Welcome To Manager's Page of Guru99 Bank";
		String actualResult = welcomeMessageElement.getText();
		Assert.assertEquals(expectedResult, actualResult); 
	}
	
	@Test
	@Order(3)
	@DisplayName("(TS003/TC003) Click on \"New Customer\" button leads to the page, where a new customer can be added.")
	public void ts003_tc003() throws InterruptedException {
		// driver.findElement(LeftMenu.addCustomerLocator).click();	 
		driver.get(LeftMenu.addCustomerURL); 		
		String pageTitleExp = "Add New Customer";
		String pageTitle = driver.findElement(LeftMenu.addCustomerPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}

	@Test
	@Order(4)
	@DisplayName("(TS003/TC004) Click on \"Edit Customer\" button leads to the page with Edit Customer Form.")
	public void ts003_tc004() throws InterruptedException {		
		driver.get(LeftMenu.editCustomerURL); 		
		String pageTitleExp = "Edit Customer Form";
		String pageTitle = driver.findElement(LeftMenu.editCustomerPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(5)
	@DisplayName("(TS003/TC005) Click on \"Delete Customer\" button  leads to the page with Delete Customer Form.")
	public void ts003_tc005() throws InterruptedException {		
		driver.get(LeftMenu.deleteCustomerURL); 		
		String pageTitleExp = "Delete Customer Form";
		String pageTitle = driver.findElement(LeftMenu.deleteCustomerPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}

	@Test
	@Order(6)
	@DisplayName("(TS003/TC006) Click on \"New Account\" button leads to the page whith the New Account Form.")
	public void ts003_tc006() throws InterruptedException {		
		driver.get(LeftMenu.newAccountURL); 		
		String pageTitleExp = "Add new account form";
		String pageTitle = driver.findElement(LeftMenu.newAccountPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}	

	@Test
	@Order(7)
	@DisplayName("(TS003/TC007) Click on \"Delete Account\" button leads to the page whith the Delete Account Form.")
	public void ts003_tc007() throws InterruptedException {		
		driver.get(LeftMenu.deleteAccountURL); 		
		String pageTitleExp = "Delete Account Form";
		String pageTitle = driver.findElement(LeftMenu.deleteAccountPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(8)
	@DisplayName("(TS003/TC008)Click on \"Deposit\" button  leads to the page whith the Amount Deposit Form.")
	public void ts003_tc008() throws InterruptedException {		
		driver.get(LeftMenu.depositURL); 		
		String pageTitleExp = "Amount Deposit Form";
		String pageTitle = driver.findElement(LeftMenu.depositPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(9)
	@DisplayName("(TS003/TC009) Click on \"Withdrawal\" button leads to the page whith the Amount Withdrawal Form.")
	public void ts003_tc009() throws InterruptedException {		
		driver.get(LeftMenu.withdrawalURL); 		
		String pageTitleExp = "Amount Withdrawal Form";
		String pageTitle = driver.findElement(LeftMenu.withdrawalPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(10)
	@DisplayName("(TS003/TC010)Click on \"Fund Transfer\" button leads to the page whith the Fund Transfer Form.")
	public void ts003_tc010() throws InterruptedException {		
		driver.get(LeftMenu.fundTransferURL); 		
		String pageTitleExp = "Fund transfer";
		String pageTitle = driver.findElement(LeftMenu.fundTransferPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(11)
	@DisplayName("(TS003/TC011) Click on \"Change Password\" button leads to the page where the user can change the password.")
	public void ts003_tc011() throws InterruptedException {		
		driver.get(LeftMenu.changePasswordURL); 		
		String pageTitleExp = "Change Password";
		String pageTitle = driver.findElement(LeftMenu.changePasswordPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(12)
	@DisplayName("(TS003/TC012) Click on \"Balance Enquiry\" button leads to the page with the Balance Enquiry Form.")
	public void ts003_tc012() throws InterruptedException {		
		driver.get(LeftMenu.balanceEquiryURL); 		
		String pageTitleExp = "Balance Enquiry Form";
		String pageTitle = driver.findElement(LeftMenu.balanceEquiryPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(13)
	@DisplayName("(TS003/TC013) Click on \"Mini Statement\" button leads to the page with a Mini Statement Form.")
	public void ts003_tc013() throws InterruptedException {		
		driver.get(LeftMenu.miniStatementURL); 		
		String pageTitleExp = "Mini Statement Form";
		String pageTitle = driver.findElement(LeftMenu.miniStatementPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(14)
	@DisplayName("(TS003/TC014) Click on \"Customised Statement\" button leads to the page with a Customized Statement Form.")
	public void ts003_tc014() throws InterruptedException {		
		driver.get(LeftMenu.customisedStatementURL); 		
		String pageTitleExp = "Customized Statement Form";
		String pageTitle = driver.findElement(LeftMenu.customisedStatementPageTitleLocator).getText();
		Assert.assertEquals(pageTitleExp, pageTitle);
	}
	
	@Test
	@Order(15)
	@DisplayName("(TS004/TC017) Check the Balance Enquiry Form functionality.")
	public void ts004_tc017() throws InterruptedException {		
		// In order to make an enquiry we need a customer ID
		// Create the customer first and get the ID
		// Then create the customer´s account and get its ID
		
		// Create a customer and his account 
		//ans[0] = customerID;   //ans[1] = accountID; 
		String meilrandnum = "3";
		String ans[] = CreateNewAccount.NewAccount(driver, meilrandnum);
		String customerID = ans[0];
	    String accountID = ans[1];
	    //System.out.print(accountID);
	    
	    // check that the customer ID still holds 
	 	String customerIDnew = driver.findElement(AddNewAccount.customerID).getText();
	 	Assert.assertEquals(customerID, customerIDnew);

	    // Click on the Balance enquiry 
	    driver.get(LeftMenu.balanceEquiryURL);
	    // send the Account No 
	    driver.findElement(BalanceEnquiryForm.accountNoInputField).sendKeys(accountID);
	    // click submit 
	    driver.findElement(BalanceEnquiryForm.submitButton).click(); 
	    
	    // never manage to lend on the page after clicking submit, no idea what should be on the page to check
	    // just to try - see if it is possible to find "Successfully!!!"
	 	Assert.assertTrue(driver.getPageSource().contains("Successfully!!!"));				
	}	
	    		 
		@Test
		@Order(16)
		@DisplayName("(TS005/TC018) Check the Fund Transfer functionality.")
		public void ts005_tc018() throws InterruptedException {		
			// In order to make a fund transfer, we need two users and two accounts 
			
			// Create a customer 1 and his account 
			//ans[0] = customerID;   //ans[1] = accountID; 
			String meilrandnum1 = "88";
			System.out.print("Creating customer with meil prefix 88");
			String ans[] = CreateNewAccount.NewAccount(driver, meilrandnum1);
			String customerID1 = ans[0];
		    String accountID1 = ans[1];
		    System.out.print("Customer ID (for meil prefix 88)" + customerID1);
		    
		    Thread.sleep(1000);
		    // Create a customer 2 and his account  
	 		String meilrandnum2 = "11";
	 		System.out.print("Creating customer with meil prefix 11");
	 		String ans2[] = CreateNewAccount.NewAccount(driver, meilrandnum2);
	 		String customerID2 = ans2[0];
	 	    String accountID2 = ans2[1];
	 	   System.out.print("Customer ID (for meil prefix 11)" + customerID2);
		 	    
		    // Click on the Fund Transfer  
		    driver.get(LeftMenu.fundTransferURL);
		    //payers account
		    driver.findElement(FundTransferLoc.payersAccountInputField).sendKeys(accountID1);
		    // payees account
		    driver.findElement(FundTransferLoc.payeesAccountInputField).sendKeys(accountID2);
		    // amount 
		    driver.findElement(FundTransferLoc.amountInputField).sendKeys(FundTransferData.amount);
		    // description
		    driver.findElement(FundTransferLoc.descriptionInputField).sendKeys(FundTransferData.description);
		    // click submit 
		    driver.findElement(FundTransferLoc.submitButtonLocator).click(); 
		    	
		    String actRes = driver.findElement(FundTransferLoc.successMessage).getText();
		    String expRes = "Fund Transfer Details";
		    Assert.assertEquals(actRes, expRes);		 
		}
		
		@Test
		@Order(17)
		@DisplayName("(TS006/TC019) Check the Deposit functionality.")
		public void ts006_tc019() throws InterruptedException {		
			// In order to make the deposit we need an account No
			// Create the customer first and get the ID
			// Then create the customer account 
			
			// Create a customer and his account 
			//ans[0] = customerID;   //ans[1] = accountID; 
			String meilrandnum = "5";
			String ans[] = CreateNewAccount.NewAccount(driver, meilrandnum);
			String customerID = ans[0];
		    String accountID = ans[1];
		    // System.out.print(accountID);
		    
		    // check that the customer ID still holds 
		 	//String customerIDnew = driver.findElement(AddNewAccount.customerID).getText();
		 	// Assert.assertEquals(customerID, customerIDnew);

		    // Click on the Deposit 
		    driver.get(LeftMenu.depositURL);
		    // send the Account No 
		    driver.findElement(DepositLoc.accountNoInputField).sendKeys(accountID);
		    // send amount 
		    driver.findElement(DepositLoc.amountInputField).sendKeys(DepositData.amount);
		    // send description
		    driver.findElement(DepositLoc.descriptionInputField).sendKeys(DepositData.description);
		    // click submit 
		    driver.findElement(DepositLoc.submitButtonLocator).click(); 	    
		    		
			// just to try - see if it is possible to find "Successfully!!!"
			 Assert.assertTrue(driver.getPageSource().contains("Successfully!!!"));				  				
		} 
		

	@Test
	@Order(18)
	@DisplayName("(TS007/TC020) Check the Withdrawal functionality.")
	public void ts007_tc020() throws InterruptedException {		
		// In order to withdraw money, an account must exist  
		// First create a customer and get the ID
		// Then create the customer´s account 
		
		// Create a customer and his account 
		//ans[0] = customerID;   //ans[1] = accountID; 
		String meilrandnum = "6";
		String ans[] = CreateNewAccount.NewAccount(driver, meilrandnum);
		String customerID = ans[0];
	    String accountID = ans[1];
	    // System.out.print(accountID);
	    
	    // check that the customer ID still holds 
	 	// String customerIDnew = driver.findElement(AddNewAccount.customerID).getText();
	 	// Assert.assertEquals(customerID, customerIDnew);

	    // Click on the Withdrawal page 
	    driver.get(LeftMenu.withdrawalURL);
	    // send the Account No 
	    driver.findElement(WithdrawalLoc.accountnoFieldLocator).sendKeys(accountID);
	    // amount 
	    driver.findElement(WithdrawalLoc.amountFieldLocator).sendKeys(WithdrawalData.amount);
	    // description 
	    driver.findElement(WithdrawalLoc.descriptionFieldLocator).sendKeys(WithdrawalData.description);
	    // click submit 
	    driver.findElement(WithdrawalLoc.submitButtonLocator).click(); 
	    // check the success message 	   
	    Thread.sleep(1000);
		Assert.assertTrue(driver.getPageSource().contains("Transaction details of Withdrawal for Account"));
	} 

	@Test
	@Order(19)
	@DisplayName("(TS008/TC021) Click on \"Log out\" button logs out the user and a pop-up window appears.")
	public void ts003_tc021() throws InterruptedException {		
		driver.findElement(LeftMenu.logOutLocator).click();
		// switch to the pop-up window
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String urlExp = "https://demo.guru99.com/v4/index.php";
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(urlExp, currentURL); // check the URL	
	} 
}
	
	/*
	// not intended for the testing, just for a quick checkup of the functionality
	// need some adjustments since there were some changes in some methods 
	@Test
	@DisplayName("(TS010/TC022) Create new customer.")
	public void ts010_tc022() throws InterruptedException {		
		driver.get(LeftMenu.addCustomerURL);
		String meilrandnum = "111";
		String customerID = CreateNewCustomer.NewCustomer(driver, meilrandnum);
		// System.out.println("just a string"); 
		String actualMessage = driver.findElement(AddNewCustomer.successMessageLocator).getText() ;
		String expectedMessage = "Customer Registered Successfully!!!";		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		// check that the customerID written in the summary is the same that came from the method
		String userIDfromSummary = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
		Assert.assertEquals(customerID, userIDfromSummary);
	} 
	
	
	// not intended for the testing, just for a quick checkup of the functionality
	@Test
	@DisplayName("(TS011/TC023) Crate new customer account.")
	public void ts009_tc022() throws InterruptedException {		
		// In order to create a new account, we need a customer ID
		// Create the customer first and get the ID
		
		//ans[0] = customerID;   //ans[1] = accountID; 
		String ans[] = CreateNewAccount.NewAccount(driver, "125");
		String customerID = ans[0];
	    String accountID = ans[1];
	    
		// check that the account is created 			
		String actualMessage = driver.findElement(AddNewAccount.successMessage).getText() ;
		String expectedMessage = "Account Generated Successfully!!!";		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		// check that the customer ID still holds 
		String customerIDnew = driver.findElement(AddNewAccount.customerID).getText();
		Assert.assertEquals(customerID, customerIDnew);
		// String.equals(customerID, customerIDnew);
		//assertEquals(customerID,customerIDnew)
		// assertEquals(customerID, customerIDnew);			
	}
	

	@Test
	@Order(5)
	@DisplayName("(Not for smoke test) Create account.")
	public void ts_create_account() throws InterruptedException {				
		// Create a customer and his account 
		//ans[0] = customerID;   //ans[1] = accountID; 
		String meilrandnum = "7";
		String ans[] = CreateNewAccount.NewAccount(driver, meilrandnum);
		String customerID = ans[0];
	    String accountID = ans[1];
	    // System.out.print(accountID);
	    
	    // check that the customer ID still holds 
	 	String customerIDnew = driver.findElement(AddNewAccount.customerID).getText();
	 	Assert.assertEquals(customerID, customerIDnew);
	 	
	 	String ans2[] = CreateNewAccount.NewAccount(driver, "667");
	 	}*/
