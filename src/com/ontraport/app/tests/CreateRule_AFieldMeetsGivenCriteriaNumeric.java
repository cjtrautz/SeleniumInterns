package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_AFieldMeetsGivenCriteriaNumeric extends AbstractTest
{
    @Test
    public void testCreateRule_AFieldMeetsGivenCriteriaNumeric ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "if_numeric_meets_criteria"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Field is this value");
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInput("num", 1);
        rule_Create.selectIfDrillDownPaneOption(value.get("Fields", "Numeric_Field"));
        rule_Create.openIfConditionPane(2);
        rule_Create.selectIfDrillDownPaneOption("Equal To");
        rule_Create.enterIfInput("1", 4);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "if_numeric_meets_criteria"));
        
        //verify rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "if_numeric_meets_criteria"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "if_numeric_meets_criteria"));
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyHeaderText("FIELD")==null)
        {
            fail("didnt select Field is this value");
        }
        if(rule_Edit.verifyIfDropDownInputText(2, "Equal To")==null)
        {
            fail("didnt select equal to");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, value.get("Fields", "Numeric_Field"))==null)
        {
            fail("didnt select first name");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
