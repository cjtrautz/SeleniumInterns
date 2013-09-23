package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateRuleStepSequence extends AbstractTest
{
    @Test
    public void testCreateRuleStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName("SelRuleStepSequence");
        sequence_CreateStep.clickAddRuleStep();
        sequence_CreateStep.enterRuleName("RuleStepTest");
        sequence_CreateStep.openIfPane(1);
        sequence_CreateStep.selectIfOption("If Contact is subscribed to Sequence");
        sequence_CreateStep.openIfPane(1);
        sequence_CreateStep.selectIfOption("Any Sequence");
        sequence_CreateStep.openThenPane(1);
        sequence_CreateStep.selectThenOption("Recharge all declined transactions");
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find("SelRuleStepSequence");
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence("SelRuleStepSequence")==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelRuleStepSequence");
        if(sequence_Edit.verifySequenceStepAndExpand("RULE", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyRuleName("RuleStepTest")==null)
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
    }
}
