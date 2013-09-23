package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_ContactIsNotSubscribedToTag extends AbstractTest
{
    @Test
    public void testCreateRule_ContactIsNotSubscribedToTag ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleContactIsNotSubscribedToTag");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("If Contact is not subscribed to Tag");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("SelTag");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleContactIsNotSubscribedToTag");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleContactIsNotSubscribedToTag")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleContactIsNotSubscribedToTag");
        if(rule_Edit.verifyText("If Contact is not subscribed to Tag:")==null)
        {
            fail("didnt select if contact subscribed to tag");
        }
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
