package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateWPFieldTaskMessage extends AbstractTest
{
    @Test
    public void testCreateWPFieldTaskMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateTask message_CreateTask = message_TypeSelection.clickTaskCreate();
        message_CreateTask.enterTaskName(value.get("Messages", "wp_task_message"));
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.enterMergeFieldPane("User");
        message_CreateTask.selectDropDownOption("User Name");
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.enterMergeFieldPane("Pass");
        message_CreateTask.selectDropDownOption("Password");
        message_ListAll = message_CreateTask.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "wp_task_message"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "wp_task_message"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "wp_task_message"));
        if(message_Edit.verifyTextAreaContains("username")==null)
        {
            fail("couldn't find username");
        }
        if(message_Edit.verifyTextAreaContains("password")==null)
        {
            fail("couldn't find password");
        }
       

    }
}
