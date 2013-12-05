package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_SMSContainsText extends AbstractTest
{
    @Test
    public void testCreateRule_SMSContainsText ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "sms_contains_text"));
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInput("sms", 1);
        rule_Create.selectIfDrillDownPaneOption("SMS Contains Text");
        rule_Create.enterIfInput("test", 1);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "sms_contains_text"));
        
        //verify rule
        if(rule_ListAll.verifyRule(value.get("Rules", "sms_contains_text"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "sms_contains_text"));
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select tracked links");
        }

        if(rule_Edit.verifyText("SMS Contains ")==null)
        {
            fail("didnt select tracked links");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
