package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateCustomFieldTaskMessage extends AbstractTest
{
    @Test
    public void testCreateCustomFieldTaskMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateTask message_CreateTask = message_TypeSelection.clickTaskCreate();
        message_CreateTask.enterTaskName(value.get("Messages", "custom_task_message"));
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.enterMergeFieldPane(value.get("Fields", "Long_Text_Field"));
        message_CreateTask.selectDropDownOption(value.get("Fields", "Long_Text_Field"));

        message_ListAll = message_CreateTask.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "custom_task_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "custom_task_message"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "custom_task_message"));
        if(message_Edit.verifyTextArea("[" + value.get("Fields", "Long_Text_Field") + "]")==null)
        {
            fail("couldn't find username");
        }
       

    }
}
