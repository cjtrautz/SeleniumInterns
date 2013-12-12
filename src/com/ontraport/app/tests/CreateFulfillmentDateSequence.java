package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateFulfillmentDateSequence extends AbstractTest
{
    @Test
    public void testCreateFulfillmentDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateDate sequence_CreateDate = sequence_TypeSelection.clickDateSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateDate.enterSequenceName(value.get("Sequences", "fulfillment_date"));
        sequence_CreateDate.clickAddFulfillmentStep();
        sequence_CreateDate.clickRadioButtonSpecificEvent();
        sequence_CreateDate.clickEventFieldDropDown();
        sequence_CreateDate.selectDropDown("Birthday");
        sequence_CreateDate.openFulfillmentDropDownPane(1);
        sequence_CreateDate.selectDrillDown(value.get("Admin", "fulfillment_list"));
        sequence_ListAll = sequence_CreateDate.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "fulfillment_date"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "fulfillment_date"))==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "fulfillment_date"));
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
