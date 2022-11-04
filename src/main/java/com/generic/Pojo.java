package com.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Pojo.driver = driver;
	}
	
}
