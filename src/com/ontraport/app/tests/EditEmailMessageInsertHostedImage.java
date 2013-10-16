package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class EditEmailMessageInsertHostedImage extends AbstractTest
{
    @Test
    public void testEditEmailMessageInsertHostedImage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "email_message"));
        message_Edit.clickCKEditorImage();
        message_Edit.ckEditorDialogBox.clickSelectHostedImage(0);
        //message_Edit.dialogBox.clickUpload();
        message_Edit.dialogBox.enterURL("https://lh3.googleusercontent.com/-5L0rfiolByw/AAAAAAAAAAI/AAAAAAAAAAA/i9lUvSgKLDM/s48-c-k/photo.jpg");
        message_Edit.dialogBox.clickGo();
        message_Edit.dialogBox.selectPicture();
        message_Edit.dialogBox.insertSelectedImage();
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
        if(message_Edit.ckEditorDialogBox.verifyURLContains("http://i.ontraport.com")==null)
        {
            fail("couldn't find url of picture");
        }
        message_Edit.ckEditorDialogBox.clickSelectHostedImage(1);
        message_Edit.dialogBox.clickBrowse();
        message_Edit.dialogBox.selectPicture();
        message_Edit.dialogBox.clickDelete();
        message_Edit.dialogBox.clickBrowse();
        message_Edit.dialogBox.clickCancelPicture();
        message_Edit.ckEditorDialogBox.clickOk(1);
        message_Edit.clickMailImage();
        message_Edit.typeDelete();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "email_message"));

    }
}
