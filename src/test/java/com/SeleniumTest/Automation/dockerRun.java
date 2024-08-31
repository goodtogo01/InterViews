package com.SeleniumTest.Automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class dockerRun {

	public static void main(String[] args) throws MalformedURLException {

		RemoteWebDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName", "chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		driver.get("https://about.google/products/");
		System.out.println("the page title is : " + driver.getTitle());

	}
}
