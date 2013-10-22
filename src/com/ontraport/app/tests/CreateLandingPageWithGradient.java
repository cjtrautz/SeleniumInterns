package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_CreateType1;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateLandingPageWithGradient extends AbstractTest
{
    @Test
    public void testCreateLandingPageWithGradient ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        LandingPage_CreateType1 landingPage_CreateType1 = landingPage_TypeSelection.clickCreateEasyPages();
        landingPage_CreateType1.enterLandingPageName(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        landingPage_CreateType1.enterLandingPageTitle(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        landingPage_CreateType1.clickPageURL();
        landingPage_CreateType1.dialogBox.clickUseHostedDomain();
        landingPage_CreateType1.dialogBox.enterHostedDomainName(value.get("LandingPages", "Easy_Landing_Page_Gradient") + AbstractSuite.UNIQUE);
        landingPage_CreateType1.dialogBox.clickAccept();
        landingPage_CreateType1.clickNewItem();
        landingPage_CreateType1.dialogBox.clickGradient();
        landingPage_ListAll = landingPage_CreateType1.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        
        //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page_Gradient"))==null)
        {
            fail("couldnt find lp");
        }

        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        //not sure how to wait to see if website has been hosted yet efficiently
        if(landingPage_Edit.verifyLandingPageTitle(value.get("LandingPages", "Easy_Landing_Page_Gradient"))==null)
        {
            fail("couldnt find lp titile");
        }
        if(landingPage_Edit.verifyLandingPageURL(value.get("LandingPages", "Easy_Landing_Page_Gradient") + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find lp url");
        }
        if(landingPage_Edit.verifyLandingPageSquareGradient()==null)
        {
            fail("didnt add rectangle gradient");
        }


        
    }
}
