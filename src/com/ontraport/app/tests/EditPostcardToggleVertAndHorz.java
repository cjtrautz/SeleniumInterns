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

public class EditPostcardToggleVertAndHorz extends AbstractTest
{
    @Test
    public void testEditPostcardToggleVertAndHorz ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_postcard"));

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "gradient_postcard"));
        message_Edit.clickShape();
        message_Edit.clickVertical();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_postcard"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "gradient_postcard"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "gradient_postcard"));
        if(message_Edit.verifyVertical()==null)
        {
            fail("couldn't find verticle");
        }
        message_Edit.clickShape();
        message_Edit.clickHorizontal();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "gradient_postcard"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "gradient_postcard"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "gradient_postcard"));
        if(message_Edit.verifyHorizontal()==null)
        {
            fail("couldn't find verticle");
        }


    }
}
