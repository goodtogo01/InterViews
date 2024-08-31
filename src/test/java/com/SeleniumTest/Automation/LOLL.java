package com.SeleniumTest.Automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LOLL {

//Naukri.com (@naukridotcom) • Instagram photos and videos
	static WebDriver driver;
	public static String path = "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe";
	static long Time_count = 20;
	public static WebDriverWait wait;
	public Alert alrt;
	public static Actions action;

	
	//Find the right window
	public static boolean rightWindow(List<String> windowList, String rightTitle) {
		for(String e:windowList) {
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(rightTitle)) {
				System.out.println("Found right window....");
				return true;
			}
		}
		return false;
	}
	//Switch to parent window
	public static void pWindow(String parents) {
		driver.switchTo().window(parents);
		
	}
	
	//Close all window but parent
	public static void closeAllButParent(List<String> windowList, String parentW) {
		for(String e:windowList) {
			if(!e.equals(parentW)) {
				driver.switchTo().window(e).close();
			}
		}
	}
	// setup
	@BeforeMethod
	public static void tearUp() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		// driver.get("https://demoqa.com/alerts");
		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.navigate().to("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	// Open all window
	@Test
	public static void company() {
		String pWin = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on Facebook']")).click();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on Instagram']")).click();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on Twitter']")).click();
		driver.findElement(By.xpath("//a[@title='Follow Naukri.com on LinkedIn']")).click();
		Set<String> widows = driver.getWindowHandles();
		List<String> allWindow = new ArrayList<>(widows);
		if(rightWindow(allWindow, "Naukri.com (@naukridotcom) • Instagram photos and videos")) {
			System.out.println("Founded window is : "+driver.getTitle()+"\nURL is : "+driver.getCurrentUrl());
		}
		pWindow(pWin);
		closeAllButParent(allWindow, pWin);
		
		
		
		
		
	}

		
	


}
