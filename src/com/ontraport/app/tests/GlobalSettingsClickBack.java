package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.pages.Affiliate_Settings;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class GlobalSettingsClickBack extends AbstractTest
{
    @Test
    public void testGlobalSettingsClickBack () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Affiliate_Settings affiliate_Settings = contactListAll.menuPrimary.clickAffiliateSettings();
        Affiliate_ListAll affiliateProgram_ListAll = affiliate_Settings.clickBack();
        if(affiliateProgram_ListAll.verifyPage()==null)
        {
            fail("couldnt find affiliates program page");
        }
    }
}
