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

public class EditPostcardHiddenLayer extends AbstractTest
{
    @Test
    public void testEditPostcardHiddenLayer ()
    {
        Values value = new Values();
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        message_Edit.clickHideTextLayer();
        if(message_Edit.verifyNoPostcardText("Copy of" + value.get("Messages", "front_text"))==null)
        {
            fail("couldn't find front text");
        }
        message_Edit.clickShowTextLayer();
        if(message_Edit.verifyPostcardText("Copy of" + value.get("Messages", "front_text"))==null)
        {
            fail("couldn't find front text");
        }


    }
}
