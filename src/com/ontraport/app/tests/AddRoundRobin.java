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

public class AddRoundRobin extends AbstractTest
{
    @Test
    public void testAddRoundRobin ()
    {
    Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
    
    Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
    LeadRouter_ListAll leadRouter_ListAll = contact_Settings.clickLeadRouting();
    LeadRouter_TypeSelection leadRouterTypeSelection = leadRouter_ListAll.clickNewLeadRouter();
    LeadRouter_CreateRR leadRouter_CreateRR = leadRouterTypeSelection.clickRoundRobinCreate();
    leadRouter_CreateRR.enterRouterName("SelRoundRobin");
    leadRouter_CreateRR.openWhoPane(1);
    leadRouter_CreateRR.selectWho(1, 1);
    leadRouter_ListAll = leadRouter_CreateRR.clickSave();
    leadRouter_ListAll.formSearch.find("SelRoundRobin");
    
    //verify it exists
    if(leadRouter_ListAll.verifyRouter("SelRoundRobin")==null)
    {
        fail("couldnt find round robin router");
    }

    LeadRouter_Edit leadRouter_Edit = leadRouter_ListAll.clickRouter("SelRoundRobin");
    if(leadRouter_Edit.verifyUser("1")==null)
    {
        fail("couldnt find user");
    }

    }
    
}
