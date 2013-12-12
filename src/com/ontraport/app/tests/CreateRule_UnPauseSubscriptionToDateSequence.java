package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_UnPauseSubscriptionToDateSequence extends AbstractTest
{
    @Test
    public void testCreateRule_UnPauseSubscriptionToStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "unpause_subscription_to_date_sequence"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Unpause subscription to a sequence");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption(value.get("Sequences", "date_task_sequence"));
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "unpause_subscription_to_date_sequence"));
        
        //verify rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "unpause_subscription_to_date_sequence"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "unpause_subscription_to_date_sequence"));
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, value.get("Sequences", "date_task_sequence"))==null)
        {
            fail("didnt select step sequence");
        }
        if(rule_Edit.verifyText("Unpause subscription to ")==null)
        {
            fail("didn't select unpause subscription to sequence");
        }
        
    }
}
