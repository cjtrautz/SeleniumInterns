package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(

{  
    //yep
    
    com.ontraport.app.tests.CreateRole.class,
    //relies on role
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    
    com.ontraport.app.tests.CreateUCConfig.class,
    
    com.ontraport.app.tests.CreateDoubleOptinMessage.class,
    com.ontraport.app.tests.DeleteDoubleOptinMessage.class,
    
    com.ontraport.app.tests.CreateSendFromAddress.class,
    
    com.ontraport.app.tests.UploadToAttachmentManager.class,
    com.ontraport.app.tests.DeleteUploadToAttachmentManager.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    com.ontraport.app.tests.DeleteRuleDateSequence.class,
    
    com.ontraport.app.tests.CreateGateway.class, 
    com.ontraport.app.tests.DeleteGateway.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    //relies on a message
    com.ontraport.app.tests.CreateCopyOfEmailMessage.class,
    com.ontraport.app.tests.DeleteCopyOfEmailMessage.class,
    //relies on a message
    com.ontraport.app.tests.CreateEmailDateSequence.class,
    com.ontraport.app.tests.DeleteEmailDateSequence.class,
    //relies on a message
    com.ontraport.app.tests.CreateRule_NotifySomeoneWithEmail.class,
    com.ontraport.app.tests.DeleteRule_NotifySomeoneWithEmail.class,
    //relies on a message
    com.ontraport.app.tests.CreateEmailStepSequence.class,
    //relies on a step sequence
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToStepSequence.class,
    //relies on a step sequence
    com.ontraport.app.tests.CreateRule_UnPauseSubscriptionToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_UnPauseSubscriptionToStepSequence.class,
    //relies on a step sequence
    com.ontraport.app.tests.CreateRule_PauseSubscriptionToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_PauseSubscriptionToStepSequence.class,
    //relies on a step sequence
    com.ontraport.app.tests.CreateRule_RemoveContactFromStepSequence.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromStepSequence.class,
    //relies on a step sequence
    com.ontraport.app.tests.CreateRule_AddContactToStepSequence.class,
    com.ontraport.app.tests.DeleteRule_AddContactToStepSequence.class,
    com.ontraport.app.tests.DeleteEmailStepSequence.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    //requires previously imported csv
    com.ontraport.app.tests.TryToFailUsageAgreementImport.class,
    
    com.ontraport.app.tests.AddNewSection.class,
  //relies on section
    com.ontraport.app.tests.CreateStateField.class,
    com.ontraport.app.tests.DeleteStateField.class,
    //relies on section
    com.ontraport.app.tests.CreatePriceField.class,
    com.ontraport.app.tests.DeletePriceField.class,
  //relies on section
    com.ontraport.app.tests.CreateNumericField.class,
    com.ontraport.app.tests.DeleteNumericField.class,
    //relies on section
    com.ontraport.app.tests.CreateLongTextField.class,
    com.ontraport.app.tests.DeleteLongTextField.class,
    //relies on section
    com.ontraport.app.tests.CreateListSelectionField.class,
    com.ontraport.app.tests.DeleteListSelectionField.class,
    //relies on section
    com.ontraport.app.tests.CreateDateField.class,
    com.ontraport.app.tests.DeleteDateField.class,
    //relies on section
    com.ontraport.app.tests.CreateCheckboxField.class,
    com.ontraport.app.tests.DeleteCheckBoxField.class,
  //relies on section
    com.ontraport.app.tests.CreateDropdownField.class,
    com.ontraport.app.tests.DeleteDropdownField.class,
  //relies on section
    com.ontraport.app.tests.CreateTextField.class,
    com.ontraport.app.tests.DeleteTextField.class,
    com.ontraport.app.tests.DeleteSection.class,
    
    com.ontraport.app.tests.CreateASmartForm.class,
    
    com.ontraport.app.tests.CreateContact.class,
    //relies on having contacts
    //com.ontraport.app.tests.AddColumn.class,
    //com.ontraport.app.tests.DeleteColumn.class,
    //relies on single contact
    com.ontraport.app.tests.CreateNote.class,
    com.ontraport.app.tests.DeleteNote.class,
    //relies on having contacts
    com.ontraport.app.tests.CreateExportContacts.class,
    //relies on contact
    com.ontraport.app.tests.AddDeleteUserPermissions.class,
    com.ontraport.app.tests.DeleteContact.class,
    
    com.ontraport.app.tests.CreateTaskMessage.class,
    //relies on task message
    com.ontraport.app.tests.CreateCopyOfTaskMessage.class,
    com.ontraport.app.tests.DeleteCopyOfTaskMessage.class,
    com.ontraport.app.tests.DeleteTaskMessage.class,
    
    com.ontraport.app.tests.CreateFulfillment.class, 
  //relies on a fulfillment
    com.ontraport.app.tests.CreateFulfillmentStepSequence.class,
    com.ontraport.app.tests.DeleteFulfillmentStepSequence.class,
    //relies on a fulfillment
    com.ontraport.app.tests.CreateRule_RemoveContactFromFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_RemoveContactFromFulfillmentList.class,
    //relies on a fulfillment
    com.ontraport.app.tests.CreateRule_AddContactToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_AddContactToFulfillmentList.class,
    com.ontraport.app.tests.DeleteFulfillment.class,
    
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    
    com.ontraport.app.tests.CreateAPIKeys.class, 
    com.ontraport.app.tests.DeleteAPIKeys.class,
    
    com.ontraport.app.tests.AddRoundRobin.class, 
    //relies on a router
    com.ontraport.app.tests.CreateRule_AddToLeadRouter.class,
    com.ontraport.app.tests.DeleteRule_AddToLeadRouter.class,
    com.ontraport.app.tests.DeleteRoundRobin.class,
    com.ontraport.app.tests.AddWeightedRandom.class, 
    com.ontraport.app.tests.DeleteWeightedRandom.class,
    
    com.ontraport.app.tests.CreateATag.class,
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
    com.ontraport.app.tests.DeleteTag.class,
    
    com.ontraport.app.tests.CreateProduct.class,
    //relies on product
    com.ontraport.app.tests.CreateRule_AddProductToPurchaseHistory.class,
    com.ontraport.app.tests.DeleteRule_AddProductToPurchaseHistory.class,
    com.ontraport.app.tests.DeleteProduct.class,
    
    //rules that dont rely on anything
    com.ontraport.app.tests.CreateRule_PingAUrl.class,
    com.ontraport.app.tests.DeleteRule_PingAUrl.class,
    com.ontraport.app.tests.CreateRule_ContactIsCreated.class,
    com.ontraport.app.tests.DeleteRule_ContactIsCreated.class,
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
    com.ontraport.app.tests.CreateRule_WhenVisitsNonWpWebsite.class,
    com.ontraport.app.tests.DeleteRule_WhenVisitsNonWpWebsite.class,
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
    
    com.ontraport.app.tests.AddGroup.class,
    com.ontraport.app.tests.DeleteGroup.class,
    
    com.ontraport.app.tests.CreateAffiliateTrackingPixel.class,
    com.ontraport.app.tests.Create1SCSync.class,
    com.ontraport.app.tests.AffiliateLink.class,
    
    //failing
    
  //com.ontraport.app.tests.CreateFacebook.class, 
    //com.ontraport.app.tests.DeleteFacebook.class,
//    com.ontraport.app.tests.CreateRule_WasSubscribedToSequence.class,
//    com.ontraport.app.tests.DeleteRule_WasSubscribedToSequence.class,
//    com.ontraport.app.tests.CreateTab.class,
//    com.ontraport.app.tests.DeleteTab.class,

    
})
public class Active extends AbstractSuite
{
}
