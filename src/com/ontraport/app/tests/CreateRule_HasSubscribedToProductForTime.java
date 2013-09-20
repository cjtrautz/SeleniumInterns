package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_HasSubscribedToProductForTime extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleHasSubscribedToProductForTime");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInput("product", 1);
        rule_Create.selectIfDrillDownPaneOption("Has been subscribed to a product for a certain amount of time");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Any Subscription Product");
        rule_Create.enterIfInput("1", 2);
        rule_Create.openIfConditionPane(2);
        rule_Create.selectIfDrillDownPaneOption("Days");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleHasSubscribedToProductForTime");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleHasSubscribedToProductForTime")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleHasSubscribedToProductForTime");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Has been subscribed to ")==null)
        {
            fail("didnt select has been subscribed to product for time");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, "Any Subscription Product")==null)
        {
            fail("didnt select any subscription product");
        }
        if(rule_Edit.verifyIfDropDownInputText(2, "Days")==null)
        {
            fail("didnt select days");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
