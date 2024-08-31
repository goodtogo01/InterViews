package com.SeleniumTest.Automation;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTable02 {
	static FirefoxDriver driver;


	public static void main(String[] args) throws InterruptedException, SocketException {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		Thread.sleep(15000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.xpath("//form[@id='login-form']")).submit();
		Thread.sleep(10000);
		dataTables();
		driver.quit();
	}

	/*Find all data from the table
	 * find the number of Column and row
	 * fatch data from the salary column
	 * sort the salary
	 * */

	public static void  dataTables() {
		// Find all data from the table
		System.out.println("======================== Entire Table ==================================");
		List<WebElement> fullTable = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]"));
		for(WebElement we:fullTable) {
			System.out.println(we.getText());
		}
		System.out.println("=======*******************************************************************=========\n");
		
		//  find the number of Column and row
		
		System.out.println("======================== Columns ==================================");
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='appointmentTypesTable']/tbody/tr[1]/td"));
		System.out.println("Number of columns : "+col.size());
		System.out.println("======================== Rows ==================================");
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='appointmentTypesTable']/tbody/tr"));
		System.out.println("Number of Rows : "+rows.size());
		
		// * fatch data from the Duration (min) column
		System.out.println("\n======================== Actual Duration List ==================================");
		List<WebElement> durations = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[23]/table[1]/tbody[1]/tr/td[2]"));
		System.out.println("Duration (min)");
		for(int i =0; i<durations.size(); i++) {
			System.out.print(durations.get(i).getText()+" ");
		}
		// sort the Durations
		List<Integer> duration = new ArrayList<Integer>();
		 for (WebElement durationSort:durations) {
			 duration.add(Integer.valueOf(durationSort.getText()));
			}
		 Collections.sort(duration);
		 System.out.println("\n======================== After Sorted Duration List ==================================");
		 for(Integer d:duration) {
			 System.out.print(d+" ");
		 }
		 System.out.println("\n************************** END TEST *****************************************\n");
 
		
	}
	
	public static void qt() {
		driver.quit();
	}
}
