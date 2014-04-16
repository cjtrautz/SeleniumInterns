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

public class CreatePostcardAndEditFontSize extends AbstractTest
{
    @Test
    public void testCreatePostcardAndEditFontSize ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreatePostcard message_CreatePostcard = message_TypeSelection.clickPostcardCreate();
        message_CreatePostcard.enterMessageName("SelMessageTestingPostcard");
        message_CreatePostcard.clickNewItem();
        message_CreatePostcard.dialogBox.clickTextArea();
        message_CreatePostcard.doubleClickInsertText();
        message_CreatePostcard.enterText("test text");
        message_CreatePostcard.doubleClickText("test text");
        message_CreatePostcard.clickFontDropDown();
        message_CreatePostcard.selectSize("3");
        message_ListAll = message_CreatePostcard.clickSave();
        message_ListAll.formSearch.find("SelMessageTestingPostcard");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("SelMessageTestingPostcard")==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage("SelMessageTestingPostcard");
        if(message_Edit.verifyTextSize("32")==null)
        {
            fail("couldn't find body text size");
        }


    }
}
