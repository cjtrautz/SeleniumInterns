package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_HasVisitedLPNumberTimes extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleHasVisitedLPNumberTimes");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Has visited a landing page a certain number of times");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Any Landing Page");
        rule_Create.openIfConditionPane(2);
        rule_Create.selectIfDrillDownPaneOption("Equal To");
        rule_Create.enterIfInput("1", 3);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleHasVisitedLPNumberTimes");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleHasVisitedLPNumberTimes")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleHasVisitedLPNumberTimes");
        if(rule_Edit.verifyText("Has visited ")==null)
        {
            fail("didnt select has visited website number of times");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, "Any Landing Page")==null)
        {
            fail("didnt select any LP");
        }
        if(rule_Edit.verifyIfDropDownInputText(2, "Equal To")==null)
        {
            fail("didnt select equalto");
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
