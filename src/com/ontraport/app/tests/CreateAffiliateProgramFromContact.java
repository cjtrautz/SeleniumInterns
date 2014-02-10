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
        contactEdit.enterNewAffiliateProgramName(value.get("Partners", "affiliate_program_from_contact_name"));
        
        AffiliateProgram_Create affiliateProgram_Create = contactEdit.clickAffiliateProgramSaveAndEdit();
        
        affiliateProgram_Create.clickProgramTypeDropDown();
        affiliateProgram_Create.selectDrillDown("1 Tier");
        affiliateProgram_Create.clickInfoGiveDropDown();
        affiliateProgram_Create.selectDrillDown("Share first name and last initial");
        affiliateProgram_Create.clickNotifySomeoneDropDown();
        affiliateProgram_Create.selectDrillDown("Do Not Notify");
        
        contactEdit = affiliateProgram_Create.clickSaveToContact();
        
        /* TODO validate back at contact edit and field is updated. Click "back" to return contacts list then do the following validation
        contactListAll.formSearch.find(value.get("Contacts", "selenium_email"));
        contactListAll.clickContact(value.get("Contacts", "selenium_email"));
        contactEdit.clickReferralInfoTab();
        */
        
        if(contactEdit.verifyDrilldownValue(value.get("Partners", "affiliate_program_from_contact_name"))==null)
        {
            fail("affiliate program not set");
        }
        
        AffiliateProgram_ListAll affiliateProgram_ListAll = contactListAll.menuPrimary.clickAffiliateProgramListAll();
        
        affiliateProgram_ListAll.formSearch.find(value.get("Partners", "affiliate_program_from_contact_name"));
        if(affiliateProgram_ListAll.verifyProgram(value.get("Partners", "affiliate_program_from_contact_name"))==null)
        {
            fail("couldnt find program");
        }
        AffiliateProgram_Edit affiliateProgram_Edit = affiliateProgram_ListAll.clickProgram(value.get("Partners", "affiliate_program_from_contact_name"));
        if(affiliateProgram_Edit.verifyName(value.get("Partners", "affiliate_program_from_contact_name"))==null)
        {
            fail("couldnt find program name");
        }
        if(affiliateProgram_Edit.verifyType("1 Tier")==null)
        {
            fail("couldnt find program type");
        }
        if(affiliateProgram_Edit.verifyInformation("Share first name and last initial")==null)
        {
            fail("couldnt find program information");
        }
        if(affiliateProgram_Edit.verifyNotify("Do Not Notify")==null)
        {
            fail("couldnt find program notify");
        }
    }
}