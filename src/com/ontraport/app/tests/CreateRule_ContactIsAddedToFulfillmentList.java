package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_ContactIsAddedToFulfillmentList extends AbstractTest
{
    @Test
    public void testCreateRule_ContactIsAddedToFulfillmentList ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleContactAddedToFulfillment");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInputDropDown("Fulfillment", 1);
        rule_Create.selectWhenDrillDownPaneOption("When Contact is added to Fulfillment List");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any Fulfillment List");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleContactAddedToFulfillment");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleContactAddedToFulfillment")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleContactAddedToFulfillment");
        if(rule_Edit.verifyText("When Contact is added to Fulfillment List:")==null)
        {
            fail("didnt select when contact is added to fulfillment list");
        }

        if(rule_Edit.verifyWhenDropDownInputText(1, "Any Fulfillment List")==null)
        {
            fail("didnt select any fulfillment");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
