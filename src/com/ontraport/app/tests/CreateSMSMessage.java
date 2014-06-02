package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateSMS;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateSMSMessage extends AbstractTest
{
    @Test
    public void testCreateSMSMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateSMS message_CreateSMS = message_TypeSelection.clickSMSCreate();
        message_CreateSMS.openMergeFieldPane();
        message_CreateSMS.selectMergeField("First Name");
        message_CreateSMS.dialogBox.clickOk();
       message_CreateSMS.enterSMSBody("Sel");
        message_CreateSMS.enterMessageName("SelSMSMessage");
       	message_ListAll = message_CreateSMS.clickSave();
      	 message_ListAll.formSearch.find("SelSMSMessage");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("SelSMSMessage")==null)
        {
           fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage("SelSMSMessage");
        if(message_Edit.verifyTextArea("[First Name]Sel")==null)
        {
            fail("couldn't find message body");
        }

    }
}
