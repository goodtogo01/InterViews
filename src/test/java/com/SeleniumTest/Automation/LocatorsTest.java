package com.SeleniumTest.Automation;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsTest {
	static LocatorsTest ltest;
	static WebDriver driver;
	public static String path = "C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe";
	static long Time_count = 12;
	public static WebDriverWait wait;

	@BeforeMethod
	public static void tearUp() {
		ltest = new LocatorsTest();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.navigate().refresh();
		driver.navigate().to("https://www.demo.iscripts.com/multicart/demo/index.php");
		 driver.get("https://demoqa.com/browser-windows");
		//driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// https://www.demo.iscripts.com/multicart/demo/index.php
	}
	
	@Test(priority = 1)
	public void alrtHndl() throws Exception {
		//Basic alert
		System.out.println("Basic Alert.");
		driver.findElement(By.id("alertButton")).click();
		Alert alrt = driver.switchTo().alert();
		String getAlrtText = alrt.getText();
		System.out.println("Basic Alert Text is : "+getAlrtText);
		alrt.dismiss();
		//Timer alert
		System.out.println("Timer Alert.");
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		String  text2 = alrt.getText();
		System.out.println("Timer Alert Text : "+text2);
		alrt.accept();
		
		
	};
	

	@Test(priority = 1)
	public void lgn() throws InterruptedException {

		// Opening all the child window
		
		driver.findElement(By.xpath("//button[@id='dLabellogin']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driver.findElement(By.xpath("//button[@id='jqLogin']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(text(),'Clothing')]")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(text(),'Peters casual')]")).click();
	
		driver.findElement(By.xpath("//input[@id='txtQty']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtQty']")).sendKeys("2");
	
		String actualValue = driver.findElement(By.xpath("//span[@id='product_price_val']")).getText();

		System.out.println(actualValue);
		
//		WebElement we = driver.findElement(By.xpath(" //*[@id='wrapper']/div[2]/div/div/div/form/div[1]/section[1]"));
//
//		System.out.println(we.getText());
//
//		// *[@id="wrapper"]/div[2]/div/div/div/form/div[1]/section[1]
//
//		System.out.println(we.getText());

		// *[@id="66"]/div/div[7]/div[1]/a
		// Get window hndl
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is : " + mainWindow);

		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Chield window handle is : " + s1);
		Iterator<String> itr = s1.iterator();

		// here we will check if chield window has other child window
		while (itr.hasNext()) {
			String chieldWindow = itr.next();
			if (!mainWindow.equalsIgnoreCase(chieldWindow)) {
				driver.switchTo().window(chieldWindow);
//			WebElement text = driver.findElement(By.id("sampleHeading"));
//			System.out.println("Heading of chile window is "+ text.getText());
				driver.close();
				System.out.println("Chield window is clsed.");
			}
		}

	}

	@Test(priority = 1)
	public void multiPleWindows() {

		// Opening all the child window
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("messageWindowButton")).click();

		// Get window hndl
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is : " + mainWindow);

		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Chield window handle is : " + s1);
		Iterator<String> itr = s1.iterator();

		// here we will check if chield window has other child window
		while (itr.hasNext()) {
			String chieldWindow = itr.next();
			if (!mainWindow.equalsIgnoreCase(chieldWindow)) {
				driver.switchTo().window(chieldWindow);
//			WebElement text = driver.findElement(By.id("sampleHeading"));
//			System.out.println("Heading of chile window is "+ text.getText());
				driver.close();
				System.out.println("Chield window is clsed.");
			}
		}

	}

	@Test(priority = 1)
	public void windowHndl() {
		// Click on the button where child window located
		driver.findElement(By.id("windowButton")).click();

		// Get window hndl
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindowss = driver.getWindowHandles();
		Iterator<String> itr = allWindowss.iterator();

		// here we will check if chield window has other child window
		while (itr.hasNext()) {
			String chieldWindow = itr.next();
			if (!mainWindow.equalsIgnoreCase(chieldWindow)) {
				driver.switchTo().window(chieldWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of chile window is " + text.getText());
			}
		}

	}

	// @Test(priority = 2)
	public void test1() {
		// tearUp();
		String title = driver.getTitle();
		System.out.println("Title of this page is : " + title);
	}

	// @Test(priority = 1)
	public static void selectclassValue() {
		// Select manue
		Select sl = new Select(driver.findElement(By.xpath("//*[@id='cars']")));
		if (sl.isMultiple()) {
			// Select multiple value by index
			sl.selectByIndex(0);
			/*
			 * sl.selectByIndex(2);
			 * 
			 * // serching by name sl.selectByValue("volvo"); sl.selectByValue("audi");
			 * 
			 * //serch by visible taxt sl.selectByVisibleText("Audi");
			 * sl.selectByVisibleText("Saab");
			 */
		}
		// List manue
		Select sl2 = new Select(driver.findElement(By.id("oldSelectMenu")));
		List<WebElement> optios = sl2.getOptions();
		for (WebElement oo : optios) {
			System.out.println(oo.getText());

		}

	}

	@Test(priority = 3)
	public void hoverOvers() {
		// tearUp();

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		// Mouse hover actions on an element using Actions class
		action.moveToElement(element).build().perform();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[3]/a[2]/span[1]")));

		WebElement element2 = driver.findElement(By.xpath(
				"//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[3]/a[2]/span[1]"));
		action.moveToElement(element2);
		// Mouse of hover actions on a sub-elemenet useing Actions Class:
		action.click().build().perform();
		System.out.println(driver.getCurrentUrl());

	}

	@Test(priority = 1)
	public void locatorsTest() {
		// Find by ID
		driver.findElement(By.id("userName")).sendKeys("khosruz zaman");
		driver.findElement(By.id("userEmail")).sendKeys("khosruz@mailinator.com");
		driver.findElement(By.xpath("//*[@id='currentAddress']"))
				.sendKeys("508 Windield Avenue, Upper Darby, PA, 19082.");
		driver.findElement(By.xpath("//*[@id='permanentAddress']"))
				.sendKeys("363 Lakeview Dr, Draxel Hill, PA, 19082.");

		driver.findElement(By.xpath("//*[@id='submit']")).submit();

		String details = driver.findElement(By.xpath("//*[@id='output']/div")).getText();
		System.out.println(details);

		// *[@id="submit"] #submit //*[@id="userForm"]/div[5]/div //*[@id='submit']
	}

	// @AfterMethod
	public static void closeBrowsers() {
		driver.close();

	}
}
