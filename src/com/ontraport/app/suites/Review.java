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
    com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.CreateLandingPageWithText.class,
    com.ontraport.app.tests.EditLandingPageHeight.class,
    com.ontraport.app.tests.EditLandingPageWidth.class,
    com.ontraport.app.tests.EditLandingPageTop.class,
    com.ontraport.app.tests.EditLandingPageLeft.class,
    com.ontraport.app.tests.EditLandingPageLineSpacing.class,
    com.ontraport.app.tests.EditLandingPageLetterSpacing.class,
    com.ontraport.app.tests.EditLandingPageRightAlign.class,
    com.ontraport.app.tests.EditLandingPageCenter.class,
    com.ontraport.app.tests.EditLandingPageLeftAlign.class,
    com.ontraport.app.tests.EditLandingPageUnderline.class,
    com.ontraport.app.tests.EditLandingPageItalic.class,
    com.ontraport.app.tests.EditLandingPageBold.class,
    com.ontraport.app.tests.EditLandingPageFontSize.class,
    com.ontraport.app.tests.EditLandingPageFont.class,
    com.ontraport.app.tests.DeleteLandingPageWithText.class,
    
com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.CreateLandingPageWithText.class,
    com.ontraport.app.tests.EditLandingPageHeight.class,
    com.ontraport.app.tests.EditLandingPageWidth.class,
    com.ontraport.app.tests.EditLandingPageTop.class,
    com.ontraport.app.tests.EditLandingPageLeft.class,
    com.ontraport.app.tests.EditLandingPageLineSpacing.class,
    com.ontraport.app.tests.EditLandingPageLetterSpacing.class,
    com.ontraport.app.tests.EditLandingPageRightAlign.class,
    com.ontraport.app.tests.EditLandingPageCenter.class,
    com.ontraport.app.tests.EditLandingPageLeftAlign.class,
    com.ontraport.app.tests.EditLandingPageUnderline.class,
    com.ontraport.app.tests.EditLandingPageItalic.class,
    com.ontraport.app.tests.EditLandingPageBold.class,
    com.ontraport.app.tests.EditLandingPageFontSize.class,
    com.ontraport.app.tests.EditLandingPageFont.class,
    com.ontraport.app.tests.DeleteLandingPageWithText.class,
    
com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.CreateLandingPageWithText.class,
    com.ontraport.app.tests.EditLandingPageHeight.class,
    com.ontraport.app.tests.EditLandingPageWidth.class,
    com.ontraport.app.tests.EditLandingPageTop.class,
    com.ontraport.app.tests.EditLandingPageLeft.class,
    com.ontraport.app.tests.EditLandingPageLineSpacing.class,
    com.ontraport.app.tests.EditLandingPageLetterSpacing.class,
    com.ontraport.app.tests.EditLandingPageRightAlign.class,
    com.ontraport.app.tests.EditLandingPageCenter.class,
    com.ontraport.app.tests.EditLandingPageLeftAlign.class,
    com.ontraport.app.tests.EditLandingPageUnderline.class,
    com.ontraport.app.tests.EditLandingPageItalic.class,
    com.ontraport.app.tests.EditLandingPageBold.class,
    com.ontraport.app.tests.EditLandingPageFontSize.class,
    com.ontraport.app.tests.EditLandingPageFont.class,
    com.ontraport.app.tests.DeleteLandingPageWithText.class,
    
com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.CreateLandingPageWithText.class,
    com.ontraport.app.tests.EditLandingPageHeight.class,
    com.ontraport.app.tests.EditLandingPageWidth.class,
    com.ontraport.app.tests.EditLandingPageTop.class,
    com.ontraport.app.tests.EditLandingPageLeft.class,
    com.ontraport.app.tests.EditLandingPageLineSpacing.class,
    com.ontraport.app.tests.EditLandingPageLetterSpacing.class,
    com.ontraport.app.tests.EditLandingPageRightAlign.class,
    com.ontraport.app.tests.EditLandingPageCenter.class,
    com.ontraport.app.tests.EditLandingPageLeftAlign.class,
    com.ontraport.app.tests.EditLandingPageUnderline.class,
    com.ontraport.app.tests.EditLandingPageItalic.class,
    com.ontraport.app.tests.EditLandingPageBold.class,
    com.ontraport.app.tests.EditLandingPageFontSize.class,
    com.ontraport.app.tests.EditLandingPageFont.class,
    com.ontraport.app.tests.DeleteLandingPageWithText.class,
    
com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.CreateLandingPageWithText.class,
    com.ontraport.app.tests.EditLandingPageHeight.class,
    com.ontraport.app.tests.EditLandingPageWidth.class,
    com.ontraport.app.tests.EditLandingPageTop.class,
    com.ontraport.app.tests.EditLandingPageLeft.class,
    com.ontraport.app.tests.EditLandingPageLineSpacing.class,
    com.ontraport.app.tests.EditLandingPageLetterSpacing.class,
    com.ontraport.app.tests.EditLandingPageRightAlign.class,
    com.ontraport.app.tests.EditLandingPageCenter.class,
    com.ontraport.app.tests.EditLandingPageLeftAlign.class,
    com.ontraport.app.tests.EditLandingPageUnderline.class,
    com.ontraport.app.tests.EditLandingPageItalic.class,
    com.ontraport.app.tests.EditLandingPageBold.class,
    com.ontraport.app.tests.EditLandingPageFontSize.class,
    com.ontraport.app.tests.EditLandingPageFont.class,
    com.ontraport.app.tests.DeleteLandingPageWithText.class,
    
}
)
public class Review extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setUrl("https://app.ontraport.com");
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
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
}
