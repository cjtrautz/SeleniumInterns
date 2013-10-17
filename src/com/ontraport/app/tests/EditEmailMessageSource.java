package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageSource extends AbstractTest
{
    @Test
    public void testEditEmailMessageSource () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        message_Edit.clickSource();
        if(message_Edit.verifySource()==null)
        {
            fail("couldn't find source");
        }
        message_Edit.enterTextArea("<u>This is a Test</u>");
        message_Edit.clickSource();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "email_message"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        if(message_Edit.verifyUnderlinedIframe("This is a Test")==null)
        {
            fail("couldn't find underlined text");
        }


    }
}
