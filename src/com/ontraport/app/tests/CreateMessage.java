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

public class CreateMessage extends AbstractTest
{
    @Test
    public void testCreateMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName("SelEmailMessage");
//        message_CreateEmail.enterSendOutName("Selenium");
//        message_CreateEmail.enterReplyToEmail("selenium@email.com");
        message_CreateEmail.openSendFromPane();
        message_CreateEmail.selectSendFrom(1);
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject("SelSubject");
        message_CreateEmail.enterMessageBody("SelBody");
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.selectMergeField("First Name");
        message_CreateEmail.clickCopyFromHTML();
        message_CreateEmail.dialogBox.clickYes2();
        message_ListAll = message_CreateEmail.clickSave();
        message_ListAll.formSearch.find("SelEmailMessage");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("SelEmailMessage")==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage("SelEmailMessage");
        if(message_Edit.verifyBody("[First Name]SelBody")==null)
        {
            fail("couldn't find message body");
        }
        if(message_Edit.verifyPlainTextBody("[First Name]")==null)
        {
            fail("couldn't find message body");
        }
        if(message_Edit.verifyPlainTextBody("SelBody")==null)
        {
            fail("couldn't find message body");
        }
//        if(message_Edit.verifyReplyTo("selenium@email.com")==null)
//        {
//            fail("couldn't find reply to");
//        }
//        if(message_Edit.verifySendName("Selenium")==null)
//        {
//            fail("couldn't find send name");
//        }
        if(message_Edit.verifySubject("SelSubject")==null)
        {
            fail("couldn't find subject");
        }

    }
}
