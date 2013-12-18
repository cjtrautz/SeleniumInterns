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
    //com.ontraport.app.tests.MoveATab.class,
    com.ontraport.app.tests.NameATab.class,
    
    com.ontraport.app.tests.CreateTab.class,
    com.ontraport.app.tests.DeleteTab.class,
    
    com.ontraport.app.tests.CreateTrackingURL.class,
    com.ontraport.app.tests.DeleteTrackingURL.class,
    
    com.ontraport.app.tests.CreateSmartFormWithTemplate.class,
    com.ontraport.app.tests.DeleteSmartFormWithTemplate.class,
    com.ontraport.app.tests.CreateSmartFormWithConditions.class,
    com.ontraport.app.tests.DeleteSmartFormWithConditions.class,
    com.ontraport.app.tests.CreateSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.CreateSmartFormWithCaptcha.class,
    com.ontraport.app.tests.DeleteSmartFormWithCaptcha.class,
    com.ontraport.app.tests.CreateSmartFormWithGetPaid.class,
    com.ontraport.app.tests.DeleteSmartFormWithGetPaid.class,
    com.ontraport.app.tests.CreateSmartFormWithAddContent.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddContent.class,
    com.ontraport.app.tests.CreateSmartFormWithAddField.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddField.class,
}
)
public class Review extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setUrl("https://staging.ontraport.com/");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(false);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        driver = new FirefoxDriver(profile);
//        driver = new ChromeDriver();
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
