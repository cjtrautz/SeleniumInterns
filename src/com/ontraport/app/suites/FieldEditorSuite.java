package com.ontraport.app.suites;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.OPPackage_View;
import com.ontraport.app.pages.Ontraport_SignUp;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.Values;

@RunWith(Suite.class)
@SuiteClasses(

{  
    //used in following tests
    com.ontraport.app.tests.CreateRuleStepSequence.class,
    //uses CreateRuleStepSequence sequence
    com.ontraport.app.tests.CopyStepSequence.class,
    //used in following tests
    com.ontraport.app.tests.CreateMessage.class,
    //used in following tests
    com.ontraport.app.tests.CreateContact.class,
    //used in following tests
    com.ontraport.app.tests.AddNewSection.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateStateField.class,
    //uses CreateStateField field
    com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldState.class,
    com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldState.class,
    com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaState.class,
    com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaState.class,
    com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedState.class,
    com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedState.class,
    com.ontraport.app.tests.CreateLeadScoring_AStateFieldMeetsCriteria.class,
    com.ontraport.app.tests.DeleteLeadScoring_AStateFieldMeetsCriteria.class,
    //used in following tests
    com.ontraport.app.tests.CreateTaskMessageBeforeDue.class,
    //used in following tests
    com.ontraport.app.tests.CreateGateway.class, 
    //used in following tests
    com.ontraport.app.tests.CreateATag.class,
    //used in following tests and uses CreateGateway gateway and uses CreateATag tag and uses CreateRuleStepSequence sequence and 
    com.ontraport.app.tests.CreateOrderform.class,
    //used in following tests and uses CreateOrderform orderform
    com.ontraport.app.tests.CreateLandingPageWithForm.class,
    //used in following tests and uses CreateOrderform orderform
    com.ontraport.app.tests.SubmitOrderForm.class,
    //used in following tests
    com.ontraport.app.tests.CreateUserFieldEditor.class,
    //used in following tests
    com.ontraport.app.tests.CreateRule_PingAUrl.class,
    //uses CreateATag tag and uses CreateRuleStepSequence sequence and uses CreateMessage message and 
    //uses CreateLandingPageWithForm landing page and uses CreateOrderform orderform and 
    //uses CreateRule_PingAUrl rule and uses AddNewSection section and uses CreateUserFieldEditor section
    com.ontraport.app.tests.AddAPackageWithEverything.class,
    com.ontraport.app.tests.DeletePackageWithAll.class,
    //end use of CreateATag tag
    com.ontraport.app.tests.DeleteTag.class,
    //end use of CreateRule_PingAUrl rule
    com.ontraport.app.tests.DeleteRule_PingAUrl.class,
    //end use of CreateUserFieldEditor section
    com.ontraport.app.tests.DeleteUserFieldEditor.class,
    //uses CreateLandingPageWithForm landing page
    com.ontraport.app.tests.EditLandingPageFormOpacity.class,
    //com.ontraport.app.tests.EditLandingPageFormColor.class,
    //com.ontraport.app.tests.EditLandingPageFormSize.class,
    //end use of CreateLandingPageWithForm landing page
    com.ontraport.app.tests.DeleteLandingPageWithForm.class,
    //uses CreateOrderform orderform
    com.ontraport.app.tests.CreateTaskMessageIncludeForm.class,
    com.ontraport.app.tests.CreateTaskMessageNoForm.class,
    //end use of CreateOrderform orderform
    com.ontraport.app.tests.DeleteOrderForm.class,
    //end use of CreateGateway gateway 
    com.ontraport.app.tests.DeleteGateway.class,
    //uses CreateTaskMessageBeforeDue message
    com.ontraport.app.tests.CreateTaskMessageSMS.class,
    com.ontraport.app.tests.CreateTaskMessageEmail.class,
    com.ontraport.app.tests.CreateTaskMessageAfterComplete.class,
    com.ontraport.app.tests.CreateTaskMessageAfterAssigned.class,
    com.ontraport.app.tests.CreateTaskMessageAfterDue.class,
    //end use of CreateTaskMessageBeforeDue message
    com.ontraport.app.tests.DeleteTaskMessageBeforeDue.class,
    //uses CreateStateField field
    com.ontraport.app.tests.AddStateFieldColumn.class,
    com.ontraport.app.tests.DeleteStateFieldColumn.class,
    com.ontraport.app.tests.AddGroupWithStateField.class,
    com.ontraport.app.tests.DeleteStateGroup.class,
    //end use of CreateStateField field
    com.ontraport.app.tests.DeleteStateField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreatePriceField.class,
    //uses CreatePriceField field
    com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldPrice.class,
    com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldPrice.class,
    com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaPrice.class,
    com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaPrice.class,
    com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedPrice.class,
    com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedPrice.class,
    com.ontraport.app.tests.CreateLeadScoring_APriceFieldMeetsCriteria.class,
    com.ontraport.app.tests.DeleteLeadScoring_APriceFieldMeetsCriteria.class,
    com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
    com.ontraport.app.tests.DeleteEmailCustomMessage.class,
    com.ontraport.app.tests.AddPriceFieldColumn.class,
    com.ontraport.app.tests.DeletePriceFieldColumn.class,
    com.ontraport.app.tests.AddGroupWithPriceField.class,
    com.ontraport.app.tests.DeletePriceGroup.class,
    //end use of CreatePriceField field
    com.ontraport.app.tests.DeletePriceField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateNumericField.class,
    //uses CreateNumericField field
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
    //end use of CreateNumericField field
    com.ontraport.app.tests.DeleteNumericField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateLongTextField.class,
    //uses CreateLongTextField field
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
    //end use of CreateLongTextField field
    com.ontraport.app.tests.DeleteLongTextField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateListSelectionField.class,
    //uses CreateListSelectionField field
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
    //end use of CreateListSelectionField field
    com.ontraport.app.tests.DeleteListSelectionField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateDateField.class,
    //uses CreateDateField field
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
    //end use of CreateDateField field
    com.ontraport.app.tests.DeleteDateField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateCheckboxField.class,
    //uses CreateCheckboxField field
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
    //end use of CreateCheckboxField field
    com.ontraport.app.tests.DeleteCheckBoxField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateDropdownField.class,
    //uses CreateDropdownField field
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
    //end use of CreateDropdownField field
    com.ontraport.app.tests.DeleteDropdownField.class,
    //used in following tests and uses AddNewSection section
    com.ontraport.app.tests.CreateTextField.class,
    //uses CreateTextField field
    com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldText.class,
    com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldText.class,
    com.ontraport.app.tests.CreateLeadScoring_ATextFieldMeetsCriteria.class,
    com.ontraport.app.tests.DeleteLeadScoring_ATextFieldMeetsCriteria.class,
    com.ontraport.app.tests.AddTextFieldColumn.class,
    com.ontraport.app.tests.DeleteTextFieldColumn.class,
    com.ontraport.app.tests.AddGroupWithTextField.class,
    com.ontraport.app.tests.DeleteTextGroup.class,
    //end use of CreateTextField field 
    com.ontraport.app.tests.DeleteTextField.class,
    //end use of AddNewSection section
    com.ontraport.app.tests.DeleteSection.class,
    //uses CreateContact contact  
    com.ontraport.app.tests.CreateTagToAddToContact.class,
    //uses CreateRuleStepSequence sequence
    com.ontraport.app.tests.CreateCopyOfStepSequence.class,
    com.ontraport.app.tests.DeleteCopyOfRuleStepSequence.class,
    
    //end use of CreateMessage message
    com.ontraport.app.tests.DeleteMessage.class,
    //end use of CreateRuleStepSequence sequence
    com.ontraport.app.tests.DeleteRuleStepSequence.class,
    //end use of CreateContact contact  
    com.ontraport.app.tests.DeleteContact.class,
    
    
})
public class FieldEditorSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+" + AbstractSuite.UNIQUE +"@gmail.com");
        AbstractPage.setPassword("test123");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(false);
        profile.setPreference("browser.cache.disk.enable", true);
        profile.setPreference("browser.cache.memory.enable", true);
        profile.setPreference("browser.cache.offline.enable", true);
        profile.setPreference("network.http.use-cache", true);
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
        Values value = new Values();
        driver.get("https://ontraport.com/ontraport-comped-signup.php");
        Ontraport_SignUp ontraport_SignUp = (Ontraport_SignUp) new Ontraport_SignUp().init();
        ontraport_SignUp.enterFirstName(value.get("SignUp", "first_name"));
        ontraport_SignUp.enterLastName(value.get("SignUp", "last_name"));
        ontraport_SignUp.enterBusinessName(value.get("SignUp", "business"));
        ontraport_SignUp.enterPhoneNumber(value.get("SignUp", "phone_number"));
        ontraport_SignUp.enterAddress(value.get("SignUp", "address"));
        ontraport_SignUp.enterCity(value.get("SignUp", "city"));
        ontraport_SignUp.enterState("c");
        ontraport_SignUp.enterZip(value.get("SignUp", "zip"));
        ontraport_SignUp.enterCountry("u");
        ontraport_SignUp.enterEmailAddress("ontraportselenium+" + AbstractSuite.UNIQUE +"@gmail.com");
        ontraport_SignUp.enterEmailAddressAgain("ontraportselenium+" + AbstractSuite.UNIQUE +"@gmail.com");
        ontraport_SignUp.enterPassword("test123");
        ontraport_SignUp.enterPasswordAgain("test123");
        ontraport_SignUp.enterNameOnCard(value.get("SignUp", "name"));
        ontraport_SignUp.enterCard(value.get("SignUp", "card"));
        ontraport_SignUp.enterSecurityCode(value.get("SignUp", "code"));
        ontraport_SignUp.enterExpiresOnMonth("2");
        ontraport_SignUp.enterExpiresOnYear("2");
        ontraport_SignUp.enterBillingZip(value.get("SignUp", "zip"));
        ontraport_SignUp.checkAgreeToTerms();
        ontraport_SignUp.clickCreateMyAccount();
        Thread.sleep(4000);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPage.setUrl("https://staging.ontraport.com/");
        Login login = (Login) new Login().init();
        login.open(Login.url, true);
        login.as(AbstractPage.getLogin(), AbstractPage.getPassword());
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        ontraport_SignUp.dialogBox.enterSubDomain(value.get("SignUp", "first_name") + AbstractSuite.UNIQUE);
        ontraport_SignUp.dialogBox.enterReplyToName(value.get("SignUp", "email"));
        ontraport_SignUp.dialogBox.enterBusinessName(value.get("SignUp", "business"));
        ontraport_SignUp.dialogBox.enterBusinessAddress(value.get("SignUp", "address"));
        ontraport_SignUp.dialogBox.enterBusinessCity(value.get("SignUp", "city"));
        ontraport_SignUp.dialogBox.enterBusinessZip(value.get("SignUp", "zip"));
        Contact_ListAll contact_ListAll = ontraport_SignUp.dialogBox.clickSubmit();
        contact_ListAll.dialogBox.clickCancelTour();
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
    @AfterClass
    public static void afterSuite ()
    {
        Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
        contact_ListAll.menuUser.open();
        OPPackage_View oPPackage_View = contact_ListAll.menuUser.clickAccount();
        oPPackage_View.clickCancelAccount();
        oPPackage_View.dialogBox.checkIKnowDeleted();
        oPPackage_View.dialogBox.checkIKnowNoRecovery();
        oPPackage_View.dialogBox.checkIKnowStopWorking();
        Login login = oPPackage_View.dialogBox.clickCancelAccount();
        AbstractPart.waitForAjax(driver, 30);
        if ( driver.findElements(By.xpath("//input[@class='moonray-form-input']")).size() == 0 )
        {
            fail("Can't find Affiliates page");
        }
    }
}
