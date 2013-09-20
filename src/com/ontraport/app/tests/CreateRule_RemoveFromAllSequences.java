package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_RemoveFromAllSequences extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleRemoveFromAllSequences");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Remove from all sequences");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleRemoveFromAllSequences");
        
        //verify rule
        if(rule_ListAll.verifyRule("SelRuleRemoveFromAllSequences")==null)
        {
            fail("couldnt find rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleRemoveFromAllSequences");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyText("Remove from all sequences")==null)
        {
            fail("didn't select remove from all sequences");
        }
        
    }
}
