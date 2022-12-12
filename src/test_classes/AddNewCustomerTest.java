package test_classes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.AddNewCustomer;
import pages.CreateNewCustomer;
// import pages

public class AddNewCustomerTest  {
	// not used for the testing, some stuff probably not up to date
	// Declare the virtual browser
	public static WebDriver driver = null;
		
	
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();		
	}
	
	@AfterAll
	public static void afterAll() {
		// after each of the test method
		//driver.close();
		}
		
	@Test
	@DisplayName("Create new customer")
	public void tc_create_new_customer() throws InterruptedException{
		String meilrandnum = "10";
		String customerID = CreateNewCustomer.NewCustomer(driver, meilrandnum);
		
		Thread.sleep(2000);
		// System.out.print(customerID);
		assertEquals(customerID, 1); 

		/*
		String expectedResult = "Gender";
		String actualResult = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[1]")).getText(); 
		// 	System.out.print(actualResult);  
		assertEquals(expectedResult, actualResult);*/ 
	}
	
}
