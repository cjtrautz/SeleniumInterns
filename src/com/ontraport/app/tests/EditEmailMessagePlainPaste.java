package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessagePlainPaste extends AbstractTest
{
    @Test
    public void testEditEmailMessagePlainPaste () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        message_Edit.clickPlainPaste();
        message_Edit.ckEditorDialogBox.enterIframePasteBody(value.get("Messages", "text_paste_text_body"));
        message_Edit.ckEditorDialogBox.clickOk(0);
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "editable_email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "editable_email_message"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "editable_email_message"));
        if(message_Edit.verifyBody(value.get("Messages", "text_paste_text_body") + value.get("Messages", "text_paste_body") + value.get("Messages", "editable_email_body"))==null)
        {
            fail("couldn't find message body");
        }




    }
}
