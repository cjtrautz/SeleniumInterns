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

public class EditPostcardFrontAndBackWithText extends AbstractTest
{
    @Test
    public void testEditPostcardFrontAndBackWithText ()
    {
        Values value = new Values();
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        message_Edit.clickNewItem();
        message_Edit.dialogBox.clickTextArea();
        message_Edit.doubleClickInsertText(1);
        message_Edit.enterText(value.get("Messages", "front_text"));
        message_Edit.clickBackView();
        if(message_Edit.verifyBack()==null)
        {
            fail("couldn't find Back");
        }
        message_Edit.clickNewItem();
        message_Edit.dialogBox.clickTextArea();
        message_Edit.doubleClickInsertText(2);
        message_Edit.enterText(value.get("Messages", "back_text"));
        message_Edit.clickSave();
        message_ListAll = message_Edit.clickBack();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "shape_postcard"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        if(message_Edit.verifyPostcardText(value.get("Messages", "front_text"))==null)
        {
            fail("couldn't find front text");
        }
        message_Edit.clickBackView();
        if(message_Edit.verifyPostcardText(value.get("Messages", "back_text"))==null)
        {
            fail("couldn't find back text");
        }

    }
}
