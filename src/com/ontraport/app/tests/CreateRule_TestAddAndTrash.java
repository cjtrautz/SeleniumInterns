package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_TestAddAndTrash extends AbstractTest
{
    @Test
    public void testCreateRule_TestAddAndTrash ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.addNewAction();
        rule_Create.addNewCondition();
        rule_Create.addNewTrigger();
  
        //verify rule
        if(rule_Create.verifyNewRows()==null)
        {
            fail("couldnt find added action,condition, or trigger");
        }
        rule_Create.trashAction();
        
        
        if(rule_Create.verifyOneAction()==null)
        {
            fail("didnt delete action");
        }
        rule_Create.trashCondition();
        if(rule_Create.verifyOneCondition()==null)
        {
            fail("didnt delete condition");
        }
        rule_Create.trashTrigger();
        if(rule_Create.verifyOneTrigger()==null)
        {
            fail("didnt delete condition");
        }
       
    }
}
