package com.SeleniumTest.Automation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertSelenium {
	static LocatorsTest ltest;
	static WebDriver driver;
	public static String path = "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe";
	static long Time_count = 12;
	public static WebDriverWait wait;
	public Alert alrt;

	@BeforeMethod
	public static void tearUp() {
		ltest = new LocatorsTest();
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
	}

	@Test(priority = 1) // using java Script executor
	public void promptAlert() {

		System.out.println("Prompt Alert.");

		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		
		alrt = driver.switchTo().alert();
		String text2 = alrt.getText();
		System.out.println("Prompt Alert Text : " + text2);
		
		alrt.sendKeys("Khosruz zaman");
		//alrt.accept();
	}

	@Test(priority = 2)
	public void basicAlert() throws Exception {

		System.out.println("Basic Alert.");
		try {
			driver.findElement(By.id("alertButton")).click();
			Alert alrt = driver.switchTo().alert();
			String getAlrtText = alrt.getText();
			System.out.println("Basic Alert Text is : " + getAlrtText);
			alrt.dismiss();
			System.out.println("Unexpected alert accepted");
		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}
		driver.close();
		

	};

	@Test(priority = 3)
	public void timerAlert() {

		System.out.println("Timer Alert.");
		try {
			driver.findElement(By.id("timerAlertButton")).click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			alrt = driver.switchTo().alert();
			String text2 = alrt.getText();
			System.out.println("Timer Alert Text : " + text2);
			alrt.accept();
			System.out.println("Unexpected alert accepted");
		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}

	};
	@Test(priority = 4) // using java Script executor
	public void confirmAlert() {

		System.out.println("Confirm Alert.");
		 
			WebElement element = driver.findElement(By.id("confirmButton"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);		
			alrt = driver.switchTo().alert();
			String text2 = alrt.getText();
			System.out.println("Confirm Alert Text : " + text2);
			alrt.accept();
		}

	}
