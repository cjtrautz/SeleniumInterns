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
    com.ontraport.app.tests.AddNewSection.class,
    //relies on section
      com.ontraport.app.tests.CreateStateField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedState.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedState.class,
      com.ontraport.app.tests.DeleteStateField.class,
      //relies on section
      com.ontraport.app.tests.CreatePriceField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedPrice.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedPrice.class,
      com.ontraport.app.tests.DeletePriceField.class,
    //relies on section
      com.ontraport.app.tests.CreateNumericField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedNumeric.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedNumeric.class,
      com.ontraport.app.tests.DeleteNumericField.class,
      //relies on section
      com.ontraport.app.tests.CreateLongTextField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedLongText.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedLongText.class,
      com.ontraport.app.tests.DeleteLongTextField.class,
      //relies on section
      com.ontraport.app.tests.CreateListSelectionField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedListSelection.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedListSelection.class,
      com.ontraport.app.tests.DeleteListSelectionField.class,
      //relies on section
      com.ontraport.app.tests.CreateDateField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedDate.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedDate.class,
      com.ontraport.app.tests.DeleteDateField.class,
      //relies on section
      com.ontraport.app.tests.CreateCheckboxField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedCheckBox.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedCheckBox.class,
      com.ontraport.app.tests.DeleteCheckBoxField.class,
    //relies on section
      com.ontraport.app.tests.CreateDropdownField.class,
      com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdatedDropDown.class,
      com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdatedDropDown.class,
      com.ontraport.app.tests.DeleteDropdownField.class,
      com.ontraport.app.tests.DeleteSection.class,
    
}
)
public class Review extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setUrl("https://app.ontraport.com/");
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
