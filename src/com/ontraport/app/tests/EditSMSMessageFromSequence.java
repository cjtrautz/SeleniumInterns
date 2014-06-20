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

    public class EditSMSMessageFromSequence extends AbstractTest
    {
        @Test
        public void testEditSMSMessageFromSequence () throws InterruptedException
        {
            Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
            Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
            sequence_ListAll.formSearch.find(value.get("Sequences", "sms_from_sequence"));
            Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "sms_from_sequence"));
           
            // Verify SMS message Preview in Sequence
            if(sequence_Edit.verifySequenceStepAndExpand("SMS TEXT", 1)==null)
            {
                fail("couldn't find sequence step");
            }
         
            Message_Edit message_Edit = sequence_Edit.clickEditSMS();
            
            message_Edit.enterName(value.get("Messages", "sms_from_sequence_edit"));
            message_Edit.openMergeFieldPane();
            message_Edit.selectMergeField("Last Name");
            message_Edit.dialogBox.clickOk();
            message_Edit.sendSMSBody("SelEDIT");
            
            sequence_Edit = message_Edit.clickSMSSaveToSequence();
            
            // Verify SMS message Preview in Sequence
            if(sequence_Edit.verifyPreviewData("[Last Name][First Name]SelSelEDIT")==null)
            {
                fail("couldn't find message body");
            }
            if(sequence_Edit.verifySequenceName(value.get("Sequences", "sms_from_sequence"))==null)
            {
                fail("couldn't find message body");
            }
            
            Message_ListAll message_ListAll = sequence_Edit.menuPrimary.clickMessageListAll();
            message_ListAll.formSearch.find(value.get("Messages", "sms_from_sequence_edit"));
            
            // Verify SMS message in Collection
            if(message_ListAll.verifyMessage(value.get("Messages", "sms_from_sequence_edit"))==null)
            {
               fail("couldn't find created message");
            }
            
            message_Edit = message_ListAll.clickMessage(value.get("Messages", "sms_from_sequence_edit"));
            
            // Verify SMS message edits
            if(message_Edit.verifyTextArea("[Last Name][First Name]SelSelEDIT")==null)
            {
                fail("couldn't find message body");
            }
            
            if(message_Edit.verifyMessageName("[Last Name][First Name]SelSelEDIT")==null)
            {
                fail("couldn't find message body");
            }

            
//            // Verify task message IN sequence
//            if(sequence_Edit.verifyTaskName(value.get("Messages", "task_message_who_edit2"))==null)
//            {
//                fail("couldn't find sequence task name");
//            }
//            if(sequence_Edit.verifyTaskDueDate("120")==null)
//            {
//                fail("couldn't find sequence task due date");
//            }
//            if(sequence_Edit.verifyAssignee("Contact Owner")==null)
//            {
//                fail("couldn't find sequence task assignee");
//            }
//            
//            message_Edit = sequence_Edit.clickEditTask();
//            
//            // Verify task message edits
//            if(message_Edit.verifyTaskDueDate("120")==null)
//            {
//                fail("couldn't find sequence task due date");
//            }
//            if(message_Edit.verifyAssignee("Contact Owner")==null)
//            {
//                fail("couldn't find sequence task assignee");
//            }
//            if(message_Edit.verifyOutcome("SelOutcome"  + AbstractSuite.UNIQUE)==null)
//            {
//                fail("couldn't find sequence task Outcome");
//            }
//            if(message_Edit.verifyOutcome("SelOutcome2-"  + AbstractSuite.UNIQUE)==null)
//            {
//                fail("couldn't find sequence task Outcome");
//            }

          
        }
        
    }