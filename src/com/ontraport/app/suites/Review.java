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
import org.openqa.selenium.remote.LocalFileDetector;

import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(
{
//    com.ontraport.app.tests.UploadVideo.class,
//    com.ontraport.app.tests.CreateGateway.class,
//    //used in following tests
//    com.ontraport.app.tests.CreateATag.class,
//    com.ontraport.app.tests.CreateRuleStepSequence.class,
//    com.ontraport.app.tests.CreateOrderform.class,
//    com.ontraport.app.tests.CreateContact.class,
//    com.ontraport.app.tests.CreateMessage.class,
//    com.ontraport.app.tests.CreateATag.class,
//    com.ontraport.app.tests.CreateRuleDateSequence.class,
//    com.ontraport.app.tests.MassActionForContacts.class,
//    com.ontraport.app.tests.CreateTaskFromSequence.class,
//    com.ontraport.app.tests.DeleteCreateTaskFromSequence.class,
//    com.ontraport.app.tests.CreateGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.CreateProduct.class,
//    com.ontraport.app.tests.CreateOrderformWithTaxAndShipping.class,
//    com.ontraport.app.tests.DeleteOrderformWithTaxAndShipping.class,
//    com.ontraport.app.tests.DeleteProduct.class,
//    com.ontraport.app.tests.DeleteGatewayPayPalPaymentsPro.class,
//    com.ontraport.app.tests.DeleteAndVerifyMassActionForContact.class,
//    com.ontraport.app.tests.DeleteRuleDateSequence.class,
//    com.ontraport.app.tests.DeleteTag.class,
//    com.ontraport.app.tests.DeleteMessage.class,
//    com.ontraport.app.tests.SignUp.class,
//    com.ontraport.app.tests.DeleteRuleDateSequence.class,
//    com.ontraport.app.tests.DeleteTag.class,
//    com.ontraport.app.tests.DeleteMessage.class,
    com.ontraport.app.tests.CreateOrderformWithGatewayWorkflow.class,
    com.ontraport.app.tests.DeleteOrderFormGateway.class,
    com.ontraport.app.tests.DeleteProduct.class
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
        profile.setPreference("browser.cache.disk.enable", true);
        profile.setPreference("browser.cache.memory.enable", true);
        profile.setPreference("browser.cache.offline.enable", true);
        profile.setPreference("network.http.use-cache", true);
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
