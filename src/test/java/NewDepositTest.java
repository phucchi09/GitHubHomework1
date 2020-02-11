

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;  // testng annotation use garne      don't import JUnit wala 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewDepositTest 
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
	
	@Test(priority = 1)
	public void userShouldBeAbleToAddDeposit() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
		//Thread.sleep(2000);
		
		// 3. Enter password: abc123
		driver.findElement(By.xpath("//input[contains(@placeholder,'assword')]")).sendKeys("abc123");
		//Thread.sleep(2000);
		
		//4. Click login button
		driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
		
		String expectedTitle = "Dashboard- TechFios Test Application - Billing";
		Assert.assertEquals(driver.getTitle(),expectedTitle, "Dashboard- TechFios Test Application - Billing");
		
	Thread.sleep(2000);
	}
	
	/*
	@Test(priority = 2)
	public void userShouldBeAbleToAddDeposit2() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
		//Thread.sleep(2000);
		
		// 3. Enter password: abc123
		driver.findElement(By.xpath("//input[contains(@placeholder,'assword')]")).sendKeys("abc123");
		//Thread.sleep(2000);
		
		//4. Click login button
		driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
		//Thread.sleep(2000);
		// 5. Click on Transactions in the Side Navigation
				driver.findElement(By.linkText("Transactions")).click();	
				Thread.sleep(2000);
				
				// 6. Click on transfer
				driver.findElement(By.linkText("Transfer")).click();	
				Thread.sleep(2000);

				// 7. Fill in the New Transfer Form
			    Select fromAccountType = new Select(driver.findElement(By.xpath("//*[@id='faccount']")));
				fromAccountType.selectByValue("lol");
				Thread.sleep(3000);
	}
	*/
	

		
	 
	@AfterMethod
	 public void closeEverything()
		{		
		    driver.close();
		   driver.quit();
		}

}
