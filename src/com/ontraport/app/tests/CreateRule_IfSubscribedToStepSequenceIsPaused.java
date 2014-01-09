package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_IfSubscribedToStepSequenceIsPaused extends AbstractTest
{
    @Test
    public void testCreateRule_IfSubscribedToStepSequenceIsPaused ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "if_subscription_to_step_sequence_is_paused"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInputDropDown("sequence", 1);
        rule_Create.selectIfDrillDownPaneOption("Subscription to a sequence is paused");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption(value.get("Sequences", "step_task_sequence"));
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "if_subscription_to_step_sequence_is_paused"));
        
        //verify that rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "if_subscription_to_step_sequence_is_paused"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "if_subscription_to_step_sequence_is_paused"));
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Subscription ")==null)
        {
            fail("didnt select if contact is subscribed to fulfillment list");
        }
        if(rule_Edit.verifyText(" is paused")==null)
        {
            fail("didnt select if contact is subscribed to fulfillment list");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, value.get("Sequences", "step_task_sequence"))==null)
        {
            fail("didnt select any fulfillment list");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
