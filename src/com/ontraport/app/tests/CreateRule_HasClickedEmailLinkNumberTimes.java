package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_HasClickedEmailLinkNumberTimes extends AbstractTest
{
    @Test
    public void testCreateRule_HasClickedEmailLinkNumberTimes ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleHasClickedEmailLinkNumberTimes");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openIfConditionPane(1);
        rule_Create.enterIfInputDropDown("clicked", 1);
        rule_Create.selectIfDrillDownPaneOption("Has clicked an Email link a certain number of times");
        rule_Create.openIfConditionPane(1);
        rule_Create.selectIfDrillDownPaneOption("Any Email");
        rule_Create.openIfConditionPane(2);
        rule_Create.selectIfDrillDownPaneOption("Equal To");
        rule_Create.enterIfInput("1", 4);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Recharge all declined transactions");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleHasClickedEmailLinkNumberTimes");
        
        //verify that rule exists
        if(rule_ListAll.verifyRule("SelRuleHasClickedEmailLinkNumberTimes")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleHasClickedEmailLinkNumberTimes");
        if(rule_Edit.verifyText("Has clicked ")==null)
        {
            fail("didnt select has opened email number of times");
        }
        if(rule_Edit.verifyIfDropDownInputText(1, "Any Email")==null)
        {
            fail("didnt select any email");
        }
        if(rule_Edit.verifyIfDropDownInputText(2, "Equal To")==null)
        {
            fail("didnt select equal to");
        }
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Recharge all declined transactions")==null)
        {
            fail("didn't select recharge all declined transactions");
        }
    }
}
