package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CopyLandingPageAction extends AbstractTest
{
    @Test
    public void testCopyLandingPageAction () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Easy_Landing_Page"));
        landingPage_ListAll.selectLandingPage(value.get("LandingPages", "Easy_Landing_Page"));
        LandingPage_Edit landingPage_Edit = landingPage_ListAll.drawerActions.clickCopyLandingPage();
        landingPage_Edit.dialogBox.clickOk();
        landingPage_ListAll = landingPage_Edit.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Copy_Of_Easy_Landing_Page"));
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Copy_Of_Easy_Landing_Page"))==null)
        {
            fail("couldnt find copy of landing page");
        }
        
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Copy_Of_Easy_Landing_Page"));
        landingPage_ListAll.selectLandingPage(value.get("LandingPages", "Copy_Of_Easy_Landing_Page"));
        landingPage_ListAll.drawerActions.clickDeleteLandingPage();
        landingPage_ListAll.dialogBox.clickOk();
         
         //verify
         if(landingPage_ListAll.verifyNoLandingPage()==null)
         {
             fail("found delete lp");
         }
    }
}
