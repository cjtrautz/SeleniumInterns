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
    com.ontraport.app.tests.CreateLandingPageWithHTML.class,
    com.ontraport.app.tests.EditLandingPageHTMLLinksTo.class,
    com.ontraport.app.tests.EditLandingPageOpacityWithHTML.class,
    com.ontraport.app.tests.EditLandingPageLeftWithHTML.class,
    com.ontraport.app.tests.EditLandingPageWidthWithHTML.class,
    com.ontraport.app.tests.EditLandingPageTopWithHTML.class,
    com.ontraport.app.tests.EditLandingPageHeightWithHTML.class,
    com.ontraport.app.tests.DeleteLandingPageWithHTML.class,
    
    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
    com.ontraport.app.tests.EditLandingPageGradientOpacity.class,
    com.ontraport.app.tests.EditLandingPageToggleVertAndHorz.class,
    com.ontraport.app.tests.EditLandingPageGradientColors.class,
    com.ontraport.app.tests.EditLandingPageRoundedGradient.class,
    com.ontraport.app.tests.EditLandingPageCircleGradient.class,
    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
    
    com.ontraport.app.tests.CreateLandingPagePictureWithRectangle.class,
    com.ontraport.app.tests.EditLandingPageCircleImage.class,
    com.ontraport.app.tests.EditLandingPageImageTop.class,
    com.ontraport.app.tests.EditLandingPageImageWidth.class,
    com.ontraport.app.tests.EditLandingPageImageHeight.class,
    com.ontraport.app.tests.EditLandingPageImageLeft.class,
    com.ontraport.app.tests.EditLandingPageImageLinksTo.class,
    com.ontraport.app.tests.EditLandingPageImageOpacity.class,
    com.ontraport.app.tests.EditLandingPageImageRounded.class,
    com.ontraport.app.tests.EditLandingPageImageSelectImage.class,
    com.ontraport.app.tests.DeleteLandingPageImage.class,
    
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
    
    com.ontraport.app.tests.CreateSMSMessage.class,
    com.ontraport.app.tests.DeleteSMSMessage.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.EditLandingPageOpacity.class,
    com.ontraport.app.tests.EditLandingPageColor.class,
    com.ontraport.app.tests.EditLandingPageRounded.class,
    com.ontraport.app.tests.EditLandingPageCircle.class,
    com.ontraport.app.tests.EditLandingPageSplitTesting.class,
    com.ontraport.app.tests.EditLandingPageRemoveSplitTesting.class,
    com.ontraport.app.tests.EditLandingPagePageSize.class,
    com.ontraport.app.tests.EditLandingPageBackground.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateCopyOfStepSequence.class,
    com.ontraport.app.tests.DeleteCopyOfRuleStepSequence.class,
    com.ontraport.app.tests.CreateSplitTestMessages.class,
    com.ontraport.app.tests.EditSequenceWaitNegativeDaysAndAddEmailStep.class,
    com.ontraport.app.tests.EditSequenceWait0Days.class,
    com.ontraport.app.tests.EditSequenceWait1Days.class,
    com.ontraport.app.tests.EditSequenceSendAt15Mins.class,
    com.ontraport.app.tests.EditSequenceSendAtImmediate.class,
    com.ontraport.app.tests.EditSequenceSendAt2Hours.class,
    com.ontraport.app.tests.EditSequenceSendAt12PM.class,
    com.ontraport.app.tests.DeleteMessage.class,
    com.ontraport.app.tests.ShowSequenceOnSubscriptionManaementPage.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.EditEmailMessageAlignment.class,
    com.ontraport.app.tests.EditEmailMessageLinkText.class,
    com.ontraport.app.tests.EditEmailMessageSource.class,
    //relies on a message
    com.ontraport.app.tests.SendTestEmail.class,
    com.ontraport.app.tests.EditEmailMessageInsertHostedImage.class,
    com.ontraport.app.tests.EditEmailMessageInsertImage.class,
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
    
    com.ontraport.app.tests.CreateTaskMessageBeforeDue.class,
    com.ontraport.app.tests.CreateGateway.class, 
    com.ontraport.app.tests.CreateOrderform.class,
    com.ontraport.app.tests.CreateLandingPageWithForm.class,
    com.ontraport.app.tests.DeleteLandingPageWithForm.class,
    com.ontraport.app.tests.CreateTaskMessageIncludeForm.class,
    com.ontraport.app.tests.CreateTaskMessageNoForm.class,
    com.ontraport.app.tests.DeleteOrderForm.class,
    com.ontraport.app.tests.DeleteGateway.class,
    com.ontraport.app.tests.CreateTaskMessageSMS.class,
    com.ontraport.app.tests.CreateTaskMessageEmail.class,
    com.ontraport.app.tests.CreateTaskMessageAfterComplete.class,
    com.ontraport.app.tests.CreateTaskMessageAfterAssigned.class,
    com.ontraport.app.tests.CreateTaskMessageAfterDue.class,
    com.ontraport.app.tests.DeleteTaskMessageBeforeDue.class,
    
    com.ontraport.app.tests.TaskMessageCancel.class,
    
    com.ontraport.app.tests.TaskMessageBack.class,
    
    com.ontraport.app.tests.CreateTaskWhoMessage.class,
    com.ontraport.app.tests.DeleteTaskWhoMessage.class,
    
    com.ontraport.app.tests.CreateTaskMessage.class,
    //relies on task message
    com.ontraport.app.tests.CreateCopyOfTaskMessage.class,
    com.ontraport.app.tests.DeleteCopyOfTaskMessage.class,
    com.ontraport.app.tests.DeleteTaskMessage.class,
    
    com.ontraport.app.tests.CreatePostcardPictureWithRectangle.class,
    com.ontraport.app.tests.EditPostcardPictureOpacity.class,
    com.ontraport.app.tests.EditPostcardPictureCircle.class,
    com.ontraport.app.tests.EditPostcardPictureRounded.class,
    com.ontraport.app.tests.DeletePostcardPictureMessageAndCheckSelectImage.class,
    
    com.ontraport.app.tests.UploadToAttachmentManager.class,
    com.ontraport.app.tests.DeleteUploadToAttachmentManager.class,
    
    com.ontraport.app.tests.CreatePostcardGradientWithRectangle.class,
    com.ontraport.app.tests.EditPostcardGradientOpacity.class,
    com.ontraport.app.tests.EditPostcardToggleVertAndHorz.class,
    com.ontraport.app.tests.EditPostcardGradient.class,
    com.ontraport.app.tests.EditPostcardGradientRounded.class,
    com.ontraport.app.tests.EditPostcardGradientCircle.class,
    com.ontraport.app.tests.DeletePostcardGradientMessage.class,
    
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardOpacity.class,
    com.ontraport.app.tests.EditPostcardColor.class,
    com.ontraport.app.tests.EditPostcardRounded.class,
    com.ontraport.app.tests.EditPostcardRectangle.class,
    com.ontraport.app.tests.EditPostcardCircle.class,
    //relies postcard message
    com.ontraport.app.tests.CreateCopyOfPostcardMessage.class,
    com.ontraport.app.tests.DeleteCopyOfPostcardMessage.class,
    com.ontraport.app.tests.DeletePostcardMessage.class,
    
    com.ontraport.app.tests.CreatePostcardAndEditFontSize.class,
    com.ontraport.app.tests.EditPostcardLetterSpacing.class,
    com.ontraport.app.tests.EditPostcardLineSpacing.class,
    com.ontraport.app.tests.EditPostcardAlignRight.class,
    com.ontraport.app.tests.EditPostcardAlignCenter.class,
    com.ontraport.app.tests.EditPostcardAlignLeft.class,
    com.ontraport.app.tests.EditPostcardUnderline.class,
    com.ontraport.app.tests.EditPostcardItalic.class,
    com.ontraport.app.tests.EditPostcardBold.class,
    com.ontraport.app.tests.DeleteTestingPostcardMessage.class,
    
    com.ontraport.app.tests.CreateUserFieldEditor.class,
    com.ontraport.app.tests.DeleteUserFieldEditor.class,
    
    com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.AddNewSection.class,
    //relies on section
      com.ontraport.app.tests.CreateStateField.class,
    //relies on text field
      com.ontraport.app.tests.AddStateFieldColumn.class,
      com.ontraport.app.tests.DeleteStateFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithStateField.class,
      com.ontraport.app.tests.DeleteStateGroup.class,
      com.ontraport.app.tests.DeleteStateField.class,
      //relies on section
      com.ontraport.app.tests.CreatePriceField.class,
    //relies on text field
      com.ontraport.app.tests.AddPriceFieldColumn.class,
      com.ontraport.app.tests.DeletePriceFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithPriceField.class,
      com.ontraport.app.tests.DeletePriceGroup.class,
      com.ontraport.app.tests.DeletePriceField.class,
    //relies on section
      com.ontraport.app.tests.CreateNumericField.class,
    //relies on text field
      com.ontraport.app.tests.AddNumericFieldColumn.class,
      com.ontraport.app.tests.DeleteNumericFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithNumericField.class,
      com.ontraport.app.tests.DeleteNumericGroup.class,
      com.ontraport.app.tests.DeleteNumericField.class,
      //relies on section
      com.ontraport.app.tests.CreateLongTextField.class,
    //relies on text field
      com.ontraport.app.tests.AddGroupWithLongTextField.class,
      com.ontraport.app.tests.DeleteLongTextGroup.class,
      com.ontraport.app.tests.DeleteLongTextField.class,
      //relies on section
      com.ontraport.app.tests.CreateListSelectionField.class,
    //relies on text field
      com.ontraport.app.tests.AddGroupWithListField.class,
      com.ontraport.app.tests.DeleteListGroup.class,
      com.ontraport.app.tests.DeleteListSelectionField.class,
      //relies on section
      com.ontraport.app.tests.CreateDateField.class,
    //relies on text field
      com.ontraport.app.tests.AddDateFieldColumn.class,
      com.ontraport.app.tests.DeleteDateFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithDateField.class,
      com.ontraport.app.tests.DeleteDateGroup.class,
      com.ontraport.app.tests.DeleteDateField.class,
      //relies on section
      com.ontraport.app.tests.CreateCheckboxField.class,
    //relies on text field
      com.ontraport.app.tests.AddCheckboxFieldColumn.class,
      com.ontraport.app.tests.DeleteCheckboxFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithCheckboxField.class,
      com.ontraport.app.tests.DeleteCheckboxGroup.class,
      com.ontraport.app.tests.DeleteCheckBoxField.class,
    //relies on section
      com.ontraport.app.tests.CreateDropdownField.class,
    //relies on text field
      com.ontraport.app.tests.AddDropDownFieldColumn.class,
      com.ontraport.app.tests.DeleteDropDownFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithDropDownField.class,
      com.ontraport.app.tests.DeleteDropdownGroup.class,
      com.ontraport.app.tests.DeleteDropdownField.class,
    //relies on section
      com.ontraport.app.tests.CreateTextField.class,
    //relies on text field
      com.ontraport.app.tests.AddTextFieldColumn.class,
      com.ontraport.app.tests.DeleteTextFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithTextField.class,
      com.ontraport.app.tests.DeleteTextGroup.class,
      com.ontraport.app.tests.DeleteTextField.class,
      com.ontraport.app.tests.DeleteSection.class,
      com.ontraport.app.tests.DeleteContact.class,
      
    com.ontraport.app.tests.AddGroup.class,
    com.ontraport.app.tests.EditGroupPermission.class,
    com.ontraport.app.tests.DeleteGroup.class,
    
    com.ontraport.app.tests.CollapseNavButton.class,
    
    com.ontraport.app.tests.CheckLogOut.class,
    
    com.ontraport.app.tests.CreateRuleDateSequence.class,
  //relies on sequence
    com.ontraport.app.tests.UnsubscribeContactAfterLastStep.class,
  //relies on sequence
    com.ontraport.app.tests.RunSequenceOnlyOnWeekends.class,
    //relies on sequence
    com.ontraport.app.tests.VerifySequenceEditSteps.class,
    com.ontraport.app.tests.DeleteRuleDateSequence.class,
    
    com.ontraport.app.tests.CreateSendFromAddress.class,
    
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateContact.class,
    //relies on a contact
    com.ontraport.app.tests.AddColumn.class,
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
    com.ontraport.app.tests.CreateATag.class,
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
    com.ontraport.app.tests.DeleteTag.class,
    com.ontraport.app.tests.DeleteContact.class,
    
    com.ontraport.app.tests.SetLanguage.class, 
    
    com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.SetTimezone.class,
    
    com.ontraport.app.tests.UneditedWorkflow.class,
    com.ontraport.app.tests.PinnedItemsWorkflow.class,
    
    com.ontraport.app.tests.ChangeUserInfo.class,
    
    com.ontraport.app.tests.AccountAddAPackage.class,
    
    com.ontraport.app.tests.CreateRole.class,
    //relies on role
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    
    com.ontraport.app.tests.CreateUCConfig.class,
    
    com.ontraport.app.tests.CreateDoubleOptinMessage.class,
    com.ontraport.app.tests.DeleteDoubleOptinMessage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    //requires previously imported csv
    com.ontraport.app.tests.TryToFailUsageAgreementImport.class,
    
    com.ontraport.app.tests.CreateASmartForm.class,
    
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
    com.ontraport.app.tests.EditFulfillmentMonthly.class, 
    com.ontraport.app.tests.EditFulfillmentWeekly.class,
    com.ontraport.app.tests.EditFulfillmentSendNotificationTo.class,
    com.ontraport.app.tests.EditFulfillmentAddRecipient.class,
    com.ontraport.app.tests.EditFulfillmentUnsubContactFromFulfillmentAfterSend.class,
    com.ontraport.app.tests.EditFulfillmentCreateTask.class,
    com.ontraport.app.tests.EditFulfillmentDueEntryBox.class,
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
    
    com.ontraport.app.tests.CreateAPIKeys.class, 
    com.ontraport.app.tests.DeleteAPIKeys.class,
    
    com.ontraport.app.tests.AddRoundRobin.class, 
    //relies on a router
    com.ontraport.app.tests.CreateRule_AddToLeadRouter.class,
    com.ontraport.app.tests.DeleteRule_AddToLeadRouter.class,
    com.ontraport.app.tests.DeleteRoundRobin.class,
    com.ontraport.app.tests.AddWeightedRandom.class, 
    com.ontraport.app.tests.DeleteWeightedRandom.class,
    
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
    com.ontraport.app.tests.CreateRule_WasSubscribedToSequence.class,
    com.ontraport.app.tests.DeleteRule_WasSubscribedToSequence.class,
    
    com.ontraport.app.tests.CreateAffiliateTrackingPixel.class,
    com.ontraport.app.tests.Create1SCSync.class,
    com.ontraport.app.tests.AffiliateLink.class,
    
    com.ontraport.app.tests.CreateFacebook.class, 
    com.ontraport.app.tests.DeleteFacebook.class,

    com.ontraport.app.tests.GmailConfirmations.class,
    com.ontraport.app.tests.DeleteSendFromAddress.class,
    
})
public class Staging extends AbstractSuite
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
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
}
