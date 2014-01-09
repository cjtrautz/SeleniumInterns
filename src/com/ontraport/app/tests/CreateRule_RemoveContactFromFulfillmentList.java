package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_RemoveContactFromFulfillmentList extends AbstractTest
{
    @Test
    public void testCreateRule_RemoveContactFromFulfillmentList ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleRemoveContactFromFulfillment");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInputDropDown("Fulfillment", 1);
        rule_Create.selectThenDrillDownPaneOption("Remove Contact from Fulfillment List");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("SelFulfillment");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleRemoveContactFromFulfillment");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleRemoveContactFromFulfillment")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleRemoveContactFromFulfillment");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select contact is created");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, "SelFulfillment")==null)
        {
            fail("didnt select any selfulfillment");
        }
        if(rule_Edit.verifyText("Remove Contact from Fulfillment List:")==null)
        {
            fail("didn't select remove contact from fulfillment");
        }
    }
}
