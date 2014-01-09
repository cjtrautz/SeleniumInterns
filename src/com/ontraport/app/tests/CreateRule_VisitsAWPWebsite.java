package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_VisitsAWPWebsite extends AbstractTest
{
    @Test
    public void testCreateRule_VisitsAWPWebsite ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName(value.get("Rules", "visits_wp_site"));
        rule_Create.openWhenTriggerPane(1);
        rule_Create.enterWhenInputDropDown("website", 1);
        rule_Create.selectWhenDrillDownPaneOption("Visits website");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption(value.get("WordPress", "wordpress_site") + AbstractSuite.UNIQUE);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find(value.get("Rules", "visits_wp_site"));
        
        //verify that rule exists
        if(rule_ListAll.verifyRule(value.get("Rules", "visits_wp_site"))==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule(value.get("Rules", "visits_wp_site"));
        if(rule_Edit.verifyText("Visits ")==null)
        {
            fail("didnt select field updated");
        }
        if(rule_Edit.verifyWhenDropDownInputText(1, value.get("WordPress", "wordpress_site") + AbstractSuite.UNIQUE)==null)
        {
            fail("didnt select first name");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
