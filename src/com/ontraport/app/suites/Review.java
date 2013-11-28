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
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CopyLandingPageAction.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.CreateMessage.class,  
    com.ontraport.app.tests.CreateSplitTestMessages.class,
    com.ontraport.app.tests.EditSequenceWaitNegativeDaysAndAddEmailStep.class,
    com.ontraport.app.tests.EditSequenceSplitB.class,
    com.ontraport.app.tests.EditSequenceSplitBAndC.class,
    com.ontraport.app.tests.EditSequenceSplitBAndCAndD.class,
    com.ontraport.app.tests.CreateEmailDateSequence.class,
    com.ontraport.app.tests.DeleteEmailDateSequence.class,
    com.ontraport.app.tests.DeleteMessage.class, 
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    
    com.ontraport.app.tests.CreateRule_ContactIsCreated.class,
    com.ontraport.app.tests.PauseRule.class,
    com.ontraport.app.tests.UnpauseRule.class,
    com.ontraport.app.tests.DeleteRule_ContactIsCreated.class,
    
    com.ontraport.app.tests.EnsureStepSequenceImmedAndDelayStep.class,
    
    com.ontraport.app.tests.CreateSMSMessage.class,
    com.ontraport.app.tests.CreateCopyOfSMSMessage.class,
    com.ontraport.app.tests.DeleteSMSMessage.class,
    
    com.ontraport.app.tests.CreateInvoiceMessage.class,
    com.ontraport.app.tests.DeleteInvoiceMessage.class,
    
    com.ontraport.app.tests.CreatePostcardGradientWithRectangle.class,
    com.ontraport.app.tests.CreatePostcardStepSequence.class,
    com.ontraport.app.tests.DeletePostcardStepSequence.class,
    com.ontraport.app.tests.DeletePostcardGradientMessage.class,
    
    com.ontraport.app.tests.CreateTaskWhoMessage.class,
    com.ontraport.app.tests.CreateTaskStepSequence.class,
    com.ontraport.app.tests.DeleteTaskStepSequence.class,
    com.ontraport.app.tests.DeleteTaskWhoMessage.class,
    
    com.ontraport.app.tests.CreateAffilatesProgram.class,
    com.ontraport.app.tests.EditAffilatesProgramNotify.class,
    com.ontraport.app.tests.EditAffilatesProgramShowCompletePurchaseHistory.class,
    com.ontraport.app.tests.EditAffilatesProgramShowDeclined.class,
    com.ontraport.app.tests.EditAffilatesProgramInformation.class,
    com.ontraport.app.tests.EditAffilatesProgramType.class,
    com.ontraport.app.tests.EditAffilatesProgramName.class,
    com.ontraport.app.tests.DeleteAffiliateProgram.class,
    
    com.ontraport.app.tests.VideoManagerBack.class,
    
    com.ontraport.app.tests.WordPressSiteSwitchBetweenDomain.class,
    
    com.ontraport.app.tests.CreateAnExistingWordPressSite.class,
    com.ontraport.app.tests.ExistingWordPressSiteTryPilotPress.class,
    com.ontraport.app.tests.DeleteExistingWordPressSite.class,
    
    com.ontraport.app.tests.CreateWordPressBack.class,
    com.ontraport.app.tests.CreateWordPressCancel.class,
    
    com.ontraport.app.tests.WorkflowPagination.class,
    
    com.ontraport.app.tests.CreateDoubleOptinMessage.class,
    com.ontraport.app.tests.CreateCopyOfDoubleOptinMessage.class,
    com.ontraport.app.tests.DeleteDoubleOptinMessage.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateEmailandRuleStepSequenceTestStepControl.class,
    com.ontraport.app.tests.CreateEmailStepSequenceEdit.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.CreateStepSequenceBack.class,
    
    com.ontraport.app.tests.EmailStepCreateNewMessageAndEdit.class,
    
    com.ontraport.app.tests.CreateLandingPageCodeMode.class,
    com.ontraport.app.tests.EditLandingPageCodeModeInsertField.class,
    com.ontraport.app.tests.EditLandingPageCodeModeAddText.class,
    com.ontraport.app.tests.EditLandingPageCodeModeAddHTMLViaSource.class,
    com.ontraport.app.tests.EditLandingPageCodeModeSplitTestCheckbox.class,
    com.ontraport.app.tests.EditLandingPageCodeModeSplitTestDropDown.class,
    com.ontraport.app.tests.EditLandingPageCodeModeAlignment.class,
    com.ontraport.app.tests.EditLandingPageCodeModeAlignmentCenter.class,
    com.ontraport.app.tests.EditLandingPageCodeModeURL.class,
    com.ontraport.app.tests.EditLandingPageCodeModeTitle.class,
    com.ontraport.app.tests.EditLandingPageCodeModeName.class,
    com.ontraport.app.tests.CreateGateway.class,
    com.ontraport.app.tests.CreateOrderform.class,
    com.ontraport.app.tests.EditLandingPageCodeModeInsertForm.class,
    com.ontraport.app.tests.DeleteOrderForm.class,
    com.ontraport.app.tests.DeleteGateway.class,
    com.ontraport.app.tests.DeleteLandingPageCodeMode.class,
    
    com.ontraport.app.tests.VideoManagerCancel.class,
    
    com.ontraport.app.tests.CreateLandingPageBack.class,
    
    com.ontraport.app.tests.CreateLandingPageCancel.class,
    
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
    
    com.ontraport.app.tests.CreateSMSMessage.class,
    com.ontraport.app.tests.EditSMSMessageName.class,
    com.ontraport.app.tests.EditSMSMessageBody.class,
    com.ontraport.app.tests.EditSMSMessageMergeField.class,
    com.ontraport.app.tests.EditSMSMessageCancel.class,
    com.ontraport.app.tests.DeleteSMSMessage.class,
    
    com.ontraport.app.tests.CreateMessageCancel.class,
    
    com.ontraport.app.tests.CreateContact.class,
    //relies on having at least one contact
    com.ontraport.app.tests.AddTaskToContact.class,
    com.ontraport.app.tests.DeleteAddTaskToCopy.class,
    com.ontraport.app.tests.DeleteContact.class,
    
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
