package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_CreateWR;
import com.ontraport.app.pages.LeadRouter_Edit;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.pages.LeadRouter_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class AddWeightedRandom extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        LeadRouter_ListAll leadRouter_ListAll = contact_Settings.clickLeadRouting();
        LeadRouter_TypeSelection leadRouter_TypeSelection = leadRouter_ListAll.clickNewLeadRouter();
        LeadRouter_CreateWR leadRouter_CreateWR = leadRouter_TypeSelection.clickWeightedRandomCreate();
        leadRouter_CreateWR.enterRouterName("SelWeightedRandom");
        leadRouter_CreateWR.openWhoPane(1);
        leadRouter_CreateWR.selectWho(1, 1);
        leadRouter_CreateWR.enterPercentOfLeads(1, "100");
        leadRouter_ListAll = leadRouter_CreateWR.clickSave();
        leadRouter_ListAll.formSearch.find("SelWeightedRandom");
        
        //verify that SelWeightedRandom is there
        if(leadRouter_ListAll.verifyRouter("SelWeightedRandom")==null)
        {
            fail("couldnt find router");
        }
        LeadRouter_Edit leadRouter_Edit = leadRouter_ListAll.clickRouter("SelWeightedRandom");
        if(leadRouter_Edit.verifyUser("1")==null)
        {
            fail("couldnt find user");
        }
        if(leadRouter_Edit.verifyPercent("100")==null)
        {
            fail("couldnt find user percent");
        }

    }
}
