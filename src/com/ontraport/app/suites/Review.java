package com.ontraport.app.suites;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(
{
    com.ontraport.app.tests.CreateGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.DeleteGatewayPayPalPaymentsPro.class,
    
    com.ontraport.app.tests.CreateGatewayUSAePayToken.class,
    com.ontraport.app.tests.DeleteGatewayUSAePayToken.class,
    
    com.ontraport.app.tests.CreateGatewayUSAePay.class,
    com.ontraport.app.tests.DeleteGatewayUSAePay.class,
    
    com.ontraport.app.tests.CreateGatewayQuickBooks.class,
    com.ontraport.app.tests.DeleteGatewayQuickBooks.class,
    
    com.ontraport.app.tests.CreateGatewayPayPal.class,
    com.ontraport.app.tests.DeleteGatewayPayPal.class,
    
    com.ontraport.app.tests.CreateGatewayPayLeap.class,
    com.ontraport.app.tests.DeleteGatewayPayLeap.class,
    
    com.ontraport.app.tests.CreateGatewayPayJunction.class,
    com.ontraport.app.tests.DeleteGatewayPayJunction.class,
    
    com.ontraport.app.tests.CreateGatewayPayflowPro.class,
    com.ontraport.app.tests.DeleteGatewayPayflowPro.class,
    
    com.ontraport.app.tests.CreateGatewayNetworkMerchantsInc.class,
    com.ontraport.app.tests.DeleteGatewayNetworkMerchantsInc.class,
    
    com.ontraport.app.tests.CreateGatewayeWay.class,
    com.ontraport.app.tests.DeleteGatewayeWay.class,
    
    com.ontraport.app.tests.CreateGatewayElavon.class,
    com.ontraport.app.tests.DeleteGatewayElavon.class,
    
  com.ontraport.app.tests.CreateGatewayAuthorizeNet.class,
  com.ontraport.app.tests.DeleteGatewayAuthorizeNet.class,
  
  com.ontraport.app.tests.CreateGatewayAuthorizeNetCIM.class,
  com.ontraport.app.tests.DeleteGatewayAuthorizeNetCIM.class,

    
//    com.ontraport.app.tests.CreateContact.class,
//    //relies on having at least one contact
//    com.ontraport.app.tests.AddTaskToContact.class,
//    com.ontraport.app.tests.DeleteAddTaskToCopy.class,
//    com.ontraport.app.tests.DeleteContact.class,
    
}
)
public class Review extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setUrl("https://app.ontraport.com/");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        driver = new FirefoxDriver(profile);
        //driver = new ChromeDriver();
        driver.manage()
              .timeouts()
              .implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage()
              .window()
              .setPosition(new Point(0, 0));
        driver.manage()
              .window()
              .maximize();
        Login login = (Login) new Login().init();
        login.open(Login.url, true);
        login.as(AbstractPage.getLogin(), AbstractPage.getPassword());
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }

}
