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
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    com.ontraport.app.tests.CopyStepSequence.class,
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.AddNewSection.class,
    //relies on section
      com.ontraport.app.tests.CreateStateField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldState.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldState.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaState.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaState.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedState.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedState.class,
      com.ontraport.app.tests.CreateLeadScoring_AStateFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_AStateFieldMeetsCriteria.class,
      com.ontraport.app.tests.CreateTaskMessageBeforeDue.class,
      com.ontraport.app.tests.CreateGateway.class, 
      com.ontraport.app.tests.CreateOrderform.class,
      com.ontraport.app.tests.CreateLandingPageWithForm.class,
      com.ontraport.app.tests.CreateATag.class,
      com.ontraport.app.tests.SubmitOrderForm.class,
      com.ontraport.app.tests.CreateUserFieldEditor.class,
      com.ontraport.app.tests.CreateRule_PingAUrl.class,
      com.ontraport.app.tests.AddAPackageWithEverything.class,
      com.ontraport.app.tests.DeletePackageWithAll.class,
      com.ontraport.app.tests.DeleteTag.class,
      com.ontraport.app.tests.DeleteRule_PingAUrl.class,
      com.ontraport.app.tests.DeleteUserFieldEditor.class,
      com.ontraport.app.tests.EditLandingPageFormOpacity.class,
      com.ontraport.app.tests.EditLandingPageFormColor.class,
      com.ontraport.app.tests.EditLandingPageFormSize.class,
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
    //relies on text field
      com.ontraport.app.tests.AddStateFieldColumn.class,
      com.ontraport.app.tests.DeleteStateFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithStateField.class,
      com.ontraport.app.tests.DeleteStateGroup.class,
      com.ontraport.app.tests.DeleteStateField.class,
      //relies on section
      com.ontraport.app.tests.CreatePriceField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldPrice.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldPrice.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaPrice.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaPrice.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedPrice.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedPrice.class,
      com.ontraport.app.tests.CreateLeadScoring_APriceFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_APriceFieldMeetsCriteria.class,
    //relies on text field
      com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
      com.ontraport.app.tests.DeleteEmailCustomMessage.class,
      com.ontraport.app.tests.AddPriceFieldColumn.class,
      com.ontraport.app.tests.DeletePriceFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithPriceField.class,
      com.ontraport.app.tests.DeletePriceGroup.class,
      com.ontraport.app.tests.DeletePriceField.class,
    //relies on section
      com.ontraport.app.tests.CreateNumericField.class,
    //relies on text field
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldNumeric.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldNumeric.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaNumeric.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaNumeric.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedNumeric.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedNumeric.class,
      com.ontraport.app.tests.CreateLeadScoring_ANumericFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ANumericFieldMeetsCriteria.class,
      com.ontraport.app.tests.AddNumericFieldColumn.class,
      com.ontraport.app.tests.DeleteNumericFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithNumericField.class,
      com.ontraport.app.tests.DeleteNumericGroup.class,
      com.ontraport.app.tests.DeleteNumericField.class,
      //relies on section
      com.ontraport.app.tests.CreateLongTextField.class,
    //relies on text field
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldLongText.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldLongText.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaLongText.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaLongText.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedLongText.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedLongText.class,
      com.ontraport.app.tests.CreateSMSCustomFieldMessage.class,
      com.ontraport.app.tests.DeleteSMSCustomFieldMessage.class,
      com.ontraport.app.tests.CreateCustomFieldTaskMessage.class,
      com.ontraport.app.tests.DeleteCustomFieldTaskMessage.class,
      com.ontraport.app.tests.CreateLeadScoring_ALongTextFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ALongTextFieldMeetsCriteria.class,
      com.ontraport.app.tests.AddGroupWithLongTextField.class,
      com.ontraport.app.tests.DeleteLongTextGroup.class,
      com.ontraport.app.tests.DeleteLongTextField.class,
      //relies on section
      com.ontraport.app.tests.CreateListSelectionField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_AListSelectionFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_AListSelectionFieldMeetsCriteria.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldListSelection.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldListSelection.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaListSelection.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaListSelection.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedListSelection.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedListSelection.class,
      com.ontraport.app.tests.AddGroupWithListField.class,
      com.ontraport.app.tests.DeleteListGroup.class,
      com.ontraport.app.tests.DeleteListSelectionField.class,
      //relies on section
      com.ontraport.app.tests.CreateDateField.class,
    //relies on text field
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldDate.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldDate.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaDate.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaDate.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedDate.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedDate.class,
      com.ontraport.app.tests.CreateLeadScoring_ADateFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ADateFieldMeetsCriteria.class,
      com.ontraport.app.tests.AddDateFieldColumn.class,
      com.ontraport.app.tests.DeleteDateFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithDateField.class,
      com.ontraport.app.tests.DeleteDateGroup.class,
      com.ontraport.app.tests.DeleteDateField.class,
      //relies on section
      com.ontraport.app.tests.CreateCheckboxField.class,
    //relies on text field
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldCheckbox.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldCheckBox.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedCheckBox.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedCheckBox.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaCheckBox.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaCheckBox.class,
      com.ontraport.app.tests.CreateLeadScoring_ACheckboxFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ACheckboxFieldMeetsCriteria.class,
      com.ontraport.app.tests.AddCheckboxFieldColumn.class,
      com.ontraport.app.tests.DeleteCheckboxFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithCheckboxField.class,
      com.ontraport.app.tests.DeleteCheckboxGroup.class,
      com.ontraport.app.tests.DeleteCheckBoxField.class,
    //relies on section
      com.ontraport.app.tests.CreateDropdownField.class,
    //relies on text field
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldDropDown.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldDropDown.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaDropDown.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaDropDown.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedDropDown.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedDropDown.class,
      com.ontraport.app.tests.CreateLeadScoring_ADropDownFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ADropDownFieldMeetsCriteria.class,
      com.ontraport.app.tests.AddDropDownFieldColumn.class,
      com.ontraport.app.tests.DeleteDropDownFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithDropDownField.class,
      com.ontraport.app.tests.DeleteDropdownGroup.class,
      com.ontraport.app.tests.DeleteDropdownField.class,
    //relies on section
      com.ontraport.app.tests.CreateTextField.class,
    //relies on text field
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldText.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldText.class,
      com.ontraport.app.tests.CreateLeadScoring_ATextFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ATextFieldMeetsCriteria.class,
      com.ontraport.app.tests.AddTextFieldColumn.class,
      com.ontraport.app.tests.DeleteTextFieldColumn.class,
      com.ontraport.app.tests.AddGroupWithTextField.class,
      com.ontraport.app.tests.DeleteTextGroup.class,
      com.ontraport.app.tests.DeleteTextField.class,
      com.ontraport.app.tests.DeleteSection.class,
      
    com.ontraport.app.tests.CreateTagToAddToContact.class,
    com.ontraport.app.tests.CreateCopyOfStepSequence.class,
    com.ontraport.app.tests.DeleteCopyOfRuleStepSequence.class,
    com.ontraport.app.tests.CreateSplitTestMessages.class,
    com.ontraport.app.tests.EditSequenceWaitNegativeDaysAndAddEmailStep.class,
    com.ontraport.app.tests.EditSequenceSplitB.class,
    com.ontraport.app.tests.EditSequenceSplitBAndC.class,
    com.ontraport.app.tests.EditSequenceSplitBAndCAndD.class,
    com.ontraport.app.tests.CreateEmailDateSequence.class,
    com.ontraport.app.tests.EditDateSequenceSplitB.class,
    com.ontraport.app.tests.EditDateSequenceSplitBAndC.class,
    com.ontraport.app.tests.EditDateSequenceSplitBAndCAndD.class,
    com.ontraport.app.tests.CreateDateSequenceFromExisting.class,
    com.ontraport.app.tests.DeleteEmailDateSequence.class,
    com.ontraport.app.tests.EditSequenceWait0Days.class,
    com.ontraport.app.tests.EditSequenceWait1Days.class,
    com.ontraport.app.tests.EditSequenceSendAt15Mins.class,
    com.ontraport.app.tests.EditSequenceSendAtImmediate.class,
    com.ontraport.app.tests.EditSequenceSendAt2Hours.class,
    com.ontraport.app.tests.EditSequenceSendAt12PM.class,
    com.ontraport.app.tests.DeleteMessage.class,
    com.ontraport.app.tests.ShowSequenceOnSubscriptionManaementPage.class,
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    com.ontraport.app.tests.DeleteContact.class,
    
    
})
public class FieldEditorSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+2@gmail.com");
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
