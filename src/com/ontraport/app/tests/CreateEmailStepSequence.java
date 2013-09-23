package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEmailStepSequence extends AbstractTest
{
    @Test
    public void testCreateEmailStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName("SelEmailStepSequence");
        sequence_CreateStep.clickAddEmailStep();
        sequence_CreateStep.openEmailNamePane();
        sequence_CreateStep.selectDrillDownEmailName("SelEmailMessage");
        sequence_CreateStep.openEmailFromPane();
        sequence_CreateStep.selectDrillDownByIndex(1);
        sequence_CreateStep.openSendFromPane();
        sequence_CreateStep.selectDrillDown("Contact Owner");
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find("SelEmailStepSequence");
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence("SelEmailStepSequence")==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelEmailStepSequence");
        if(sequence_Edit.verifySequenceStepAndExpand("EMAIL", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyEmailName("SelEmailMessage")==null)
        {
            fail("couldn't find sequence email name");
        }
        if(sequence_Edit.verifySendFrom("Contact Owner")==null)
        {
            fail("couldn't find sequence email send from");
        }
        if(sequence_Edit.verifyEmailMessage("SelBody[First Name]")==null)
        {
            fail("couldn't find sequence email message");
        }
    }
}
