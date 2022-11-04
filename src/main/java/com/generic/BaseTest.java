package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver driver;

	public WebDriver intializeWebEnvironment() {	
		String strProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", strProjectPath + "/src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		Pojo.setDriver(driver);
		return driver;
	}

	public void tearDownWebEnvironment() {
		if (Pojo.getDriver() != null) {
			Pojo.getDriver().quit();
		}
		System.out.println("Quiting the browser");
	}
}
