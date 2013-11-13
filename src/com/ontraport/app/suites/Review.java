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
    com.ontraport.app.tests.CreateLeadScoring_SMSDoesntContainText.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSDoesntContainText.class,
    
    com.ontraport.app.tests.CreateLeadScoring_SMSContainsText.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSContainsText.class,
    
    com.ontraport.app.tests.CreateLeadScoring_SMSDoesntContainsAnEmailAddress.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSDoesntContainsAnEmailAddress.class,
    
    com.ontraport.app.tests.CreateLeadScoring_SMSContainsAnEmailAddress.class,
    com.ontraport.app.tests.DeleteLeadScoring_SMSContainsAnEmailAddress.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateLeadScoring_HasAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.CreateLeadScoring_DoesntHaveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteLeadScoring_DoesntHaveAccessToWordPressMembershipLevel.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
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
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateLeadScoring_HasVisitedLandingPageNumberOfTimes.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasVisitedLandingPageNumberOfTimes.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateLeadScoring_HasVisitedWebsiteNumberOfTimes.class,
    com.ontraport.app.tests.DeleteLeadScoring_HasVisitedWebsiteNumberOfTimes.class,
    
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToTag.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToTag.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToTag.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToTag.class,
    com.ontraport.app.tests.DeleteTag.class,
    
      com.ontraport.app.tests.AddNewSection.class,
        //relies on section          
      com.ontraport.app.tests.CreateStateField.class,
      com.ontraport.app.tests.CreateLeadScoring_AStateFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_AStateFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteStateField.class,
      //relies on section
      com.ontraport.app.tests.CreatePriceField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_APriceFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_APriceFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeletePriceField.class,
    //relies on section
      com.ontraport.app.tests.CreateNumericField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_ANumericFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ANumericFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteNumericField.class,
      //relies on section
      com.ontraport.app.tests.CreateLongTextField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_ALongTextFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ALongTextFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLongTextField.class,
      //relies on section
      com.ontraport.app.tests.CreateDateField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_ADateFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ADateFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteDateField.class,
      //relies on section
      com.ontraport.app.tests.CreateCheckboxField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_ACheckboxFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ACheckboxFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteCheckBoxField.class,
    //relies on section
      com.ontraport.app.tests.CreateDropdownField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_ADropDownFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ADropDownFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteDropdownField.class,
    //relies on section
      com.ontraport.app.tests.CreateTextField.class,
    //relies on text field
      com.ontraport.app.tests.CreateLeadScoring_ATextFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteLeadScoring_ATextFieldMeetsCriteria.class,
      com.ontraport.app.tests.DeleteTextField.class,
      com.ontraport.app.tests.DeleteSection.class,

    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateEmailStepSequence.class,
    //relies on a step sequence
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToUnPausedStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToUnPausedStepSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToPausedStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToPausedStepSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToStepSequence.class,
    com.ontraport.app.tests.DeleteEmailStepSequence.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToUnPausedDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToUnPausedDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToPausedDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToPausedDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteRuleDateSequence.class,    
    
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
