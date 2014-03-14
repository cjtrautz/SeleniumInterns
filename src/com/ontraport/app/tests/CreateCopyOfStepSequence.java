package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateCopyOfStepSequence extends AbstractTest
{
    @Test
    public void testCreateCopyOfStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        sequence_TypeSelection.clickStepSequenceDropDown();
        Sequence_Edit sequence_Edit = sequence_TypeSelection.selectDropDown(value.get("Sequences", "step_rule_sequence"));
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_Edit.clickAddEmailStep();
        sequence_Edit.openEmailNamePane();
        sequence_Edit.selectDrillDownEmailName(value.get("Messages", "email_message"));
        sequence_Edit.openEmailFromPane();
        sequence_Edit.selectDrillDownByIndex(1);
        sequence_Edit.openSendFromPane();
        sequence_Edit.selectDrillDown("Contact owner");
        sequence_ListAll = sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "copy_step_rule_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "copy_step_rule_sequence"));
        if(sequence_Edit.verifySequenceStep("EMAIL", 2)==null)
        {
            fail("couldn't find sequence step2");
        }
        if(sequence_Edit.verifySequenceStep("RULE", 1)==null)
        {
            fail("couldn't find sequence step1");
        }
        
    }
}
