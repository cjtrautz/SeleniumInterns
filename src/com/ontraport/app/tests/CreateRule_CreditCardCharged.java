package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_CreditCardCharged extends AbstractTest
{
    @Test
    public void testCreateRule_CreditCardCharged ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleCreditCardCharged");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInputDropDown("Credit", 1);
        rule_Create.selectWhenDrillDownPaneOption("Credit card is charged or declined");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Charged");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleCreditCardCharged");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleCreditCardCharged")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleCreditCardCharged");
        if(rule_Edit.verifyText("Credit card is ")==null)
        {
            fail("didnt select credit card");
        }

        if(rule_Edit.verifyWhenDropDownInputText(1, "Charged")==null)
        {
            fail("didnt select charged");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }

        
    }
}
