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
    com.ontraport.app.tests.CreateSmartFormWithGetPaid.class,
    com.ontraport.app.tests.DeleteSmartFormWithGetPaid.class,
    
    com.ontraport.app.tests.UploadVideo.class,
    
    com.ontraport.app.tests.CreateTab.class,
    com.ontraport.app.tests.DeleteTab.class,
    
    com.ontraport.app.tests.NameATab.class,
    
    com.ontraport.app.tests.SetLanguage.class, 
    
    com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.SetTimezone.class,
    
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
   
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    com.ontraport.app.tests.MassActionForContacts.class,
    //uses CreateMessage message
    com.ontraport.app.tests.CreateAffiliatesProgramWithContactIDAndPurchaseHistory.class,
    com.ontraport.app.tests.DeleteAffiliateProgramWithContactIDAndPurchaseHistory.class,
    //uses CreateMessage message
    com.ontraport.app.tests.CreateAffiliatesProgramWithFullNameAndDeclinedTrans.class,
    com.ontraport.app.tests.DeleteAffiliateProgramWithFullNameAndDeclinedTrans.class,
    //used in following tests uses CreateMessage message
    com.ontraport.app.tests.CreateAffilatesProgram.class,
    //uses CreateAffilatesProgram program
    com.ontraport.app.tests.EditAffilatesProgramNotify.class,
    com.ontraport.app.tests.EditAffilatesProgramShowCompletePurchaseHistory.class,
    com.ontraport.app.tests.EditAffilatesProgramShowDeclined.class,
    com.ontraport.app.tests.EditAffilatesProgramInformation.class,
    com.ontraport.app.tests.EditAffilatesProgramType.class,
    com.ontraport.app.tests.EditAffilatesProgramName.class,
    //end use of CreateAffilatesProgram program
    com.ontraport.app.tests.DeleteAffiliateProgram.class,
    
    com.ontraport.app.tests.VideoManagerBack.class,
    
    com.ontraport.app.tests.UploadToAttachmentManager.class,
    com.ontraport.app.tests.DeleteUploadToAttachmentManager.class,
    
    com.ontraport.app.tests.CreateTrackingURL.class,
    com.ontraport.app.tests.DeleteTrackingURL.class,
    
    com.ontraport.app.tests.CreateSmartFormWithConditions.class,
    com.ontraport.app.tests.DeleteSmartFormWithConditions.class,
    com.ontraport.app.tests.CreateSmartFormWithTemplate.class,
    com.ontraport.app.tests.DeleteSmartFormWithTemplate.class,
    com.ontraport.app.tests.CreateSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.CreateSmartFormWithCaptcha.class,
    com.ontraport.app.tests.DeleteSmartFormWithCaptcha.class,
    com.ontraport.app.tests.CreateSmartFormWithAddContent.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddContent.class,
    com.ontraport.app.tests.CreateSmartFormWithAddField.class,
    com.ontraport.app.tests.DeleteSmartFormField.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddField.class,
    com.ontraport.app.tests.CreateSmartFormWithMovedSubmit.class,
    com.ontraport.app.tests.DeleteSmartFormWithMovedSubmit.class,
    com.ontraport.app.tests.CreateAndHostSmartForm.class,
    com.ontraport.app.tests.DeleteHostedSmartForm.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    com.ontraport.app.tests.MassActionForContacts.class,
    com.ontraport.app.tests.CreateTaskFromSequence.class,
    com.ontraport.app.tests.DeleteCreateTaskFromSequence.class,
    com.ontraport.app.tests.CreateGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.CreateProduct.class,
    com.ontraport.app.tests.CreateOrderformWithTaxAndShipping.class,
    com.ontraport.app.tests.DeleteOrderformWithTaxAndShipping.class,
    com.ontraport.app.tests.CreateSMSMessageFromSequence.class,
    com.ontraport.app.tests.DeleteSMSMessageFromSequence.class,
    com.ontraport.app.tests.CreateFulfillmentFromSequence.class,
    com.ontraport.app.tests.DeleteFulfillmentFromSequence.class,
    com.ontraport.app.tests.DeleteProduct.class,
    com.ontraport.app.tests.DeleteGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.MoveATabToOverflow.class,
    //used in following tests
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    //used in following tests
    com.ontraport.app.tests.CreateSplitTestMessages.class,
    //uses CreateRuleStepSequence sequence and uses CreateMessage message
    com.ontraport.app.tests.EditSequenceWaitNegativeDaysAndAddEmailStep.class,
  //uses CreateRuleStepSequence sequence and uses CreateSplitTestMessages messages
    com.ontraport.app.tests.EditSequenceSplitB.class,
    com.ontraport.app.tests.EditSequenceSplitBAndC.class,
    com.ontraport.app.tests.EditSequenceSplitBAndCAndD.class,
    //uses CreateRuleStepSequence sequence
    com.ontraport.app.tests.EditSequenceWait0Days.class,
    com.ontraport.app.tests.EditSequenceWait1Days.class,
    com.ontraport.app.tests.EditSequenceSendAt15Mins.class,
    com.ontraport.app.tests.EditSequenceSendAtImmediate.class,
    com.ontraport.app.tests.EditSequenceSendAt2Hours.class,
    com.ontraport.app.tests.EditSequenceSendAt12PM.class,
    com.ontraport.app.tests.ShowSequenceOnSubscriptionManaementPage.class,
    //used in following tests and uses CreateMessage message
    com.ontraport.app.tests.CreateEmailDateSequence.class,
    //uses CreateEmailDateSequence sequence and uses CreateSplitTestMessages messages
    com.ontraport.app.tests.EditDateSequenceSplitB.class,
    com.ontraport.app.tests.EditDateSequenceSplitBAndC.class,
    com.ontraport.app.tests.EditDateSequenceSplitBAndCAndD.class,
    //uses uses CreateEmailDateSequence sequence
    com.ontraport.app.tests.CreateDateSequenceFromExisting.class,
    com.ontraport.app.tests.CreateSmartFormWithConditions.class,
    com.ontraport.app.tests.DeleteSmartFormWithConditions.class,
    com.ontraport.app.tests.CreateSmartFormWithTemplate.class,
    com.ontraport.app.tests.DeleteSmartFormWithTemplate.class,
    com.ontraport.app.tests.CreateSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.CreateSmartFormWithCaptcha.class,
    com.ontraport.app.tests.DeleteSmartFormWithCaptcha.class,
    com.ontraport.app.tests.CreateSmartFormWithAddContent.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddContent.class,
    com.ontraport.app.tests.CreateSmartFormWithAddField.class,
    com.ontraport.app.tests.DeleteSmartFormField.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddField.class,
    com.ontraport.app.tests.CreateSmartFormWithMovedSubmit.class,
    com.ontraport.app.tests.DeleteSmartFormWithMovedSubmit.class,
    com.ontraport.app.tests.DeleteAndVerifyMassActionForContact.class,
    com.ontraport.app.tests.DeleteRuleDateSequence.class,
    com.ontraport.app.tests.DeleteTag.class,
    //end use of CreateEmailDateSequence sequence
    com.ontraport.app.tests.DeleteEmailDateSequence.class,
    com.ontraport.app.tests.DeleteMessage.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
   
    
    
})
public class AdminSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+4@gmail.com");
        AbstractPage.setPassword("test123");
        //AbstractPage.setUrl("https://staging.ontraport.com/");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(false);
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
