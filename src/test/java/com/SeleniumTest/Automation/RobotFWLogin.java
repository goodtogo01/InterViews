package com.SeleniumTest.Automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotFWLogin {
	static LocatorsTest ltest;
	static WebDriver driver;
	public static String path = "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe";
	static long Time_count = 12;
	public static WebDriverWait wait;
	static String totalSales = "$3,001";
	static String converTotalSale = String.valueOf(totalSales);

	@BeforeMethod
	public static void tearUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\MY_WORKS\\Framework\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://robotsparebinindustries.com");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();
		//driver.navigate().refresh();

	}
	//*[@name="username"]
	//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]
	
	@Test
	public void tblList() {
		
		//driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).sendKeys("Admin");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("admin123");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();
		String mm = driver.getTitle();
		System.out.println(mm);
		
	}

	@Test
	public static void trt() throws InterruptedException {
		List<WebElement> totalFields = driver
				.findElements(By.xpath("//body/div[@id='container']/div[@id='login-form']/div[1]"));
		System.out.println("Total Number of Form is : " + totalFields.size());
		System.out.print("Total number of Elements are availabel include hidden message area is : ");
		//totalFields.forEach(ele->System.out.print(ele.getText()));
		for (WebElement e : totalFields) {
			System.out.print(e.getText().length() + "\n");
		}
		
//		driver.findElement(By.id("login-button")).click();
//		//Validate Empty Email input field
//		String emptyEmailError = driver.findElement(By.xpath("//div[contains(text(),'Email is required')]")).getText();
//		Assert.assertEquals(emptyEmailError, "Email is required", "Email Field must not be empty!");
//		System.out.println("Email Field is Empty with this error message: "+emptyEmailError.toString());
//		
//		//Validate Empty Password input field
//		String emptyPassError = driver.findElement(By.xpath("//div[contains(text(),'Password is required')]")).getText();
//		Assert.assertEquals(emptyPassError, "Password is required", "Password Field must not be empty!");
//		System.out.println("Password Field is Empty with this error message: "+emptyPassError.toString());

	}

	@Test(priority = 1)
	public static void logins() throws InterruptedException {
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("maria");
		driver.findElement(By.id("password")).sendKeys("thoushallnotpass");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		System.out.println("Title: " + driver.getTitle());
		 Thread.sleep(500);
		 //System.out.println(con);
		 driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("molmola");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("molmola");
		driver.findElement(By.id("lastname")).sendKeys("Mia");
		driver.findElement(By.id("salesresult")).sendKeys("3214");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	}

	@Test(priority = 2)
	public static void screenShotSpecificElement() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("maria");
		driver.findElement(By.id("password")).sendKeys("thoushallnotpass");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * boolean idBoxchk =
		 * driver.findElement(By.xpath("//input[@id='firstnam0e']")).isDisplayed();
		 * System.out.println("exit: "+idBoxchk); Assert.assertTrue(idBoxchk);
		 */

		driver.findElement(By.id("firstname")).sendKeys("molmola");
		driver.findElement(By.id("lastname")).sendKeys("Mia");
		driver.findElement(By.id("salesresult")).sendKeys(converTotalSale);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[contains(text(),'Show performance')]")).click();
		WebElement element = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File ScreenShotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenShotFile, new File("el.png"));
				
		}
	
	@Test(priority = 2)
	public static void enterSalseRecord() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("maria");
		driver.findElement(By.id("password")).sendKeys("thoushallnotpass");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * boolean idBoxchk =
		 * driver.findElement(By.xpath("//input[@id='firstnam0e']")).isDisplayed();
		 * System.out.println("exit: "+idBoxchk); Assert.assertTrue(idBoxchk);
		 */

		driver.findElement(By.id("firstname")).sendKeys("molmola");
		driver.findElement(By.id("lastname")).sendKeys("Mia");
		driver.findElement(By.id("salesresult")).sendKeys(converTotalSale);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[contains(text(),'Show performance')]")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Locate Table
		WebElement mainTable = driver.findElement(By.xpath("//*[@id='sales-results']/table[1]"));

		// Locate Rows of the table
		List<WebElement> totalRow = mainTable.findElements(By.tagName("tr"));
		
		// Total Number of Row
		int rowCount = totalRow.size();
		System.out.println("Total number of Row " + rowCount );

		// Loop will execute till last row of the table
		for (int row = 0; row < rowCount; row++) {

			// Find the column of the specific row
			List<WebElement> column_row = totalRow.get(row).findElements(By.tagName("td"));
			//column_row.forEach(f->System.out.print(f.getText()));
			

			// Find number of column in the specific row
			int colCount = column_row.size();
			System.out.println("Total number of Column " + colCount); 

			// Loop will execute till last row of the table
			for (int col = 0; col < colCount; col++) {

				// To Retrieve specific Column value
				String colText = column_row.get(col).getText();
				System.out
						.println("Column Value of Row Number " + row + " and Column Number " + col + " is " + colText);

				// Validation message
				String message = "Oh dear.";

				if (message.equals(colText)) {
					System.out.println("Message from the Boss as : " + message);
				} else {
					System.out.println("Test is not validated");

				}
				System.out.println("-------------------------------------------------------------------");

			}
		}
		driver.close();

		/*
		 * String usn =
		 * driver.findElement(By.xpath("//span[contains(text(),'maria')]")).getText();
		 * System.out.println("name of user "+usn); Assert.assertEquals(usn, "maria",
		 * "Name found as maria");
		 */

	}

	@Test(priority = 2)
	public static void salseResult() throws Throwable {
		enterSalseRecord();
		WebElement baseTable = driver.findElement(By.tagName("table"));
		System.out.println("Base Tables : " + baseTable.getText());

		// find table column
		WebElement tableCol = baseTable.findElement(By.xpath("//th[contains(text(),'Result')]"));
		String colName = tableCol.getText();
		System.out.println("Column Name is : " + colName);

		// Column Value
		WebElement columnValu = tableCol.findElement(By.xpath("//tbody/tr/td[3]"));

		String finalValue = columnValu.getText();

		System.out.println("Column value is ----------------: " + finalValue);

		assertEquals(finalValue, converTotalSale, "Mismatch Value");

	}

	// @AfterMethod
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

	// @Test
	public static void dis() {
		List<Integer> ll = Arrays.asList(1, 2, 3, 4, 5, 6, 77, 7, 7, 75654, 4, 3, 3, 22, 1, 1, 1);
		System.out.println("Total Elements found as : " + ll.size());

		long disEle = ll.stream().distinct().count();
		System.out.println("Elements Present in the list : " + ll + "\nDistinct elements are: " + disEle);
		Object ar[] = ll.stream().toArray();

	}

}
//Object arr[] = r1.stream().toArray();