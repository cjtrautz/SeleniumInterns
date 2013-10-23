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

public class CreateLandingPageWithForm extends AbstractTest
{
    @Test
    public void testCreateLandingPageWithForm ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        LandingPage_CreateType1 landingPage_CreateType1 = landingPage_TypeSelection.clickCreateEasyPages();
        landingPage_CreateType1.enterLandingPageName(value.get("LandingPages", "Easy_Landing_Page_Form"));
        landingPage_CreateType1.enterLandingPageTitle(value.get("LandingPages", "Easy_Landing_Page_Form"));
        landingPage_CreateType1.clickPageURL();
        landingPage_CreateType1.dialogBox.clickUseHostedDomain();
        landingPage_CreateType1.dialogBox.enterHostedDomainName(value.get("LandingPages", "Easy_Landing_Page_Form") + AbstractSuite.UNIQUE);
        landingPage_CreateType1.dialogBox.clickAccept();
        landingPage_CreateType1.clickNewItem();
        landingPage_CreateType1.dialogBox.clickForm();
        landingPage_CreateType1.clickFormDropDown();
        landingPage_CreateType1.selectDrillDown("Smart Forms and Order Form");
        landingPage_CreateType1.selectDrillDown(value.get("SmartForms", "orderForm"));
        landingPage_ListAll = landingPage_CreateType1.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Form"));
        
      //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page_Form"))==null)
        {
            fail("couldnt find lp");
        }

        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Form"));
        if(landingPage_Edit.verifyForm()==null)
        {
            fail("couldn't find form");
        }


    }
}
