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

public class CreatePostcardGradientWithRectangle extends AbstractTest
{
    @Test
    public void testCreatePostcardGradientWithRectangle ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreatePostcard message_CreatePostcard = message_TypeSelection.clickPostcardCreate();
        message_CreatePostcard.enterMessageName(value.get("Messages", "gradient_postcard"));
        message_CreatePostcard.clickNewItem();
        message_CreatePostcard.dialogBox.clickGradient();
        message_ListAll = message_CreatePostcard.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_postcard"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "gradient_postcard"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "gradient_postcard"));
        if(message_Edit.verifyGradientRectangle()==null)
        {
            fail("couldn't find body text size");
        }


    }
}
