package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_ContactRemovedFromTag extends AbstractTest
{
    @Test
    public void testCreateRule_ContactRemovedFromTag ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleContactRemovedFromTag");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInputDropDown("Tag", 1);
        rule_Create.selectWhenDrillDownPaneOption("When Contact is removed from Tag");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("SelTag");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleContactRemovedFromTag");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleContactRemovedFromTag")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleContactRemovedFromTag");
        if(rule_Edit.verifyText("When Contact is removed from Tag:")==null)
        {
            fail("didnt select contact removed from tag");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
