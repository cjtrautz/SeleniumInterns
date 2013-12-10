package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_CreateType2;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRedirectLandingPage extends AbstractTest
{
    @Test
    public void testCreateRedirectLandingPage () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        LandingPage_ListAll landingPage_ListAll = contactListAll.menuPrimary.clickLandingPageListAll1();
        LandingPage_TypeSelection landingPage_TypeSelection = landingPage_ListAll.clickNewLandingPage();
        LandingPage_CreateType2 landingPage_CreateType2 = landingPage_TypeSelection.clickCreateRedirectMode();
        landingPage_CreateType2.enterLandingPageName(value.get("LandingPages", "redirect_page"));
        landingPage_CreateType2.enterPageURL(value.get("LandingPages", "redirect_page") + AbstractSuite.UNIQUE);
        landingPage_CreateType2.clickDomainDropDown();
        landingPage_CreateType2.selectDrillDown("respond.ontraport.net");
        landingPage_ListAll = landingPage_CreateType2.clickSave();
        landingPage_ListAll.formSearch.find(value.get("LandingPages", "redirect_page"));
        
        //verify product exists
          if(landingPage_ListAll.verifyLandingPage(value.get("LandingPages", "redirect_page"))==null)
          {
              fail("couldnt find lp");
          }

          LandingPage_Edit landingPage_Edit = landingPage_ListAll.clickPage(value.get("LandingPages", "redirect_page"));
          if(landingPage_Edit.verifyName(value.get("LandingPages", "redirect_page"))==null)
          {
              fail("couldn't find name");
          }
          if(landingPage_Edit.verifyRedirectURL(value.get("LandingPages", "redirect_page") + AbstractSuite.UNIQUE + ".respond.ontraport.net")==null)
          {
              fail("couldn't find url");
          }
    }
}
