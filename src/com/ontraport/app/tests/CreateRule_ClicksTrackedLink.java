package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_ClicksTrackedLink extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleClicksTrackedLink");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInput("tracked", 1);
        rule_Create.selectWhenDrillDownPaneOption("Clicks tracked link");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any Tracked Link");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleClicksTrackedLink");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleClicksTrackedLink")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleClicksTrackedLink");
        if(rule_Edit.verifyText("Clicks ")==null)
        {
            fail("didnt select tracked links");
        }
        if(rule_Edit.verifyWhenDropDown(1, "0")==null)
        {
            fail("didnt select any tracked link");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
