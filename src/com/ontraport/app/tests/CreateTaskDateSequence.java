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

public class CreateTaskDateSequence extends AbstractTest
{
    @Test
    public void testCreateTaskDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateDate sequence_CreateDate = sequence_TypeSelection.clickDateSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateDate.enterSequenceName(value.get("Sequences", "date_task_sequence"));
        sequence_CreateDate.clickAddTaskStep();
        sequence_CreateDate.clickRadioButtonSpecificEvent();
        sequence_CreateDate.clickEventFieldDropDown();
        sequence_CreateDate.selectDropDown("Birthday");
        sequence_CreateDate.clickTaskNameDropDown();
        sequence_CreateDate.selectDrillDown(value.get("Messages", "task_message_who"));
        sequence_CreateDate.enterDueDateTask("1");
        sequence_CreateDate.openAssigneePane();
        sequence_CreateDate.selectDrillDown("Contact owner");
        sequence_ListAll = sequence_CreateDate.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "date_task_sequence"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "date_task_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "date_task_sequence"));
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
        if(sequence_Edit.verifyAssignee("Contact owner")==null)
        {
            fail("couldn't find sequence task assignee");
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
