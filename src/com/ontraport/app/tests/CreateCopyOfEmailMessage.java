package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateCopyOfEmailMessage extends AbstractTest
{
    @Test
    public void testCreateCopyOfEmailMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        message_TypeSelection.clickEmailCopy();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.selectEmailCopyOption("SelEmailMessage");
        message_ListAll = message_CreateEmail.clickSave();
        message_ListAll.formSearch.find("Copy of SelEmailMessage");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("Copy of SelEmailMessage")==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage("Copy of SelEmailMessage");
//        if(message_Edit.verifyReplyTo("selenium@email.com")==null)
//        {
//            fail("couldn't find reply to");
//        }
//        if(message_Edit.verifySendName("Selenium")==null)
//        {
//            fail("couldn't find send name");
//        }
        if(message_Edit.verifySubject(value.get("Messages", "edited_message_subject"))==null)
        {
            fail("couldn't find subject");
        }

    }
}
