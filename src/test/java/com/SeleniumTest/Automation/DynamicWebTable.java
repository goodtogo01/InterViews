package com.SeleniumTest.Automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Optional;

public class DynamicWebTable {

	public WebDriver driver;

	@BeforeMethod
	public void startsUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\zaman\\eclipse-workspace\\Automation\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/zaman/eclipse-workspace/Automation/dataTable.html");
	}

	@Test
	public void dataTable() {
		/*
		 * Find all data from the table find the number of Column and row fatch data
		 * from the salary column sort the salary
		 */

		// Entire Table Data
		System.out.println("Entire Table Datas: ");
		List<WebElement> tableData = driver.findElements(By.xpath("//*[@id='MainTables']"));
		for (int i = 0; i < tableData.size(); i++) {
			System.out.println(tableData.get(i).getText());
		}

		// find the number of Column and row
		System.out.println("\nTotal number of Column and row");
		List<WebElement> totalRow = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr[1]/td"));
		System.out.println("Number of Column : " + totalRow.size());
		List<WebElement> totalCol = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[1]"));
		System.out.println("Number of Row : " + totalCol.size());

		// fetch data from the salary column
		System.out.println("\nAll Salaris from the slary column");
		List<WebElement> sal = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[4]"));

		System.out.println("Actual List of Data from salary columns which's befor sort. ");
		for (int i = 0; i < sal.size(); i++) {
			System.out.println(sal.get(i).getText());
		}

		List<Integer> salarySorted = new ArrayList<Integer>();
		for (WebElement finalSorts : sal) {
			salarySorted.add(Integer.valueOf(finalSorts.getText()));
		}
		System.out.println("****** Sorted List **********");
		Collections.sort(salarySorted);
		for (Integer p : salarySorted) {
			System.out.println(p);
		}
	}

	// *[@id='MainTables']/tbody/tr/td[1]
	@Test
	public void salarySorts() {
		// get Entire Table data
		List<WebElement> data = driver.findElements(By.xpath("//*[@id='MainTables']"));
		System.out.println("get Entire Table data.");
		for (WebElement we : data) {
			System.out.println(we.getText());
		}
		// get Salary Column data from the Table
		List<WebElement> tt = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[4]"));
		System.out.println("\nget Salary Column data from the Table \n");
		for(WebElement w:tt) {
			System.out.println(w.getText());
			
		}
		System.out.println();
		tt.stream().map(m->m.getText()).distinct().sorted().forEach(System.out::println);
 
		
	}

	@Test
	public void nameSortingTest() {
		// get Entire Table data
		List<WebElement> data = driver.findElements(By.xpath("//*[@id='MainTables']"));
		System.out.println("get Entire Table data.");
		for (WebElement we : data) {
			System.out.println(we.getText());
		}
		// get Salary Column data from the Table
		List<WebElement> tt = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[2]"));
		System.out.println("\nget Salary Column data from the Table \n");
		String[] before_sort = new String[tt.size()];

		for (int i = 0; i < tt.size(); i++) {
			before_sort[i] = tt.get(i).getText();
		}
		System.out.println("************** Before Sort **************");
		Print(before_sort);

		System.out.println("************** After Sort **************");
		Arrays.sort(before_sort);
		Print(before_sort);

	}

	@Test
	public void roleSortingTest() {
		// get Entire Table data
		List<WebElement> data = driver.findElements(By.xpath("//*[@id='MainTables']"));
		System.out.println("get Entire Table data.");
		for (WebElement we : data) {
			System.out.println(we.getText());
		}
		// get Salary Column data from the Table
		List<WebElement> tt = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[3]"));
		System.out.println("\nget Salary Column data from the Table \n");
		String[] before_sort = new String[tt.size()];

		for (int i = 0; i < tt.size(); i++) {
			before_sort[i] = tt.get(i).getText();
		}
		System.out.println("************** Before Sort **************");
		Print(before_sort);

		System.out.println("************** After Sort **************");
		Arrays.sort(before_sort);
		Print(before_sort);

	}

	public static void Print(String[] before_sort) {
		for (int i = 0; i < before_sort.length; i++) {
			System.out.println(before_sort[i]);
		}
	}

	@Test
	public void salarySortingTest() {
		// get Entire Table data
		List<WebElement> data = driver.findElements(By.xpath("//*[@id='MainTables']"));
		System.out.println("get Entire Table data.");
		for (WebElement we : data) {
			System.out.println(we.getText());
		}
		// get Salary Column data from the Table
		List<WebElement> actualSal = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[4]"));

		System.out.println("\nGet Salary Column data from the Table \n");
		System.out.println("************** Before Sort **************");
		for (WebElement empSal : actualSal) {
			System.out.println(empSal.getText());
		}
		List<Double> finalSalaryList = new ArrayList<Double>();
		for (WebElement al : actualSal) {
			finalSalaryList.add(Double.valueOf(al.getText().replace("", "")));
		}
		Collections.sort(finalSalaryList);
		System.out.println("************** After Sort **************");
		for (Double p : finalSalaryList) {

			System.out.println(p);
		}

	}

	@Test
	public void fullTableSort() {
		/*
		 * Find all data from the table find the number of Column and row fatch data
		 * from the salary column sort the salary
		 */

		// Entire Table Data
		System.out.println("Entire Table Datas: ");
		WebElement tableData = driver.findElement(By.xpath("//*[@id='MainTables']"));
		System.out.println(tableData.getText());

		// find the number of Column and row
		System.out.println("\nTotal number of Column and row");
		List<WebElement> totalRow = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr[1]/td"));
		System.out.println("Number of Column : " + totalRow.size());
		List<WebElement> totalCol = driver.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[1]"));
		System.out.println("Number of Row : " + totalCol.size());

		// fetch data from the salary column
		System.out.println("\nAll Salaris from the slary column");
		List<WebElement> sal = tableData.findElements(By.xpath("//*[@id='MainTables']/tbody/tr/td[4]"));

		for (int i = 0; i < sal.size(); i++) {
			System.out.println(sal.get(i).getText());
		}

		List<Integer> salarySorted = new ArrayList<Integer>();
		for (WebElement finalSorts : sal) {
			salarySorted.add(Integer.valueOf(finalSorts.getText()));
		}
		System.out.println("****** Sorted List **********");
		Collections.sort(salarySorted);
		for (Integer p : salarySorted) {
			System.out.println(p);

		}
	}

	@AfterMethod
	public void clsBrs() {

		// Close the webdriver
		driver.quit();

	}

}

//*[@id='MainTables']/tbody/tr/td[2]
