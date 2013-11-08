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
    com.ontraport.app.tests.CreateRole.class,
    //relies on role
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    
    com.ontraport.app.tests.CreateEditableEmailMessage.class,
    com.ontraport.app.tests.EditEmailMessageMaximize.class,
    //com.ontraport.app.tests.EditEmailMessageStyles.class,
    com.ontraport.app.tests.EditEmailMessageLinkAndUnlink.class,
    com.ontraport.app.tests.EditEmailMessageAlignmentRight.class,
    com.ontraport.app.tests.EditEmailMessageAlignmentJustify.class,
    com.ontraport.app.tests.EditEmailMessageAlignmentLeft.class,
    com.ontraport.app.tests.EditEmailMessagePreview.class,
    com.ontraport.app.tests.EditEmailMessageBold.class,
    com.ontraport.app.tests.EditEmailMessageItalicize.class,
    com.ontraport.app.tests.EditEmailMessageStrikeThrough.class,
    com.ontraport.app.tests.EditEmailMessageOrderedList.class,
    com.ontraport.app.tests.EditEmailMessageUnOrderedList.class,
    com.ontraport.app.tests.EditEmailMessageQuote.class,
    com.ontraport.app.tests.EditEmailMessageUndoAndRedo.class,
    com.ontraport.app.tests.EditEmailMessagePaste.class,
    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
    com.ontraport.app.tests.EditEmailMessageInsertTable.class,
    com.ontraport.app.tests.EditEmailMessageInsertHorizontalLine.class,
    com.ontraport.app.tests.EditEmailMessageInsertSpecialCharacter.class,
    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
    
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.CreateGateway.class, 
    com.ontraport.app.tests.CreateOrderform.class,
    com.ontraport.app.tests.CreateLandingPageWithForm.class,
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.SubmitOrderForm.class,
    com.ontraport.app.tests.DeleteTag.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    com.ontraport.app.tests.DeleteLandingPageWithForm.class,
    com.ontraport.app.tests.DeleteOrderForm.class,
    com.ontraport.app.tests.DeleteGateway.class,
    
//    com.ontraport.app.tests.SendBroadcastEmailToContact.class,
//    com.ontraport.app.tests.EnsureDateSequence.class,
//    com.ontraport.app.tests.EnsureStepSequenceImmedAndDelayStep.class,
//    com.ontraport.app.tests.SendSingleEmailToContact.class,
//    com.ontraport.app.tests.GmailConfirmations.class,
//    com.ontraport.app.tests.DeleteBroadCastEmail.class,
//    com.ontraport.app.tests.DeleteEnsureStepSequenceImmedAndDelayStep.class,
//    com.ontraport.app.tests.DeleteEnsureDateSequence.class,

//    com.ontraport.app.tests.SearchTest.class,
    
    
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
