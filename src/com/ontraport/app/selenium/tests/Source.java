package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Source extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testSource() throws Exception {
		driver.get(baseUrl + "/");
		String message="<b>test</b>";
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Navigate to Messages-> New Message-> Create Email Message
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
		
		driver.findElement(By.xpath("//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(3000);
		//Click on Source button
		driver.findElement(By.xpath("//a[@title='Source']")).click();
		Thread.sleep(1000);
		
		//Enter value in the Body Frame
		driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).clear();
		driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).sendKeys(message);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Source']")).click();
		
		//verify the text is bold..
		driver.switchTo().frame(1);
		driver.findElement(By.cssSelector("body")).click();
		String text=driver.findElement(By.cssSelector("body")).getText().trim();
		System.out.println("Text is: "+text);
		driver.switchTo().defaultContent();
		
		//Assertion for Bold Text
		Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Bold']")).isEnabled());
		
		//Click source again
		driver.findElement(By.xpath("//a[@title='Source']")).click();
		Thread.sleep(1000);
		
		//assertion that source text is shown
		String emailText= driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).getAttribute("value");
		System.out.println("Now Text is: "+emailText);
		Assert.assertEquals("Source Message", message, emailText);
		
		//logout
		appUtilities.logOutOfApp(driver);
	}
}
