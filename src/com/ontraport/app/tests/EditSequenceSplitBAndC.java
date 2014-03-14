package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditSequenceSplitBAndC extends AbstractTest
{
    @Test
    public void testEditSequenceSplitBAndC ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();

        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        
        sequence_Edit.expandStep(2);
        sequence_Edit.clickSplitTestingOn();
        if(sequence_Edit.verifySplitTestOn()==null)
        {
            fail("couldn't find sequence split test on");
        }
        sequence_Edit.clickNewSplitTest();
        sequence_Edit.openEmailNamePane();
        sequence_Edit.selectDrillDownEmailName(value.get("Messages", "email_messageB"));
        sequence_Edit.openEmailFromPane();
        sequence_Edit.selectDrillDownByIndex(1);
        sequence_Edit.openSendFromPane();
        sequence_Edit.selectDrillDown("Contact owner");
        sequence_Edit.clickNewSplitTest();
        sequence_Edit.openEmailNamePane();
        sequence_Edit.selectDrillDownEmailName(value.get("Messages", "email_messageC"));
        sequence_Edit.openEmailFromPane();
        sequence_Edit.selectDrillDownByIndex(1);
        sequence_Edit.openSendFromPane();
        sequence_Edit.selectDrillDown("Contact owner");
        sequence_ListAll = sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));

        if(sequence_ListAll.verifySequence(value.get("Sequences", "step_rule_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        sequence_Edit.expandStep(2);
        if(sequence_Edit.verifyVersion(2)==null)
        {
            fail("couldn't find sequence email name");
        }
        sequence_Edit.clickVersion(3);
        if(sequence_Edit.verifyEmailName(value.get("Messages", "email_messageC"))==null)
        {
            fail("couldn't find sequence email name");
        }
        if(sequence_Edit.verifySendFrom("Contact owner")==null)
        {
            fail("couldn't find sequence email send from");
        }
        sequence_Edit.clickDeleteSplitTest();
        sequence_Edit.clickVersion(2);
        if(sequence_Edit.verifyEmailName(value.get("Messages", "email_messageB"))==null)
        {
            fail("couldn't find sequence email name");
        }
        if(sequence_Edit.verifySendFrom("Contact owner")==null)
        {
            fail("couldn't find sequence email send from");
        }
        sequence_Edit.clickDeleteSplitTest();
        sequence_Edit.clickSplitTestingOff();
        if(sequence_Edit.verifySplitTestOff()==null)
        {
            fail("couldn't find sequence split test off");
        }
        sequence_ListAll = sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
    }
}
