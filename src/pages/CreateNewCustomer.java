package pages;


import test_data.CustomerData;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.AddNewCustomer;
import locators.LeftMenu;
import test_data.CustomerData;

public class CreateNewCustomer {
	// Create new customer with the data from test_data.CustomerData
	
	@DisplayName("Create a customer")
	public static String NewCustomer(WebDriver driver, String meilrandnum) throws InterruptedException{
		System.out.println("--- Create a customer --- ");
		// here should be the button click, due to the poping adds go directly to the particular page 	
		driver.get(LeftMenu.addCustomerURL);
		
		//Thread.sleep(2000);
		// in case youd did not log in:
		//driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		
		// Enter customer name		    
	    driver.findElement(AddNewCustomer.nameInpuFieldLocator).sendKeys(CustomerData.customerName);
	    driver.findElement(AddNewCustomer.dOdInpuFieldLocator).sendKeys(CustomerData.dateOfbirth);
	    
	    // male by default, only change the radiobutton for female gender
	    if(CustomerData.gender.equals("female")) {
	    	driver.findElement(AddNewCustomer.femaleRadioButtonLocator).click();
	    }
	    	
	    /* does not work, apparently cannot click the radiobutton which is already selected
	    if(CustomerData.gender.equals("male")) {
	    	driver.findElement(AddNewCustomer.maleRadioButtonLocator).click();	  
	    }else if(CustomerData.gender.equals("female")) {
	    	driver.findElement(AddNewCustomer.femaleRadioButtonLocator).click();
	    } */
	    
	    driver.findElement(AddNewCustomer.addrInpuFieldLocator).sendKeys(CustomerData.address);
	    driver.findElement(AddNewCustomer.cityInpuFieldLocator).sendKeys(CustomerData.city);
	    driver.findElement(AddNewCustomer.stateInpuFieldLocator).sendKeys(CustomerData.state);
	    driver.findElement(AddNewCustomer.pinInpuFieldLocator).sendKeys(CustomerData.pin);
	    driver.findElement(AddNewCustomer.mobileInpuFieldLocator).sendKeys(CustomerData.mobileNumber);
	    // don't know how to make the random number in the User TestData Random for each run, so this is a workaround
	    String customerEmail = "m" + meilrandnum + CustomerData.email; 
	    System.out.println(customerEmail);
	    driver.findElement(AddNewCustomer.emailInpuFieldLocator).sendKeys(customerEmail);
	    driver.findElement(AddNewCustomer.passInpuFieldLocator).sendKeys(CustomerData.customerPassword);
	    		 
	    Thread.sleep(1000); // better use explicit wait		
		// take a screenshot here, to see the data used for the New Customer, from time to time it does not work
		try {
			takeSnapShot(driver, "c:\\Users\\cadov\\Documents\\Vyuka\\PragueCodingSchool\\SmokeTest\\screenshots\\create_new_customer_"+ meilrandnum + ".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
	    driver.findElement(AddNewCustomer.submitButtonLocator).click();
		Thread.sleep(2000); // better with the explicit wait 
		String expectedResult = "Customer Registered Successfully!!!";
		String actualResult =  driver.findElement(AddNewCustomer.successMessageLocator).getText();
		// System.out.print(actualResult);
		assertEquals(expectedResult, actualResult);
		
		// Retrieve the Customer ID - TODO move the css selector to the locators 
		String customerID = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
		// System.out.println(customerID);
		System.out.print("    - customerID: ");
		System.out.println(customerID);
		System.out.print("    - email: ");
		System.out.println(CustomerData.email);
		
		return customerID;					
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

