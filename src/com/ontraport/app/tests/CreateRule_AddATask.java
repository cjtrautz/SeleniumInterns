package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_AddATask extends AbstractTest
{
    @Test
    public void testCreateRule_AddATask ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "add_a_task"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInputDropDown("Task", 1);
        rule_Create.selectThenDrillDownPaneOption("Add Task");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption(value.get("Messages", "task_message_who"));
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "add_a_task"));
        
        //verify rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "add_a_task"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "add_a_task"));
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Send an ")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyThenInput(1, value.get("Messages", "task_message_who"))==null)
        {
            fail("didnt type url right");
        }
        
    }
}
