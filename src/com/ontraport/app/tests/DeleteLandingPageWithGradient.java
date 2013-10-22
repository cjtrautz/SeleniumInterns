package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteLandingPageWithGradient extends AbstractTest
{
    @Test
    public void testDeleteLandingPageWithGradient ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        landingPage_ListAll.selectLandingPage(value.get("LandingPages", "Easy_Landing_Page_Gradient"));
        landingPage_ListAll.drawerActions.clickDeleteLandingPage();
        landingPage_ListAll.dialogBox.clickOk();
         
         //verify
         if(landingPage_ListAll.verifyNoLandingPage()==null)
         {
             fail("found delete lp");
         }
        
    }
}
