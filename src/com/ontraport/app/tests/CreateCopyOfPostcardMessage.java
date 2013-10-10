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

public class CreateCopyOfPostcardMessage extends AbstractTest
{
    @Test
    public void testCreateCopyOfPostcardMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        message_TypeSelection.clickPostcardCopy();
        Message_CreatePostcard message_CreatePostcard = message_TypeSelection.selectPostcardCopyOption("SelPostcardMessage");
        message_ListAll = message_CreatePostcard.clickSave();
        message_ListAll.formSearch.find("Copy of SelPostcardMessage");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("Copy of SelPostcardMessage")==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage("Copy of SelPostcardMessage");
        if(message_Edit.verifyShape()==null)
        {
            fail("couldn't find message body");
        }


    }
}
