package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRoundRobin extends AbstractTest
{
    @Test
    public void testDeleteRoundRobin ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_settings = contactListAll.menuPrimary.clickContactSettings();
        LeadRouter_ListAll leadRouter_ListAll = contact_settings.clickLeadRouting();
        leadRouter_ListAll.formSearch.find("SelRoundRobin");
        leadRouter_ListAll.selectAllOnPage();
        leadRouter_ListAll.drawerActions.clickDeleteRouter();
        leadRouter_ListAll.dialogBox.clickOk();
        
        //verify
        if(leadRouter_ListAll.verifyNoRouter()==null)
        {
            fail("found deleted router");
        }
        
    }
}
