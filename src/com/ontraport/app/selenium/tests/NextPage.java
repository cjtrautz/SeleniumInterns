package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class NextPage extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testNextPage() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(20000);
		String pageCount = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-page-count')]")).getText();
		String currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
		System.out.println("page count"+pageCount);
		int crntPgNoB4Click = Integer.parseInt(currentPageNumber);
		int pgCnt = Integer.parseInt(pageCount);
		if (pgCnt>1){
			driver.findElement(By.xpath("//a[@class='ussr-paginator-control-next']")).click();
			Thread.sleep(20000);
			currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
			int crntPgNoA4Click = Integer.parseInt(currentPageNumber);
			if (crntPgNoA4Click==(crntPgNoB4Click+1)){
				Assert.assertTrue("NextPageNavigation success", true);
			}else{
				Assert.assertTrue("NextPageNavigation success", false);
			}

		}else{
			Assert.assertTrue("No suffecient records to execute test case", false);
		}

		appUtilities.logOutOfApp(driver);

	}
	
	
	@Test
	public void testLastPage() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(20000);
		String pageCount = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-page-count')]")).getText();
		String currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
		System.out.println("page count"+pageCount);
		int pgCnt = Integer.parseInt(pageCount);
		if (pgCnt>1){
			driver.findElement(By.xpath("//a[@class='ussr-paginator-control-last']")).click();
			Thread.sleep(20000);
			currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
			int crntPgNoA4Click = Integer.parseInt(currentPageNumber);
			if (crntPgNoA4Click==(pgCnt)){
				Assert.assertTrue("NextPageNavigation success", true);
			}else{
				Assert.assertTrue("NextPageNavigation success", false);
			}

		}else{
			Assert.assertTrue("No suffecient records to execute test case", false);
		}

		appUtilities.logOutOfApp(driver);

	}
	
	
	
	@Test
	public void testPreviousPage() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(20000);
		String pageCount = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-page-count')]")).getText();
		String currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
		System.out.println("page count"+pageCount);
		int crntPgNoB4Click = Integer.parseInt(currentPageNumber);
		int pgCnt = Integer.parseInt(pageCount);
		if (pgCnt>1){
			driver.findElement(By.xpath("//a[@class='ussr-paginator-control-next']")).click();
			Thread.sleep(20000);
			currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
			int crntPgNoA4Click = Integer.parseInt(currentPageNumber);
			if (crntPgNoA4Click==(crntPgNoB4Click+1)){
				Assert.assertTrue("NextPageNavigation success", true);
				driver.findElement(By.xpath("//a[@class='ussr-paginator-control-prev']")).click();
				Thread.sleep(5000);
				String currentPageNumberAfterClickingPreviousBtn = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
				int crntPgNoA4ClickOfPrvBtn = Integer.parseInt(currentPageNumberAfterClickingPreviousBtn);
				if (crntPgNoA4ClickOfPrvBtn==crntPgNoB4Click){
					Assert.assertTrue("PreviousPageNavigation success", true);
				}else{
					Assert.assertTrue("PreviousPageNavigation success", false);
				}
				
			}else{
				Assert.assertTrue("NextPageNavigation success", false);
			}

		}else{
			Assert.assertTrue("No suffecient records to execute test case", false);
		}

		appUtilities.logOutOfApp(driver);

	}
}