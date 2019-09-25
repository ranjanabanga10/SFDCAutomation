package SalesforcePakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class TC05_UserMenudrpdwntest extends ReusuableFunction
{
	static WebDriver driver;
	static ExtentReports report;
	static com.relevantcodes.extentreports.ExtentTest logger;
	@Test
	public static void userDropDwntest() 
	{
		CreateTestScriptReport("TC05_User menu drop down displayed...");
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		WebElement Uname=driver.findElement(By.id("username"));
		Uname.sendKeys("raji_salesforce@sales.com");
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("Test@2019!");
		WebElement loginbtn1=driver.findElement(By.id("Login"));
		loginbtn1.click();
		WebElement usrdrpdwn=driver.findElement(By.id("userNavLabel"));
		usrdrpdwn.click();
		if(usrdrpdwn.isDisplayed()) {
			System.out.println("User drop down menu is displayed with option...");
		}
		
		ReusuableFunction.report.endTest(logger);
		ReusuableFunction.report.flush();
		driver.close();
		System.out.println("TC05_User menu drop down is completed");
	}
}
