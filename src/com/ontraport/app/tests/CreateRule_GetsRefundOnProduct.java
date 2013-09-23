package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_GetsRefundOnProduct extends AbstractTest
{
    @Test
    public void testCreateRule_GetsRefundOnProduct ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleGetsRefundOnProduct");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInput("refund", 1);
        rule_Create.selectWhenDrillDownPaneOption("Gets a refund on a Product");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any Product");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleGetsRefundOnProduct");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleGetsRefundOnProduct")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleGetsRefundOnProduct");
        if(rule_Edit.verifyText("Gets a refund on ")==null)
        {
            fail("didnt select refund on product");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, "Any Product")==null)
        {
            fail("didnt select any product");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }

        
    }
}
