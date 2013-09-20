package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_IsSubscribedToProduct extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleHasSubscribedToProduct");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInput("subscribed", 1);
        rule_Create.selectIfDrillDownPaneOption("Is subscribed to product");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Any Subscription Product");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleHasSubscribedToProduct");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleHasSubscribedToProduct")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleHasSubscribedToProduct");
        if(rule_Edit.verifyText("Is subscribed to ")==null)
        {
            fail("didnt select is subscribed to product");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, "Any Subscription Product")==null)
        {
            fail("didnt select any product");
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
