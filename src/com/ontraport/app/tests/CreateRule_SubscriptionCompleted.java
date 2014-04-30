package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_SubscriptionCompleted extends AbstractTest
{
    @Test
    public void testCreateRule_SubscriptionCompleted ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleSubscriptionCompleted");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInputDropDown("Open", 1);
        rule_Create.selectWhenDrillDownPaneOption("Open order is charged or updated");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any Product");
        rule_Create.openWhenTriggerPane(2);
        rule_Create.selectWhenDrillDownPaneOption("Completed");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleSubscriptionCompleted");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleSubscriptionCompleted")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleSubscriptionCompleted");
        if(rule_Edit.verifyText("Subscription to ")==null)
        {
            fail("didnt select subscription to product");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, "Open order with ")==null)
        {
            fail("didnt select any subscription product");
        }
        if(rule_Edit.verifyWhenDropDownInputText(2, "Completed")==null)
        {
            fail("didnt select completed");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
