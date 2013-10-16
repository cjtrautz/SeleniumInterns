package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateTaskMessageBeforeDue extends AbstractTest
{
    @Test
    public void testCreateTaskMessageBeforeDue ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateTask message_CreateTask = message_TypeSelection.clickTaskCreate();
        message_CreateTask.enterTaskName(value.get("Messages", "task_message_notifications"));
        message_CreateTask.enterTaskSubjectName("You need to do this");
        message_CreateTask.enterDueDate("1");
        message_CreateTask.clickAssigneeDropDown();
        message_CreateTask.selectDropDownOption("Contact");
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.selectDropDownOption("First Name");
        message_CreateTask.clickAddNewNotification();
        message_CreateTask.clickWhoDropDown();
        message_CreateTask.selectDropDownOption("Contact Owner");
        message_CreateTask.clickWhenDropDown();
        message_CreateTask.selectDropDownOption("Before Task is Due");
        message_ListAll = message_CreateTask.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "task_message_notifications"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "task_message_notifications"))==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "task_message_notifications"));
        if(message_Edit.verifyWhen("Before Task is Due")==null)
        {
            fail("couldn't find Before Task is Due");
        }
       

    }
}
