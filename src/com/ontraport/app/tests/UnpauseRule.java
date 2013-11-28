package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class UnpauseRule extends AbstractTest
{
    @Test
    public void testUnpauseRule ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        rule_ListAll.formSearch.find(value.get("Rules", "when_contact_is_created"));
        rule_ListAll.selectRule(value.get("Rules", "when_contact_is_created"));
        rule_ListAll.drawerActions.clickUnpauseRule();
        rule_ListAll.dialogBox.clickOk();
        contactListAll = rule_ListAll.menuPrimary.clickContactListAll();
        rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        rule_ListAll.formSearch.find(value.get("Rules", "when_contact_is_created"));
        
        if(rule_ListAll.verifyRulUnpaused(value.get("Rules", "when_contact_is_created"))==null)
        {
            fail("rule didnt use");
        }
        
    }
}
