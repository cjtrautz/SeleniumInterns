package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.Alert;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateMessageCancel extends AbstractTest
{
    @Test
    public void testCreateMessageCancel ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName("DontShow");
//        message_CreateEmail.enterSendOutName("DontShow");
//        message_CreateEmail.enterReplyToEmail("DontShow@email.com");
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject("DontShow");
        message_CreateEmail.enterMessageBody("DontShow");
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.selectMergeField("First Name");
        message_ListAll = message_CreateEmail.clickCancel();
        message_ListAll.formSearch.find("DontShow");
        
        //verify that it exists
        if(message_ListAll.verifyNoMessage()==null)
        {
            fail("couldn't find created message");
        }


    }
}
