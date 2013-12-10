package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEditableEmailMessage extends AbstractTest
{
    @Test
    public void testCreateEditableEmailMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName(value.get("Messages", "editable_email_message"));
//        message_CreateEmail.enterSendOutName(value.get("Messages", "email_send_out"));
//        message_CreateEmail.enterReplyToEmail(value.get("Messages", "email_reply_to"));
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject(value.get("Messages", "email_subject"));
        message_CreateEmail.clickSource();
        message_CreateEmail.enterMessageBodySource(value.get("Messages", "source_editable_email_body"));
        message_ListAll = message_CreateEmail.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "editable_email_message"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        if(message_Edit.verifyBoldIFrame(value.get("Messages", "editable_email_body"))==null) 
        {
            fail("couldn't find message body");
        }
        message_CreateEmail.clickSource();
        if(message_Edit.verifySourceText(value.get("Messages", "source_editable_email_body"))==null)
        {
            fail("couldn't find message body");
        }
        if(message_Edit.verifyReplyTo(value.get("Messages", "email_reply_to"))==null)
        {
            fail("couldn't find reply to");
        }
        if(message_Edit.verifySendName(value.get("Messages", "email_send_out"))==null)
        {
            fail("couldn't find send name");
        }
        if(message_Edit.verifySubject(value.get("Messages", "email_subject"))==null)
        {
            fail("couldn't find subject");
        }

    }
}
