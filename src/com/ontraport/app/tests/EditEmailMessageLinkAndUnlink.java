package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageLinkAndUnlink extends AbstractTest
{
    @Test
    public void testEditEmailMessageLinkAndUnlink () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        message_Edit.highlightText(value.get("Messages", "editable_email_body"));
        message_Edit.clickLinkText();
        message_Edit.ckEditorDialogBox.enterURL("www.ontraport.com");
        message_Edit.ckEditorDialogBox.clickOk(0);
        if(message_Edit.verifyLinkText(value.get("Messages", "editable_email_body"), "www.ontraport.com")==null)
        {
            fail("couldn't find link text");
        }
        message_Edit.clickUnLinkText();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "editable_email_message"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        if(message_Edit.verifyUnLinkText(value.get("Messages", "editable_email_body"))==null)
        {
            fail("couldn't find link text");
        }


    }
}
