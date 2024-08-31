package com.SeleniumTest.Automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class linn {
	public WebDriver driver;

	@BeforeMethod
	public void startsUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/zaman/eclipse-workspace/Automation/dataTable.html");
	}

	@Test
	public void dataTable() {
		/*Find all data from the table
		 * find the number of Column and row
		 * fatch data from the salary column
		 * sort the salary
		 * */

		// Entire Table Data
		System.out.println("Entire Table Datas: ");
 		List<WebElement> tableData = driver.findElements(By.xpath("//*[@id='MainTables']"));
		for(int i =0; i<tableData.size(); i++){
			System.out.println(tableData.get(i).getText());
		}
		
		//find the number of Column and row
		System.out.println("\nTotal number of Column and row");
		List<WebElement> totalRow = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr[1]/td"));
		System.out.println("Number of Column : "+totalRow.size());
		List<WebElement> totalCol = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[1]"));
		System.out.println("Number of Row : "+totalCol.size());
		
		Map<String, Object> mm = new HashMap<String, Object>();
		
		
		//fetch data from the salary column
		System.out.println("\nAll Salaris from the slary column");
		List<WebElement> sal = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[4]"));
		 
		for(int i=0; i<sal.size(); i++) {
			System.out.println(sal.get(i).getText());
		}
		
		List<Integer> salarySorted = new ArrayList<Integer>();
		for(WebElement finalSorts:sal) {
			salarySorted.add(Integer.valueOf(finalSorts.getText()));
		}
		System.out.println("****** Sorted List **********");
		Collections.sort(salarySorted);
		for(Integer p:salarySorted) {
			System.out.println(p);
		}
		List<WebElement> sl = new ArrayList<WebElement>();
		for(Object o:sl) {
	sl.add(Integer.valueOf(o.getClass().getTypeName()), null);
		}
		for(WebElement ss:sl) {
			System.out.println("What "+ss.getText());
		}

		
	}
}

