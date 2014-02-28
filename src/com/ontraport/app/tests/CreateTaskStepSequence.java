package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateTaskStepSequence extends AbstractTest
{
    @Test
    public void testCreateTaskStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName(value.get("Sequences", "step_task_sequence"));
        sequence_CreateStep.clickAddTaskStep();
        sequence_CreateStep.clickTaskNameDropDown();
        sequence_CreateStep.selectDrillDown(value.get("Messages", "task_message_who"));
        sequence_CreateStep.enterDueDateTask("1");
        sequence_CreateStep.openAssigneePane();
        sequence_CreateStep.selectDrillDown("Contact Owner");
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_task_sequence"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "step_task_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_task_sequence"));
        if(sequence_Edit.verifySequenceStepAndExpand("TASK", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyTaskName(value.get("Messages", "task_message_who"))==null)
        {
            fail("couldn't find sequence task name");
        }
        if(sequence_Edit.verifyTaskDueDate("1")==null)
        {
            fail("couldn't find sequence task due date");
        }
        if(sequence_Edit.verifyAssignee("Contact Owner")==null)
        {
            fail("couldn't find sequence task assignee");
        }

    }
}
