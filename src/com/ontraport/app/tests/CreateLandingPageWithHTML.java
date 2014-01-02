package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_CreateType1;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_CreatePostcard;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Values;

public class CreateLandingPageWithHTML extends AbstractTest
{
    @Test
    public void testCreateLandingPageWithHTML ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        LandingPage_CreateType1 landingPage_CreateType1 = landingPage_TypeSelection.clickCreateEasyPages();
        landingPage_CreateType1.enterLandingPageName(value.get("LandingPages", "Easy_Landing_Page_HTML"));
        landingPage_CreateType1.enterLandingPageTitle(value.get("LandingPages", "Easy_Landing_Page_HTML"));
        landingPage_CreateType1.clickPageURL();
        landingPage_CreateType1.dialogBox.clickUseHostedDomain();
        landingPage_CreateType1.dialogBox.enterHostedDomainName(value.get("LandingPages", "Easy_Landing_Page_HTML") + AbstractSuite.UNIQUE);
        landingPage_CreateType1.dialogBox.clickAccept();
        //landingPage_CreateType1.dialogBox.clickCancel();
        landingPage_CreateType1.clickNewItem();
        landingPage_CreateType1.dialogBox.clickHTML();
        landingPage_CreateType1.clickEditHTML();
        landingPage_CreateType1.dialogBox.enterHTML("<u>this is a test</u>");
        landingPage_CreateType1.dialogBox.clickAcceptHTML();
        landingPage_ListAll = landingPage_CreateType1.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_HTML"));
        
      //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page_HTML"))==null)
        {
            fail("couldnt find lp");
        }

        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_HTML"));
        if(landingPage_Edit.verifyUnderlined("this is a test")==null)
        {
            fail("couldn't find undelrlined html");
        }


    }
}
