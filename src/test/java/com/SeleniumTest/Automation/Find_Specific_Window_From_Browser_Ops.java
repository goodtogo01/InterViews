package com.SeleniumTest.Automation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Find_Specific_Window_From_Browser_Ops {

	static WebDriver driver;
	public static String path = "C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe";
	//public static String path = "C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\geckodriver.exe";
	static long Time_count = 20;
	public static WebDriverWait wait;
	public Alert alrt;
	public static Actions action;

	@BeforeMethod
	public static void tearUp() {

		System.setProperty("webdriver.chrome.driver", path);
		// driver = new FirefoxDriver();
		 driver = new ChromeDriver();
//
//		ChromeOptions chromeOptions = new ChromeOptions();
//		driver = new ChromeDriver(chromeOptions);

			driver.navigate().to("https://www.naukri.com/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
	}
	// Switch to parent window
	public static void switchToParentWindow(String parentWin) {
		driver.switchTo().window(parentWin);

	}

	public static void closeAllButParent(List<String> wList, String mainWindow) {
		for (String e : wList) {
			if (!e.equals(mainWindow)) {
				driver.switchTo().window(e).close();
			}

		}

	}

	public static void wt() {
		//wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	@Test(priority = 2)
	public void basicAlert() throws InterruptedException, IOException {
		String parantWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on Facebook']")).click();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on Instagram']")).click();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on Twitter']")).click();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on LinkedIn']")).click();
		
		Set<String> allWindow = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(allWindow);
		if (findRightWindow("Naukri.com | Facebook", windowList)) {
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
		}
		WebElement we = driver.findElement(By.xpath("//form[@id='login_popup_cta_form']"));

		takeScreenShootSpecificElement(we);
		switchToParentWindow(parantWindow);
		closeAllButParent(windowList, parantWindow);
	}

	public static boolean findRightWindow(String windowTitle, List<String> list) {
		for (String e : list) {
			String title = driver.switchTo().window(e).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("Found the right window ....");
				return true;
			}
		}
		return false;
	}

	public static void takeScreenShoot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(curentDir + "/Screen_Shoot/" + System.currentTimeMillis() + ".png"));

	}

	public static void takeScreenShootSpecificElement(WebElement element) throws IOException {
		File screenShotFile = element.getScreenshotAs(OutputType.FILE);
		String curentDir = System.getProperty("user.dir");
		FileUtils.copyFile(screenShotFile,
				new File(curentDir + "/Screen_Shoot/" + System.currentTimeMillis() + ".png"));

	}
}
