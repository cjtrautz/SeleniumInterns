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

public class EditPostcardAlignLeft extends AbstractTest
{
    @Test
    public void testEditPostcardAlignLeft ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find("SelMessageTestingPostcard");

        Message_Edit message_Edit = message_ListAll.clickMessage("SelMessageTestingPostcard");
        message_Edit.doubleClickText("test text");
        message_Edit.highlightTextRight("test text");
        message_Edit.clickAlignLeft();
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find("SelMessageTestingPostcard");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("SelMessageTestingPostcard")==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage("SelMessageTestingPostcard");
        if(message_Edit.verifyAlignedLeft("test text")==null)
        {
            fail("couldn't find bold text");
        }


    }
}
