package com.ontraport.app.selenium.suites;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	com.ontraport.app.selenium.tests.Login.class,
	//com.ontraport.app.selenium.tests.AddNewSection.class,
	//com.ontraport.app.selenium.tests.AddTab.class,
	//com.ontraport.app.selenium.tests.CreateATag.class,
	//com.ontraport.app.selenium.tests.CreateContact.class,
	//com.ontraport.app.selenium.tests.CreateProduct.class,
	//com.ontraport.app.selenium.tests.CreateRule.class,
	//com.ontraport.app.selenium.tests.DeleteATag.class,
	//com.ontraport.app.selenium.tests.DeleteGateway.class,
	//com.ontraport.app.selenium.tests.DeleteSMS_Number.class,
	//com.ontraport.app.selenium.tests.HostOrderformLP.class,
	//com.ontraport.app.selenium.tests.MakeA_SMS_Number.class,
	//com.ontraport.app.selenium.tests.MakeAdditionalRole.class,
	//com.ontraport.app.selenium.tests.MakeAdditionalUser.class,
	//com.ontraport.app.selenium.tests.MakeAGateWay.class,
	//com.ontraport.app.selenium.tests.MakeANewLP.class,
	//com.ontraport.app.selenium.tests.MakeAPackage.class,
	//com.ontraport.app.selenium.tests.MakeaTask.class,
	//com.ontraport.app.selenium.tests.TestPinnedItemsWorkflow.class,
	//com.ontraport.app.selenium.tests.TestUneditedWorkFlow.class,
	//com.ontraport.app.selenium.tests.AddDeleteUserPermission.class,
	//com.ontraport.app.selenium.tests.AddRoundRobin.class,
	//com.ontraport.app.selenium.tests.DeleteALP.class,
	com.ontraport.app.selenium.tests.DeleteAWPSite.class


	})

public class Sanity {
	protected static String baseUrl;
	protected static Process proc;
	protected static StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://ontraport.com.dev";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1600, 1200));
		//proc = Runtime.getRuntime()
		//.exec("ffmpeg -r 30 -s 1600x1200 -f x11grab -i :1.0 -vcodec msmpeg4v2 -qscale 2 ./report/selenium/" + (getClass().getSimpleName()) + ".avi");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
		//proc.destroy();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		fail(verificationErrorString);
		}
	}
	public static WebDriver getDriver(){
		return driver;
	}
	
}