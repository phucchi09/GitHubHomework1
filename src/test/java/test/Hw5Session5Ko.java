package test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hw5Session5Ko
{
	
WebDriver driver;
	
	@BeforeMethod 
	 public void learnWindowHandle()
	 {
		    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	        driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		    
		    driver.get("http://techfios.com/test/billing/?ng=admin/"); 
		    
	 }
	
	@Test
	public void DepositHw() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
		//Thread.sleep(2000);
		
		// 3. Enter password: abc123
		driver.findElement(By.xpath("//input[contains(@placeholder,'assword')]")).sendKeys("abc123");
		//Thread.sleep(2000);
		
		//4. Click login button
		driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();

		// 5. Click on Transactions in the Side Navigation
		driver.findElement(By.linkText("Transactions")).click();	
		//Thread.sleep(2000);
		//ANOTHER   WAY   XPATH ASIS  -->  By TRANSACTION_MENU_LOCATOR = By.xpath("//ul[@id='side-menu']/descendant::span[text()='Transactions']");
	    // xpath axis use garepachi aru side menu ma vayeka element lai yehi xpath le kaam gar6 --> jus tchange "Transactions"= "CRM" crm ko lagi 
		//By TRANSACTION_MENU_LOCATOR = By.xpath("//ul[@id='side-menu']/descendant::span[text()='Transactions']");
		
		By NEW_DEPOSIT_PAGE_LOCATOR = By.linkText("New Deposit");
		
		//driver.findElement(TRANSACTION_MENU_LOCATOR).click();
		
		waitForElement(NEW_DEPOSIT_PAGE_LOCATOR, driver, 30);  // at work we just have to call method = waitForElement();
		Thread.sleep(3000);
		driver.findElement(NEW_DEPOSIT_PAGE_LOCATOR).click();
		
		Thread.sleep(3000);
		//Select an account 
		Select select = new Select(driver.findElement(By.cssSelector("select#account")));
		select.selectByVisibleText("Swimming");
		
		
//		Random rnd = new Random();
//		rnd.nextInt(999);
		//  OR 
		//new Random().nextInt(999);
		
		String expectedDescription = "AutomationTest" + new Random().nextInt(999);
		driver.findElement(By.id("description")).sendKeys(expectedDescription);
		Thread.sleep(3000);
		driver.findElement(By.id("amount")).sendKeys("100,000");
		Thread.sleep(3000);
		driver.findElement(By.id("submit")).click();
		 
		////td/a will also work   //*[contains(@class, 'blockUI')]
		
		
//new WebDriver(driver,60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td/a")));
		
		
		//Assert.assertTrue(isDescriptionMatch(expectedDescription,  descriptionElements), "Deposit unsuccessful");
		
		// List banaune Descriptions haruko lagi 
		Thread.sleep(3000);
		List <WebElement> descriptionElements = driver.findElements(By.xpath("//table/descendant::a"));  // all 20 elements of Descritpion got stored in     descriptionElements
		
		System.out.println(descriptionElements.get(0).getText()); 
		
		Thread.sleep(4000);
		
		
		
		
	}

	private void waitForElement(By locator1, WebDriver driver1, int time)
	  {
		// Instinatiate the WebDriverWait 
		 new WebDriverWait(driver1, time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator1));  //  time = whatever time is passed or changed by people it will get the updated time 
		
	  }
	
	@AfterMethod
	 public void closeEverything()
		{		
		    driver.close();
		   driver.quit();
		}


}
