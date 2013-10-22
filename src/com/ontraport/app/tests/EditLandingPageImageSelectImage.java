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

public class EditLandingPageImageSelectImage extends AbstractTest
{
    @Test
    public void testEditLandingPageImageSelectImage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Image"));
        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Image"));
        landingPage_Edit.clickImage();
        landingPage_Edit.clickSelectImage();
        landingPage_Edit.dialogBox.clickUpload();
        landingPage_Edit.dialogBox.enterURL(value.get("Sites", "small_2"));
        landingPage_Edit.dialogBox.clickGo();
        landingPage_Edit.dialogBox.selectPicture(".PNG");
        landingPage_Edit.dialogBox.insertSelectedImage();
        landingPage_ListAll = landingPage_Edit.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Image"));
        
        //verify product exists
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Easy_Landing_Page_Image"))==null)
        {
            fail("couldnt find lp");
        }

        landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Image"));

        if(landingPage_Edit.verifyImage(".PNG")==null)
        {
            fail("couldn't find body picture");
        }
       
        
    }
}
