package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRule_IsSubscribedToProduct extends AbstractTest
{
    @Test
    public void testDeleteRule_IsSubscribedToProduct ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
         Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
         rule_ListAll.formSearch.find("SelRuleHasSubscribedToProduct");
         rule_ListAll.selectRule("SelRuleHasSubscribedToProduct");
         rule_ListAll.drawerActions.clickDeleteRule();
         rule_ListAll.dialogBox.clickOk();
         
         //verify
         if(rule_ListAll.verifyNoRule()==null)
         {
             fail("found deleted rule");
         }
        
    }
}
