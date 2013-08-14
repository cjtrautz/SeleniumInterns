package com.ontraport.app.selenium.tools;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.suites.Sanity;

public abstract class OntraportFirefoxTest {
	//public WebDriver driver = new FirefoxDriver();
	protected Process proc;

	
	public WebDriver getDriver(){
		WebDriver driver = Sanity.getDriver();
		if(driver != null){
			return driver;
		}
		return new FirefoxDriver();
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		proc = Runtime.getRuntime()
		.exec("ffmpeg -r 30 -s 1600x1200 -f x11grab -i :1.0 -vcodec msmpeg4v2 -qscale 2 ./report/selenium/" + (getClass().getSimpleName()) + ".avi");
	}
	@AfterClass
	public void tearDown() throws Exception {
		proc.destroy();
	}

}
