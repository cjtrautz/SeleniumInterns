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
    com.ontraport.app.tests.CreatePostcardPictureWithRectangle.class,
    com.ontraport.app.tests.EditPostcardPictureOpacity.class,
    com.ontraport.app.tests.EditPostcardPictureCircle.class,
    com.ontraport.app.tests.EditPostcardPictureRounded.class,
    com.ontraport.app.tests.DeletePostcardPictureMessageAndCheckSelectImage.class,
    
    com.ontraport.app.tests.CreatePostcardGradientWithRectangle.class,
    com.ontraport.app.tests.EditPostcardGradientOpacity.class,
    com.ontraport.app.tests.EditPostcardToggleVertAndHorz.class,
    com.ontraport.app.tests.EditPostcardGradient.class,
    com.ontraport.app.tests.EditPostcardGradientRounded.class,
    com.ontraport.app.tests.EditPostcardGradientCircle.class,
    com.ontraport.app.tests.CreatePostcardStepSequence.class,
    com.ontraport.app.tests.DeletePostcardStepSequence.class,
    com.ontraport.app.tests.DeletePostcardGradientMessage.class,
    
    com.ontraport.app.tests.CreatePostcardMessage.class,
    com.ontraport.app.tests.EditPostcardOpacity.class,
    com.ontraport.app.tests.EditPostcardColor.class,
    com.ontraport.app.tests.EditPostcardRounded.class,
    com.ontraport.app.tests.EditPostcardRectangle.class,
    com.ontraport.app.tests.EditPostcardCircle.class,
    com.ontraport.app.tests.EditPostcardShapeHeight.class,
    com.ontraport.app.tests.EditPostcardShapeWidth.class,
    com.ontraport.app.tests.EditPostcardShapeLeft.class,
    com.ontraport.app.tests.EditPostcardShapeTop.class,
    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
    com.ontraport.app.tests.EditPostcardCopyLayer.class,
    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
    com.ontraport.app.tests.EditPostcardMoveLayer.class,
    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
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
    
})
public class AnotherSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+5@gmail.com");
        AbstractPage.setPassword("test123");
        //AbstractPage.setUrl("https://staging.ontraport.com/");
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
        Login login = (Login) new Login().init();
        login.open(Login.url, true);
        login.as(AbstractPage.getLogin(), AbstractPage.getPassword());
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        //AbstractPart.waitForAjax(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
}
