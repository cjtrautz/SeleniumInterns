package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_NotifySomeoneWithEmail extends AbstractTest
{
    @Test
    public void testCreateRule_NotifySomeoneWithEmail ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleNotifySomeoneWithEmail");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Notify someone with an E-mail");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Contact");
        rule_Create.openThenActionPane(2);
        rule_Create.selectThenDrillDownPaneOption("SelEmailMessage");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleNotifySomeoneWithEmail");
        
        //verify rule exists
        if(rule_ListAll.verifyRule("SelRuleNotifySomeoneWithEmail")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleNotifySomeoneWithEmail");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, "Contact's Owner")==null)
        {
            fail("didnt select contacts owner");
        }
        if(rule_Edit.verifyThenDropDownInputText(2, "SelEmailMessage")==null)
        {
            fail("didnt select selenium message");
        }
        if(rule_Edit.verifyText("Notify ")==null)
        {
            fail("didn't select notify with an email");
        }
        
    }
}
