package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageInsertImage extends AbstractTest
{
    @Test
    public void testEditEmailMessageInsertImage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        message_Edit.clickCKEditorImage();
        message_Edit.ckEditorDialogBox.enterURL("https://lh3.googleusercontent.com/-5L0rfiolByw/AAAAAAAAAAI/AAAAAAAAAAA/i9lUvSgKLDM/s48-c-k/photo.jpg");
        message_Edit.ckEditorDialogBox.clickOk(0);
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "email_message"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        message_Edit.clickMailImage();
        message_Edit.clickCKEditorImage();
        if(message_Edit.ckEditorDialogBox.verifyURL("https://lh3.googleusercontent.com/-5L0rfiolByw/AAAAAAAAAAI/AAAAAAAAAAA/i9lUvSgKLDM/s48-c-k/photo.jpg", 1)==null)
        {
            fail("couldn't find url of picture");
        }
        message_Edit.ckEditorDialogBox.clickOk(1);
        message_Edit.clickMailImage();
        message_Edit.typeDelete();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));


    }
}
