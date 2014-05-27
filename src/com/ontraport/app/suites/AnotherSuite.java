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

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.Ontraport_SignUp;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.Values;

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
    
    com.ontraport.app.tests.CreateContact.class,
    //uses CreateContact
    com.ontraport.app.tests.CreateAffiliateProgramFromContact.class,
    com.ontraport.app.tests.DeleteAffiliateProgramCreatedFromContact.class,
    com.ontraport.app.tests.DeleteContact.class,
    
    com.ontraport.app.tests.CreateGroupContainsTag.class,
    
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
    
    com.ontraport.app.tests.WordPressSiteSwitchBetweenDomain.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateAnExistingWordPressSite.class,
    //uses CreateAnExistingWordPressSite wordpress site
    com.ontraport.app.tests.ExistingWordPressSiteTryPilotPress.class,
    //end use of CreateAnExistingWordPressSite wordpress site
    com.ontraport.app.tests.DeleteExistingWordPressSite.class,
    
    com.ontraport.app.tests.CreateWordPressBack.class,
    com.ontraport.app.tests.CreateWordPressCancel.class,
    
    com.ontraport.app.tests.CreateGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.DeleteGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.CreateGatewayUSAePayToken.class,
    com.ontraport.app.tests.DeleteGatewayUSAePayToken.class,
    com.ontraport.app.tests.CreateGatewayUSAePay.class,
    com.ontraport.app.tests.DeleteGatewayUSAePay.class,
    com.ontraport.app.tests.CreateGatewayQuickBooks.class,
    com.ontraport.app.tests.DeleteGatewayQuickBooks.class,
    com.ontraport.app.tests.CreateGatewayPayPal.class,
    com.ontraport.app.tests.DeleteGatewayPayPal.class,
    com.ontraport.app.tests.CreateGatewayPayLeap.class,
    com.ontraport.app.tests.DeleteGatewayPayLeap.class,
    com.ontraport.app.tests.CreateGatewayPayJunction.class,
    com.ontraport.app.tests.DeleteGatewayPayJunction.class,
    com.ontraport.app.tests.CreateGatewayPayflowPro.class,
    com.ontraport.app.tests.DeleteGatewayPayflowPro.class,
    com.ontraport.app.tests.CreateGatewayNetworkMerchantsInc.class,
    com.ontraport.app.tests.DeleteGatewayNetworkMerchantsInc.class,
    com.ontraport.app.tests.CreateGatewayeWay.class,
    com.ontraport.app.tests.DeleteGatewayeWay.class,
    com.ontraport.app.tests.CreateGatewayElavon.class,
    com.ontraport.app.tests.DeleteGatewayElavon.class, 
    com.ontraport.app.tests.CreateGatewayAuthorizeNet.class,
    com.ontraport.app.tests.DeleteGatewayAuthorizeNet.class,
    com.ontraport.app.tests.CreateGatewayAuthorizeNetCIM.class,
    com.ontraport.app.tests.DeleteGatewayAuthorizeNetCIM.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    //uses CreateRuleDateSequence sequence
    com.ontraport.app.tests.CopyDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToUnPausedDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToUnPausedDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToPausedDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToPausedDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToDateSequence.class,
    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToDateSequence.class,
    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToDateSequence.class,
    com.ontraport.app.tests.UnsubscribeContactAfterLastStep.class,
    com.ontraport.app.tests.RunSequenceOnlyOnWeekends.class,
    com.ontraport.app.tests.VerifySequenceEditSteps.class,
    //end use of CreateRuleDateSequence sequence
    com.ontraport.app.tests.DeleteRuleDateSequence.class,

    com.ontraport.app.tests.SignUp.class, 
    
})
public class AnotherSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+5@gmail.com");
        AbstractPage.setPassword("test123");
        //AbstractPage.setUrl("https://app.ontraport.com/");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(false);
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
