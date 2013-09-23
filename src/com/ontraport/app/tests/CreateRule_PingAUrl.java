package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_PingAUrl extends AbstractTest
{
    @Test
    public void testCreateRule_PingAUrl ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRulePingAUrl");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.enterThenInput("url", 1);
        rule_Create.selectThenDrillDownPaneOption("Ping a URL");
        rule_Create.enterThenTextArea("www.google.com", 1);
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("First Name");
        rule_Create.openThenActionPane(2);
        rule_Create.selectThenDrillDownPaneOption("First Name");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRulePingAUrl");
        
        //verify rule exists
        if(rule_ListAll.verifyRule("SelRulePingAUrl")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRulePingAUrl");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyTextDiv("Ping URL")==null)
        {
            fail("didnt select ping url");
        }
        if(rule_Edit.verifyTextLabel("URL")==null)
        {
            fail("no url header");
        }
        if(rule_Edit.verifyTextLabel("Post Data")==null)
        {
            fail("no post data header");
        }
        if(rule_Edit.verifyThenTextArea(1, "www.google.com[First Name]")==null)
        {
            fail("didnt type url right");
        }
        if(rule_Edit.verifyThenTextArea(2, "[First Name]")==null)
        {
            fail("didn't add post data right");
        }
        
    }
}
