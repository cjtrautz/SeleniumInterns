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
//    //these are all verified in GmailConfirmations
    com.ontraport.app.tests.SendBroadcastEmailToContact.class,
    com.ontraport.app.tests.SendSingleEmailToContact.class,
    com.ontraport.app.tests.EnsureStepSequenceImmedAndDelayStep.class,
    com.ontraport.app.tests.EnsureDateSequence.class,
    //com.ontraport.app.tests.CreateSendFromAddress.class, 
    com.ontraport.app.tests.SendDoubleOptIn.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateDoubleOptinMessage.class,
    //uses CreateDoubleOptinMessage message
    com.ontraport.app.tests.CreateCopyOfDoubleOptinMessage.class,
    //end use of CreateDoubleOptinMessage message
    com.ontraport.app.tests.DeleteDoubleOptinMessage.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateMessage.class,                         
    //sends CreateMessage message 
    com.ontraport.app.tests.SendTestEmail.class,
    //uses CreateMessage message
    com.ontraport.app.tests.CreateEmailandRuleStepSequenceTestStepControl.class,
    //edits CreateMessage message
    com.ontraport.app.tests.CreateEmailStepSequenceEdit.class,
    com.ontraport.app.tests.PreviewEmailMessage.class,
    com.ontraport.app.tests.EditEmailMessageAlignment.class,
    com.ontraport.app.tests.EditEmailMessageLinkText.class,
    com.ontraport.app.tests.EditEmailMessageSource.class,
    com.ontraport.app.tests.EditEmailMessageInsertHostedImage.class,
    com.ontraport.app.tests.EditEmailMessageInsertImage.class,
    //copies CreateMessage message
    com.ontraport.app.tests.CreateCopyOfEmailMessage.class,
    com.ontraport.app.tests.DeleteCopyOfEmailMessage.class,
    //uses CreateMessage message
    com.ontraport.app.tests.CreateEmailDateSequence.class,
    com.ontraport.app.tests.DeleteEmailDateSequence.class,
    com.ontraport.app.tests.CreateRule_NotifySomeoneWithEmail.class,
    com.ontraport.app.tests.DeleteRule_NotifySomeoneWithEmail.class,
    //used in following tests and uses CreateMessage message
    com.ontraport.app.tests.CreateEmailStepSequence.class,                  
    //uses CreateEmailStepSequence sequence
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToStepSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToUnPausedStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToUnPausedStepSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToPausedStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToPausedStepSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToStepSequence.class,
    com.ontraport.app.tests.CreateRule_UnPauseSubscriptionToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_UnPauseSubscriptionToStepSequence.class,
    com.ontraport.app.tests.CreateRule_PauseSubscriptionToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_PauseSubscriptionToStepSequence.class,
    com.ontraport.app.tests.CreateRule_RemoveContactFromStepSequence.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromStepSequence.class,
    com.ontraport.app.tests.CreateRule_AddContactToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_AddContactToStepSequence.class,
    //ends the use of CreateEmailStepSequence sequence and CreateMessage message
    com.ontraport.app.tests.DeleteEmailStepSequence.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateRule_ContactIsCreated.class,
    //uses CreateRule_ContactIsCreated rule
    com.ontraport.app.tests.PauseRule.class,
    com.ontraport.app.tests.UnpauseRule.class,
    //end use of CreateRule_ContactIsCreated rule
    com.ontraport.app.tests.DeleteRule_ContactIsCreated.class,
    
    //testing rule creation
    com.ontraport.app.tests.CreateRule_RemoveFromAllSequences.class,
    com.ontraport.app.tests.DeleteRule_RemoveFromAllSequences.class,
    com.ontraport.app.tests.CreateRule_TestAddAndTrash.class,
    com.ontraport.app.tests.CreateRule_1ConditionWithOr.class,
    com.ontraport.app.tests.DeleteRule_1ConditionWithOr.class,
    com.ontraport.app.tests.CreateRule_1ConditionWithAnd.class,
    com.ontraport.app.tests.DeleteRule_1ConditionWithAnd.class,
    com.ontraport.app.tests.CreateRule_IfNotSubscribedToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_IfNotSubscribedToFulfillmentList.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToFulfillmentList.class,
    com.ontraport.app.tests.CreateRule_HasSubscribedToProductForTime.class,
    com.ontraport.app.tests.DeleteRule_HasSubscribedTorProductForTime.class,
    com.ontraport.app.tests.CreateRule_IsSubscribedToProduct.class,
    com.ontraport.app.tests.DeleteRule_IsSubscribedToProduct.class,
    com.ontraport.app.tests.CreateRule_HasOrderAmountOfProduct.class,
    com.ontraport.app.tests.DeleteRule_HasOrderAmountOfProduct.class,
    com.ontraport.app.tests.CreateRule_HasSpentAmountOnProduct.class,
    com.ontraport.app.tests.DeleteRule_HasSpentAmountOnProduct.class,
    com.ontraport.app.tests.CreateRule_HasClickedEmailLinkNumberTimes.class,
    com.ontraport.app.tests.DeleteRule_HasClickedEmailLinkNumberTimes.class,
    com.ontraport.app.tests.CreateRule_HasOpenedEmailNumberTimes.class,
    com.ontraport.app.tests.DeleteRule_HasOpenedEmailNumberTimes.class,
    com.ontraport.app.tests.CreateRule_HasVisitedLPNumberTimes.class,
    com.ontraport.app.tests.DeleteRule_HasVisitedLPNumberTimes.class,
    com.ontraport.app.tests.CreateRule_HasVisitedWebsiteNumberTimes.class,
    com.ontraport.app.tests.DeleteRule_HasVisitedWebsiteNumberTimes.class,
    com.ontraport.app.tests.CreateRule_HasBeenOnSequenceForTime.class,
    com.ontraport.app.tests.DeleteRule_HasBeenOnSequenceForTime.class,
    com.ontraport.app.tests.CreateRule_VisitsAURL.class,
    com.ontraport.app.tests.DeleteRule_VisitsAURL.class,
    com.ontraport.app.tests.CreateRule_SubscriptionCompleted.class,
    com.ontraport.app.tests.DeleteRule_SubscriptionCompleted.class,
    com.ontraport.app.tests.CreateRule_SubscriptionCancelled.class,
    com.ontraport.app.tests.DeleteRule_SubscriptionCancelled.class,
    com.ontraport.app.tests.CreateRule_SubscriptionCharged.class,
    com.ontraport.app.tests.DeleteRule_SubscriptionCharged.class,
    com.ontraport.app.tests.CreateRule_SubscribedToSubscriptionProduct.class,
    com.ontraport.app.tests.DeleteRule_SubscribedToSubscriptionProduct.class,
    com.ontraport.app.tests.CreateRule_VisitsAPURL.class,
    com.ontraport.app.tests.DeleteRule_VisitsAPURL.class,
    com.ontraport.app.tests.CreateRule_VisitsALandingPage.class,
    com.ontraport.app.tests.DeleteRule_VisitsALandingPage.class,
    com.ontraport.app.tests.CreateRule_GetsRefundOnProduct.class,
    com.ontraport.app.tests.DeleteRule_GetsRefundOnProduct.class,
    com.ontraport.app.tests.CreateRule_PurchasesProduct.class,
    com.ontraport.app.tests.DeleteRule_PurchasesProduct.class,
    com.ontraport.app.tests.CreateRule_SendsYouAnEmail.class,
    com.ontraport.app.tests.DeleteRule_SendsYouAnEmail.class,
    com.ontraport.app.tests.CreateRule_OpensEmail.class,
    com.ontraport.app.tests.DeleteRule_OpensEmail.class,
    //no longer part of the system
//    com.ontraport.app.tests.CreateRule_WhenVisitsNonWpWebsite.class,
//    com.ontraport.app.tests.DeleteRule_WhenVisitsNonWpWebsite.class,
    com.ontraport.app.tests.CreateRule_WhenSubscriptionToAnySequenceUnPaused.class,
    com.ontraport.app.tests.DeleteRule_WhenSubscriptionToAnySequenceUnPaused.class,
    com.ontraport.app.tests.CreateRule_WhenSubscriptionToAnySequencePaused.class,
    com.ontraport.app.tests.DeleteRule_WhenSubscriptionToAnySequencePaused.class,
    com.ontraport.app.tests.CreateRule_WhenContactIsRemovedFromAnySequence.class,
    com.ontraport.app.tests.DeleteRule_WhenContactIsRemovedFromAnySequence.class,
    com.ontraport.app.tests.CreateRule_WhenContactIsAddedToAnySequence.class,
    com.ontraport.app.tests.DeleteRule_WhenContactIsAddedToAnySequence.class,
    com.ontraport.app.tests.CreateRule_CreditCardDeclined.class,
    com.ontraport.app.tests.DeleteRule_CreditCardDeclined.class,
    com.ontraport.app.tests.CreateRule_CreditCardCharged.class,
    com.ontraport.app.tests.DeleteRule_CreditCardCharged.class,
    com.ontraport.app.tests.CreateRule_ContactIsAddedToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_ContactIsAddedToFulfillmentList.class,
    com.ontraport.app.tests.CreateRule_ClicksTrackedLink.class,
    com.ontraport.app.tests.DeleteRule_ClicksTrackedLink.class,
    com.ontraport.app.tests.CreateRule_ClicksEMailLink.class,
    com.ontraport.app.tests.DeleteRule_ClicksEMailLink.class,
    com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteria.class,
    com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteria.class,
    com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdated.class,
    com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdated.class,
    com.ontraport.app.tests.CreateRule_WasSubscribedToSequence.class,
    com.ontraport.app.tests.DeleteRule_WasSubscribedToSequence.class,
    
    //testing navigation
    com.ontraport.app.tests.CancelBroadCast.class,
    com.ontraport.app.tests.DeleteCancelBroadCast.class,
    com.ontraport.app.tests.LeadScoringCancel.class,
    com.ontraport.app.tests.LeadScoringBack.class,
    com.ontraport.app.tests.FieldEditorCancel.class,
    com.ontraport.app.tests.FieldEditorBack.class,
    com.ontraport.app.tests.SMSStats.class,
    com.ontraport.app.tests.SMSCancel.class,
    com.ontraport.app.tests.SMSBack.class,
    
    //testing LeadScoring creation
    com.ontraport.app.tests.CreateLeadScoring_SMSDoesntContainText.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSDoesntContainText.class,
    com.ontraport.app.tests.CreateLeadScoring_SMSContainsText.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSContainsText.class,
    com.ontraport.app.tests.CreateLeadScoring_SMSDoesntContainsAnEmailAddress.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSDoesntContainsAnEmailAddress.class,
    com.ontraport.app.tests.CreateLeadScoring_SMSContainsAnEmailAddress.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSContainsAnEmailAddress.class,
    com.ontraport.app.tests.CreateLeadScoring_IsNotSubscribedToFulfillment.class,
    com.ontraport.app.tests.DeleteLeadScoring_IsNotSubscribedToFulfillment.class,
    com.ontraport.app.tests.CreateLeadScoring_IsSubscribedToFulfillment.class,
    com.ontraport.app.tests.DeleteLeadScoring_IsSubscribedToFulfillment.class,
    com.ontraport.app.tests.CreateLeadScoring_HasBeenSubscribedToProductCertainAmountOfTime.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasBeenSubscribedToProductCertainAmountOfTime.class,   
    com.ontraport.app.tests.CreateLeadScoring_IsSubscribedToProduct.class,
    com.ontraport.app.tests.DeleteLeadScoring_IsSubscribedToProduct.class,
    com.ontraport.app.tests.CreateLeadScoring_HasOrderedACertainAmountOnProduct.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasOrderedACertainAmountOnProduct.class,   
    com.ontraport.app.tests.CreateLeadScoring_HasSpentACertainAmountOnProduct.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasSpentACertainAmountOnProduct.class,
    com.ontraport.app.tests.CreateLeadScoring_HasOpenedEmailNumberOfTimes.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasOpenedEmailNumberOfTimes.class,
    com.ontraport.app.tests.CreateLeadScoring_HasVisitedWebsiteNumberOfTimes.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasVisitedWebsiteNumberOfTimes.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateEditableEmailMessage.class,
    //edits CreateEditableEmailMessage message
    com.ontraport.app.tests.EditEmailMessageBody.class,
    com.ontraport.app.tests.EditEmailMessageSubject.class,
//    com.ontraport.app.tests.EditEmailMessageReplyToName.class,
//    com.ontraport.app.tests.EditEmailMessageSendOutName.class,   
    com.ontraport.app.tests.EditEmailMessageName.class,
    com.ontraport.app.tests.EditEmailMessageMaximize.class,
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
    com.ontraport.app.tests.EditEmailMessagePaste.class,
    com.ontraport.app.tests.EditEmailMessagePlainPaste.class,
    com.ontraport.app.tests.EditEmailMessageInsertTable.class,
    com.ontraport.app.tests.EditEmailMessageInsertHorizontalLine.class,
    com.ontraport.app.tests.EditEmailMessageInsertSpecialCharacter.class,
    //ends use of CreateEditableEmailMessage message
    com.ontraport.app.tests.DeleteEditableEmailMessage.class,
    
    //verifies first tests fired emails
    com.ontraport.app.tests.GmailConfirmations.class,
    //deletes all of the email verification objects
    com.ontraport.app.tests.DeleteEnsureDateSequence.class,
    //com.ontraport.app.tests.DeleteSendFromAddress.class,
    com.ontraport.app.tests.DeleteBroadCastEmail.class,
    com.ontraport.app.tests.DeleteEnsureStepSequenceImmedAndDelayStep.class,
    //wait a little before deleting contact and message for one off to ensure email is sent
    com.ontraport.app.tests.DeleteSendSingleEmailToContact.class,
    
})
public class GmailSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("orm_off3@ontraport.com");
        AbstractPage.setPassword("password3");
        //AbstractPage.setUrl("https://app.ontraport.com/");
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
        Thread.sleep(10000);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
}
