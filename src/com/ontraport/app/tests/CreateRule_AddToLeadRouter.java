package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_AddToLeadRouter extends AbstractTest
{
    @Test
    public void testCreateRule_AddToLeadRouter ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleAddToLeadRouter");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInputDropDown("Router", 1);
        rule_Create.selectThenDrillDownPaneOption("Add to Lead Router");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("SelRoundRobin");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleAddToLeadRouter");
        
        //verify rule exists
        if(rule_ListAll.verifyRule("SelRuleAddToLeadRouter")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleAddToLeadRouter");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, "SelRoundRobin")==null)
        {
            fail("didnt select Sel round robin");
        }
        if(rule_Edit.verifyText("Add to ")==null)
        {
            fail("didn't select add to round robin");
        }
        
    }
}
