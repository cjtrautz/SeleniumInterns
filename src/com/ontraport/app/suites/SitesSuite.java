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
//    com.ontraport.app.tests.ImportContacts.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateAWordPressSite.class,
//    //uses CreateAWordPressSite wordpress site
//    com.ontraport.app.tests.CreateEmailMessageWPFields.class,
//    com.ontraport.app.tests.DeleteEmailWPMessage.class,
//    com.ontraport.app.tests.CreateLeadScoring_HasAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteLeadScoring_HasAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateLeadScoring_DoesntHaveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteLeadScoring_DoesntHaveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateSMSWPFieldMessage.class,
//    com.ontraport.app.tests.DeleteSMSWPFieldMessage.class,
////    com.ontraport.app.tests.CreatePostcardWPFieldMessage.class,
////    com.ontraport.app.tests.DeletePostcardWPFieldMessage.class,
//    com.ontraport.app.tests.CreateWPFieldTaskMessage.class,
//    com.ontraport.app.tests.DeleteWPFieldsTaskMessage.class,
//    com.ontraport.app.tests.CreateRule_VisitsAWPWebsite.class,
//    com.ontraport.app.tests.DeleteRule_VisitsAWPWebsite.class,
//    com.ontraport.app.tests.CreateRule_RemoveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteRule_RemoveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateRule_GiveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteRule_GiveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateRule_DoesntHaveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteRule_DoesntHaveAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateRule_HasAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteRule_HasAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateRule_LosesAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteRule_LosesAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.CreateRule_IsGivenAccessToWordPressMembershipLevel.class,
//    com.ontraport.app.tests.DeleteRule_IsGivenAccessToWordPressMembershipLevel.class,
//    //end use of CreateAWordPressSite site
//    com.ontraport.app.tests.DeleteWordPressSite.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateLandingPageWithHTML.class,
//    //uses CreateLandingPageWithHTML landing page
//    com.ontraport.app.tests.EditLandingPageHTMLLinksTo.class,
//    com.ontraport.app.tests.EditLandingPageOpacityWithHTML.class,
//    com.ontraport.app.tests.EditLandingPageLeftWithHTML.class,
//    com.ontraport.app.tests.EditLandingPageWidthWithHTML.class,
//    com.ontraport.app.tests.EditLandingPageTopWithHTML.class,
//    com.ontraport.app.tests.EditLandingPageHeightWithHTML.class,
//    //end use of CreateLandingPageWithHTML landing page
//    com.ontraport.app.tests.DeleteLandingPageWithHTML.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateLandingPageWithGradient.class,
//    //uses CreateLandingPageWithGradient landing page
//    com.ontraport.app.tests.EditLandingPageGradientOpacity.class,
//    com.ontraport.app.tests.EditLandingPageToggleVertAndHorz.class,
//    com.ontraport.app.tests.EditLandingPageGradientColors.class,
//    com.ontraport.app.tests.EditLandingPageRoundedGradient.class,
//    com.ontraport.app.tests.EditLandingPageCircleGradient.class,
//    //end use of CreateLandingPageWithGradient landing page
//    com.ontraport.app.tests.DeleteLandingPageWithGradient.class,
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
//    
    //used in following tests
    com.ontraport.app.tests.CreateLandingPageWithText.class,
    //uses CreateLandingPageWithText landing page
    com.ontraport.app.tests.EditLandingPageHeight.class,
    com.ontraport.app.tests.EditLandingPageWidth.class,
    com.ontraport.app.tests.EditLandingPageTop.class,
    com.ontraport.app.tests.EditLandingPageLeft.class,
    com.ontraport.app.tests.EditLandingPageLineSpacing.class,
    com.ontraport.app.tests.EditLandingPageLetterSpacing.class,
    com.ontraport.app.tests.EditLandingPageRightAlign.class,
    com.ontraport.app.tests.EditLandingPageCenter.class,
    com.ontraport.app.tests.EditLandingPageLeftAlign.class,
    com.ontraport.app.tests.EditLandingPageUnderline.class,
    com.ontraport.app.tests.EditLandingPageItalic.class,
    com.ontraport.app.tests.EditLandingPageBold.class,
    com.ontraport.app.tests.EditLandingPageFontSize.class,
    com.ontraport.app.tests.EditLandingPageFont.class,
    //end use of CreateLandingPageWithText landing page
    com.ontraport.app.tests.DeleteLandingPageWithText.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateLandingPage.class,
//    //uses CreateLandingPage landing page
//    com.ontraport.app.tests.CreateSMSLPFieldMessage.class,
//    com.ontraport.app.tests.DeleteSMSLPFieldMessage.class,
//    com.ontraport.app.tests.CreateLPFieldTaskMessage.class,
//    com.ontraport.app.tests.DeleteLPFieldsTaskMessage.class,
//    com.ontraport.app.tests.CreateLeadScoring_HasVisitedLandingPageNumberOfTimes.class,
//    com.ontraport.app.tests.DeleteLeadScoring_HasVisitedLandingPageNumberOfTimes.class,
//    com.ontraport.app.tests.EditLandingPageOpacity.class,
//    com.ontraport.app.tests.EditLandingPageColor.class,
//    com.ontraport.app.tests.EditLandingPageRounded.class,
//    com.ontraport.app.tests.EditLandingPageCircle.class,
//    com.ontraport.app.tests.EditLandingPageSplitTesting.class,
//    com.ontraport.app.tests.EditLandingPageRemoveSplitTesting.class,
//    com.ontraport.app.tests.EditLandingPagePageSize.class,
//    com.ontraport.app.tests.EditLandingPageBackground.class,
//    com.ontraport.app.tests.CreateEmailMessageLPFields.class,
//    com.ontraport.app.tests.DeleteEmailLPMessage.class,
//    com.ontraport.app.tests.EditLandingPageAlignment.class,
//    com.ontraport.app.tests.EditLandingPageURL.class,
//    com.ontraport.app.tests.EditLandingPageTitle.class,
//    com.ontraport.app.tests.EditLandingPageName.class,
//    com.ontraport.app.tests.CreateEasyLandingPageFromExisting.class,
//    com.ontraport.app.tests.CopyLandingPageAction.class,
//    //end use of CreateLandingPage landing page
//    com.ontraport.app.tests.DeleteLandingPage.class,
//    
//    com.ontraport.app.tests.CreateStepSequenceBack.class,
//    
//    com.ontraport.app.tests.EmailStepCreateNewMessageAndEdit.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateLandingPageCodeMode.class,
//    //uses CreateLandingPageCodeMode landing page
//    com.ontraport.app.tests.EditLandingPageCodeModeInsertField.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeAddText.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeAddHTMLViaSource.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeSplitTestCheckbox.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeSplitTestDropDown.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeAlignment.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeAlignmentCenter.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeURL.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeTitle.class,
//    com.ontraport.app.tests.EditLandingPageCodeModeName.class,
//    //used in following tests
//    com.ontraport.app.tests.CreateGateway.class,
//    //used in following tests
//    com.ontraport.app.tests.CreateATag.class,
//    com.ontraport.app.tests.CreateRuleStepSequence.class,
//    //used in following tests and uses CreateGateway gateway and uses CreateATag
//    com.ontraport.app.tests.CreateOrderform.class,
//    //uses CreateOrderform orderform
//    com.ontraport.app.tests.EditLandingPageCodeModeInsertForm.class,
//    //end use of CreateOrderform orderform
//    com.ontraport.app.tests.DeleteOrderForm.class,
//    com.ontraport.app.tests.DeleteRuleStepSequence.class,
//    //end use of CreateGateway gateway
//    com.ontraport.app.tests.DeleteGateway.class,
//    com.ontraport.app.tests.CreateCodeModeLandingPageFromExisting.class,
//    //end use of CreateLandingPageCodeMode landing page
//    com.ontraport.app.tests.DeleteLandingPageCodeMode.class,
//    
//    com.ontraport.app.tests.VideoManagerCancel.class,
//    com.ontraport.app.tests.CreateLandingPageBack.class,
//    com.ontraport.app.tests.CreateLandingPageCancel.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateTrackedDomain.class, 
//    //uses CreateTrackedDomain tracked domain
//    com.ontraport.app.tests.ViewTrackingScript.class,
//    //end use of CreateTrackedDomain tracked domain
//    com.ontraport.app.tests.DeleteTrackedDomain.class, 
//    
//    com.ontraport.app.tests.SignUp.class, 
//    com.ontraport.app.tests.CreateRedirectLandingPage.class, 
//    com.ontraport.app.tests.DeleteLandingPageRedirect.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateTrackedLink.class, 
//    //uses CreateTrackedLink tracked link
//    com.ontraport.app.tests.EditTrackedLinkName.class, 
//    com.ontraport.app.tests.EditTrackedDestinationLink.class, 
//    //end use of CreateTrackedLink tracked link
//    com.ontraport.app.tests.DeleteTrackedLink.class, 
//    
//    com.ontraport.app.tests.CreateRule_SMSContainsText.class,
//    com.ontraport.app.tests.DeleteRule_SMSContainsText.class,
//    com.ontraport.app.tests.CreateRule_SMSDoesntContainAnEmailAddress.class,
//    com.ontraport.app.tests.DeleteRule_SMSDoesntContainAnEmailAddress.class,
//    com.ontraport.app.tests.CreateRule_SMSDoesNotContainText.class,
//    com.ontraport.app.tests.DeleteRule_SMSDoesNotContainText.class,
//    com.ontraport.app.tests.CreateRule_SMSContainsAnEmailAddress.class,
//    com.ontraport.app.tests.DeleteRule_SMSContainsAnEmailAddress.class,  
//    com.ontraport.app.tests.CreateRule_SMSRecievedFromContact.class,
//    com.ontraport.app.tests.DeleteRule_SMSRecievedFromContact.class,
//    
//    com.ontraport.app.tests.AddDateModifiedColumn.class,
//    com.ontraport.app.tests.DeleteDateModifiedColumn.class,
//    com.ontraport.app.tests.AddDateCreatedColumn.class,
//    com.ontraport.app.tests.DeleteDateCreatedColumn.class,
//    com.ontraport.app.tests.AddQuantityPurchasedColumn.class,
//    com.ontraport.app.tests.DeleteQuantityPurchasedColumn.class,
//    com.ontraport.app.tests.AddRevenueColumn.class,
//    com.ontraport.app.tests.DeleteRevenueColumn.class,
//    com.ontraport.app.tests.AddPriceColumn.class,
//    com.ontraport.app.tests.DeletePriceColumn.class,
//    com.ontraport.app.tests.AddProductIDColumn.class,
//    com.ontraport.app.tests.DeleteProductIDColumn.class,
//    
//    com.ontraport.app.tests.WordPressSiteSwitchBetweenDomain.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateAnExistingWordPressSite.class,
//    //uses CreateAnExistingWordPressSite wordpress site
//    com.ontraport.app.tests.ExistingWordPressSiteTryPilotPress.class,
//    //end use of CreateAnExistingWordPressSite wordpress site
//    com.ontraport.app.tests.DeleteExistingWordPressSite.class,
//    
//    com.ontraport.app.tests.CreateWordPressBack.class,
//    com.ontraport.app.tests.CreateWordPressCancel.class,
//    
//    com.ontraport.app.tests.CreateGatewayPayPalPaymentsPro.class,
//    com.ontraport.app.tests.DeleteGatewayPayPalPaymentsPro.class,
//    com.ontraport.app.tests.CreateGatewayUSAePayToken.class,
//    com.ontraport.app.tests.DeleteGatewayUSAePayToken.class,
//    com.ontraport.app.tests.CreateGatewayUSAePay.class,
//    com.ontraport.app.tests.DeleteGatewayUSAePay.class,
//    com.ontraport.app.tests.CreateGatewayQuickBooks.class,
//    com.ontraport.app.tests.DeleteGatewayQuickBooks.class,
//    com.ontraport.app.tests.CreateGatewayPayPal.class,
//    com.ontraport.app.tests.DeleteGatewayPayPal.class,
//    com.ontraport.app.tests.CreateGatewayPayLeap.class,
//    com.ontraport.app.tests.DeleteGatewayPayLeap.class,
//    com.ontraport.app.tests.CreateGatewayPayJunction.class,
//    com.ontraport.app.tests.DeleteGatewayPayJunction.class,
//    com.ontraport.app.tests.CreateGatewayPayflowPro.class,
//    com.ontraport.app.tests.DeleteGatewayPayflowPro.class,
//    com.ontraport.app.tests.CreateGatewayNetworkMerchantsInc.class,
//    com.ontraport.app.tests.DeleteGatewayNetworkMerchantsInc.class,
//    com.ontraport.app.tests.CreateGatewayeWay.class,
//    com.ontraport.app.tests.DeleteGatewayeWay.class,
//    com.ontraport.app.tests.CreateGatewayElavon.class,
//    com.ontraport.app.tests.DeleteGatewayElavon.class, 
//    com.ontraport.app.tests.CreateGatewayAuthorizeNet.class,
//    com.ontraport.app.tests.DeleteGatewayAuthorizeNet.class,
//    com.ontraport.app.tests.CreateGatewayAuthorizeNetCIM.class,
//    com.ontraport.app.tests.DeleteGatewayAuthorizeNetCIM.class,
//    
//    //used in following tests
//    com.ontraport.app.tests.CreateRuleDateSequence.class,
//    //uses CreateRuleDateSequence sequence
//    com.ontraport.app.tests.CopyDateSequence.class,
//    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToUnPausedDateSequence.class,
//    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToUnPausedDateSequence.class,
//    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToPausedDateSequence.class,
//    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToPausedDateSequence.class,
//    com.ontraport.app.tests.CreateLeadScoring_ContactNotSubscribedToDateSequence.class,
//    com.ontraport.app.tests.DeleteLeadScoring_ContactNotSubscribedToDateSequence.class,
//    com.ontraport.app.tests.CreateLeadScoring_ContactSubscribedToDateSequence.class,
//    com.ontraport.app.tests.DeleteLeadScoring_ContactSubscribedToDateSequence.class,
//    com.ontraport.app.tests.UnsubscribeContactAfterLastStep.class,
//    com.ontraport.app.tests.RunSequenceOnlyOnWeekends.class,
//    com.ontraport.app.tests.VerifySequenceEditSteps.class,
//    //end use of CreateRuleDateSequence sequence
//    com.ontraport.app.tests.DeleteRuleDateSequence.class,
//    
})
public class SitesSuite extends AbstractSuite
{
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        AbstractPage.setLogin("ontraportselenium+1@gmail.com");
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
