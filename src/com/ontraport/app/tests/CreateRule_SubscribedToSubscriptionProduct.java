package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_SubscribedToSubscriptionProduct extends AbstractTest
{
    @Test
    public void testCreateRule_SubscribedToSubscriptionProduct ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleSubscribedToSubscriptionProduct");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInput("product", 1);
        rule_Create.selectWhenDrillDownPaneOption("Is subscribed to subscription product");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any Subscription Product");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleSubscribedToSubscriptionProduct");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleSubscribedToSubscriptionProduct")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleSubscribedToSubscriptionProduct");
        if(rule_Edit.verifyText("Is subscribed to ")==null)
        {
            fail("didnt select subscribed to subscription product");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, "Any Subscription Product")==null)
        {
            fail("didnt select any subscription product");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
