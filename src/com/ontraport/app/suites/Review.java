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
    com.ontraport.app.tests.CreateLandingPageCodeMode.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.EditLandingPageAlignment.class,
    com.ontraport.app.tests.EditLandingPageURL.class,
    com.ontraport.app.tests.EditLandingPageTitle.class,
    com.ontraport.app.tests.EditLandingPageName.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.GlobalSettingsClickCancel.class,
    com.ontraport.app.tests.GlobalSettingsClickBack.class,
    com.ontraport.app.tests.GlobalSettingsCookiesExpireIn30Days.class,
    com.ontraport.app.tests.GlobalSettingsCookiesNeverExpire.class,
    com.ontraport.app.tests.GlobalSettingsCommissionPaidToLastReferrer.class,
    com.ontraport.app.tests.GlobalSettingsCommissionPaidToFirstReferrer.class,
    com.ontraport.app.tests.GlobalSettingsPayThreshold.class,
    com.ontraport.app.tests.GlobalSettingsPayAffiliateByTheirChoice.class,
    com.ontraport.app.tests.GlobalSettingsPayAffiliateByCheck.class,
    com.ontraport.app.tests.GlobalSettingsPayAffiliateByPaypal.class,
    
    com.ontraport.app.tests.EditAffiliatesProgramBack.class,
    com.ontraport.app.tests.EditAffiliatesProgramCancel.class,
    
    com.ontraport.app.tests.CreateAffiliatesProgramWithContactIDAndPurchaseHistory.class,
    com.ontraport.app.tests.DeleteAffiliateProgramWithContactIDAndPurchaseHistory.class,
    
    com.ontraport.app.tests.CreateAffiliatesProgramWithFullNameAndDeclinedTrans.class,
    com.ontraport.app.tests.DeleteAffiliateProgramWithFullNameAndDeclinedTrans.class,
    
    com.ontraport.app.tests.CreateAffilatesProgram.class,
    com.ontraport.app.tests.DeleteAffiliateProgram.class,
    
    com.ontraport.app.tests.CreateSMSMessage.class,
    com.ontraport.app.tests.EditSMSMessageName.class,
    com.ontraport.app.tests.EditSMSMessageBody.class,
    com.ontraport.app.tests.EditSMSMessageMergeField.class,
    com.ontraport.app.tests.EditSMSMessageCancel.class,
    com.ontraport.app.tests.DeleteSMSMessage.class,
    
    com.ontraport.app.tests.CreateMessageCancel.class,
    
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
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }

}
