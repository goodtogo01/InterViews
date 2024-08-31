package com.SeleniumTest.Automation;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class TakeScreenShoots{
	public static String path = ".//Screen_Shoot/"+reportName()+".png";
	public static void main(String[] args) throws InterruptedException, IOException {
		oldVersion();
		//newVersion();
		
	}
	public static void oldVersion()  throws InterruptedException, IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ebay.com/");
		Thread.sleep(10000);
		File screenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShots, new File(path));
		driver.close();
		
	}
	public static void newVersion() throws IOException, InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(path));
		driver.close();
	}
	
	public static String reportName() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_mm_dd_HH_mm_ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String formattedTime = dateTimeFormatter.format(localDateTime);
		String reportName = "Shoot_On_" + formattedTime;
		return reportName;
	}
	
	

}
