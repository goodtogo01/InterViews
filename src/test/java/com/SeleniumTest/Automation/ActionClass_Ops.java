package com.SeleniumTest.Automation;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass_Ops {

	static LocatorsTest ltest;
	static WebDriver driver;
	public static String path = "C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe";
	//public static String path = "C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe";
	static long Time_count = 12;
	public static WebDriverWait wait;
	public Alert alrt;
	
	@FindBy(xpath = "//form[@id='userForm']")
	public static WebElement myEle;

	@BeforeMethod
	public static void tearUp() {
		ltest = new LocatorsTest();
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		// driver.get("https://demoqa.com/alerts");
		driver.navigate().to("https://demoqa.com/text-box");
		driver.manage().window().maximize();
	}

	public static void takeScreenShootSpecificElement(WebElement element) throws IOException {
		File screenShotFile = element.getScreenshotAs(OutputType.FILE);
		String curentDir = System.getProperty("user.dir");
		FileUtils.copyFile(screenShotFile,
				new File(curentDir + "/Screen_Shoot/" + System.currentTimeMillis() + ".png"));

	}



	
	
	@Test(priority = 2)
	public void basicAlert() throws Exception {

		System.out.println("Basic Alert.");

//		driver.findElement(By.id("alertButton")).click();
//		String txt = driver.switchTo().alert().getText();
//		System.out.println(txt);
//		driver.switchTo().alert().dismiss();

		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		driver.switchTo().alert().sendKeys("Text");

		// driver.close();

	};

	@Test
	public static void actionClassed() throws IOException, InterruptedException {
		Actions action = new Actions(driver);

		WebElement we = driver.findElement(By.xpath("//form[@id='userForm']"));
		// Enter address
		WebElement currentAdds = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currentAdds.sendKeys("43 School Lane London EC71 9GO");

		/// copy curent address to parmanent address

		// Select current address CONTROL + A
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// CopY current address CONTROL + C
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		//Thread.sleep(10000);
		takeScreenShootSpecificElement(we);
		// driver.switchTo().
		// Press tab key to jump into permanent address taxt box

		action.sendKeys(Keys.TAB);
		action.build().perform();

		// Past to permanet address
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		WebElement permanentADds = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		assertEquals(currentAdds.getAttribute("value"), permanentADds.getAttribute("value"));
		System.out.println("Address transfired successFully");
		takeScreenShootSpecificElement(we);

		action.build().perform();
		driver.navigate().refresh();
	}

}
