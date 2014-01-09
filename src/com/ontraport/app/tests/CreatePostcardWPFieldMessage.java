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

public class CreatePostcardWPFieldMessage extends AbstractTest
{
    @Test
    public void testCreatePostcardWPFieldMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreatePostcard message_CreatePostcard = message_TypeSelection.clickPostcardCreate();
        message_CreatePostcard.enterMessageName(value.get("Messages", "wp_postcard_message"));
        message_CreatePostcard.clickNewItem();
        message_CreatePostcard.dialogBox.clickTextArea();
        message_CreatePostcard.doubleClickInsertText();
        message_CreatePostcard.clickMergeFieldDropDown();
        message_CreatePostcard.enterMergeFieldPane("User");
        message_CreatePostcard.selectDropDownOption("User Name");
        message_CreatePostcard.clickMergeFieldDropDown();
        message_CreatePostcard.enterMergeFieldPane("Pass");
        message_CreatePostcard.selectDropDownOption("Password");
        message_ListAll = message_CreatePostcard.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "wp_postcard_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "wp_postcard_message"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "wp_postcard_message"));
        if(message_Edit.verifyPostcardTextAreaContains("username")==null)
        {
            fail("couldn't find message username");
        }
        if(message_Edit.verifyPostcardTextAreaContains("password")==null)
        {
            fail("couldn't find message password");
        }


    }
}
