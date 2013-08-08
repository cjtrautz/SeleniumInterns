package com.ontraport.app.selenium.suites;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	com.ontraport.app.selenium.tests.Login.class,
	//com.ontraport.app.selenium.tests.AddNewSection.class,
	//com.ontraport.app.selenium.tests.AddTab.class,
	//com.ontraport.app.selenium.tests.CreateATag.class,
	//com.ontraport.app.selenium.tests.CreateContact.class,
	//com.ontraport.app.selenium.tests.CreateProduct.class,
	//com.ontraport.app.selenium.tests.CreateRule.class,
	//com.ontraport.app.selenium.tests.DeleteATag.class,
	//com.ontraport.app.selenium.tests.MakeAGateWay.class,
	//com.ontraport.app.selenium.tests.DeleteGateway.class,
	//com.ontraport.app.selenium.tests.DeleteSMS_Number.class,
	//com.ontraport.app.selenium.tests.HostOrderformLP.class,
	//com.ontraport.app.selenium.tests.MakeA_SMS_Number.class,
	//com.ontraport.app.selenium.tests.MakeAdditionalRole.class,
	//com.ontraport.app.selenium.tests.MakeAdditionalUser.class,
	//com.ontraport.app.selenium.tests.MakeANewLP.class,
	//com.ontraport.app.selenium.tests.MakeAPackage.class,
	//com.ontraport.app.selenium.tests.MakeaTask.class,
	//com.ontraport.app.selenium.tests.TestPinnedItemsWorkflow.class,
	//com.ontraport.app.selenium.tests.TestUneditedWorkFlow.class,
	//com.ontraport.app.selenium.tests.AddDeleteUserPermission.class,
	//com.ontraport.app.selenium.tests.AddRoundRobin.class,
	//com.ontraport.app.selenium.tests.DeleteALP.class,
	//com.ontraport.app.selenium.tests.DeleteAWPSite.class,
	//com.ontraport.app.selenium.tests.AddWeightedRandom.class,
	//com.ontraport.app.selenium.tests.CreateMessage.class,
	//com.ontraport.app.selenium.tests.DeleteAllContacts.class,
	//com.ontraport.app.selenium.tests.DeleteAllForms.class,
	//com.ontraport.app.selenium.tests.DeleteAllMessages.class,
	//com.ontraport.app.selenium.tests.DeleteAllRules.class,
	//com.ontraport.app.selenium.tests.DeleteAllSequences.class,
	//com.ontraport.app.selenium.tests.DeleteMessage.class,
	//com.ontraport.app.selenium.tests.SendFromAddress.class,
	//com.ontraport.app.selenium.tests.AddGroup.class,
	//com.ontraport.app.selenium.tests.FormEditorLoad.class,
	//com.ontraport.app.selenium.tests.SetUpOrderForm.class,
	//com.ontraport.app.selenium.tests.UploadAttachment.class,
	//com.ontraport.app.selenium.tests.CreateFulfillment.class,
	//com.ontraport.app.selenium.tests.AffiliateLink.class,
	//com.ontraport.app.selenium.tests.UploadVideo.class,
	//com.ontraport.app.selenium.tests.DoubleOptIn.class,
	//com.ontraport.app.selenium.tests.NewInvoice.class,
	//com.ontraport.app.selenium.tests.EnsureOPPPWork.class,
	//com.ontraport.app.selenium.tests.SetTimezone.class,
	//com.ontraport.app.selenium.tests.DeleteAllTags.class,
	//com.ontraport.app.selenium.tests.ClickLogOut.class,
	//com.ontraport.app.selenium.tests.MakeATagAndAddItToContact.class,
	//com.ontraport.app.selenium.tests.ClickAddPackage.class,
	//com.ontraport.app.selenium.tests.ChangeUserInfo.class,
	//com.ontraport.app.selenium.tests.DeleteSingleContact.class,
	//com.ontraport.app.selenium.tests.DeletSendFromAddress.class,
	//com.ontraport.app.selenium.tests.TestWorkflowEnsureItemStore.class,
	//com.ontraport.app.selenium.tests.DeleteRule.class,
	//com.ontraport.app.selenium.tests.OpensDrawerRule.class,
	//com.ontraport.app.selenium.tests.PauseRule.class,
	//com.ontraport.app.selenium.tests.TryToFailUsageAgreement.class,
	//com.ontraport.app.selenium.tests.CreateNote.class,
	//com.ontraport.app.selenium.tests.AddColumn.class,
	//com.ontraport.app.selenium.tests.AllSequenceSteps.class,
	//com.ontraport.app.selenium.tests.CreateEmailSequence.class,
	//com.ontraport.app.selenium.tests.CreateSMSSTep.class,
	//com.ontraport.app.selenium.tests.CreateTaskSequence.class,
	//com.ontraport.app.selenium.tests.CreatePostcardSequence.class,
	//com.ontraport.app.selenium.tests.CreateRuleSequence.class,
	//com.ontraport.app.selenium.tests.CreateFulfillmentSequence.class,
	//com.ontraport.app.selenium.tests.CreateRule_ContactIsAddedToFulfillmentList.class,
	//com.ontraport.app.selenium.tests.CreateRule_ContactIsAddedToTag.class,
	//com.ontraport.app.selenium.tests.CreateRule_ContactIsRemovedFromTag.class,
	//com.ontraport.app.selenium.tests.CreateRule_CreditCardCharged.class,
	//com.ontraport.app.selenium.tests.CreateRule_CreditCardDeclined.class,
	//com.ontraport.app.selenium.tests.CreateRule_GetsRefundOnProduct.class,
	//com.ontraport.app.selenium.tests.CreateRule_LosesAccess.class,
	//com.ontraport.app.selenium.tests.CreateRule_MembershipAdded.class,
	//com.ontraport.app.selenium.tests.CreateRule_SubscribedToSubscriptionProduct.class,
	//com.ontraport.app.selenium.tests.CreateRule_SubscriptionToProduct_Cancelled.class,
	//com.ontraport.app.selenium.tests.CreateRule_SubscriptionToProduct_Charged.class,
	//com.ontraport.app.selenium.tests.CreateRule_SubscriptionToProduct_Completed.class,
	//com.ontraport.app.selenium.tests.CreateRule_VisitsLandingPage.class,
	//com.ontraport.app.selenium.tests.CreateRule_VisitsPURL.class,
	//com.ontraport.app.selenium.tests.CreateTaskCopy.class,
	//com.ontraport.app.selenium.tests.CreateSMSMessage.class,
	//com.ontraport.app.selenium.tests.CreateSMSCopy.class,
	//com.ontraport.app.selenium.tests.CreateExportContacts.class,
	//com.ontraport.app.selenium.tests.SetLanguage.class,
	//com.ontraport.app.selenium.tests.CreateEmailCopy.class,
	//com.ontraport.app.selenium.tests.CreateSectionWithFields.class,
	//com.ontraport.app.selenium.tests.CreateRule_CertainFieldIsUpdated_Checkbox.class,
	//com.ontraport.app.selenium.tests.CreateRule_CertainFieldIsUpdated_Date.class,
	//com.ontraport.app.selenium.tests.CreateRule_CertainFieldIsUpdated_LongText.class,
	//com.ontraport.app.selenium.tests.CreateRule_CertainFieldIsUpdated_Numeric.class,
	//com.ontraport.app.selenium.tests.CreateRule_CertainFieldIsUpdated_Price.class,
	//com.ontraport.app.selenium.tests.CreateRule_CertainFieldIsUpdated_State.class,
	com.ontraport.app.selenium.tests.CreateRule_SMSReceived.class,
	com.ontraport.app.selenium.tests.CreateRule_VisitsPURL.class,




	})

public class Sanity {
	protected static String baseUrl;
	protected static Process proc;
	protected static StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://ontraport.com.dev";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1600, 1200));
		//proc = Runtime.getRuntime()
		//.exec("ffmpeg -r 30 -s 1600x1200 -f x11grab -i :1.0 -vcodec msmpeg4v2 -qscale 2 ./report/selenium/" + (Sanity.class.getSimpleName()) + ".avi");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
		//proc.destroy();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		fail(verificationErrorString);
		}
	}
	public static WebDriver getDriver(){
		return driver;
	}

}
