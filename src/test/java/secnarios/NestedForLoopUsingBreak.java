package secnarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NestedForLoopUsingBreak {
	static FirefoxDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\geckodriver.exe");
 
		driver = new FirefoxDriver();
		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.xpath("//form[@id='login-form']")).submit();
		boolean result = verifyServiceType("Urology");
		System.out.println(result);
	 
 
	}
	public static boolean verifyServiceType(String sName) throws InterruptedException
	{
		boolean result=false ; 
		List<WebElement> pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		List<WebElement> tdList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
 
		//Example for Nested for loop 
		outerloop:
		for(int i = 1 ; i< pageList.size();i++)
		{
			for(int j=0;j<tdList.size();j++)
			{
				if(tdList.get(j).getText().contains(sName))
				{
					System.out.println("Service Type Found!!!");
					result = true;
					break outerloop;
				}
			}
			pageList =driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a")); 
			pageList.get(i).click();
			tdList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		}
		return result;
	}
}
