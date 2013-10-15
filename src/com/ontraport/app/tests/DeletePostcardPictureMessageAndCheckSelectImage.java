package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeletePostcardPictureMessageAndCheckSelectImage extends AbstractTest
{
    @Test
    public void testDeletePostcardPictureMessageAndCheckSelectImage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_picture"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "gradient_picture"));
        message_Edit.clickImage();
        message_Edit.clickSelectImage();
        message_Edit.dialogBox.clickBrowse();
        message_Edit.dialogBox.selectPicture();
        message_Edit.dialogBox.clickDelete();
        message_Edit.dialogBox.clickBrowse();
        message_Edit.dialogBox.clickCancelPicture();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_picture"));
        message_ListAll.selectAllOnPage();
        message_ListAll.drawerActions.clickDeleteMessage();
        message_ListAll.dialogBox.clickOk();
        
        //verify
        if(message_ListAll.verifyNoMessage()==null)
        {
            fail("found deleted message");
        }
        
    }
}
