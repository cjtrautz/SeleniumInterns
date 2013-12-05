package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_DoesntHaveAccessToWordPressMembershipLevel extends AbstractTest
{
    @Test
    public void testCreateRule_DoesntHaveAccessToWordPressMembershipLevel ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "doesnt_have_access_to_wordpress_membership_level"));
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInput("word", 1);
        rule_Create.selectIfDrillDownPaneOption("Does not have access to WordPress Membership Level");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOptionContains(value.get("WordPress", "wordpress_domain") + AbstractSuite.UNIQUE + ".affcntr.com");
        rule_Create.selectIfDrillDownPaneOptionContains(value.get("WordPress", "level"));
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "doesnt_have_access_to_wordpress_membership_level"));
        
        //verify rule
        if(rule_ListAll.verifyRule(value.get("Rules", "doesnt_have_access_to_wordpress_membership_level"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "doesnt_have_access_to_wordpress_membership_level"));
        if(rule_Edit.verifyText("Does not have access to ")==null)
        {
            fail("didnt select tracked links");
        }

        if(rule_Edit.verifyIfDropDownInputTextContains(1, value.get("WordPress", "wordpress_domain") + AbstractSuite.UNIQUE + ".affcntr.com >> " + value.get("WordPress", "level"))==null)
        {
            fail("didnt select any tracked link");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
        
    }
}
