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

public class EditAffilatesProgramType extends AbstractTest
{
    @Test
    public void testEditAffilatesProgramType () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        AffiliateProgram_ListAll affiliateProgram_ListAll = contactListAll.menuPrimary.clickAffiliateProgramListAll();
        affiliateProgram_ListAll.formSearch.find(value.get("Partners", "affiliate_program_name"));
        if(affiliateProgram_ListAll.verifyProgram(value.get("Partners", "affiliate_program_name"))==null)
        {
            fail("couldnt find program");
        }
        AffiliateProgram_Edit affiliateProgram_Edit = affiliateProgram_ListAll.clickProgram(value.get("Partners", "affiliate_program_name"));
        affiliateProgram_Edit.clickProgramType();
        affiliateProgram_Edit.selectProgramType("2 Tier");
        if(affiliateProgram_Edit.verifyName(value.get("Partners", "affiliate_program_name"))==null)
        {
            fail("couldnt find program name");
        }
        affiliateProgram_ListAll = affiliateProgram_Edit.clickBack();
        affiliateProgram_ListAll.formSearch.find(value.get("Partners", "affiliate_program_name"));
        if(affiliateProgram_ListAll.verifyProgram(value.get("Partners", "affiliate_program_name"))==null)
        {
            fail("couldnt find program");
        }
        affiliateProgram_Edit = affiliateProgram_ListAll.clickProgram(value.get("Partners", "affiliate_program_name"));
        if(affiliateProgram_Edit.verifyType("2 Tier")==null)
        {
            fail("couldnt find program name");
        }
                
    }
}
