package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_VisitsALandingPage extends AbstractTest
{
    @Test
    public void testCreateRule_VisitsALandingPage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleVisitsLandingPage");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInput("landing", 1);
        rule_Create.selectWhenDrillDownPaneOption("Visits a landing page");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any Landing Page");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleVisitsLandingPage");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleVisitsLandingPage")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleVisitsLandingPage");
        if(rule_Edit.verifyText("Visits ")==null)
        {
            fail("didnt select visits a landing page");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, "Any Landing Page")==null)
        {
            fail("didnt select any landing page");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
