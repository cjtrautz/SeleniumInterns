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
    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
    com.ontraport.app.tests.EditLandingPageGradientColors.class,
    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.SearchTest.class,
    
    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
    com.ontraport.app.tests.EditLandingPageGradientColors.class,
    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.SearchTest.class,
    
    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
    com.ontraport.app.tests.EditLandingPageGradientColors.class,
    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.SearchTest.class,
    
    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
    com.ontraport.app.tests.EditLandingPageGradientColors.class,
    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.SearchTest.class,
    
    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
    com.ontraport.app.tests.EditLandingPageGradientColors.class,
    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.SearchTest.class,
//    com.ontraport.app.tests.CreateEditableEmailMessage.class,
//    com.ontraport.app.tests.EditEmailMessagePreview.class,
//    com.ontraport.app.tests.EditEmailMessageBold.class,
//    com.ontraport.app.tests.EditEmailMessageItalicize.class,
//    com.ontraport.app.tests.EditEmailMessageStrikeThrough.class,
//    com.ontraport.app.tests.EditEmailMessageOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageUnOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageQuote.class,
//    com.ontraport.app.tests.EditEmailMessageUndoAndRedo.class,
//    com.ontraport.app.tests.EditEmailMessagePaste.class,
//    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
//    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
//    
//    com.ontraport.app.tests.CreateContact.class,
//    //relies on having at least one contact
//    com.ontraport.app.tests.AddColumn.class,
//    com.ontraport.app.tests.MoveColumn.class,
//    com.ontraport.app.tests.DeleteColumn.class,
//    com.ontraport.app.tests.DeleteContact.class,
//    
//    com.ontraport.app.tests.SearchTest.class,
//    
//    com.ontraport.app.tests.CreateEditableEmailMessage.class,
//    com.ontraport.app.tests.EditEmailMessagePreview.class,
//    com.ontraport.app.tests.EditEmailMessageBold.class,
//    com.ontraport.app.tests.EditEmailMessageItalicize.class,
//    com.ontraport.app.tests.EditEmailMessageStrikeThrough.class,
//    com.ontraport.app.tests.EditEmailMessageOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageUnOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageQuote.class,
//    com.ontraport.app.tests.EditEmailMessageUndoAndRedo.class,
//    com.ontraport.app.tests.EditEmailMessagePaste.class,
//    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
//    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
//    
//    com.ontraport.app.tests.CreateContact.class,
//    //relies on having at least one contact
//    com.ontraport.app.tests.AddColumn.class,
//    com.ontraport.app.tests.MoveColumn.class,
//    com.ontraport.app.tests.DeleteColumn.class,
//    com.ontraport.app.tests.DeleteContact.class,
//    
//    com.ontraport.app.tests.SearchTest.class,
//    
//    com.ontraport.app.tests.CreateEditableEmailMessage.class,
//    com.ontraport.app.tests.EditEmailMessagePreview.class,
//    com.ontraport.app.tests.EditEmailMessageBold.class,
//    com.ontraport.app.tests.EditEmailMessageItalicize.class,
//    com.ontraport.app.tests.EditEmailMessageStrikeThrough.class,
//    com.ontraport.app.tests.EditEmailMessageOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageUnOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageQuote.class,
//    com.ontraport.app.tests.EditEmailMessageUndoAndRedo.class,
//    com.ontraport.app.tests.EditEmailMessagePaste.class,
//    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
//    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
//    
//    com.ontraport.app.tests.CreateContact.class,
//    //relies on having at least one contact
//    com.ontraport.app.tests.AddColumn.class,
//    com.ontraport.app.tests.MoveColumn.class,
//    com.ontraport.app.tests.DeleteColumn.class,
//    com.ontraport.app.tests.DeleteContact.class,
//    
//    com.ontraport.app.tests.SearchTest.class,
//    
//    com.ontraport.app.tests.CreateEditableEmailMessage.class,
//    com.ontraport.app.tests.EditEmailMessagePreview.class,
//    com.ontraport.app.tests.EditEmailMessageBold.class,
//    com.ontraport.app.tests.EditEmailMessageItalicize.class,
//    com.ontraport.app.tests.EditEmailMessageStrikeThrough.class,
//    com.ontraport.app.tests.EditEmailMessageOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageUnOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageQuote.class,
//    com.ontraport.app.tests.EditEmailMessageUndoAndRedo.class,
//    com.ontraport.app.tests.EditEmailMessagePaste.class,
//    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
//    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
//    
//    com.ontraport.app.tests.CreateContact.class,
//    //relies on having at least one contact
//    com.ontraport.app.tests.AddColumn.class,
//    com.ontraport.app.tests.MoveColumn.class,
//    com.ontraport.app.tests.DeleteColumn.class,
//    com.ontraport.app.tests.DeleteContact.class,
//    
//    com.ontraport.app.tests.SearchTest.class,
//    
//    com.ontraport.app.tests.CreateEditableEmailMessage.class,
//    com.ontraport.app.tests.EditEmailMessagePreview.class,
//    com.ontraport.app.tests.EditEmailMessageBold.class,
//    com.ontraport.app.tests.EditEmailMessageItalicize.class,
//    com.ontraport.app.tests.EditEmailMessageStrikeThrough.class,
//    com.ontraport.app.tests.EditEmailMessageOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageUnOrderedList.class,
//    com.ontraport.app.tests.EditEmailMessageQuote.class,
//    com.ontraport.app.tests.EditEmailMessageUndoAndRedo.class,
//    com.ontraport.app.tests.EditEmailMessagePaste.class,
//    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
//    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
//    
//    com.ontraport.app.tests.CreateContact.class,
//    //relies on having at least one contact
//    com.ontraport.app.tests.AddColumn.class,
//    com.ontraport.app.tests.MoveColumn.class,
//    com.ontraport.app.tests.DeleteColumn.class,
//    com.ontraport.app.tests.DeleteContact.class,
//    
//    com.ontraport.app.tests.SearchTest.class,
    
    
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
