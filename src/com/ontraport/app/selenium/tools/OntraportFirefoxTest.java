package com.ontraport.app.selenium.tools;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.suites.Sanity;

public abstract class OntraportFirefoxTest {
	//public WebDriver driver = new FirefoxDriver();

	

	public WebDriver getDriver(){
		WebDriver driver = Sanity.getDriver();
		if(driver != null){
			return driver;
		}
		return new FirefoxDriver();
	}

}
