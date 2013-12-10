package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.pages.QueuedMessage_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CancelBroadCast extends AbstractTest
{
    @Test
    public void testCancelBroadCast ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName(value.get("Messages", "broadcast_cancel"));
//        message_CreateEmail.enterSendOutName(value.get("Messages", "email_send_out"));
//        message_CreateEmail.enterReplyToEmail(value.get("Messages", "email_reply_to"));
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject(value.get("Messages", "broadcast_cancel"));
        message_CreateEmail.enterMessageBody(value.get("Messages", "email_body"));
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.selectMergeField("First Name");
        message_ListAll = message_CreateEmail.clickSave();
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName(value.get("Contacts", "no_first_name"));
        contact_Create.enterLastName(value.get("Contacts", "no_last_name"));
        contact_Create.enterEmail(value.get("Contacts", "no_email_adress"));
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find(value.get("Contacts", "no_email_adress"));
        
       //verify that the contact Exists
        if(contactListAll.verifyContact(value.get("Contacts", "no_email_adress"))==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_Edit = contactListAll.clickContact(value.get("Contacts", "no_email_adress"));
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "no_email_adress"))==null)
        {
            fail("couldnt find contact email");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "no_first_name"))==null)
        {
            fail("couldnt find contact first name");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "no_last_name"))==null)
        {
            fail("couldnt find contact last name");
        }
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName(value.get("Contacts", "no_first_name2"));
        contact_Create.enterLastName(value.get("Contacts", "no_last_name2"));
        contact_Create.enterEmail(value.get("Contacts", "no_email_adress2"));
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find(value.get("Contacts", "no_email_adress2"));
        
       //verify that the contact Exists
        if(contactListAll.verifyContact(value.get("Contacts", "no_email_adress2"))==null)
        {
            fail("couldnt find created contact");
        }
        contact_Edit = contactListAll.clickContact(value.get("Contacts", "no_email_adress2"));
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "no_email_adress2"))==null)
        {
            fail("couldnt find contact email");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "no_first_name2"))==null)
        {
            fail("couldnt find contact first name");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "no_last_name2"))==null)
        {
            fail("couldnt find contact last name");
        }
        contactListAll = contact_Edit.menuPrimary.clickContactListAll();
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickSendEmail();
        contactListAll.drawerActions.clickEmailNameDropDown();
        contactListAll.drawerActions.selectDrillDown(value.get("Messages", "broadcast_cancel"));
        contactListAll.drawerActions.clickSendFromDropDown();
        contactListAll.drawerActions.selectDropDown(1);
        //contactListAll.drawerActions.enterTodaysDate();
        //contactListAll.drawerActions.clickAtDropDown();
        //contactListAll.drawerActions.selectFutureHour();
        contactListAll.drawerActions.clickSend();

        
        //verify its gone
        if(contactListAll.verifyQued()==null)
        {
            fail("didnt que send");
        }
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        QueuedMessage_ListAll queuedMessage_ListAll = contact_Settings.clickScheduledBroadCasts();
        queuedMessage_ListAll.formSearch.find(value.get("Messages", "broadcast_cancel"));
        queuedMessage_ListAll.clickSelectAll();
        queuedMessage_ListAll.drawerActions.clickCancel();
        queuedMessage_ListAll.dialogBox.clickOk();
        if(queuedMessage_ListAll.verifyNoMessages()==null)
        {
            fail("found deleted broadcasts");
        }

    }
}
