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

public class EditLandingPageGradientColors extends AbstractTest
{
    @Test
    public void testEditLandingPageGradientColors ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        landingPage_Edit.clickShape();
        landingPage_Edit.clickGradient1();
        landingPage_Edit.dialogBox.enterRValueLP("38");
        landingPage_Edit.dialogBox.enterGValueLP("219");
        landingPage_Edit.dialogBox.enterBValueLP("188");
        landingPage_Edit.dialogBox.clickAcceptColorLP();
        landingPage_Edit.clickGradient2();
        landingPage_Edit.dialogBox.enterRValueLP("220");
        landingPage_Edit.dialogBox.enterGValueLP("75");
        landingPage_Edit.dialogBox.enterBValueLP("142");
        landingPage_Edit.dialogBox.clickAcceptColorLP();
        landingPage_ListAll = landingPage_Edit.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        
        //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page_Gradient"))==null)
        {
            fail("couldnt find lp");
        }

        landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Gradient"));

        if(landingPage_Edit.verifyColor("(38, 219, 188)")==null)
        {
            fail("couldn't find gradient1");
        }
        if(landingPage_Edit.verifyColor("(220, 75, 142)")==null)
        {
            fail("couldn't find gradient2");
        }
       
        
    }
}
