package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateTaskFromSequence extends AbstractTest
{
    @Test
    public void testCreateTaskFromSequence () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName(value.get("Sequences", "email_from_sequence"));
        sequence_CreateStep.clickAddTaskStep();
        sequence_CreateStep.clickTaskNameDropDown();
        sequence_CreateStep.clickCreateNewMessage();
        sequence_CreateStep.enterName(value.get("Messages", "message_from_sequence"));
        Message_Edit message_Edit = sequence_CreateStep.clickSaveAndEdit();
        message_Edit.enterTaskSubjectName("You need to do this");
        message_Edit.enterDueDate("1");
        sequence_CreateStep = message_Edit.clickSaveToSequence();
        if(sequence_CreateStep.verifyPage() == null)
        {
            fail("didnt return to sequence editor");
        }
        sequence_CreateStep.openAssigneePane();
        sequence_CreateStep.selectDrillDown("Contact owner");
        sequence_ListAll = sequence_CreateStep.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "email_from_sequence"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "email_from_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "email_from_sequence"));
        if(sequence_Edit.verifySequenceStepAndExpand("TASK", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyTaskName(value.get("Messages", "message_from_sequence"))==null)
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
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "message_from_sequence"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "message_from_sequence"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "message_from_sequence"));
        if(message_Edit.verifySubjectTask("You need to do this")==null) 
        {
            fail("couldn't find subject");
        }
        if(message_Edit.verifyDueDate("1")==null)
        {
            fail("couldn't find due Date");
        }
        
    }
}
