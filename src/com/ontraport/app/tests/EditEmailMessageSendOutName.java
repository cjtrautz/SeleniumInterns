package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageSendOutName extends AbstractTest
{
    @Test
    public void testEditEmailMessageSendOutName () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        message_Edit.enterSendOutName(value.get("Messages", "new_editable_email_message"));
        message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        
        if(message_Edit.verifySendName(value.get("Messages", "new_editable_email_message"))==null) 
        {
            fail("couldn't find message body");
        }
        message_Edit.enterSendOutName(value.get("Messages", "email_send_out"));
        message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        if(message_Edit.verifySendName(value.get("Messages", "email_send_out"))==null) 
        {
            fail("couldn't find message body");
        }

    }
}
