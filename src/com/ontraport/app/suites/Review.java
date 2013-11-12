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
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardShapeHeight.class,
    com.ontraport.app.tests.EditPostcardShapeWidth.class,
    com.ontraport.app.tests.EditPostcardShapeLeft.class,
    com.ontraport.app.tests.EditPostcardShapeTop.class,
    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
    com.ontraport.app.tests.EditPostcardCopyLayer.class,
    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
    com.ontraport.app.tests.EditPostcardMoveLayer.class,
    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
    com.ontraport.app.tests.DeletePostcardMessage.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.CreatePriceField.class,
    com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
    com.ontraport.app.tests.DeleteEmailCustomMessage.class,
    com.ontraport.app.tests.DeletePriceField.class,
    com.ontraport.app.tests.DeleteSection.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateEmailMessageLPFields.class,
    com.ontraport.app.tests.DeleteEmailLPMessage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateEmailMessageWPFields.class,
    com.ontraport.app.tests.DeleteEmailWPMessage.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardShapeHeight.class,
    com.ontraport.app.tests.EditPostcardShapeWidth.class,
    com.ontraport.app.tests.EditPostcardShapeLeft.class,
    com.ontraport.app.tests.EditPostcardShapeTop.class,
    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
    com.ontraport.app.tests.EditPostcardCopyLayer.class,
    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
    com.ontraport.app.tests.EditPostcardMoveLayer.class,
    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
    com.ontraport.app.tests.DeletePostcardMessage.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.CreatePriceField.class,
    com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
    com.ontraport.app.tests.DeleteEmailCustomMessage.class,
    com.ontraport.app.tests.DeletePriceField.class,
    com.ontraport.app.tests.DeleteSection.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateEmailMessageLPFields.class,
    com.ontraport.app.tests.DeleteEmailLPMessage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateEmailMessageWPFields.class,
    com.ontraport.app.tests.DeleteEmailWPMessage.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardShapeHeight.class,
    com.ontraport.app.tests.EditPostcardShapeWidth.class,
    com.ontraport.app.tests.EditPostcardShapeLeft.class,
    com.ontraport.app.tests.EditPostcardShapeTop.class,
    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
    com.ontraport.app.tests.EditPostcardCopyLayer.class,
    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
    com.ontraport.app.tests.EditPostcardMoveLayer.class,
    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
    com.ontraport.app.tests.DeletePostcardMessage.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.CreatePriceField.class,
    com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
    com.ontraport.app.tests.DeleteEmailCustomMessage.class,
    com.ontraport.app.tests.DeletePriceField.class,
    com.ontraport.app.tests.DeleteSection.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateEmailMessageLPFields.class,
    com.ontraport.app.tests.DeleteEmailLPMessage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateEmailMessageWPFields.class,
    com.ontraport.app.tests.DeleteEmailWPMessage.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardShapeHeight.class,
    com.ontraport.app.tests.EditPostcardShapeWidth.class,
    com.ontraport.app.tests.EditPostcardShapeLeft.class,
    com.ontraport.app.tests.EditPostcardShapeTop.class,
    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
    com.ontraport.app.tests.EditPostcardCopyLayer.class,
    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
    com.ontraport.app.tests.EditPostcardMoveLayer.class,
    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
    com.ontraport.app.tests.DeletePostcardMessage.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.CreatePriceField.class,
    com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
    com.ontraport.app.tests.DeleteEmailCustomMessage.class,
    com.ontraport.app.tests.DeletePriceField.class,
    com.ontraport.app.tests.DeleteSection.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateEmailMessageLPFields.class,
    com.ontraport.app.tests.DeleteEmailLPMessage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateEmailMessageWPFields.class,
    com.ontraport.app.tests.DeleteEmailWPMessage.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,
    
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardShapeHeight.class,
    com.ontraport.app.tests.EditPostcardShapeWidth.class,
    com.ontraport.app.tests.EditPostcardShapeLeft.class,
    com.ontraport.app.tests.EditPostcardShapeTop.class,
    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
    com.ontraport.app.tests.EditPostcardCopyLayer.class,
    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
    com.ontraport.app.tests.EditPostcardMoveLayer.class,
    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
    com.ontraport.app.tests.DeletePostcardMessage.class,
    
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.CreatePriceField.class,
    com.ontraport.app.tests.CreateEmailMessageCustomFields.class,
    com.ontraport.app.tests.DeleteEmailCustomMessage.class,
    com.ontraport.app.tests.DeletePriceField.class,
    com.ontraport.app.tests.DeleteSection.class,
    
    com.ontraport.app.tests.CreateLandingPage.class,
    com.ontraport.app.tests.CreateEmailMessageLPFields.class,
    com.ontraport.app.tests.DeleteEmailLPMessage.class,
    com.ontraport.app.tests.DeleteLandingPage.class,
    
    com.ontraport.app.tests.CreateAWordPressSite.class,
    com.ontraport.app.tests.CreateEmailMessageWPFields.class,
    com.ontraport.app.tests.DeleteEmailWPMessage.class,
    com.ontraport.app.tests.DeleteWordPressSite.class,

    
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
