package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_RemoveAccessToWordPressMembershipLevel extends AbstractTest
{
    @Test
    public void testCreateRule_RemoveAccessToWordPressMembershipLevel ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "remove_access_to_wordpress_membership_level"));
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInput("word", 1);
        rule_Create.selectThenDrillDownPaneOption("Remove access to WordPress Membership Level");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOptionContains(value.get("WordPress", "wordpress_domain") + AbstractSuite.UNIQUE + ".affcntr.com");
        rule_Create.selectThenDrillDownPaneOptionContains(value.get("WordPress", "level"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "remove_access_to_wordpress_membership_level"));
        
        //verify rule
        if(rule_ListAll.verifyRule(value.get("Rules", "remove_access_to_wordpress_membership_level"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "remove_access_to_wordpress_membership_level"));
        if(rule_Edit.verifyText("Remove acces to ")==null)
        {
            fail("didnt select tracked links");
        }

        if(rule_Edit.verifyThenDropDownInputTextContains(1, value.get("WordPress", "wordpress_domain") + AbstractSuite.UNIQUE + ".affcntr.com >> " + value.get("WordPress", "level"))==null)
        {
            fail("didnt select any tracked link");
        }
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
