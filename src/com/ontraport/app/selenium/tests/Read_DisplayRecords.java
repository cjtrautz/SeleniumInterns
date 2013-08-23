package com.ontraport.app.selenium.tests;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Read_DisplayRecords extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void Display5Records() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
	//check for 5 records
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='5']")).click();
	Thread.sleep(5000);
	String recordCount = driver.findElement(By.xpath("//*[@class='ussr-component-paginator-result display-inline float-left']//span[@class='ussr-component-paginator-record-count']")).getText();
	System.out.println("Record count:"+recordCount);
	int rdCnt = Integer.parseInt(recordCount);
	if (rdCnt<5){
		System.out.println("Insufficient data to execute the test");
	}
	else{
		Assert.assertEquals("Number of Records Assertion","1-5", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[1]/ul/li[1]/span[2]")).getText().trim());
		Assert.assertEquals("Number of Record Selected", "5", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[2]/div[2]/div/div/input")).getAttribute("value"));
		System.out.println("More than 5 records");
	}
	
	appUtilities.logOutOfApp(driver);
	}

	@Test
	public void Display10Records() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
	//check for 10 records
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='10']")).click();
	Thread.sleep(5000);
		String recordCount = driver.findElement(By.xpath("//*[@class='ussr-component-paginator-result display-inline float-left']//span[@class='ussr-component-paginator-record-count']")).getText();
	System.out.println("Record count:"+recordCount);
	int rdCnt = Integer.parseInt(recordCount); 
	if (rdCnt<10){
		System.out.println("Insufficient data to execute the test");
	}
	else{
		Assert.assertEquals("Number of Records Assertion","1-10", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[1]/ul/li[1]/span[2]")).getText().trim());
		Assert.assertEquals("Number of Record Selected", "10", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[2]/div[2]/div/div/input")).getAttribute("value"));
		System.out.println("More than 10 records");
	}
	
	appUtilities.logOutOfApp(driver);
		}


	@Test
	public void Display25Records() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
	//check for 10 records
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='25']")).click();
	Thread.sleep(5000);
		String recordCount = driver.findElement(By.xpath("//*[@class='ussr-component-paginator-result display-inline float-left']//span[@class='ussr-component-paginator-record-count']")).getText();
	System.out.println("Record count:"+recordCount);
	int rdCnt = Integer.parseInt(recordCount); 
	if (rdCnt<25){
		System.out.println("Insufficient data to execute the test");
	}
	else{
		Assert.assertEquals("Number of Records Assertion","1-25", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[1]/ul/li[1]/span[2]")).getText().trim());
		Assert.assertEquals("Number of Record Selected", "25", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[2]/div[2]/div/div/input")).getAttribute("value"));
		System.out.println("More than 25 records");
	}
	
	appUtilities.logOutOfApp(driver);
		}
	
	@Test
	public void Display50Records() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
	//check for 10 records
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='50']")).click();
	Thread.sleep(5000);
		String recordCount = driver.findElement(By.xpath("//*[@class='ussr-component-paginator-result display-inline float-left']//span[@class='ussr-component-paginator-record-count']")).getText();
	System.out.println("Record count:"+recordCount);
	int rdCnt = Integer.parseInt(recordCount); 
	if (rdCnt<25){
		System.out.println("Insufficient data to execute the test");
	}
	else{
		Assert.assertEquals("Number of Records Assertion","1-50", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[1]/ul/li[1]/span[2]")).getText().trim());
		Assert.assertEquals("Number of Record Selected", "50", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[2]/div[2]/div/div/input")).getAttribute("value"));
		System.out.println("More than 50 records");
	}
	
	appUtilities.logOutOfApp(driver);
		}
	
	@Test
	public void Display100Records() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
	//check for 10 records
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")).click();
	Thread.sleep(5000);
		String recordCount = driver.findElement(By.xpath("//*[@class='ussr-component-paginator-result display-inline float-left']//span[@class='ussr-component-paginator-record-count']")).getText();
	System.out.println("Record count:"+recordCount);
	int rdCnt = Integer.parseInt(recordCount); 
	if (rdCnt<25){
		System.out.println("Insufficient data to execute the test");
	}
	else{
		Assert.assertEquals("Number of Records Assertion","1-100", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[1]/ul/li[1]/span[2]")).getText().trim());
		Assert.assertEquals("Number of Record Selected", "100", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[2]/div[2]/div/div/input")).getAttribute("value"));
		System.out.println("More than 100 records");
	}
	
	appUtilities.logOutOfApp(driver);
		}
}


	
	