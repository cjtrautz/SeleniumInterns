package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_AddContactToFulfillmentList extends AbstractTest
{
    @Test
    public void testCreateRule_AddContactToFulfillmentList ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleAddContactToFulfillment");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInputDropDown("Fulfillment", 1);
        rule_Create.selectThenDrillDownPaneOption("Add Contact to Fulfillment List");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("SelFulfillment");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleAddContactToFulfillment");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleAddContactToFulfillment")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleAddContactToFulfillment");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select contact is created");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, "SelFulfillment")==null)
        {
            fail("didnt select any selfulfillment");
        }
        if(rule_Edit.verifyText("Add Contact to Fulfillment List:")==null)
        {
            fail("didn't select add contact to fulfillment");
        }
    }
}
