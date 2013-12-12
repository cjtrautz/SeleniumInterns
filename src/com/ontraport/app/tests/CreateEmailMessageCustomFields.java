package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateEmailMessageCustomFields extends AbstractTest
{
    @Test
    public void testCreateEmailMessageCustomFields ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName(value.get("Messages", "custom_email_message"));
//        message_CreateEmail.enterSendOutName(value.get("Messages", "email_send_out"));
//        message_CreateEmail.enterReplyToEmail(value.get("Messages", "email_reply_to"));
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject(value.get("Messages", "email_subject"));
        message_CreateEmail.enterMessageBody(value.get("Messages", "email_body"));
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.enterMergeFieldPane(value.get("Fields", "Price_Field"));
        message_CreateEmail.selectMergeField(value.get("Fields", "Price_Field"));
        message_ListAll = message_CreateEmail.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "custom_email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "custom_email_message"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "custom_email_message"));
        if(message_Edit.verifyBodyContains("[" + value.get("Fields", "Price_Field") + "]")==null)
        {
            fail("couldn't find custom body");
        }
//        if(message_Edit.verifyReplyTo(value.get("Messages", "email_reply_to"))==null)
//        {
//            fail("couldn't find reply to");
//        }
//        if(message_Edit.verifySendName(value.get("Messages", "email_send_out"))==null)
//        {
//            fail("couldn't find send name");
//        }
        if(message_Edit.verifySubject(value.get("Messages", "email_subject"))==null)
        {
            fail("couldn't find subject");
        }

    }
}
