package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageLinkText extends AbstractTest
{
    @Test
    public void testEditEmailMessageLinkText () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        message_Edit.clickText(value.get("Messages", "edited_message_body"));
        message_Edit.clickLinkText();
        message_Edit.ckEditorDialogBox.enterURL("www.ontraport.com");
        message_Edit.ckEditorDialogBox.clickOk(0);
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "email_message"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        if(message_Edit.verifyLinkText(value.get("Messages", "email_message_body"), "www.ontraport.com")==null)
        {
            fail("couldn't find link text");
        }
        message_Edit.clickText(value.get("Messages", "edited_message_body"));
        message_Edit.clickLinkText();
        if(message_Edit.ckEditorDialogBox.verifyURL("www.ontraport.com", 1)==null)
        {
            fail("couldn't find filled out link");
        }
        message_Edit.ckEditorDialogBox.clickOk(1);

    }
}
