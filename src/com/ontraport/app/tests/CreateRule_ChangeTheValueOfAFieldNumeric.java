package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_ChangeTheValueOfAFieldNumeric extends AbstractTest
{
    @Test
    public void testCreateRule_ChangeTheValueOfAFieldNumeric ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "change_the_value_of_numeric_field"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInputDropDown("Change", 1);
        rule_Create.selectThenDrillDownPaneOption("Change the value of a field");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInputDropDown("Num", 1);
        rule_Create.selectThenDrillDownPaneOption(value.get("Fields", "Numeric_Field"));
        rule_Create.enterThenInput("1", 2);
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "change_the_value_of_numeric_field"));
        
        //verify rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "change_the_value_of_numeric_field"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "change_the_value_of_numeric_field"));
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyTDText(" Change")==null)
        {
            fail("didnt select ping url");
        }

        if(rule_Edit.verifyThenDropDownInputText(1, value.get("Fields", "Numeric_Field"))==null)
        {
            fail("didnt type url right");
        }
        if(rule_Edit.verifyThenInput(2, "1")==null)
        {
            fail("didn't add post data right");
        }

        
    }
}
