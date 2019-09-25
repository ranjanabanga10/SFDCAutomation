package SalesforcePakage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class TC06_ProfileTest extends ReusuableFunction
{
	static WebDriver driver;
	static ExtentReports report;
	static com.relevantcodes.extentreports.ExtentTest logger;
	@Test
	public static void profileTC06() throws InterruptedException {
		CreateTestScriptReport("TC06_profile test case...");
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
		else {
			System.out.println("User drop down menu not displayed with option...");
		}
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();

		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.id("aboutTab")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'About')]"));

		driver.findElement(By.id("lastName")).sendKeys("Kaur");
		driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']")).click();
		driver.switchTo().defaultContent();
		String title = driver.getTitle();
		System.out.println("Title::"  + title);

		String url = driver.getCurrentUrl();
		System.out.println("url is ::: " + url);
		String parent = driver.getWindowHandle();
		System.out.println("Name of the window:::" + parent);

		driver.findElement(By.id("publisherAttachTextPost")).click();
		driver.findElement(By.id("publisherAttachTextPost")).sendKeys("Hello Salesforce!!!!");
		WebElement postIframe=driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		driver.switchTo().frame(postIframe);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("publishersharebutton")).click();
		System.out.println("Text Posted is shared");

		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		driver.findElement(By.id("chatterUploadFileAction")).click();
		driver.findElement(By.id("chatterFile")).sendKeys("/Users/ranjanabanga/Desktop/sales.docx");

		WebElement moderator = driver.findElement(By.id("displayBadge"));
		mouseOver(driver, moderator);
		WebElement AddPhotolink = driver.findElement(By.id("uploadLink"));
		AddPhotolink.click();
		WebElement Iframe = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		switchFrameid(driver,"uploadPhotoContentId");
		WebElement choosefileoption = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
        choosefileoption.click();
		//clickObj(choosefileoption, "choosefileoption");
        enterText(choosefileoption, "/Users/ranjanabanga/Desktop/IMG_1789.JPG", "choosefileoption");
		//choosefileoption.sendKeys("/Users/ranjanabanga/Desktop/IMG_1789.JPG");

		WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:save"));
		save.click();



		driver.switchTo().defaultContent();

		ReusuableFunction.report.endTest(logger);
		ReusuableFunction.report.flush();
		driver.close();
		System.out.println("TC06_Profile dropdown test is completed");
	}
}
