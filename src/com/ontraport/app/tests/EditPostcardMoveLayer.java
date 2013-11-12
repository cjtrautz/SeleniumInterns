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

public class EditPostcardMoveLayer extends AbstractTest
{
    @Test
    public void testEditPostcardMoveLayer ()
    {
        Values value = new Values();
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        message_Edit.clickMoveTextLayer(100);
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "shape_postcard"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "shape_postcard"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "shape_postcard"));
        if(message_Edit.verifyOrderLayer(1, "SelFrontTe...")==null)
        {
            fail("found wrong order layer1");
        }
        
        if(message_Edit.verifyOrderLayer(2, "Copy ofSel...")==null)
        {
            fail("found wrong order layer2");
        }


    }
}
