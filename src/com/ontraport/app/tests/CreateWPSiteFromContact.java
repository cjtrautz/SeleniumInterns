package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_CreateType2;
import com.ontraport.app.pages.WordPress_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateWPSiteFromContact extends AbstractTest
{
    @Test
    public void testCreateWPSiteFromContact () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.formSearch.find(value.get("Contacts", "selenium_email"));
        
        Contact_Edit contactEdit = contactListAll.clickContact(value.get("Contacts", "selenium_email"));
        
        contactEdit.clickMembershipsTab();
        contactEdit.clickNewWPMembership();
        contactEdit.clickWPMembershipDrilldown();
        
        WordPress_TypeSelection wpTypeSelect = contactEdit.clickNewWPSite();
        
        WordPress_CreateType2 wpCreate = wpTypeSelect.clickCreateNewWordPressSiteWorkflow();
        
        wpCreate.enterWordPressSiteName("New WP Site From Contact"+AbstractSuite.UNIQUE);
        wpCreate.enterDomainName("WPSiteFromContact"+AbstractSuite.UNIQUE);
        wpCreate.enterMembershipLevel("One");
        wpCreate.clickAddMembershipLevel();
        wpCreate.saveToContactEditor();
        wpCreate.dialogBox.clickOk();
        
        contactEdit.saveWPMembership();
        
        contactListAll = contactEdit.clickBack();
        
        contactListAll.formSearch.find(value.get("Contacts", "selenium_email"));
        
        contactEdit = contactListAll.clickContact(value.get("Contacts", "selenium_email"));
        contactEdit.clickMembershipsTab();
        contactEdit.formSearch.find("WPSiteFromContact"+AbstractSuite.UNIQUE);
        
        if ( contactEdit.clickWPMembership("WPSiteFromContact"+AbstractSuite.UNIQUE) == null )
            {
                fail("couldn't find membership");
            };
            
        if ( contactEdit.verifyWPUsername(value.get("Contacts", "selenium_email")) == null )
        {
            fail("username not correct");
        }
        
        if ( contactEdit.verifyWPUsername("SelFirstNameSelLastName") == null )
        {
            fail("nickname not correct");
        }
        
    }
}