package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateCopyOfSMSMessage extends AbstractTest
{
    @Test
    public void testCreateCopyOfSMSMessage () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        message_TypeSelection.clickSMSDropDown();
        Message_Edit message_edit = message_TypeSelection.selectSMSCopyOption(value.get("Messages", "sms_message"));
        message_ListAll = message_edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "copy_of_sms_message"));
        if(message_ListAll.verifyMessage(value.get("Messages", "copy_of_sms_message"))==null)
        {
            fail("couldnt find copy of sms");
        }
        message_edit = message_ListAll.clickMessage(value.get("Messages", "copy_of_sms_message"));
        if(message_edit.verifyName(value.get("Messages", "copy_of_sms_message"))==null)
        {
            fail("couldnt find message name");
        }
    }
}
