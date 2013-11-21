package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_CreateType0;
import com.ontraport.app.pages.LandingPage_CreateType1;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateLandingPageCodeMode extends AbstractTest
{
    @Test
    public void testCreateLandingPageCodeMode ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        LandingPage_CreateType0 landingPage_CreateType0 = landingPage_TypeSelection.clickCreateCodeMode();
        landingPage_CreateType0.enterLandingPageName(value.get("LandingPages", "Easy_Landing_Page_Code_Mode"));
        landingPage_CreateType0.enterLandingPageTitle(value.get("LandingPages", "Easy_Landing_Page_Code_Mode_Title"));
        landingPage_CreateType0.clickPageURL();
        landingPage_CreateType0.dialogBox.clickUseHostedDomain();
        landingPage_CreateType0.dialogBox.enterHostedDomainName(value.get("LandingPages", "Easy_Landing_Page_Code_Mode") + AbstractSuite.UNIQUE);
        landingPage_CreateType0.dialogBox.clickAccept();
        landingPage_CreateType0.enterText("test");
        landingPage_ListAll = landingPage_CreateType0.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Code_Mode"));
        
        //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page_Code_Mode"))==null)
        {
            fail("couldnt find lp");
        }

        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Code_Mode"));
        //not sure how to wait to see if website has been hosted yet efficiently
        if(landingPage_Edit.verifyName(value.get("LandingPages", "Easy_Landing_Page_Code_Mode"))==null)
        {
            fail("couldnt find lp titile");
        }
        if(landingPage_Edit.verifyLandingPageTitle(value.get("LandingPages", "Easy_Landing_Page_Code_Mode_Title"))==null)
        {
            fail("couldnt find lp titile");
        }
        if(landingPage_Edit.verifyLandingPageURLCodeMode(value.get("LandingPages", "Easy_Landing_Page_Code_Mode") + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find lp url");
        }
        if(landingPage_Edit.verifyText("test")==null)
        {
            fail("couldnt find lp url");
        }


        
    }
}
