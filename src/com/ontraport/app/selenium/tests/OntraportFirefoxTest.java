package com.ontraport.app.selenium.tools;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OntraportFirefoxTest {
	protected WebDriver driver;
	protected String baseUrl, baseUrl1;
	protected Process proc;
	protected StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//baseUrl = "http://ontraport.com";
		baseUrl = "https://app.ontraport.com";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1600, 1200));
		//proc = Runtime.getRuntime()
		//.exec("ffmpeg -r 30 -s 1600x1200 -f x11grab -i :1.0 -vcodec msmpeg4v2 -qscale 2 ./report/selenium/" + (getClass().getSimpleName()) + ".avi");
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
		//proc.destroy();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
