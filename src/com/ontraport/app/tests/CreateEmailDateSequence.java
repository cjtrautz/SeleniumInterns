package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEmailDateSequence extends AbstractTest
{
    @Test
    public void testCreateEmailDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateDate sequence_CreateDate = sequence_TypeSelection.clickDateSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateDate.enterSequenceName("SelEmailDateSequence");
        sequence_CreateDate.clickAddEmailStep();
        sequence_CreateDate.clickRadioButtonSpecificEvent();
        sequence_CreateDate.clickEventFieldDropDown();
        sequence_CreateDate.selectDropDown("Birthday");
        sequence_CreateDate.openEmailNamePane();
        sequence_CreateDate.selectDrillDownEmailName("SelEmailMessage");
        sequence_CreateDate.openEmailFromPane();
        sequence_CreateDate.selectDrillDownByIndex(1);
        sequence_CreateDate.openSendFromPane();
        sequence_CreateDate.selectDropDown("Contact Owner");
        sequence_ListAll = sequence_CreateDate.clickSave();
        sequence_ListAll.formSearch.find("SelEmailDateSequence");
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence("SelEmailDateSequence")==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelEmailDateSequence");
        if(sequence_Edit.verifySequenceStepAndExpand("EMAIL", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifySpecificEventSelected()==null)
        {
            fail("specific event not selected");
        }
        if(sequence_Edit.verifyEventFieldDropDown("Birthday")==null)
        {
            fail("event field drop down not birthday");
        }
        if(sequence_Edit.verifyEmailName("SelEmailMessage")==null)
        {
            fail("couldn't find sequence email name");
        }
        if(sequence_Edit.verifySendFrom("Contact Owner")==null)
        {
            fail("couldn't find sequence email send from");
        }
    }
}
