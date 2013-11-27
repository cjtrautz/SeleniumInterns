package com.ontraport.app.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTaskStepSequence extends AbstractTest
{
    @Test
    public void testDeleteTaskStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_task_sequence"));
        sequence_ListAll.selectAllOnPage();
        sequence_ListAll.drawerActions.clickDeleteSequences();
        sequence_ListAll.dialogBox.clickOk();
        //verify
        if(sequence_ListAll.verifyNoSequence()==null)
        {
            fail("found deleted sequence");
        }
        
        
    }
}
