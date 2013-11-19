package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_Create;
import com.ontraport.app.pages.AffiliateProgram_Edit;
import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateAffilatesProgram extends AbstractTest
{
    @Test
    public void testCreateAffilatesProgram () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        AffiliateProgram_ListAll affiliateProgram_ListAll = contactListAll.menuPrimary.clickAffiliateProgramListAll();
        AffiliateProgram_Create affiliateProgram_Create = affiliateProgram_ListAll.clickNewPartnerProgram();
        affiliateProgram_Create.enterProgramName(value.get("Partners", "affiliate_program_name"));
        affiliateProgram_Create.clickProgramTypeDropDown();
        affiliateProgram_Create.selectDrillDown("1 Tier");
        affiliateProgram_Create.clickInfoGiveDropDown();
        affiliateProgram_Create.selectDrillDown("Share first name and last initial");
        affiliateProgram_Create.clickNotifySomeoneDropDown();
        affiliateProgram_Create.createCustomEmail();
        affiliateProgram_Create.enterCustomEmail(value.get("Partners", "partner_email"));
        affiliateProgram_Create.clickSelect();
        affiliateProgram_ListAll = affiliateProgram_Create.clickSave();
        affiliateProgram_ListAll.formSearch.find(value.get("Partners", "affiliate_program_name"));
        if(affiliateProgram_ListAll.verifyProgram(value.get("Partners", "affiliate_program_name"))==null)
        {
            fail("couldnt find program");
        }
        AffiliateProgram_Edit affiliateProgram_Edit = affiliateProgram_ListAll.clickProgram(value.get("Partners", "affiliate_program_name"));
        if(affiliateProgram_Edit.verifyName(value.get("Partners", "affiliate_program_name"))==null)
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
        if(affiliateProgram_Edit.verifyShowDeclined("No")==null)
        {
            fail("couldnt find program decilined");
        }
        if(affiliateProgram_Edit.verifyShowPurchaseHistory("No")==null)
        {
            fail("couldnt find program purchase history");
        }
        if(affiliateProgram_Edit.verifyNotify(value.get("Partners", "partner_email"))==null)
        {
            fail("couldnt find program notify");
        }
                
    }
}
