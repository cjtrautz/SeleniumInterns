package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditSequenceSendAt15Mins extends AbstractTest
{
    @Test
    public void testEditSequenceSendAt15Mins ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();

        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        
        sequence_Edit.expandStep(2);
        sequence_Edit.clickSendAtDropDown();
        sequence_Edit.selectDrillDown("15 Minutes");
        sequence_ListAll = sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));

        if(sequence_ListAll.verifySequence(value.get("Sequences", "step_rule_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        sequence_Edit.expandStep(2);
        if(sequence_Edit.verifySendAtTime("15 Minutes")==null)
        {
            fail("couldn't find send at time");
        }
        
    }
}
