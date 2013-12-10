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
    com.ontraport.app.tests.CreateRedirectLandingPage.class, 
    com.ontraport.app.tests.DeleteLandingPageRedirect.class, 
    
    com.ontraport.app.tests.CreateTrackedLink.class, 
    com.ontraport.app.tests.EditTrackedLinkName.class, 
    com.ontraport.app.tests.EditTrackedDestinationLink.class, 
    com.ontraport.app.tests.DeleteTrackedLink.class, 
    
    com.ontraport.app.tests.AddRoundRobin.class, 
    com.ontraport.app.tests.CopyRoundRobin.class, 
    com.ontraport.app.tests.DeleteRoundRobin.class,
    com.ontraport.app.tests.AddWeightedRandom.class, 
    com.ontraport.app.tests.CopyWeightedRandom.class, 
    com.ontraport.app.tests.DeleteWeightedRandom.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class, 
    com.ontraport.app.tests.CreateRule_VisitsAWPWebsite.class,
    com.ontraport.app.tests.DeleteRule_VisitsAWPWebsite.class,
    com.ontraport.app.tests.CreateRule_RemoveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteRule_RemoveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.CreateRule_GiveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteRule_GiveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.CreateRule_DoesntHaveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteRule_DoesntHaveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.CreateRule_HasAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteRule_HasAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.CreateRule_LosesAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteRule_LosesAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.CreateRule_IsGivenAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteRule_IsGivenAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreateRole.class,
    //relies on role
    com.ontraport.app.tests.CreateUser.class,
    com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.AddTaskToContact.class,
    com.ontraport.app.tests.TaskActions.class,
    com.ontraport.app.tests.DeleteAddTaskToCopy.class,
    com.ontraport.app.tests.DeleteContact.class,
    com.ontraport.app.tests.DeleteUser.class,
    com.ontraport.app.tests.DeleteRole.class,
    
    com.ontraport.app.tests.CreateTaskWhoMessage.class,
    com.ontraport.app.tests.CreateRule_AddATask.class,
    com.ontraport.app.tests.DeleteRule_AddATask.class,
    com.ontraport.app.tests.DeleteTaskWhoMessage.class,
    
    com.ontraport.app.tests.CreateRule_SMSContainsText.class,
    com.ontraport.app.tests.DeleteRule_SMSContainsText.class,
    com.ontraport.app.tests.CreateRule_SMSDoesntContainAnEmailAddress.class,
    com.ontraport.app.tests.DeleteRule_SMSDoesntContainAnEmailAddress.class,
    com.ontraport.app.tests.CreateRule_SMSDoesNotContainText.class,
    com.ontraport.app.tests.DeleteRule_SMSDoesNotContainText.class,
    com.ontraport.app.tests.CreateRule_SMSContainsAnEmailAddress.class,
    com.ontraport.app.tests.DeleteRule_SMSContainsAnEmailAddress.class,
    
    com.ontraport.app.tests.CreateRule_SMSRecievedFromContact.class,
    com.ontraport.app.tests.DeleteRule_SMSRecievedFromContact.class,
    
    com.ontraport.app.tests.CreateGateway.class, 
    com.ontraport.app.tests.CreateOrderform.class,
    com.ontraport.app.tests.CreateLandingPageWithForm.class,
    com.ontraport.app.tests.EditLandingPageFormOpacity.class,
    com.ontraport.app.tests.EditLandingPageFormColor.class,
    com.ontraport.app.tests.EditLandingPageFormSize.class,
    com.ontraport.app.tests.DeleteLandingPageWithForm.class,
    com.ontraport.app.tests.DeleteOrderForm.class,
    com.ontraport.app.tests.DeleteGateway.class,
    
    com.ontraport.app.tests.AddDateModifiedColumn.class,
    com.ontraport.app.tests.DeleteDateModifiedColumn.class,
    com.ontraport.app.tests.AddDateCreatedColumn.class,
    com.ontraport.app.tests.DeleteDateCreatedColumn.class,
    com.ontraport.app.tests.AddQuantityPurchasedColumn.class,
    com.ontraport.app.tests.DeleteQuantityPurchasedColumn.class,
    com.ontraport.app.tests.AddRevenueColumn.class,
    com.ontraport.app.tests.DeleteRevenueColumn.class,
    com.ontraport.app.tests.AddPriceColumn.class,
    com.ontraport.app.tests.DeletePriceColumn.class,
    com.ontraport.app.tests.AddProductIDColumn.class,
    com.ontraport.app.tests.DeleteProductIDColumn.class,

    com.ontraport.app.tests.AddNewSection.class,
    //relies on section
      com.ontraport.app.tests.CreateStateField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldState.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldState.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaState.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaState.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedState.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedState.class,
      com.ontraport.app.tests.DeleteStateField.class,
      //relies on section
      com.ontraport.app.tests.CreatePriceField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldPrice.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldPrice.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaPrice.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaPrice.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedPrice.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedPrice.class,
      com.ontraport.app.tests.DeletePriceField.class,
    //relies on section
      com.ontraport.app.tests.CreateNumericField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldNumeric.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldNumeric.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaNumeric.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaNumeric.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedNumeric.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedNumeric.class,
      com.ontraport.app.tests.DeleteNumericField.class,
      //relies on section
      com.ontraport.app.tests.CreateLongTextField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldLongText.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldLongText.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaLongText.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaLongText.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedLongText.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedLongText.class,
      com.ontraport.app.tests.DeleteLongTextField.class,
      //relies on section
      com.ontraport.app.tests.CreateListSelectionField.class,
      com.ontraport.app.tests.CreateLeadScoring_AListSelectionFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_AListSelectionFieldMeetsCriteria.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldListSelection.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldListSelection.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaListSelection.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaListSelection.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedListSelection.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedListSelection.class,
      com.ontraport.app.tests.DeleteListSelectionField.class,
      //relies on section
      com.ontraport.app.tests.CreateDateField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldDate.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldDate.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaDate.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaDate.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedDate.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedDate.class,
      com.ontraport.app.tests.DeleteDateField.class,
      //relies on section
      com.ontraport.app.tests.CreateCheckboxField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldCheckbox.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldCheckBox.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedCheckBox.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedCheckBox.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaCheckBox.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaCheckBox.class,
      com.ontraport.app.tests.DeleteCheckBoxField.class,
    //relies on section
      com.ontraport.app.tests.CreateDropdownField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldDropDown.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldDropDown.class,
      com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteriaDropDown.class,
      com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteriaDropDown.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedDropDown.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedDropDown.class,
      com.ontraport.app.tests.DeleteDropdownField.class,
      com.ontraport.app.tests.CreateTextField.class,
      com.ontraport.app.tests.CreateRule_ChangeTheValueOfAFieldText.class,
      com.ontraport.app.tests.DeleteRule_ChangeTheValueOfAFieldText.class,
      com.ontraport.app.tests.DeleteTextField.class,
      com.ontraport.app.tests.DeleteSection.class,
    
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
