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
    com.ontraport.app.tests.RetryTransactionsNonNumbers.class,
    com.ontraport.app.tests.RetryTransactionsDecimal.class,
    com.ontraport.app.tests.RetryTransactionsWholeNumber.class,
    
    com.ontraport.app.tests.FieldEditorSectionPermissions.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    com.ontraport.app.tests.ChangeBusinessInformation.class,
    
    com.ontraport.app.tests.AccountClickHere.class,
    com.ontraport.app.tests.AccountExportItFirst.class,
    
    com.ontraport.app.tests.HelpOpenAndClose.class,
    com.ontraport.app.tests.HelpFeedback.class,
    com.ontraport.app.tests.HelpSendEmail.class,
    com.ontraport.app.tests.HelpWatchVideos.class,
    
    com.ontraport.app.tests.RetryTransactionsNonNumbers.class,
    com.ontraport.app.tests.RetryTransactionsDecimal.class,
    com.ontraport.app.tests.RetryTransactionsWholeNumber.class,
    
    com.ontraport.app.tests.FieldEditorSectionPermissions.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    com.ontraport.app.tests.ChangeBusinessInformation.class,
    
    com.ontraport.app.tests.AccountClickHere.class,
    com.ontraport.app.tests.AccountExportItFirst.class,
    
    com.ontraport.app.tests.HelpOpenAndClose.class,
    com.ontraport.app.tests.HelpFeedback.class,
    com.ontraport.app.tests.HelpSendEmail.class,
    com.ontraport.app.tests.HelpWatchVideos.class,
    
    com.ontraport.app.tests.RetryTransactionsNonNumbers.class,
    com.ontraport.app.tests.RetryTransactionsDecimal.class,
    com.ontraport.app.tests.RetryTransactionsWholeNumber.class,
    
    com.ontraport.app.tests.FieldEditorSectionPermissions.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    com.ontraport.app.tests.ChangeBusinessInformation.class,
    
    com.ontraport.app.tests.AccountClickHere.class,
    com.ontraport.app.tests.AccountExportItFirst.class,
    
    com.ontraport.app.tests.HelpOpenAndClose.class,
    com.ontraport.app.tests.HelpFeedback.class,
    com.ontraport.app.tests.HelpSendEmail.class,
    com.ontraport.app.tests.HelpWatchVideos.class,
    
    com.ontraport.app.tests.RetryTransactionsNonNumbers.class,
    com.ontraport.app.tests.RetryTransactionsDecimal.class,
    com.ontraport.app.tests.RetryTransactionsWholeNumber.class,
    
    com.ontraport.app.tests.FieldEditorSectionPermissions.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    com.ontraport.app.tests.ChangeBusinessInformation.class,
    
    com.ontraport.app.tests.AccountClickHere.class,
    com.ontraport.app.tests.AccountExportItFirst.class,
    
    com.ontraport.app.tests.HelpOpenAndClose.class,
    com.ontraport.app.tests.HelpFeedback.class,
    com.ontraport.app.tests.HelpSendEmail.class,
    com.ontraport.app.tests.HelpWatchVideos.class,
    
    com.ontraport.app.tests.RetryTransactionsNonNumbers.class,
    com.ontraport.app.tests.RetryTransactionsDecimal.class,
    com.ontraport.app.tests.RetryTransactionsWholeNumber.class,
    
    com.ontraport.app.tests.FieldEditorSectionPermissions.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    com.ontraport.app.tests.ChangeBusinessInformation.class,
    
    com.ontraport.app.tests.AccountClickHere.class,
    com.ontraport.app.tests.AccountExportItFirst.class,
    
    com.ontraport.app.tests.HelpOpenAndClose.class,
    com.ontraport.app.tests.HelpFeedback.class,
    com.ontraport.app.tests.HelpSendEmail.class,
    com.ontraport.app.tests.HelpWatchVideos.class,
    
    
    
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
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
}
