package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_CreatePostcard;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Values;

public class CreatePostcardPictureWithRectangle extends AbstractTest
{
    @Test
    public void testCreatePostcardPictureWithRectangle ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreatePostcard message_CreatePostcard = message_TypeSelection.clickPostcardCreate();
        message_CreatePostcard.enterMessageName(value.get("Messages", "gradient_picture"));
        message_CreatePostcard.clickNewItem();
        message_CreatePostcard.dialogBox.clickPicture();
        message_CreatePostcard.dialogBox.clickUpload();
        message_CreatePostcard.dialogBox.enterURL("https://lh3.googleusercontent.com/-5L0rfiolByw/AAAAAAAAAAI/AAAAAAAAAAA/i9lUvSgKLDM/s48-c-k/photo.jpg");
        message_CreatePostcard.dialogBox.clickGo();
        message_CreatePostcard.dialogBox.selectPicture();
        message_CreatePostcard.dialogBox.insertSelectedImage();
        message_ListAll = message_CreatePostcard.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_picture"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "gradient_picture"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "gradient_picture"));
        if(message_Edit.verifyImageRectangle("http://i.ontraport.com")==null)
        {
            fail("couldn't find body text size");
        }


    }
}
