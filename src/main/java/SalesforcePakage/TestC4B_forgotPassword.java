package SalesforcePakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;


public class TestC4B_forgotPassword extends ReusuableFunction
{
	static WebDriver driver;
	static ExtentReports report;
	static com.relevantcodes.extentreports.ExtentTest logger;
	
	@Test
	public static void forgotPasswordB() throws InterruptedException {
		
		CreateTestScriptReport("TC4B_WrongUsernamePwd");
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		WebElement Uname=driver.findElement(By.id("username"));
		Uname.sendKeys("123");
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("22131");
		WebElement loginbtn1=driver.findElement(By.id("Login"));
		loginbtn1.click();
		
		String Errormsg = driver.findElement(By.xpath("//div[@id='error']")).getText();
		String ActualError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Thread.sleep(3000);
		if(ActualError.equals(Errormsg)) {
	        System.out.println("Test Case Passed");
	    }else{
	        System.out.println("Test Case Failed");
	    }
		
		ReusuableFunction.report.endTest(logger);
		ReusuableFunction.report.flush();
		driver.close();
		System.out.println("TC4B_WrongUsernamePwd is completed");
		
	}

	
}
