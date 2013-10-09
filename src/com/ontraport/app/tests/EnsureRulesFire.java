package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EnsureRulesFire extends AbstractTest
{
    @Test
    public void testEnsureRulesFire ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleEnsureThatItWillFire");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("A Certain field is updated");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("First Name");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInput("change", 1);
        rule_Create.selectThenDrillDownPaneOption("Change the value of a field");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Last Name");
        rule_Create.enterThenInput("RuleFired", 2);
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleEnsureThatItWillFire");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleEnsureThatItWillFire")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleEnsureThatItWillFire");
        if(rule_Edit.verifyText(" is Updated")==null)
        {
            fail("didnt select field updated");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, "First Name")==null)
        {
            fail("didnt select first name");
        }
        if(rule_Edit.verifyTDText(" Change")==null)
        {
            fail("didn't select change value of field");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, "Last Name")==null)
        {
            fail("didn't select last name");
        }
        contactListAll = rule_Edit.menuPrimary.clickContactListAll();
        Contact_Edit contact_Edit = contactListAll.clickContact(1);
        contact_Edit.clickFirstName();
        contact_Edit.enterFirstName("Selenium");
        contact_Edit.clickFirstNameSave();
        contactListAll = contact_Edit.menuPrimary.clickContactListAll();
        contact_Edit = contactListAll.clickContact(1);
        
        if(contact_Edit.verifyFirstName("Selenium")==null)
        {
            fail("couldn't find firstName");
        }
        if(contact_Edit.verifyLastName("RuleFired")==null)
        {
            fail("couldn't find lasttName");
        }
        rule_ListAll = contact_Edit.menuPrimary.clickRuleListAll();
        rule_ListAll.formSearch.find("SelRuleEnsureThatItWillFire");
        if(rule_ListAll.verifyRuleFired("SelRuleEnsureThatItWillFire")==null)
        {
            fail("couldn't find rule fired");
        }
    }
}
