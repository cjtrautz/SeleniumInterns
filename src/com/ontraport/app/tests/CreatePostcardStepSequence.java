package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreatePostcardStepSequence extends AbstractTest
{
    @Test
    public void testCreatePostcardStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName(value.get("Sequences", "step_postcard_sequence"));
        sequence_CreateStep.clickAddPostcardStep();
        sequence_CreateStep.clickPostcardNameDropDown();
        sequence_CreateStep.selectDrillDown(value.get("Messages", "gradient_postcard"));
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_postcard_sequence"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "step_postcard_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_postcard_sequence"));
        if(sequence_Edit.verifySequenceStepAndExpand("POSTCARD", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyPostcardName(value.get("Messages", "gradient_postcard"))==null)
        {
            fail("couldn't find sequence task name");
        }


    }
}
