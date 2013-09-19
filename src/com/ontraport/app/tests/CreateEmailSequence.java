package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEmailSequence extends AbstractTest
{
    @Test
    public void test ()
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
        sequence_CreateStep.selectDrillDown(1);
        sequence_CreateStep.openEmailFromPane();
        sequence_CreateStep.selectDrillDown(1);
        sequence_CreateStep.openSendFromPane();
        sequence_CreateStep.selectDrillDown(1);
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find("SelEmailStepSequence");
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence("SelEmailStepSequence")==null)
        {
            fail("couldn't find sequence");
        }
        
    }
}
