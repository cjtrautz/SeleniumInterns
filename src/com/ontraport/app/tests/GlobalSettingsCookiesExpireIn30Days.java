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

public class GlobalSettingsCookiesExpireIn30Days extends AbstractTest
{
    @Test
    public void testGlobalSettingsCookiesExpireIn30Days () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Affiliate_Settings affiliate_Settings = contactListAll.menuPrimary.clickAffiliateSettings();
        affiliate_Settings.clickInASetTime();
        affiliate_Settings.clickCookiesWillExpireDropDown();
        affiliate_Settings.selectDrillDown("Months");
        affiliate_Settings.enterCookiesInput("30");
        Affiliate_ListAll affiliate_ListAll = affiliate_Settings.clickSave();
        affiliate_Settings = affiliate_ListAll.menuPrimary.clickAffiliateSettings();
        if(affiliate_Settings.verifyCookiesWillExpireInput("30")==null)
        {
            fail("couldnt find pay affiliates by");
        }
        if(affiliate_Settings.verifyCookiesWillExpire("month")==null)
        {
            fail("couldnt find pay affiliates by");
        }
    }
}
