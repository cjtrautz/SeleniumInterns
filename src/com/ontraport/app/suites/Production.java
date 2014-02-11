package com.ontraport.app.suites;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(

{
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.ImportContacts.class,
    
    com.ontraport.app.tests.SendBroadcastEmailToContact.class,
    com.ontraport.app.tests.EnsureStepSequenceImmedAndDelayStep.class,
    com.ontraport.app.tests.SendSingleEmailToContact.class,
    com.ontraport.app.tests.EnsureDateSequence.class,
    com.ontraport.app.tests.CreateSendFromAddress.class,
    
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.SendTestEmail.class,
    com.ontraport.app.tests.EditSequenceWaitNegativeDaysAndAddEmailStep.class,
    com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.CreateTagToAddToContact.class,
    com.ontraport.app.tests.WorkflowEnsureItemStore.class,
    com.ontraport.app.tests.EnsureRulesFire.class,
    com.ontraport.app.tests.DeleteEnsureRulesFire.class,
    com.ontraport.app.tests.AddNewSection.class,
    //relies on section
    com.ontraport.app.tests.CreateStateField.class,
    com.ontraport.app.tests.CreateGateway.class,
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateOrderform.class,
    com.ontraport.app.tests.CreateLandingPageWithForm.class,
    com.ontraport.app.tests.SubmitOrderForm.class,
    com.ontraport.app.tests.CreateRule_PingAUrl.class,
    com.ontraport.app.tests.CreateUserFieldEditor.class,
    com.ontraport.app.tests.AddAPackageWithEverything.class,
    com.ontraport.app.tests.DeletePackageWithAll.class,
    com.ontraport.app.tests.DeleteUserFieldEditor.class,
    com.ontraport.app.tests.DeleteRule_PingAUrl.class,
    com.ontraport.app.tests.DeleteTag.class,
    com.ontraport.app.tests.DeleteLandingPageWithForm.class,
    com.ontraport.app.tests.DeleteOrderForm.class,
    com.ontraport.app.tests.DeleteGateway.class,
    com.ontraport.app.tests.DeleteStateField.class,
    com.ontraport.app.tests.DeleteSection.class,
    com.ontraport.app.tests.DeleteContact.class,
    com.ontraport.app.tests.DeleteMessage.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    
    com.ontraport.app.tests.CreateTaskMessageBeforeDue.class,
    com.ontraport.app.tests.DeleteTaskMessageBeforeDue.class,
    
    com.ontraport.app.tests.CreateSMSMessage.class,
    com.ontraport.app.tests.DeleteSMSMessage.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.UploadToAttachmentManager.class,
    com.ontraport.app.tests.DeleteUploadToAttachmentManager.class,
    
    com.ontraport.app.tests.AddGroup.class,
    com.ontraport.app.tests.DeleteGroup.class,
    
    com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.UneditedWorkflow.class,
    com.ontraport.app.tests.PinnedItemsWorkflow.class,
    
    com.ontraport.app.tests.CreateRole.class,
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    
    //requires previously imported csv
    com.ontraport.app.tests.TryToFailUsageAgreementImport.class,
    
    com.ontraport.app.tests.CreateASmartForm.class,
    
    com.ontraport.app.tests.CreateProduct.class,
    com.ontraport.app.tests.DeleteProduct.class,
 
    com.ontraport.app.tests.GmailConfirmations.class,
    com.ontraport.app.tests.DeleteEnsureDateSequence.class,
    com.ontraport.app.tests.DeleteSendFromAddress.class,
    com.ontraport.app.tests.DeleteBroadCastEmail.class,
    com.ontraport.app.tests.DeleteEnsureStepSequenceImmedAndDelayStep.class,
    
})
public class Production extends AbstractSuite
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
