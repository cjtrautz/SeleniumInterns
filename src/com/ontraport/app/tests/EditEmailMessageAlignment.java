package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageAlignment extends AbstractTest
{
    @Test
    public void testEditEmailMessageAlignment () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        message_Edit.clickText(value.get("Messages", "email_message_body"));
        message_Edit.clickAlignCenterEmail();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "email_message"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        if(message_Edit.verifyCentered(value.get("Messages", "email_message_body"))==null)
        {
            fail("couldn't find centered text");
        }


    }
}
