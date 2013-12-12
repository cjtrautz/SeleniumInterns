package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRule_IfSubscribedToDateSequenceIsPaused extends AbstractTest
{
    @Test
    public void testDeleteRule_IfSubscribedToDateSequenceIsPaused ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        rule_ListAll.formSearch.find(value.get("Rules", "if_subscription_to_date_sequence_is_paused"));
        rule_ListAll.selectRule(value.get("Rules", "if_subscription_to_date_sequence_is_paused"));
        rule_ListAll.drawerActions.clickDeleteRule();
        rule_ListAll.dialogBox.clickOk();
        
        //verify
        if(rule_ListAll.verifyNoRule()==null)
        {
            fail("found delete rule");
        }
    }
}
