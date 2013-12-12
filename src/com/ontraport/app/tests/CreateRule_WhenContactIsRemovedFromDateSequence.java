package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_WhenContactIsRemovedFromDateSequence extends AbstractTest
{
    @Test
    public void testCreateRule_WhenContactIsRemovedFromDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "when_contact_is_removed_from_date_sequence"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("When Contact is removed from Sequence");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption(value.get("Sequences", "date_task_sequence"));
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "when_contact_is_removed_from_date_sequence"));
        
        //verify that rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "when_contact_is_removed_from_date_sequence"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "when_contact_is_removed_from_date_sequence"));
        if(rule_Edit.verifyText("When Contact is removed from Sequence:")==null)
        {
            fail("didnt select when contact is removed to sequence");
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
