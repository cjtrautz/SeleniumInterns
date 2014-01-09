package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_SMSRecievedFromContact extends AbstractTest
{
    @Test
    public void testCreateRule_SMSRecievedFromContact ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "sms_recieved_by_contact"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInputDropDown("SMS", 1);
        rule_Create.selectWhenDrillDownPaneOption("SMS Received from contact");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOptionContains("Any Number");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "sms_recieved_by_contact"));
        
        //verify rule
        if(rule_ListAll.verifyRule(value.get("Rules", "sms_recieved_by_contact"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "sms_recieved_by_contact"));
        if(rule_Edit.verifyText("SMS Received from contact on ")==null)
        {
            fail("didnt select tracked links");
        }

        if(rule_Edit.verifyWhenDropDownInputTextContains(1, "Any Number")==null)
        {
            fail("didnt select any tracked link");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
