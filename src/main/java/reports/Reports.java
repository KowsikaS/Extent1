package reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports extentReports = new ExtentReports();
	public static ExtentSparkReporter extentSpark = new ExtentSparkReporter("Sparkreport.html");

	public static WebDriver driver;
//	
//	 public static ExtentTest extentTest;
//	 public static ExtentTest extentTest = extentReports.createTest("launching
//	 url");

	@Test(priority = 1)
	public static void FristClass() throws IOException {

		ExtentTest extentTest = extentReports.createTest("Valid Username & Password");
		extentReports.attachReporter(extentSpark);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {

			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("kowsika@promantus.com");
			extentTest.log(Status.PASS, "UserName field is Enabled, Hence entering username");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("tyshd");
			extentTest.info("Password field is enabled");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully Logged In");
			driver.findElement(By.xpath("//span[text()='SOS Panel ']")).click();
			extentTest.assignAuthor("Team");

//			TakesScreenshot screenshot = ((TakesScreenshot) driver);
//			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
//			// String string = screenshotAs.toString();
//			File file = new File("screen" + ".png");
//			FileUtils.copyFile(screenshotAs, file);
//			String string = file.toString();
//			extentTest.addScreenCaptureFromPath(string);
			// extentTest.log(Status.PASS, "Launching testCase is Pass");

			// driver.quit();

		} catch (Exception e) {

			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			// extentTest.log(Status.PASS, "Launching testCase is Pass");

			TakesScreenshot screenshot1 = ((TakesScreenshot) driver);
			File screenshotAs1 = screenshot1.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file1 = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string1 = file1.toString();
			extentTest.log(Status.FAIL, e);
//			extentTest.log(Status.FAIL, "error occured").addScreenCaptureFromBase64String(string1).getExtent()
//					.addTestRunnerOutput(string1);
			extentTest.addScreenCaptureFromPath(string1);

		}
		driver.quit();
	}

	@Test(priority = 2)
	public void WrongPass() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Valid UserName & Invalid Password");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("kowsika@promantus.com");
			extentTest.log(Status.PASS, "User field is enabled & entered username");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("12345");
			extentTest.info("Password field is enabled");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully LoggedIn");
			extentTest.assignCategory("Automation Testing");
		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
		}
		driver.quit();
	}

	@Test(priority = 3)
	public void WrongUserName() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Invalid UserName & Password");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("kowsikas@promantus.com");
			extentTest.log(Status.PASS, "User field is enabled & entered username");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("4916ui");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			extentTest.assignCategory("Selenium Testing");
		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
		}
		driver.quit();
	}

	@Test(priority = 4)
	public void emptyUserName() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Invalid Username & Valid Password");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");
		driver = new ChromeDriver();
		try {

			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("  ");
			extentTest.log(Status.PASS, "User field is enabled & entered username");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("tyshd");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			extentTest.assignCategory("Selenium Testing");
		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
		}
		driver.quit();
	}

	@Test(priority = 5)
	public void emptyPass() {
		ExtentTest extentTest = extentReports.createTest("Valid UserName and Invalid Password");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
		findElement.sendKeys("kowsika@promantus.com");
		extentTest.log(Status.PASS, "User field is visible UserName is enter");
		WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
		findElement2.sendKeys("   ");
		extentTest.info("Password field is present ");
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
		findElement3.click();
		extentTest.info(" Sucessfully clicked");
		driver.quit();
	}

	@Test(priority = 6)
	public void bothEmptyField() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Empty Fields ");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("  ");
			extentTest.log(Status.PASS, "User field is enabled & entered username");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("  ");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			extentTest.assignCategory("Selenium Testing");
			extentTest.assignAuthor(" Kowsika Team ");
			extentTest.assignDevice("chrome").getExtent();
		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
		}
		driver.quit();
	}

	@Test(priority = 7)
	public void forgetPassWord() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Promantus\\eclipse-workspace\\Extentreport\\exe\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
		ExtentTest extentTest = extentReports.createTest("Forgot Password ");
		driver.findElement(By.xpath("//a[text()='Forget Password?']")).click();
		extentTest.log(Status.PASS, "Click forget password ");
		driver.quit();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
//		extentTest.skip("made skip");
//		extentTest.assignAuthor("kowsika").assignCategory("testing team");

	}

	@AfterTest
	public void afterTest() {
		extentReports.flush();
	}

	@BeforeMethod
	public void beforemethod() throws IOException {
		// extentTest.log(Status.FAIL, "before method is not executed ").getStatus();
		// System.out.println("hello value ");

	}

	@AfterMethod
	public void afterMethod() {
		// extentTest.log(Status.PASS, "sucessfully launch before method");
		// System.out.println("hello 2 ");
	}

}
