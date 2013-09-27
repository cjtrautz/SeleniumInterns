package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class DeleteLandingPage extends AbstractTest
{
    @Test
    public void testDeleteLandingPage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        landingPage_ListAll.formSearch.find("SelEasyLP");
        landingPage_ListAll.selectLandingPage("SelEasyLP");
        landingPage_ListAll.drawerActions.clickDeleteLandingPage();
        landingPage_ListAll.dialogBox.clickOk();
         
         //verify
         if(landingPage_ListAll.verifyNoLandingPage()==null)
         {
             fail("found delete lp");
         }
        
    }
}
