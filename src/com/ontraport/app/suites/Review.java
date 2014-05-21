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
import org.openqa.selenium.remote.LocalFileDetector;

import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(
{
//    com.ontraport.app.tests.CreateTaskMessage.class,
//    //uses CreateTaskMessage message
//    com.ontraport.app.tests.CreateCopyOfTaskMessage.class,
//    com.ontraport.app.tests.DeleteCopyOfTaskMessage.class,
//    //end use of CreateTaskMessage message
//    com.ontraport.app.tests.DeleteTaskMessage.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateRole.class,
//    //used in following tests uses CreateRole role
//    com.ontraport.app.tests.CreateUser.class,
//    //used in following tests
//    com.ontraport.app.tests.CreateATag.class,
//    //used in following tests
    com.ontraport.app.tests.EnsureDateSequence.class,
//    //used in following tests and uses CreateContact contact
//    com.ontraport.app.tests.AddTaskToContact.class,
//    //uses CreateUser user and uses AddTaskToContact task
//    com.ontraport.app.tests.TaskActions.class,
//    //end use of AddTaskToContact task
//    com.ontraport.app.tests.DeleteAddTaskToCopy.class,
//    //uses CreateATag tag
//    com.ontraport.app.tests.EnsureTaskOutcomeWorksOnCompletion.class,
//    //end use of CreateUser user
//    com.ontraport.app.tests.DeleteUser.class,
//    //end use of CreateRole role
//    com.ontraport.app.tests.DeleteRole.class,
//    //needs contact in the contact collection to do column test
////    //uses CreateContact contact
////    com.ontraport.app.tests.WorkflowEnsureItemStore.class,
////    com.ontraport.app.tests.EnsureRulesFire.class,
////    com.ontraport.app.tests.DeleteEnsureRulesFire.class,
////    com.ontraport.app.tests.CreateNote.class,
////    com.ontraport.app.tests.DeleteNote.class,
////    com.ontraport.app.tests.AddDeleteUserPermissions.class,
////    //relies on having contacts
////    com.ontraport.app.tests.CreateExportContacts.class,
////    //uses CreateContact contact and uses CreateATag tag
////    com.ontraport.app.tests.AddTagToContact.class,
////    //uses CreateATag tag
////    com.ontraport.app.tests.CreateRule_RemoveContactFromTag.class,
////    com.ontraport.app.tests.DeleteRule_RemoveContactFromTag.class,
////    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToTag.class,
////    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToTag.class,
////    //end use of CreateATag tag
////    com.ontraport.app.tests.DeleteTag.class,
////    //end use of CreateContact contact
////    com.ontraport.app.tests.DeleteContact.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateLandingPagePictureWithRectangle.class,
//    //uses CreateLandingPagePictureWithRectangle landing page
//    com.ontraport.app.tests.EditLandingPageCircleImage.class,
//    com.ontraport.app.tests.EditLandingPageImageTop.class,
//    com.ontraport.app.tests.EditLandingPageImageWidth.class,
//    com.ontraport.app.tests.EditLandingPageImageHeight.class,
//    com.ontraport.app.tests.EditLandingPageImageLeft.class,
//    com.ontraport.app.tests.EditLandingPageImageLinksTo.class,
//    com.ontraport.app.tests.EditLandingPageImageOpacity.class,
//    com.ontraport.app.tests.EditLandingPageImageRounded.class,
//    com.ontraport.app.tests.EditLandingPageImageSelectImage.class,
//    //end use of CreateLandingPagePictureWithRectangle landing page
//    com.ontraport.app.tests.DeleteLandingPageImage.class,

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
        Thread.sleep(10000);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }

}
