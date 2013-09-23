package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateFulfillmentStepSequence extends AbstractTest
{
    @Test
    public void testCreateFulfillmentStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName("SelFulfillmentStepSequence");
        sequence_CreateStep.clickAddFulfillmentStep();
        sequence_CreateStep.openFulfillmentDropDownPane(1);
        sequence_CreateStep.selectDrillDown("SelFulfillment");
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find("SelFulfillmentStepSequence");
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence("SelFulfillmentStepSequence")==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelFulfillmentStepSequence");
        if(sequence_Edit.verifySequenceStepAndExpand("FULFILLMENT", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyFulfillmentDropDown ()==null)
        {
            fail("didnt select SelFulfillment");
        }

    }
}
