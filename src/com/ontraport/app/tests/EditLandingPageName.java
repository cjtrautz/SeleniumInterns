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

public class EditLandingPageName extends AbstractTest
{
    @Test
    public void testEditLandingPageName ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page"));
        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page"));
        landingPage_Edit.enterName(value.get("LandingPages", "Easy_Landing_Page2"));
        landingPage_ListAll = landingPage_Edit.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page2"));
        
        //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page2"))==null)
        {
            fail("couldnt find lp");
        }

        landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page2"));

        if(landingPage_Edit.verifyName(value.get("LandingPages", "Easy_Landing_Page2"))==null)
        {
            fail("couldnt find name");
        }
       
        
    }
}
