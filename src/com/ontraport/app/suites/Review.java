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
    com.ontraport.app.tests.CreateContact.class,
    //relies on having at least one contact
    com.ontraport.app.tests.AddTaskToContact.class,
    com.ontraport.app.tests.DeleteAddTaskToCopy.class,
    com.ontraport.app.tests.DeleteContact.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    //relies on section
    com.ontraport.app.tests.CreateLongTextField.class,
    com.ontraport.app.tests.CreateSMSCustomFieldMessage.class,
    com.ontraport.app.tests.DeleteSMSCustomFieldMessage.class,
    com.ontraport.app.tests.CreateCustomFieldTaskMessage.class,
    com.ontraport.app.tests.DeleteCustomFieldTaskMessage.class,
    com.ontraport.app.tests.DeleteLongTextField.class,
    com.ontraport.app.tests.DeleteSection.class,
      
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateSMSLPFieldMessage.class,
    com.ontraport.app.tests.DeleteSMSLPFieldMessage.class,
    com.ontraport.app.tests.CreateLPFieldTaskMessage.class,
    com.ontraport.app.tests.DeleteLPFieldsTaskMessage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateSMSWPFieldMessage.class,
    com.ontraport.app.tests.DeleteSMSWPFieldMessage.class,
    com.ontraport.app.tests.CreatePostcardWPFieldMessage.class,
    com.ontraport.app.tests.DeletePostcardWPFieldMessage.class,
    com.ontraport.app.tests.CreateWPFieldTaskMessage.class,
    com.ontraport.app.tests.DeleteWPFieldsTaskMessage.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    com.ontraport.app.tests.CopyDateSequence.class,
    com.ontraport.app.tests.DeleteRuleDateSequence.class,
    
    com.ontraport.app.tests.StepSequenceBack.class,
    
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.CopyStepSequence.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
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
