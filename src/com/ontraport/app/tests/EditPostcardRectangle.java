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

public class EditPostcardRectangle extends AbstractTest
{
    @Test
    public void testEditPostcardRectangle ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find("SelPostcardMessage");

        Message_Edit message_Edit = message_ListAll.clickMessage("SelPostcardMessage");
        message_Edit.clickShape();
        message_Edit.clickRectangle();
        message_Edit.clickSave();
        message_ListAll = message_Edit.clickBack();
        message_ListAll.formSearch.find("SelPostcardMessage");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("SelPostcardMessage")==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage("SelPostcardMessage");
        if(message_Edit.verifyRectangle()==null)
        {
            fail("couldn't find rectangle");
        }


    }
}
