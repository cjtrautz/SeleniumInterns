package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_Create;
import com.ontraport.app.pages.AffiliateProgram_Edit;
import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateAffiliateProgramFromContact extends AbstractTest
{
    @Test
    public void testCreateAffiliateProgramFromContact () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.formSearch.find(value.get("Contacts", "selenium_email"));
        
        Contact_Edit contactEdit = contactListAll.clickContact(value.get("Contacts", "selenium_email"));
        
        contactEdit.clickReferralInfoTab();
        contactEdit.clickAffiliateProgram();
        contactEdit.selectDrillDown("Create New Partner Program");
        contactEdit.enterNewAffiliateProgramName(value.get("Partners", "affiliate_program_name"));
        
        AffiliateProgram_Create affiliateProgram_Create = contactEdit.clickAffiliateProgramSaveAndEdit();
        
        affiliateProgram_Create.enterProgramName(value.get("Partners", "affiliate_program_name"));
        affiliateProgram_Create.clickProgramTypeDropDown();
        affiliateProgram_Create.selectDrillDown("1 Tier");
        affiliateProgram_Create.clickInfoGiveDropDown();
        affiliateProgram_Create.selectDrillDown("Share first name and last initial");
        affiliateProgram_Create.clickNotifySomeoneDropDown();
        affiliateProgram_Create.selectDrillDown("Send Email Notification");
        affiliateProgram_Create.clickEmailDropDown();
        affiliateProgram_Create.selectDrillDown(value.get("Messages", "email_message"));
        
        contactEdit = affiliateProgram_Create.clickSaveToContact();
        
        
    }
}