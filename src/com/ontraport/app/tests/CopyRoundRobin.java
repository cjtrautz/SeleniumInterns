package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_CreateRR;
import com.ontraport.app.pages.LeadRouter_Edit;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.pages.LeadRouter_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CopyRoundRobin extends AbstractTest
{
    @Test
    public void testCopyRoundRobin ()
    {
    Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
    
    Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
    LeadRouter_ListAll leadRouter_ListAll = contact_Settings.clickLeadRouting();
    LeadRouter_TypeSelection leadRouterTypeSelection = leadRouter_ListAll.clickNewLeadRouter();
    leadRouterTypeSelection.clickRoundRobinDropDown();
    LeadRouter_CreateRR leadRouter_CreateRR = leadRouterTypeSelection.selectDrillDown(value.get("Contacts", "round_robin"));
    leadRouter_ListAll = leadRouter_CreateRR.clickSave();
    leadRouter_ListAll.formSearch.find(value.get("Contacts", "copy_of_round_robin"));
    
    //verify it exists
    if(leadRouter_ListAll.verifyRouter(value.get("Contacts", "copy_of_round_robin"))==null)
    {
        fail("couldnt find round robin router");
    }

    LeadRouter_Edit leadRouter_Edit = leadRouter_ListAll.clickRouter(value.get("Contacts", "copy_of_round_robin"));
    if(leadRouter_Edit.verifyUser("1")==null)
    {
        fail("couldnt find user");
    }

    }
    
}
