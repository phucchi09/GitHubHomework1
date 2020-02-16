package test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Removeelement
{
WebDriver driver;
	
	@BeforeMethod 
	 public void Hw5Beginner()
	 {
		    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	        driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		    
		    driver.get("http://techfios.com/test/billing/?ng=admin/"); 		    
	 }
	
	@Test(priority = 1)
	public void addingRandomizeAccountAndBalance() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//input[contains(@placeholder,'assword')]")).sendKeys("abc123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();		
		Thread.sleep(4000);

		
		// CRM ko xpath  --> //ul[@id='side-menu']/descendant::span[contains(text(),'CRM')]
		
//	    5. Click on Bank & Cash
			By BANK_N_BALANCE_MENU_LOCATOR = By.xpath("//ul[@id='side-menu']/descendant::span[text()='Bank & Cash']");				
			driver.findElement(BANK_N_BALANCE_MENU_LOCATOR).click(); Thread.sleep(3000);
		//  6. Click on  List Account
		By LIST_ACCOUNT_PAGE_LOCATOR = By.linkText("List Accounts");
		waitForElement(LIST_ACCOUNT_PAGE_LOCATOR, driver, 30); 
		driver.findElement(LIST_ACCOUNT_PAGE_LOCATOR).click(); Thread.sleep(3000);
		
		List<WebElement> namesElements = driver.findElements(By.xpath("//table/descendant::td"));
		
	    String actualAccountTitle = namesElements.get(namesElements.size()-3).getText();
	
	   
	    System.out.println("remove hun alagya element is " +actualAccountTitle);
        //String gooo = #page-wrapper > div.wrapper.wrapper-content > div.row > div > div > div.ibox-content > table > tbody > tr:nth-child(771) > td:nth-child(1);
		
		
		Thread.sleep(3000);
		// deleting Recent Account Name 
		//WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsd;
		
//		if (driver instanceof JavascriptExecutor) 
//		{
//			//  div.parentNode.removeChild(div); 
//		 //   jsd = (JavascriptExecutor) driver;
//	
//		   
//
//		//jsd.executeScript("tr:nth-child(759) > td:nth-child(3)";
//		
//		
////		Object document;
////		var elem = ((Object) document).getElementById("page-wrapper");
////		((Object) elem.parentNode).removeChild(elem);
////		}
//	
//	    
	    
		
	}	
		
		

		
		
		
	 
		@AfterMethod
	private void closEverything()
		{
		// TODO Auto-generated method stub
		
	}

	private void waitForElement(By nEW_ACCOUNT_PAGE_LOCATOR, WebDriver driver2, int i) {
		new WebDriverWait(driver2, i).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nEW_ACCOUNT_PAGE_LOCATOR));
		
	}

	private boolean isDescriptionMatch(String expectedAccountTitle, List<WebElement> accountNameElements) {
		for (int i=0; i < accountNameElements.size(); i++) 
	     {
	        if(expectedAccountTitle.equalsIgnoreCase(accountNameElements.get(i).getText()))
	        {
	        	System.out.println("Passed          lol");
	        }
	     {
	     return true;
	  }
	}
	 return false;
		
	}


}
