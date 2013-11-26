package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class SendBroadcastEmailToContact extends AbstractTest
{
    @Test
    public void testSendBroadcastEmailToContact ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName(value.get("Messages", "email_message_send2"));
        message_CreateEmail.enterSendOutName(value.get("Messages", "email_send_out"));
        message_CreateEmail.enterReplyToEmail(value.get("Messages", "email_reply_to"));
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject(value.get("Messages", "email_subject_broadcast"));
        message_CreateEmail.enterMessageBody(value.get("Messages", "email_body"));
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.selectMergeField("First Name");
        message_ListAll = message_CreateEmail.clickSave();
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName(value.get("Contacts", "my_first_name3"));
        contact_Create.enterLastName(value.get("Contacts", "my_last_name3"));
        contact_Create.enterEmail(value.get("Contacts", "my_email_adress3"));
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find(value.get("Contacts", "my_email_adress3"));
        
       //verify that the contact Exists
        if(contactListAll.verifyContact(value.get("Contacts", "my_email_adress3"))==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_Edit = contactListAll.clickContact(value.get("Contacts", "my_email_adress3"));
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "my_email_adress3"))==null)
        {
            fail("couldnt find contact email");
        }
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName(value.get("Contacts", "my_first_name2"));
        contact_Create.enterLastName(value.get("Contacts", "my_last_name2"));
        contact_Create.enterEmail(value.get("Contacts", "my_email_adress2"));
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find(value.get("Contacts", "my_email_adress2"));
        
       //verify that the contact Exists
        if(contactListAll.verifyContact(value.get("Contacts", "my_email_adress2"))==null)
        {
            fail("couldnt find created contact");
        }
        contact_Edit = contactListAll.clickContact(value.get("Contacts", "my_email_adress2"));
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "my_email_adress2"))==null)
        {
            fail("couldnt find contact email");
        }
        contactListAll = contact_Edit.menuPrimary.clickContactListAll();
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickSendEmail();
        contactListAll.drawerActions.clickEmailNameDropDown();
        contactListAll.drawerActions.selectDrillDown(value.get("Messages", "email_message_send2"));
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
        
       
        


    }
}
