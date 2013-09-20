package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_CreditCardDeclined extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleCreditCardDeclined");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInput("Credit", 1);
        rule_Create.selectWhenDrillDownPaneOption("Credit card is charged or declined");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Declined");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleCreditCardDeclined");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleCreditCardDeclined")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleCreditCardDeclined");
        if(rule_Edit.verifyText("Credit card is ")==null)
        {
            fail("didnt select credit card");
        }
<<<<<<< HEAD
        if(rule_Edit.verifyWhenDropDownInputText(1, "Declined")==null)
=======
        if(rule_Edit.verifyWhenDropDown(1, "1")==null)
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        {
            fail("didnt select declined");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
