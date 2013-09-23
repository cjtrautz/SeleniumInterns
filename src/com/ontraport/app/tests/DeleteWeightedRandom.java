package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteWeightedRandom extends AbstractTest
{
    @Test
    public void testDeleteWeightedRandom ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        LeadRouter_ListAll leadRouter_ListAll = contact_Settings.clickLeadRouting();
        leadRouter_ListAll.formSearch.find("SelWeightedRandom");
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
