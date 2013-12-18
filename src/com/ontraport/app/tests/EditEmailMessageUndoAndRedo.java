package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageUndoAndRedo extends AbstractTest
{
    @Test
    public void testEditEmailMessageUndoAndRedo () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        message_Edit.enterMessageBodyMore(value.get("Messages", "editable_email_message2"));
        if(message_Edit.verifyBody(value.get("Messages", "editable_email_message2"))==null)
        {
            fail("couldn't find message body1");
        }
        message_Edit.clickUndo();
        if(message_Edit.verifyBody(value.get("Messages", "editable_email_body"))==null)
        {
            fail("couldn't find message body2");
        }
        message_Edit.clickRedo();
        if(message_Edit.verifyBody(value.get("Messages", "editable_email_message2"))==null)
        {
            fail("couldn't find message body3");
        }





    }
}
