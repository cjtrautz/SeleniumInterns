package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateSMS;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateSMSMessageFromSequence extends AbstractTest
{
    @Test
    public void testCreateSMSMessageFromSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName(value.get("Sequences", "sms_from_sequence"));
        sequence_CreateStep.clickAddSMSStep();
        sequence_CreateStep.clickSMSDropDown();
        sequence_CreateStep.clickCreateNewMessage();
        sequence_CreateStep.enterName(value.get("Messages", "sms_from_sequence"));
        Message_Edit message_Edit = sequence_CreateStep.clickSaveAndEdit();
        message_Edit.openMergeFieldPane();
        message_Edit.selectMergeField("First Name");
        message_Edit.dialogBox.clickOk();
        message_Edit.sendSMSBody("Sel");
        sequence_CreateStep = message_Edit.clickSaveToSequence();

        if(sequence_CreateStep.verifyPreviewData("[First Name]Sel")==null)
        {
            fail("couldn't find message body");
        }
        if(sequence_CreateStep.verifySequenceName(value.get("Sequences", "sms_from_sequence"))==null)
        {
            fail("couldn't find message body");
        }

    }
}
