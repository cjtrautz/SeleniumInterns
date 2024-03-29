package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EnsureDateSequence extends AbstractTest
{
    @Test
    public void testEnsureDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName(value.get("Messages", "email_message_ensure_sequence_date"));
//        message_CreateEmail.enterSendOutName(value.get("Messages", "email_send_out"));
//        message_CreateEmail.enterReplyToEmail(value.get("Messages", "email_reply_to"));
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject(value.get("Messages", "email_ensure_date"));
        message_CreateEmail.enterMessageBody(value.get("Messages", "email_body"));
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.selectMergeField("First Name");
        message_ListAll = message_CreateEmail.clickSave();
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateDate sequence_CreateDate = sequence_TypeSelection.clickDateSequenceCreate();
        //sequence_ListAll = sequence_CreateStep.clickBack();
        //sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        //sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateDate.enterSequenceName(value.get("Sequences", "ensure_date_sequence_fires"));
        sequence_CreateDate.clickAddEmailStep();
        //sequence_CreateDate.enterTodaysDate();
        sequence_CreateDate.clickTimeToSendDropDown();
        sequence_CreateDate.enterNextTime();
        sequence_CreateDate.openEmailNamePane();
        sequence_CreateDate.selectDrillDownEmailName(value.get("Messages", "email_message_ensure_sequence_date"));
        sequence_CreateDate.openEmailFromPane();
        sequence_CreateDate.selectDrillDownByIndex(1);
        sequence_CreateDate.openSendFromPane();
        sequence_CreateDate.selectDropDown("Contact owner");
        sequence_ListAll = sequence_CreateDate.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "ensure_date_sequence_fires"));
        
        //verify Sequence exists
        if(sequence_ListAll.verifySequence(value.get("Sequences", "ensure_date_sequence_fires"))==null)
        {
            fail("couldn't find sequence");
        }
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "ensure_date_sequence_fires"));
        if(sequence_Edit.verifySequenceStepAndExpand("EMAIL", 1)==null)
        {
            fail("couldn't find sequence step");
        }
        if(sequence_Edit.verifyEmailName(value.get("Messages", "email_message_ensure_sequence_date"))==null)
        {
            fail("couldn't find sequence email name");
        }
        if(sequence_Edit.verifySendFrom("Contact owner")==null)
        {
            fail("couldn't find sequence email send from");
        }
        if(sequence_Edit.verifyTodaysDate()==null)
        {
            fail("couldn't find todays date");
        }
        if(sequence_Edit.verifyFutureTime()==null)
        {
            fail("couldn't find future date");
        }
        
        contactListAll = sequence_Edit.menuPrimary.clickContactListAll();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName(value.get("Contacts", "ensure_sequence_date_first"));
        contact_Create.enterLastName(value.get("Contacts", "ensure_sequence_date_last"));
        contact_Create.enterEmail(value.get("Contacts", "ensure_sequence_date_email"));
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find(value.get("Contacts", "ensure_sequence_date_email"));
        
       //verify that the contact Exists
        if(contactListAll.verifyContact(value.get("Contacts", "ensure_sequence_date_email"))==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_Edit = contactListAll.clickContact(value.get("Contacts", "ensure_sequence_date_email"));
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "ensure_sequence_date_email"))==null)
        {
            fail("couldnt find contact email");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "ensure_sequence_date_first"))==null)
        {
            fail("couldnt find contact first name");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "ensure_sequence_date_last"))==null)
        {
            fail("couldnt find contact last name");
        }
        contact_Edit.clickSequenceDropDown();
        contact_Edit.selectDrillDown(value.get("Sequences", "ensure_date_sequence_fires"));
        contactListAll = contact_Edit.clickBack();
        contactListAll = contact_Edit.menuPrimary.clickContactListAll();
        contactListAll.formSearch.find(value.get("Contacts", "ensure_sequence_date_email"));
        
        //verify that the contact Exists
         if(contactListAll.verifyContact(value.get("Contacts", "ensure_sequence_date_email"))==null)
         {
             fail("couldnt find created contact");
         }
         contact_Edit = contactListAll.clickContact(value.get("Contacts", "ensure_sequence_date_email"));
         if(contact_Edit.verifySequence(value.get("Sequences", "ensure_date_sequence_fires"))==null)
         {
             fail("couldnt find contact email");
         }
        



    }
}
