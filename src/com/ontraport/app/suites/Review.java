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
  //used in following tests
    com.ontraport.app.tests.CreateFulfillment.class, 
    //uses CreateFulfillment fulfillment
    com.ontraport.app.tests.CreateFulfillmentDateSequence.class, 
    com.ontraport.app.tests.DeleteFulfillmentDateSequence.class,
    com.ontraport.app.tests.CreateFulfillmentStepSequence.class,
    com.ontraport.app.tests.DeleteFulfillmentStepSequence.class,
    com.ontraport.app.tests.CreateRule_RemoveContactFromFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromFulfillmentList.class,
    com.ontraport.app.tests.CreateRule_AddContactToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_AddContactToFulfillmentList.class,
    com.ontraport.app.tests.EditFulfillmentMonthly.class, 
    com.ontraport.app.tests.EditFulfillmentWeekly.class,
    com.ontraport.app.tests.EditFulfillmentSendNotificationTo.class,
    com.ontraport.app.tests.EditFulfillmentAddRecipient.class,
    com.ontraport.app.tests.EditFulfillmentUnsubContactFromFulfillmentAfterSend.class,
    com.ontraport.app.tests.EditFulfillmentCreateTask.class,
    com.ontraport.app.tests.EditFulfillmentDueEntryBox.class,
    com.ontraport.app.tests.EditFulfillmentBack.class,
    com.ontraport.app.tests.EditFulfillmentCancel.class,
    //used in following tests
    com.ontraport.app.tests.CreateRole.class,
    //used in following tests uses CreateRole role
    com.ontraport.app.tests.CreateUser.class,
    //uses CreateFulfillment fulfillment and uses CreateUser user
    com.ontraport.app.tests.CheckLogOutAndNewUser.class,
    com.ontraport.app.tests.ChangePassword.class,
    com.ontraport.app.tests.EditFulfillmentOwner.class,
    //uses CreateFulfillment fulfillment
    com.ontraport.app.tests.EditFulfillmentListFields.class,
    com.ontraport.app.tests.EditFulfillmentClearField.class,
    com.ontraport.app.tests.EditFulfillmentSelectAllField.class,
    //end use of CreateFulfillment fulfillment
    com.ontraport.app.tests.DeleteFulfillment.class,
    //end use of CreateUser user
    com.ontraport.app.tests.DeleteUser.class,
    //end use of CreateRole role
    com.ontraport.app.tests.DeleteRole.class,
}
)
public class Review extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setUrl("https://staging.ontraport.com/");
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
        Thread.sleep(10000);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }

}
