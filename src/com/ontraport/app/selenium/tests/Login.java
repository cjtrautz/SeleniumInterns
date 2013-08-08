package com.ontraport.app.selenium.tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Login extends OntraportFirefoxTest {

	@Test
	public void testLogin() {
		String user = "colton@officeautopilot.com";
		String pass = "test123";
		String baseUrl = "http://app.ontraport.com";
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get(baseUrl + "/");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.id("login_button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Messages']")));

		//driver.findElement(By.cssSelector("li.ussr-header-nav-option-user"))
				//.click();
		//driver.findElement(By.cssSelector("a[href=\"Login/logout\"]")).click();
	}
}
