package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditSequenceSendAt12PM extends AbstractTest
{
    @Test
    public void testEditSequenceSendAt12PM ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();

        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        
        sequence_Edit.expandStep(2);
        sequence_Edit.clickSendAtDropDown();
        sequence_Edit.enterSendAtInput("12:00 PM");
        sequence_Edit.selectDrillDown("12:00 PM");
        sequence_ListAll = sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));

        if(sequence_ListAll.verifySequence(value.get("Sequences", "step_rule_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        sequence_Edit.expandStep(2);
        if(sequence_Edit.verifySendAtTime("12:00 PM")==null)
        {
            fail("couldn't find send at time");
        }
        
    }
}
