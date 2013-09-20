package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRule_CreditCardCharged extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
         Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
         rule_ListAll.formSearch.find("SelRuleCreditCardCharged");
<<<<<<< HEAD
         rule_ListAll.selectRule("SelRuleCreditCardCharged");
=======
         rule_ListAll.selectAllOnPage();
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
         rule_ListAll.drawerActions.clickDeleteRule();
         rule_ListAll.dialogBox.clickOk();
         
         //verify
         if(rule_ListAll.verifyNoRule()==null)
         {
             fail("found deleted rule");
         }
        
    }
}
