package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditSMSMessageName extends AbstractTest
{
    @Test
    public void testEditSMSMessageName () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "sms_message"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "sms_message"));
        message_Edit.enterMessageName(value.get("Messages", "sms_message") + " 2");
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "sms_message") + " 2");
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "sms_message") + " 2")==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "sms_message") + " 2");
        message_Edit.enterMessageName(value.get("Messages", "sms_message"));
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "sms_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "sms_message"))==null)
        {
            fail("couldn't find created message");
        }

    }
}
