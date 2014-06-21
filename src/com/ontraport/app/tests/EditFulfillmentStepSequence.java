package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.pages.Fulfillment_Edit;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

    public class EditFulfillmentStepSequence extends AbstractTest
    {
        @Test
        public void testEditFulfillmentStepSequence () throws InterruptedException
        {
            Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
            Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
            sequence_ListAll.formSearch.find(value.get("Sequences", "sequence_step_fulfillment"));
            Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "sequence_step_fulfillment"));
           
            if(sequence_Edit.verifySequenceStepAndExpand("FULFILLMENT", 1)==null)
            {
                fail("couldn't find sequence step");
            }
         
            Fulfillment_Edit fulfillment_Edit = sequence_Edit.clickEditFulfillment();

            fulfillment_Edit.enterFulfillmentListName(value.get("Admin", "fulfillment_list_edit"));
            fulfillment_Edit.openSendTimePane();
            fulfillment_Edit.selectTime(value.get("Admin", "fulfillment_time_edit")); // fails right here
            fulfillment_Edit.openFieldPane();
            fulfillment_Edit.selectField("Last Name");
            fulfillment_Edit.enterEmailNotification(value.get("Admin", "fulfillment_email_edit"));
            fulfillment_Edit.enterEmailSubject(value.get("Admin", "fulfillment_email_subject_edit"));
            fulfillment_Edit.enterEmailMessage(value.get("Admin", "fulfillment_email_message_edit"));
            sequence_Edit = fulfillment_Edit.clickSaveToSequence();
            
            // verify values of fulfillment in sequence
            if(sequence_Edit.verifySequenceName(value.get("Sequences", "sequence_edit_fulfillment"))==null)
            {
                fail("couldn't find message body");
            }
            if(sequence_Edit.verifyFulfillmentDropDown(value.get("Admin", "fulfillment_from_sequence"))==null)
            {
                fail("couldnt fine fulfillment");
            }
            
            //save sequence
            sequence_ListAll = sequence_Edit.clickSave();
            
            //go into admin/fulfillments, edit and verify fulfillment
            sequence_ListAll.menuUser.open();
            Account_View account_View = sequence_ListAll.menuUser.clickAdmin();
            Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
            fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_list"));
            
            //verify fulfillment exists
            if(fulfillment_ListAll.verifyFulfillment(value.get("Admin", "fulfillment_list"))==null)
            {
                fail("didnt find fulfillment");
            }
            
            fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
            
            if(fulfillment_Edit.verifyFieldValue(1, "First Name")==null)
            {
                fail("didnt find fulfillment field vale");
            }
            if(fulfillment_Edit.verifyFulfillmentName(value.get("Admin", "fulfillment_list"))==null)
            {
                fail("didnt find fulfillment list name");
            }
            if(fulfillment_Edit.verifySchedular("Daily")==null)
            {
                fail("didnt find fulfillment schedular");
            }
            
          
        }
        
    }