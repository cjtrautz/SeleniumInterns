package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageSubject extends AbstractTest
{
    @Test
    public void testEditEmailMessageSubject () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        message_Edit.enterSubject(value.get("Messages", "new_editable_email_message"));
        message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        
        if(message_Edit.verifySubject(value.get("Messages", "new_editable_email_message"))==null) 
        {
            fail("couldn't find message body");
        }
        message_Edit.enterSubject(value.get("Messages", "email_subject"));
        message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        if(message_Edit.verifySubject(value.get("Messages", "email_subject"))==null) 
        {
            fail("couldn't find message body");
        }

    }
}
