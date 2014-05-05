package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEmailandRuleStepSequenceTestStepControl extends AbstractTest
{
    @Test
    public void testCreateEmailandRuleStepSequenceTestStepControl ()
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
        sequence_CreateStep.selectDrillDownEmailName("SelEmailMessage");
        sequence_CreateStep.openEmailFromPane();
        sequence_CreateStep.selectDrillDownByIndex(1);
        sequence_CreateStep.openSendFromPane();
        sequence_CreateStep.selectDrillDown("Contact owner");
        sequence_CreateStep.clickStepDropDown(2);
        if(sequence_CreateStep.verifyEmailStepMinimized()==null)
        {
            fail("couldn't find minimized step");
        }
        sequence_CreateStep.clickStepDropDown(1);
        if(sequence_CreateStep.verifyEmailStepMaximized()==null)
        {
            fail("couldn't find maximized step");
        }
        sequence_CreateStep.clickAddRuleStep();
        sequence_CreateStep.enterRuleName("Something");
        sequence_CreateStep.clickRuleActionDropDown();
        sequence_CreateStep.selectDrillDown("Recharge all declined transactions");
        sequence_CreateStep.clickStepDropDown(3);
        sequence_CreateStep.clickStepHandleAndMove(1, 60);
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(sequence_CreateStep.verifyEmailStepNumber(2)==null)
        {
            fail("couldn't find step number");
        }
        sequence_CreateStep.clickStepDelete(2);
        sequence_CreateStep.dialogBox.clickYes();
        if(sequence_CreateStep.verifySteps(1)==null)
        {
            fail("couldn't find maximized step");
        }
        
        
    }
}
