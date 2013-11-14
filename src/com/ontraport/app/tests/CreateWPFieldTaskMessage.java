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
    public void testCreateTaskMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateTask message_CreateTask = message_TypeSelection.clickTaskCreate();
        message_CreateTask.enterTaskName(value.get("Messages", "wp_task_message"));
        message_CreateTask.enterTaskSubjectName("You need to do this");
        message_CreateTask.enterDueDate("1");
        message_CreateTask.clickAssigneeDropDown();
        message_CreateTask.selectDropDownOption("Contact");
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.enterMergeFieldPane("user");
        message_CreateTask.selectDropDownOption("User Name");
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.enterMergeFieldPane("pass");
        message_CreateTask.selectDropDownOption("Password");
        message_CreateTask.clickAddNewNotification();
        message_CreateTask.clickWhoDropDown();
        message_CreateTask.selectDropDownOption("Contact Owner");
        message_CreateTask.clickWhenDropDown();
        message_CreateTask.selectDropDownOption("After Task is Due");
        message_CreateTask.clickAddNewOutcome();
        message_CreateTask.clickOutcomeNameDropDown();
        message_CreateTask.selectCreateNewOutcome();
        message_CreateTask.enterOutcomeName("SelOutcome");
        message_CreateTask.clickSelect();
        message_CreateTask.clickOutcomeThenDropDown();
        message_CreateTask.selectDropDownOption("Recharge all declined transactions");
        message_CreateTask.clickSaveOutcome();
        message_ListAll = message_CreateTask.clickSave();
        message_ListAll.formSearch.find("SelTaskMessage");
        
        //verify that it exists
        if(message_ListAll.verifyMessage("SelTaskMessage")==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickMessage("SelTaskMessage");
        if(message_Edit.verifyOutcome("SelOutcome")==null)
        {
            fail("couldn't find SelOutcome");
        }
        if(message_Edit.verifyTextArea(dateTime)==null)
        {
            fail("couldn't find SelOutcome");
        }
       

    }
}
