package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_1ConditionWithOr extends AbstractTest
{
    @Test
    public void testCreateRule_1ConditionWithOr ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRule1ConditionWithOr");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Has been on a sequence for a certain amount of time");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Any Sequence");
        rule_Create.enterIfInput("1", 2);
        rule_Create.openIfConditionPane(2);
        rule_Create.selectIfDrillDownPaneOption("Days");
        rule_Create.addNewCondition();
        rule_Create.openIfConditionPane(4);
        rule_Create.selectIfDrillDownPaneOption("OR");
        rule_Create.openIfConditionPane(5);
        rule_Create.selectIfDrillDownPaneOption("If Contact is subscribed to Sequence");
        rule_Create.openIfConditionPane(5);
        rule_Create.selectIfDrillDownPaneOption("Any Sequence");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRule1ConditionWithOr");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRule1ConditionWithOr")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRule1ConditionWithOr");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Has Been on ")==null)
        {
            fail("didnt select has been on sequence");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, "Any Sequence")==null)
        {
            fail("didnt select any sequence");
        }
        if(rule_Edit.verifyIfDropDownInputText(2, "Days")==null)
        {
            fail("didnt select days");
        }
        if(rule_Edit.verifyIfDropDownInputText(4, "OR")==null)
        {
            fail("or not selected for second condition");
        }
        if(rule_Edit.verifyText("If Contact is subscribed to Sequence:")==null)
        {
            fail("didnt select 2nd condition that contact is subscribed to sequence");
        }
        if(rule_Edit.verifyIfDropDownInputText(5, "Any Sequence")==null)
        {
            fail("didnt select any sequence");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
