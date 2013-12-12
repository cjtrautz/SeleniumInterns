package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_WhenSubscriptionToDateSequencePaused extends AbstractTest
{
    @Test
    public void testCreateRule_WhenSubscriptionToDateSequencePaused ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "when_subscription_to_date_sequence_paused"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Subscription to Sequence is Paused");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption(value.get("Sequences", "date_task_sequence"));
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "when_subscription_to_date_sequence_paused"));
        
        //verify that rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "when_subscription_to_date_sequence_paused"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "when_subscription_to_date_sequence_paused"));
        if(rule_Edit.verifyText("Subscription to ")==null)
        {
            fail("didnt select when contact is added to sequence");
        }
        if(rule_Edit.verifyText(" is paused")==null)
        {
            fail("didnt select when contact is added to sequence");
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
