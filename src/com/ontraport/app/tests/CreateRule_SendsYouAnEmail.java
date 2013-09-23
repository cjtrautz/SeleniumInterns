package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_SendsYouAnEmail extends AbstractTest
{
    @Test
    public void testCreateRule_SendsYouAnEmail ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleSendsYouAnEmail");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Sends you an E-mail");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleSendsYouAnEmail");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleSendsYouAnEmail")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleSendsYouAnEmail");
        if(rule_Edit.verifyText("Sends you an E-mail")==null)
        {
            fail("didnt select sends you an email");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
