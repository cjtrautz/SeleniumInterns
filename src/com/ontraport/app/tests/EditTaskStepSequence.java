package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
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

    public class EditTaskStepSequence extends AbstractTest
    {
        @Test
        public void testEditTaskStepSequence () throws InterruptedException
        {
            Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
            Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
            sequence_ListAll.formSearch.find(value.get("Sequences", "step_task_sequence"));
            Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_task_sequence"));
           
            if(sequence_Edit.verifySequenceStepAndExpand("TASK", 1)==null)
            {
                fail("couldn't find sequence step");
            }
         
            Message_Edit message_Edit = sequence_Edit.clickEditTask();

            message_Edit.enterTaskSubjectName("This task was edited");
            message_Edit.enterDueDate("20");
            message_Edit.clickAssigneeDropDown();
            message_Edit.selectDropDownOption("Contact");
            message_Edit.clickMergeFieldsDropDown();
            message_Edit.selectDropDownOption("First Name");
            message_Edit.enterWhenDays("20");
            message_Edit.clickAddNewOutcome();
            message_Edit.clickOutcomeNameDropDown();
            message_Edit.selectCreateNewOutcome();
            message_Edit.enterOutcomeName("SelOutcome2-"  + AbstractSuite.UNIQUE);
            message_Edit.clickSelect();
            message_Edit.clickOutcomeThenDropDown();
            message_Edit.selectDropDownOption("Recharge all declined transactions");
            message_Edit.clickSaveOutcome();
            
            sequence_Edit = message_Edit.clickSaveTask();
            sequence_ListAll = sequence_Edit.clickSave();
            sequence_ListAll.formSearch.find(value.get("Sequences", "step_task_sequence"));
            sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_task_sequence"));
            
            // Verify task message IN sequence
            if(sequence_Edit.verifySequenceStepAndExpand("TASK", 1)==null)
            {
                fail("couldn't find sequence step");
            }
            if(sequence_Edit.verifyTaskName(value.get("Messages", "task_message_who"))==null)
            {
                fail("couldn't find sequence task name");
            }
            if(sequence_Edit.verifyTaskDueDate("120")==null)
            {
                fail("couldn't find sequence task due date");
            }
            if(sequence_Edit.verifyAssignee("Contact Owner")==null)
            {
                fail("couldn't find sequence task assignee");
            }

            Message_ListAll message_ListAll = sequence_Edit.menuPrimary.clickMessageListAll();
            message_ListAll.formSearch.find(value.get("Messages", "task_message_who"));
            message_Edit = message_ListAll.clickMessage(value.get("Messages", "task_message_who"));
            
            // Verify task message edits
            if(message_Edit.verifySubjectTask("This task was edited")==null)
            {
                fail("couldn't find sequence task due date");
            }
            if(message_Edit.verifyTaskDueDate("120")==null)
            {
                fail("couldn't find sequence task due date");
            }
            if(message_Edit.verifyAssignee("Contact Owner")==null)
            {
                fail("couldn't find sequence task assignee");
            }
            if(message_Edit.verifyOutcomeByIndex("SelOutcome"  + AbstractSuite.UNIQUE, 1)==null)
            {
                fail("couldn't find sequence task Outcome");
            }
            if(message_Edit.verifyOutcomeByIndex("SelOutcome2-"  + AbstractSuite.UNIQUE, 0)==null)
            {
                fail("couldn't find sequence task Outcome");
            }

          
        }
        
    }