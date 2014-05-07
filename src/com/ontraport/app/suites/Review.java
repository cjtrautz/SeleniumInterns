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
    com.ontraport.app.tests.SendSingleEmailToContact.class,                  
    //sends CreateMessage message 
//    com.ontraport.app.tests.SendTestEmail.class,
    //uses CreateMessage message
    
//    //used in following tests
//    com.ontraport.app.tests.CreateLandingPagePictureWithRectangle.class,
//    //uses CreateLandingPagePictureWithRectangle landing page
//    com.ontraport.app.tests.EditLandingPageCircleImage.class,
//    com.ontraport.app.tests.EditLandingPageImageTop.class,
//    com.ontraport.app.tests.EditLandingPageImageWidth.class,
//    com.ontraport.app.tests.EditLandingPageImageHeight.class,
//    com.ontraport.app.tests.EditLandingPageImageLeft.class,
//    com.ontraport.app.tests.EditLandingPageImageLinksTo.class,
//    com.ontraport.app.tests.EditLandingPageImageOpacity.class,
//    com.ontraport.app.tests.EditLandingPageImageRounded.class,
//    com.ontraport.app.tests.EditLandingPageImageSelectImage.class,
//    //end use of CreateLandingPagePictureWithRectangle landing page
//    com.ontraport.app.tests.DeleteLandingPageImage.class,
//    
//    com.ontraport.app.tests.CreateLandingPageCodeMode.class,
//    //uses CreateLandingPageCodeMode landing page
//    com.ontraport.app.tests.EditLandingPageCodeModeInsertField.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeAddText.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeAddHTMLViaSource.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeSplitTestCheckbox.class,
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
