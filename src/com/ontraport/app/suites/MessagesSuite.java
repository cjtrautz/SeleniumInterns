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
    com.ontraport.app.tests.CreateInvoiceMessage.class,
    com.ontraport.app.tests.DeleteInvoiceMessage.class,
    
    com.ontraport.app.tests.CreateSMSMessage.class,
    com.ontraport.app.tests.EditSMSMessageName.class,
    com.ontraport.app.tests.EditSMSMessageBody.class,
    com.ontraport.app.tests.EditSMSMessageMergeField.class,
    com.ontraport.app.tests.EditSMSMessageCancel.class,
    com.ontraport.app.tests.CreateCopyOfSMSMessage.class,
    com.ontraport.app.tests.DeleteSMSMessage.class,
    
    com.ontraport.app.tests.CreateMessageCancel.class,
    
    com.ontraport.app.tests.TaskMessageCancel.class,
    
    com.ontraport.app.tests.TaskMessageBack.class,
    
    com.ontraport.app.tests.CreateTaskWhoMessage.class,
    com.ontraport.app.tests.CreateTaskStepSequence.class,
    com.ontraport.app.tests.CreateRule_AddATask.class,
    com.ontraport.app.tests.DeleteRule_AddATask.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToStepSequenceIsUnPaused.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToStepSequenceIsUnPaused.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToStepSequenceIsPaused.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToStepSequenceIsPaused.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteTaskStepSequence.class,
    com.ontraport.app.tests.CreateTaskDateSequence.class,
    com.ontraport.app.tests.CreateRule_UnPauseSubscriptionToDateSequence.class,
    com.ontraport.app.tests.DeleteRule_UnPauseSubscriptionToDateSequence.class,
    com.ontraport.app.tests.CreateRule_PauseSubscriptionToDateSequence.class,
    com.ontraport.app.tests.DeleteRule_PauseSubscriptionToDateSequence.class,
    com.ontraport.app.tests.CreateRule_RemoveContactFromDateSequence.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromDateSequence.class,
    com.ontraport.app.tests.CreateRule_AddContactToDateSequence.class,
    com.ontraport.app.tests.DeleteRule_AddContactToDateSequence.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToDateSequenceIsUnPaused.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToDateSequenceIsUnPaused.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToDateSequenceIsPaused.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToDateSequenceIsPaused.class,
    com.ontraport.app.tests.CreateRule_IfNotSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteRule_IfNotSubscribedToDateSequence.class,
    com.ontraport.app.tests.CreateRule_IfSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteRule_IfSubscribedToDateSequence.class,
    com.ontraport.app.tests.CreateRule_WhenSubscriptionToDateSequenceUnPaused.class,
    com.ontraport.app.tests.DeleteRule_WhenSubscriptionToDateSequenceUnPaused.class,
    com.ontraport.app.tests.CreateRule_WhenSubscriptionToDateSequencePaused.class,
    com.ontraport.app.tests.DeleteRule_WhenSubscriptionToDateSequencePaused.class,
    com.ontraport.app.tests.CreateRule_WhenContactIsRemovedFromDateSequence.class,
    com.ontraport.app.tests.DeleteRule_WhenContactIsRemovedFromDateSequence.class,
    com.ontraport.app.tests.CreateRule_WhenContactIsAddedToDateSequence.class,
    com.ontraport.app.tests.DeleteRule_WhenContactIsAddedToDateSequence.class,
    com.ontraport.app.tests.DeleteTaskDateSequence.class,
    com.ontraport.app.tests.DeleteTaskWhoMessage.class,
    
    com.ontraport.app.tests.WorkflowPagination.class,
    
    com.ontraport.app.tests.CreateTaskMessage.class,
    //relies on task message
    com.ontraport.app.tests.CreateCopyOfTaskMessage.class,
    com.ontraport.app.tests.DeleteCopyOfTaskMessage.class,
    com.ontraport.app.tests.DeleteTaskMessage.class,
    
    com.ontraport.app.tests.UneditedWorkflow.class,
    com.ontraport.app.tests.PinnedItemsWorkflow.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    
    com.ontraport.app.tests.AccountAddAPackage.class,
    
    com.ontraport.app.tests.CreateUCConfig.class,
    
    com.ontraport.app.tests.CreateDoubleOptinMessage.class,
    com.ontraport.app.tests.CreateCopyOfDoubleOptinMessage.class,
    com.ontraport.app.tests.DeleteDoubleOptinMessage.class,
    
    //requires previously imported csv
    com.ontraport.app.tests.TryToFailUsageAgreementImport.class,
    
    com.ontraport.app.tests.CreateASmartForm.class,
    
    com.ontraport.app.tests.CreateFulfillment.class, 
    com.ontraport.app.tests.CreateFulfillmentDateSequence.class, 
    com.ontraport.app.tests.DeleteFulfillmentDateSequence.class,
  //relies on a fulfillment
    com.ontraport.app.tests.CreateFulfillmentStepSequence.class,
    com.ontraport.app.tests.DeleteFulfillmentStepSequence.class,
    //relies on a fulfillment
    com.ontraport.app.tests.CreateRule_RemoveContactFromFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromFulfillmentList.class,
    //relies on a fulfillment
    com.ontraport.app.tests.CreateRule_AddContactToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_AddContactToFulfillmentList.class,
    com.ontraport.app.tests.EditFulfillmentMonthly.class, 
    com.ontraport.app.tests.EditFulfillmentWeekly.class,
    com.ontraport.app.tests.EditFulfillmentSendNotificationTo.class,
    com.ontraport.app.tests.EditFulfillmentAddRecipient.class,
    com.ontraport.app.tests.EditFulfillmentUnsubContactFromFulfillmentAfterSend.class,
    com.ontraport.app.tests.EditFulfillmentCreateTask.class,
    com.ontraport.app.tests.EditFulfillmentDueEntryBox.class,
    com.ontraport.app.tests.EditFulfillmentBack.class,
    com.ontraport.app.tests.EditFulfillmentCancel.class,
    com.ontraport.app.tests.CreateRole.class,
    //relies on role
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.EditFulfillmentOwner.class,
    com.ontraport.app.tests.EditFulfillmentListFields.class,
    com.ontraport.app.tests.EditFulfillmentClearField.class,
    com.ontraport.app.tests.EditFulfillmentSelectAllField.class,
    com.ontraport.app.tests.DeleteFulfillment.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    
    com.ontraport.app.tests.StepSequenceBack.class,
    
    com.ontraport.app.tests.AddGroup.class,
    com.ontraport.app.tests.EditGroupPermission.class,
    com.ontraport.app.tests.DeleteGroup.class,
      
    com.ontraport.app.tests.CollapseNavButton.class,
      
    com.ontraport.app.tests.CheckLogOut.class,
    
    com.ontraport.app.tests.CreateAffiliateTrackingPixel.class,
    com.ontraport.app.tests.Create1SCSync.class,
    com.ontraport.app.tests.AffiliateLink.class,
    
    com.ontraport.app.tests.RetryTransactionsNonNumbers.class,
    com.ontraport.app.tests.RetryTransactionsDecimal.class,
    com.ontraport.app.tests.RetryTransactionsWholeNumber.class,
    
    com.ontraport.app.tests.ChangeBusinessInformation.class,
    
    com.ontraport.app.tests.AccountClickHere.class,
    com.ontraport.app.tests.AccountExportItFirst.class,
    
    com.ontraport.app.tests.HelpOpenAndClose.class,
    com.ontraport.app.tests.HelpFeedback.class,
    com.ontraport.app.tests.HelpSendEmail.class,
    com.ontraport.app.tests.HelpWatchVideos.class,
    
    com.ontraport.app.tests.CreateFacebook.class, 
    com.ontraport.app.tests.DeleteFacebook.class,

    com.ontraport.app.tests.CreateAPIKeys.class, 
    com.ontraport.app.tests.EditAPIKeysBack.class, 
    com.ontraport.app.tests.EditAPIKeysCancel.class, 
    com.ontraport.app.tests.DeleteAPIKeys.class,
    
    com.ontraport.app.tests.AddRoundRobin.class, 
    //relies on a router
    com.ontraport.app.tests.CreateRule_AddToLeadRouter.class,
    com.ontraport.app.tests.DeleteRule_AddToLeadRouter.class,
    com.ontraport.app.tests.CopyRoundRobin.class,
    com.ontraport.app.tests.DeleteRoundRobin.class,
    com.ontraport.app.tests.AddWeightedRandom.class, 
    com.ontraport.app.tests.CopyWeightedRandom.class, 
    com.ontraport.app.tests.DeleteWeightedRandom.class,
    
    com.ontraport.app.tests.CreateProduct.class,
    //relies on product
    com.ontraport.app.tests.CreateRule_AddProductToPurchaseHistory.class,
    com.ontraport.app.tests.DeleteRule_AddProductToPurchaseHistory.class,
    com.ontraport.app.tests.DeleteProduct.class,
    
    com.ontraport.app.tests.CreateRole.class,
    //relies on role
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.AddTaskToContact.class,
    com.ontraport.app.tests.TaskActions.class,
    com.ontraport.app.tests.DeleteAddTaskToCopy.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    //relies on a contact
    com.ontraport.app.tests.AddColumn.class,
    com.ontraport.app.tests.MoveColumn.class,
    com.ontraport.app.tests.DeleteColumn.class,
    //relies on having contacts
    com.ontraport.app.tests.WorkflowEnsureItemStore.class,
    com.ontraport.app.tests.EnsureRulesFire.class,
    com.ontraport.app.tests.DeleteEnsureRulesFire.class,
    //relies on single contact
    com.ontraport.app.tests.CreateNote.class,
    com.ontraport.app.tests.DeleteNote.class,
    //relies on having contacts
    com.ontraport.app.tests.CreateExportContacts.class,
    //relies on contact
    com.ontraport.app.tests.AddDeleteUserPermissions.class,
    //relies on a tag and contact
    com.ontraport.app.tests.AddTagToContact.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_RemoveContactFromTag.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromTag.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_AddContactToTag.class,
    com.ontraport.app.tests.DeleteRule_AddContactToTag.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_1ConditionWithOrAndAnd.class,
    com.ontraport.app.tests.DeleteRule_1ConditionWithOrAndAnd.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_ContactIsNotSubscribedToTag.class,
    com.ontraport.app.tests.DeleteRule_ContactIsNotSubscribedToTag.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_ContactIsSubscribedToTag.class,
    com.ontraport.app.tests.DeleteRule_ContactIsSubscribedToTag.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_ContactRemovedFromTag.class,
    com.ontraport.app.tests.DeleteRule_ContactRemovedFromTag.class,
    //relies on a tag
    com.ontraport.app.tests.CreateRule_ContactAddedToTag.class,
    com.ontraport.app.tests.DeleteRule_ContactAddedToTag.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToTag.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToTag.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToTag.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToTag.class,
    com.ontraport.app.tests.DeleteTag.class,
    com.ontraport.app.tests.DeleteContact.class,
 
})
public class MessagesSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+3@gmail.com");
        //AbstractPage.setLogin("nick@ontraport.com");
        AbstractPage.setPassword("test123");
        //AbstractPage.setUrl("https://app.ontraport.com/");
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
