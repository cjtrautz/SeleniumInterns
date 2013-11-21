package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEmailStepSequenceEdit extends AbstractTest
{
    @Test
    public void testCreateEmailStepSequenceEdit ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.clickAddEmailStep();
        sequence_CreateStep.openEmailNamePane();
        sequence_CreateStep.selectDrillDownEmailName(value.get("Messages", "email_message"));
        Message_Edit message_Edit =sequence_CreateStep.clickEdit();
        message_Edit.enterSubject("New Subject123");
        message_Edit.enterTextWithClear("New Text123");
        sequence_CreateStep = message_Edit.clickSaveToStep();
        if(sequence_CreateStep.verifyEmailSubject("NEW SUBJECT123")==null)
        {
            fail("didnt change new subject");
        }
        if(sequence_CreateStep.verifyEmailBody("New Text123")==null)
        {
            fail("didnt change message body");
        }

    }
}
