package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_CreateType1;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateCodeModeLandingPageFromExisting extends AbstractTest
{
    @Test
    public void testCreateCodeModeLandingPageFromExisting () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        landingPage_TypeSelection.clickCodeModePageDropDown();
        LandingPage_Edit landingPage_Edit = landingPage_TypeSelection.selectDrillDown(value.get("LandingPages", "Easy_Landing_Page_Code_Mode"));
        landingPage_Edit.clickPageURLCodeMode();
        landingPage_Edit.dialogBox.clickUseHostedDomain();
        landingPage_Edit.dialogBox.enterHostedDomainName(value.get("LandingPages", "Easy_Landing_Page_Code_Mode3") + AbstractSuite.UNIQUE);
        landingPage_Edit.dialogBox.clickAccept();
        landingPage_ListAll = landingPage_Edit.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "Copy_Of_Easy_Landing_Page_Code_Mode"));
        if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "Copy_Of_Easy_Landing_Page_Code_Mode"))==null)
        {
            fail("couldnt find copy of landing page");
        }
        
        landingPage_ListAll.selectLandingPage(value.get("LandingPages", "Copy_Of_Easy_Landing_Page_Code_Mode"));
        landingPage_ListAll.drawerActions.clickDeleteLandingPage();
        landingPage_ListAll.dialogBox.clickOk();
         
         //verify
         if(landingPage_ListAll.verifyNoLandingPage()==null)
         {
             fail("found delete lp");
         }
    }
}
