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
    com.ontraport.app.tests.CreateTab.class,
    com.ontraport.app.tests.DeleteTab.class,
    
    com.ontraport.app.tests.NameATab.class,
    
    com.ontraport.app.tests.SetLanguage.class, 
    
    com.ontraport.app.tests.EnsurePagination.class, 
    
    com.ontraport.app.tests.SetTimezone.class,
    
    com.ontraport.app.tests.GlobalSettingsClickCancel.class,
    com.ontraport.app.tests.GlobalSettingsClickBack.class,
    com.ontraport.app.tests.GlobalSettingsCookiesExpireIn30Days.class,
    com.ontraport.app.tests.GlobalSettingsCookiesNeverExpire.class,
    com.ontraport.app.tests.GlobalSettingsCommissionPaidToLastReferrer.class,
    com.ontraport.app.tests.GlobalSettingsCommissionPaidToFirstReferrer.class,
    com.ontraport.app.tests.GlobalSettingsPayThreshold.class,
    com.ontraport.app.tests.GlobalSettingsPayAffiliateByTheirChoice.class,
    com.ontraport.app.tests.GlobalSettingsPayAffiliateByCheck.class,
    com.ontraport.app.tests.GlobalSettingsPayAffiliateByPaypal.class,
    
    com.ontraport.app.tests.EditAffiliatesProgramBack.class,
    com.ontraport.app.tests.EditAffiliatesProgramCancel.class,
    
    //used in following tests
    com.ontraport.app.tests.CreateMessage.class, 
    //uses CreateMessage message
    com.ontraport.app.tests.CreateAffiliatesProgramWithContactIDAndPurchaseHistory.class,
    com.ontraport.app.tests.DeleteAffiliateProgramWithContactIDAndPurchaseHistory.class,
    //uses CreateMessage message
    com.ontraport.app.tests.CreateAffiliatesProgramWithFullNameAndDeclinedTrans.class,
    com.ontraport.app.tests.DeleteAffiliateProgramWithFullNameAndDeclinedTrans.class,
    //used in following tests uses CreateMessage message
    com.ontraport.app.tests.CreateAffilatesProgram.class,
    //uses CreateAffilatesProgram program
    com.ontraport.app.tests.EditAffilatesProgramNotify.class,
    com.ontraport.app.tests.EditAffilatesProgramShowCompletePurchaseHistory.class,
    com.ontraport.app.tests.EditAffilatesProgramShowDeclined.class,
    com.ontraport.app.tests.EditAffilatesProgramInformation.class,
    com.ontraport.app.tests.EditAffilatesProgramType.class,
    com.ontraport.app.tests.EditAffilatesProgramName.class,
    //end use of CreateAffilatesProgram program
    com.ontraport.app.tests.DeleteAffiliateProgram.class,
    //ends the use of CreateMessage message
    com.ontraport.app.tests.DeleteMessage.class,
    
    com.ontraport.app.tests.VideoManagerBack.class,
    
    com.ontraport.app.tests.UploadToAttachmentManager.class,
    com.ontraport.app.tests.DeleteUploadToAttachmentManager.class,
    
    com.ontraport.app.tests.CreateTrackingURL.class,
    com.ontraport.app.tests.DeleteTrackingURL.class,
    
    com.ontraport.app.tests.CreateSmartFormWithConditions.class,
    com.ontraport.app.tests.DeleteSmartFormWithConditions.class,
    com.ontraport.app.tests.CreateSmartFormWithTemplate.class,
    com.ontraport.app.tests.DeleteSmartFormWithTemplate.class,
    com.ontraport.app.tests.CreateSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddSeparator.class,
    com.ontraport.app.tests.CreateSmartFormWithCaptcha.class,
    com.ontraport.app.tests.DeleteSmartFormWithCaptcha.class,
    com.ontraport.app.tests.CreateSmartFormWithGetPaid.class,
    com.ontraport.app.tests.DeleteSmartFormWithGetPaid.class,
    com.ontraport.app.tests.CreateSmartFormWithAddContent.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddContent.class,
    com.ontraport.app.tests.CreateSmartFormWithAddField.class,
    com.ontraport.app.tests.DeleteSmartFormField.class,
    com.ontraport.app.tests.DeleteSmartFormWithAddField.class,
    com.ontraport.app.tests.CreateSmartFormWithMovedSubmit.class,
    com.ontraport.app.tests.DeleteSmartFormWithMovedSubmit.class,
    
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.CreateRuleDateSequence.class,
    com.ontraport.app.tests.MassActionForContacts.class,
    com.ontraport.app.tests.CreateTaskFromSequence.class,
    com.ontraport.app.tests.DeleteCreateTaskFromSequence.class,
    com.ontraport.app.tests.CreateGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.CreateProduct.class,
    com.ontraport.app.tests.CreateOrderformWithTaxAndShipping.class,
    com.ontraport.app.tests.DeleteOrderformWithTaxAndShipping.class,
    com.ontraport.app.tests.DeleteProduct.class,
    com.ontraport.app.tests.DeleteGatewayPayPalPaymentsPro.class,
    com.ontraport.app.tests.DeleteAndVerifyMassActionForContact.class,
    com.ontraport.app.tests.DeleteRuleDateSequence.class,
    com.ontraport.app.tests.DeleteTag.class,
    
    
//  
//    com.ontraport.app.tests.CreatePostcardPictureWithRectangle.class,
//    com.ontraport.app.tests.EditPostcardPictureOpacity.class,
//    com.ontraport.app.tests.EditPostcardPictureCircle.class,
//    com.ontraport.app.tests.EditPostcardPictureRounded.class,
//    com.ontraport.app.tests.DeletePostcardPictureMessageAndCheckSelectImage.class,
//    
//    com.ontraport.app.tests.CreatePostcardGradientWithRectangle.class,
//    com.ontraport.app.tests.EditPostcardGradientOpacity.class,
//    com.ontraport.app.tests.EditPostcardToggleVertAndHorz.class,
//    com.ontraport.app.tests.EditPostcardGradient.class,
//    com.ontraport.app.tests.EditPostcardGradientRounded.class,
//    com.ontraport.app.tests.EditPostcardGradientCircle.class,
//    com.ontraport.app.tests.CreatePostcardStepSequence.class,
//    com.ontraport.app.tests.DeletePostcardStepSequence.class,
//    com.ontraport.app.tests.DeletePostcardGradientMessage.class,
//    
//    com.ontraport.app.tests.CreatePostcardMessage.class,
//    com.ontraport.app.tests.EditPostcardOpacity.class,
//    com.ontraport.app.tests.EditPostcardColor.class,
//    com.ontraport.app.tests.EditPostcardRounded.class,
//    com.ontraport.app.tests.EditPostcardRectangle.class,
//    com.ontraport.app.tests.EditPostcardCircle.class,
//    com.ontraport.app.tests.EditPostcardShapeHeight.class,
//    com.ontraport.app.tests.EditPostcardShapeWidth.class,
//    com.ontraport.app.tests.EditPostcardShapeLeft.class,
//    com.ontraport.app.tests.EditPostcardShapeTop.class,
//    com.ontraport.app.tests.EditPostcardFrontAndBackWithText.class,
//    com.ontraport.app.tests.EditPostcardCopyLayer.class,
//    com.ontraport.app.tests.EditPostcardHiddenLayer.class,
//    com.ontraport.app.tests.EditPostcardMoveLayer.class,
//    com.ontraport.app.tests.EditPostcardDeleteLayer.class,
//    //relies postcard message
//    com.ontraport.app.tests.CreateCopyOfPostcardMessage.class,
//    com.ontraport.app.tests.DeleteCopyOfPostcardMessage.class,
//    com.ontraport.app.tests.DeletePostcardMessage.class,
//    
//    com.ontraport.app.tests.CreatePostcardAndEditFontSize.class,
//    com.ontraport.app.tests.EditPostcardLetterSpacing.class,
//    com.ontraport.app.tests.EditPostcardLineSpacing.class,
//    com.ontraport.app.tests.EditPostcardAlignRight.class,
//    com.ontraport.app.tests.EditPostcardAlignCenter.class,
//    com.ontraport.app.tests.EditPostcardAlignLeft.class,
//    com.ontraport.app.tests.EditPostcardUnderline.class,
//    com.ontraport.app.tests.EditPostcardItalic.class,
//    com.ontraport.app.tests.EditPostcardBold.class,
//    com.ontraport.app.tests.DeleteTestingPostcardMessage.class,
    
})
public class AdminSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+4@gmail.com");
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
