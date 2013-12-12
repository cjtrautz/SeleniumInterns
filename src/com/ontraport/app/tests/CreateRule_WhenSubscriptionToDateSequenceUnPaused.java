package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_WhenSubscriptionToDateSequenceUnPaused extends AbstractTest
{
    @Test
    public void testCreateRule_WhenSubscriptionToDateSequenceUnPaused ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "when_subscription_to_date_sequence_unpaused"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Subscription to Sequence is Unpaused");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption(value.get("Sequences", "date_task_sequence"));
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "when_subscription_to_date_sequence_unpaused"));
        
        //verify that rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "when_subscription_to_date_sequence_unpaused"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "when_subscription_to_date_sequence_unpaused"));
        if(rule_Edit.verifyText("Subscription to ")==null)
        {
            fail("didnt select when subscription to sequence is unpaused");
        }
        if(rule_Edit.verifyText(" is unpaused")==null)
        {
            fail("didnt select when subscription to sequence is unpaused");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, value.get("Sequences", "date_task_sequence"))==null)
        {
            fail("didnt select any sequence");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
