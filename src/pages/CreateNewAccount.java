package pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import test_data.AddNewAccountData; // the values 
import locators.AddNewAccount;      // the locators 
import locators.LeftMenu;			// locators, messagase, and URL of the items on the left menu

public class CreateNewAccount {
	// In order to crate an account, we need to know the customer ID
	// Create a new customer first, get its ID and then create an account using it
	// Customer's data are taken from test_data.CustomerData (semi-random)- Random works only for first call
	// Customer's data for the account are taken from test_data.AddNewAccountData
	
	@DisplayName("Create a customer account")
	public static String[] NewAccount(WebDriver driver, String meilrandnum) throws InterruptedException{
		
		// Create new customer
		String customerID = CreateNewCustomer.NewCustomer(driver, meilrandnum);
		//driver.get(LeftMenu.newAccountURL);
		// here should be the button click 	
		System.out.println("--- Create a customer account --- ");
		driver.get(LeftMenu.newAccountURL); // "https://demo.guru99.com/v4/manager/addAccount.php");
		driver.findElement(AddNewAccount.customerIDInputField).sendKeys(customerID);
		// here comes the account type - TODO - slider 
		Select accountType = new Select(driver.findElement(AddNewAccount.accountType));
		accountType.selectByVisibleText(AddNewAccountData.accountType);
		System.out.println("Selected account type: " + AddNewAccountData.accountType);
		driver.findElement(AddNewAccount.initialDepositInputField).sendKeys(AddNewAccountData.initDepot);
		/* Thread.sleep(1000);
		// take a screenshot here 
		try {
			takeSnapShot(driver, "c:\\Users\\cadov\\Documents\\Vyuka\\PragueCodingSchool\\SmokeTest\\screenshots\\img_"+ customerID+ ".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// "c://test.png") ; */  
		Thread.sleep(1000);
		driver.findElement(AddNewAccount.submitButtonLocator).click();
		Thread.sleep(1000);
		// return the account ID 
		String accountID = driver.findElement(AddNewAccount.accountID).getText();
		//System.out.print(accountID);
		String[] ans = new String[2];
		ans[0] = customerID;
		ans[1] = accountID;
		System.out.print("    - customerID: ");
		System.out.print(customerID);
		System.out.print("    - accountID ");
		System.out.print(accountID);
		System.out.print("    ----  ");
		return ans;		
	}
	
	 //  https://www.guru99.com/take-screenshot-selenium-webdriver.html
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
            File DestFile=new File(fileWithPath);

            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
}
}
