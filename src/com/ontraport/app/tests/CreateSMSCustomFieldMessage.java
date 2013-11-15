package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateSMS;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateSMSCustomFieldMessage extends AbstractTest
{
    @Test
    public void testCreateSMSCustomFieldMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateSMS message_CreateSMS = message_TypeSelection.clickSMSCreate();
        message_CreateSMS.openMergeFieldPane();
        message_CreateSMS.enterMergeFieldInput(value.get("Fields", "Long_Text_Field"));
        message_CreateSMS.selectMergeField2(value.get("Fields", "Long_Text_Field"));
        message_CreateSMS.enterMessageName(value.get("Messages", "custom_sms_message"));
        message_ListAll = message_CreateSMS.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "custom_sms_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "custom_sms_message"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "custom_sms_message"));
        if(message_Edit.verifyTextArea("[" + value.get("Fields", "Long_Text_Field") + "]")==null)
        {
            fail("couldn't find message body");
        }

    }
}
