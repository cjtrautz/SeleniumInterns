package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateSequenceFromRuleOutcome extends AbstractTest
{
    @Test
    public void testCreateSequenceFromRuleOutcome () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleCreateSequence");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Add Contact to Sequence");
        rule_Create.openThenActionPane(1);
        rule_Create.clickCreateNewSequence();
        rule_Create.enterNewObjectName("NewSequenceFromRule");
        
        Sequence_TypeSelection sequence_TypeSelection = rule_Create.saveAndEditNewSequence();
        
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.workflowClickStepSequenceCreate();
        
        rule_Create = sequence_CreateStep.clickSaveToRuleWorkflow();
        
        rule_ListAll = rule_Create.clickSave();
        
        Sequence_ListAll sequence_ListAll = rule_ListAll.menuPrimary.clickSequenceListAll();
        
        if (sequence_ListAll.verifySequence("NewSequenceFromRule") == null)
        {
            fail("sequence not saved");
        };
                
        rule_ListAll = sequence_ListAll.menuPrimary.clickRuleListAll();
        
        if (rule_ListAll.verifyRule("SelRuleCreateSequence") == null)
        {
            fail("rule not saved");
        }
        
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleCreateSequence");
        
        if(rule_Edit.verifyText("Contact is created") == null)
        {
            fail("didnt select when contact is created");
        }
        
        if(rule_Edit.verifyThenDropDownInputText(1, "NewSequenceFromRule") == null)
        {
            fail("didnt select product");
        }
    }
}