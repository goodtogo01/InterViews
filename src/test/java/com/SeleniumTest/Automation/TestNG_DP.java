package com.SeleniumTest.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DP {
	@DataProvider (name = "data-provide")
	public Object[][] dpMethod(){
		return new Object[][] {{1,2,3}, {2,3,2}};
	}

	@Test(dataProvider = "data-provide")
	public void dpTest(int a, int b) {
		int sum = a+b;
	System.out.println(sum);
	}
	@Test(dataProvider = "loginDP")
	public void loginTest(String passwords, String username) {
		System.setProperty("webdriver.chrome.driver", "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(passwords);
		driver.findElement(By.id("login-button")).click();
		driver.manage().deleteAllCookies();
		driver.close();
		
		//*[@id="MainTables"]
		//*[@id="MainTables"]/tbody
	}
	@DataProvider(name = "loginDP")
	public Object[][] logins(){
		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"locked_out_user", "secret_sauce"},
			{"problem_user", "secret_sauce"},
			{"performance_glitch_user", "secret_sauce"}
		};
	}
	@Test
	public void dataTable() {
		System.setProperty("webdriver.chrome.driver", "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/zaman/OneDrive/Desktop/dataTable.html");
		List<WebElement> we = driver.findElements(By.xpath("//*[@id='MainTables']/tbody"));

		//Entire Table Data
		for(WebElement tt:we) {
	System.out.println(tt.getText());
	String columnsName = tt.findElement(By.tagName("th")).getText();
 
		System.out.println("Columns are : "+tt.getText());
	
}
		//Get col
	driver.close();	
		
	}
}
