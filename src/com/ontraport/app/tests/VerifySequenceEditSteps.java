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

public class VerifySequenceEditSteps extends AbstractTest
{
    @Test
    public void testVerifySequenceEditSteps ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();

        sequence_ListAll.formSearch.find("SelRuleDateSequence");
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelRuleDateSequence");
        
        sequence_Edit.clickStats();
        if(sequence_Edit.verifyStatsTitle()==null)
        {
            fail("couldn't find stats title");
        }
        
        sequence_Edit.clickSubscribers();
        if(sequence_Edit.verifySubscriptionsTitle()==null)
        {
            fail("couldn't find subscription title");
        }
      
        sequence_Edit.clickEditSteps();
        if(sequence_Edit.verifyAddAStepTitle()==null)
        {
            fail("couldnt find add a step title");
        }

    }
}
