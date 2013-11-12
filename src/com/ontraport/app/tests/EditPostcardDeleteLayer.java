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

public class EditPostcardDeleteLayer extends AbstractTest
{
    @Test
    public void testEditPostcardDeleteLayer ()
    {
        Values value = new Values();
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        message_Edit.clickDeleteTextLayer();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "shape_postcard"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        if(message_Edit.verifyNoPostcardText(value.get("Messages", "front_text"))==null)
        {
            fail("found deleted layer");
        }


    }
}
