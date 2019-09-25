package SalesforcePakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;


public class TestC4A_forgotPasswordtest extends ReusuableFunction
{
	static WebDriver driver;
	static ExtentReports report;
	static com.relevantcodes.extentreports.ExtentTest logger;
	@Test
	public static void forgotPassword() {
		CreateTestScriptReport("TC4A_ForgotPassword");
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		WebElement Fpwd= driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
		Fpwd.click();
		WebElement Uname=driver.findElement(By.xpath("//input[@id='un']"));
		Uname.sendKeys("raji_salesforce@sales.com");
		WebElement cont=driver.findElement(By.xpath("//input[@id='continue']"));
		cont.click();
		
		ReusuableFunction.report.endTest(logger);
		ReusuableFunction.report.flush();
		driver.close();
		System.out.println("TC4A_ForgotPassword is completed");
	}
}
