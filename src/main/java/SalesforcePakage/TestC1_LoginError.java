package SalesforcePakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class TestC1_LoginError extends ReusuableFunction
{
	static int resultflag = 0;
	static WebDriver driver;
	@Test
	public static void loginError()
	{
		CreateTestScriptReport("TC2_LoginError");
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		WebElement Uname=driver.findElement(By.id("username"));
		Uname.sendKeys("raji_salesforce@sales.com");
		driver.findElement(By.id("password")).clear();
		WebElement loginbtn1=driver.findElement(By.id("Login"));
		loginbtn1.click();
		String errormessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if (errormessage.equals("Please enter your password.")){
			resultflag = 1;
		}
		else {
			resultflag = 0;
		}
		
		ReusuableFunction.report.endTest(logger);
		ReusuableFunction.report.flush();
		driver.close();
		System.out.println("TC2_LoginError is completed");
		
		
	}
}
