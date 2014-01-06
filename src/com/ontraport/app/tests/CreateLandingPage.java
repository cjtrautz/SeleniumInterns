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

public class CreateLandingPage extends AbstractTest
{
    @Test
    public void testCreateLandingPage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll2();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        LandingPage_CreateType1 landingPage_CreateType1 = landingPage_TypeSelection.clickCreateEasyPages();
        landingPage_CreateType1.enterLandingPageName(value.get("LandingPages", "Easy_Landing_Page"));
        landingPage_CreateType1.enterLandingPageTitle("SelEasyLPTitles");
        landingPage_CreateType1.clickPageURL();
        landingPage_CreateType1.dialogBox.clickUseHostedDomain();
        landingPage_CreateType1.dialogBox.enterHostedDomainName(value.get("LandingPages", "Easy_Landing_Page") + AbstractSuite.UNIQUE);
        landingPage_CreateType1.dialogBox.clickAccept();
        landingPage_CreateType1.clickNewItem();
        landingPage_CreateType1.dialogBox.clickShape();
        landingPage_ListAll = landingPage_CreateType1.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page"));
        
        //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page"))==null)
        {
            fail("couldnt find lp");
        }

        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page"));
        //not sure how to wait to see if website has been hosted yet efficiently
        if(landingPage_Edit.verifyLandingPageTitle("SelEasyLPTitles")==null)
        {
            fail("couldnt find lp titile");
        }
        if(landingPage_Edit.verifyLandingPageURL(value.get("LandingPages", "Easy_Landing_Page") + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find lp url");
        }
        System.out.println("o ya");
        if(landingPage_Edit.verifyLandingPageShape()==null)
        {
            fail("didnt add item shape");
        }
        System.out.println("o g");
        if(landingPage_Edit.verifyLandingPageRectangleShape()==null)
        {
            fail("didnt add item shape");
        }
        System.out.println("uh oh");
        if(landingPage_Edit.verifyLandingPageHosted(value.get("LandingPages", "Easy_Landing_Page") + AbstractSuite.UNIQUE)==null)
        {
            fail("didnt add item shape");
        }

        
    }
}
