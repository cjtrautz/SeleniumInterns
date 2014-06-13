package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteLandingPageImage extends AbstractTest
{
    @Test
    public void testDeleteLandingPageImage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Image"));
        LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "Easy_Landing_Page_Image"));
        landingPage_Edit.clickImage();
        landingPage_Edit.clickSelectImage();
        landingPage_Edit.dialogBox.clickBrowse();
        landingPage_Edit.dialogBox.selectPicture();
        landingPage_Edit.dialogBox.clickDelete();
        landingPage_Edit.dialogBox.clickDeleteConfirm();
        landingPage_Edit.dialogBox.clickBrowse();
        landingPage_Edit.dialogBox.selectPicture();
        landingPage_Edit.dialogBox.clickDelete();
        landingPage_Edit.dialogBox.clickBrowse();
        landingPage_Edit.dialogBox.clickCancelPicture();
        landingPage_ListAll = landingPage_Edit.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Image"));
        landingPage_ListAll.selectLandingPage(value.get("LandingPages", "Easy_Landing_Page_Image"));
        landingPage_ListAll.drawerActions.clickDeleteLandingPage();
        landingPage_ListAll.dialogBox.clickOk();
         
         //verify
         if(landingPage_ListAll.verifyNoLandingPage()==null)
         {
             fail("found delete lp");
         }
        
    }
}
