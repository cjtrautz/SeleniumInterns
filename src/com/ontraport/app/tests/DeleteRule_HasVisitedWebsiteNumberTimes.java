package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRule_HasVisitedWebsiteNumberTimes extends AbstractTest
{
    @Test
    public void testDeleteRule_HasVisitedWebsiteNumberTimes ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
         Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
         rule_ListAll.formSearch.find("SelRuleHasVisitedWebsiteNumberTimes");
         rule_ListAll.selectRule("SelRuleHasVisitedWebsiteNumberTimes");
         rule_ListAll.drawerActions.clickDeleteRule();
         rule_ListAll.dialogBox.clickOk();
         
         //verify
         if(rule_ListAll.verifyNoRule()==null)
         {
             fail("found delete rule");
         }
        
    }
}
