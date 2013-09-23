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

public class CreateRuleDateSequence extends AbstractTest
{
    @Test
    public void testCreateRuleDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateDate sequence_CreateDate = sequence_TypeSelection.clickDateSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateDate.enterSequenceName("SelRuleDateSequence");
        sequence_CreateDate.clickAddRuleStep();
        sequence_CreateDate.clickRadioButtonSpecificEvent();
        sequence_CreateDate.clickEventFieldDropDown();
        sequence_CreateDate.selectDropDown("Birthday");
        sequence_CreateDate.enterRuleName("RuleDateTest");
        sequence_CreateDate.openIfPane(1);
        sequence_CreateDate.selectIfOption("If Contact is subscribed to Sequence");
        sequence_CreateDate.openIfPane(1);
        sequence_CreateDate.selectIfOption("Any Sequence");
        sequence_CreateDate.openThenPane(1);
        sequence_CreateDate.selectThenOption("Recharge all declined transactions");
        sequence_ListAll = sequence_CreateDate.clickSave();
        sequence_ListAll.formSearch.find("SelRuleDateSequence");
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence("SelRuleDateSequence")==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelRuleDateSequence");
        if(sequence_Edit.verifySequenceStepAndExpand("RULE", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyRuleName("RuleDateTest")==null)
        {
            fail("couldn't find sequence rule name");
        }
        if(sequence_Edit.verifyIfText("If Contact is subscribed to Sequence:")==null)
        {
            fail("didnt select if contact is subscribed to sequence");
        }
        if(sequence_Edit.verifyIfDropDownInputs ("Any Sequence", 1)==null)
        {
            fail("didnt select any sequence");
        }
        if(sequence_Edit.verifyThenText("Recharge all declined transactions")==null)
        {
            fail("didnt select recharg all declined transactions");
        }
        if(sequence_Edit.verifySpecificEventSelected()==null)
        {
            fail("specific event not selected");
        }
        if(sequence_Edit.verifyEventFieldDropDown("Birthday")==null)
        {
            fail("event field drop down not birthday");
        }

    }
}
