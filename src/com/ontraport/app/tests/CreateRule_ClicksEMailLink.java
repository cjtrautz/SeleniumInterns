package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_ClicksEMailLink extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleClicksEmailLink");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Clicks an E-mail link");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Any E-Mail");
        rule_Create.enterWhenInput("0", 2);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleClicksEmailLink");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleClicksEmailLink")==null)
        {
            fail("couldnt find rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleClicksEmailLink");
        if(rule_Edit.verifyText("Clicks ")==null)
        {
            fail("didnt select email links");
        }
        if(rule_Edit.verifyText(" link ")==null)
        {
            fail("didnt select email links");
        }
<<<<<<< HEAD
        if(rule_Edit.verifyWhenDropDownInputText(1, "Any E-Mail")==null)
=======
        if(rule_Edit.verifyWhenDropDown(1, "0")==null)
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        {
            fail("didnt select any email link");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
