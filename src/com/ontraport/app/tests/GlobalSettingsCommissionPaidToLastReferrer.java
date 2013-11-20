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

public class GlobalSettingsCommissionPaidToLastReferrer extends AbstractTest
{
    @Test
    public void testGlobalSettingsCommissionPaidToLastReferrer () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Affiliate_Settings affiliate_Settings = contactListAll.menuPrimary.clickAffiliateSettings();
        affiliate_Settings.clickCommissionPaidToDropDown();
        affiliate_Settings.selectDrillDown("Last Referrer");
        Affiliate_ListAll affiliate_ListAll = affiliate_Settings.clickSave();
        affiliate_Settings = affiliate_ListAll.menuPrimary.clickAffiliateSettings();
        if(affiliate_Settings.verifyCommissionPaidTo("Last Referrer")==null)
        {
            fail("couldnt find commision Pad");
        }
    }
}
