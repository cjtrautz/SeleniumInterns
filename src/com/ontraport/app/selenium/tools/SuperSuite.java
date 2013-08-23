package com.ontraport.app.selenium.tools;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SuperSuite {
	protected static String baseUrl;
	protected static StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://app.ontraport.com";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1600, 1200));
	}
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		fail(verificationErrorString);
		}
	}
	public static WebDriver getDriver(){
		return driver;
	}
}
