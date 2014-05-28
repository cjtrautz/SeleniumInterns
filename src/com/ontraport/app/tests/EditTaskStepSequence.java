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

    public class EditTaskStepSequence extends AbstractTest
    {
        @Test
        public void testEditTaskStepSequence () throws InterruptedException
        {
            Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
            Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
            Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_task_sequence"));

            // verify task info
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