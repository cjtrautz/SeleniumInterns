package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteAffiliateProgram extends AbstractTest
{
    @Test
    public void testDeleteAffiliateProgram () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        AffiliateProgram_ListAll affiliateProgram_ListAll = contactListAll.menuPrimary.clickAffiliateProgramListAll();
        affiliateProgram_ListAll.formSearch.find(value.get("Partners", "affiliate_program_name"));
        affiliateProgram_ListAll.selectAllOnPage();
        affiliateProgram_ListAll.drawerActions.clickDeleteProgram();
        affiliateProgram_ListAll.dialogBox.clickOk();
        
        //verify
        if(affiliateProgram_ListAll.verifyNoProgram()==null)
        {
            fail("found deleted message");
        }
    }
}
