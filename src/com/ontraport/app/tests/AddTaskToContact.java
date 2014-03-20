package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Task_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class AddTaskToContact extends AbstractTest
{
    @Test
    public void testAddTaskToContact ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.formSearch.find(value.get("Contacts", "selenium_email"));
        Contact_Edit contact_edit = contactListAll.clickContact(1);
        contact_edit.clickNotesAndTasksTab();
        contact_edit.clickNewTask();
        contact_edit.drawerActions.clickTaskNameDropDown();
        Message_CreateTask message_CreateTask = contact_edit.drawerActions.createNewTask();
        message_CreateTask.enterTaskName(value.get("Messages", "task_message_add_to_contact"));
        message_CreateTask.enterTaskSubjectName(value.get("Messages", "task_subject_new"));
        message_CreateTask.enterDueDate("1");
        message_CreateTask.clickAssigneeDropDown();
        message_CreateTask.selectDropDownOption("Contact");
        message_CreateTask.clickMergeFieldsDropDown();
        message_CreateTask.selectDropDownOption("First Name");
        message_CreateTask.clickAddNewNotification();
        message_CreateTask.clickWhoDropDown();
        message_CreateTask.selectDropDownOption("Task Assignee");
        message_CreateTask.enterWhenDays("10");
        message_CreateTask.clickAddNewOutcome();
        message_CreateTask.clickOutcomeNameDropDown();
        message_CreateTask.selectCreateNewOutcome();
        message_CreateTask.enterOutcomeName("SelOutcomeForContactThatsAdded" + AbstractSuite.UNIQUE);
        message_CreateTask.clickSelect();
        message_CreateTask.clickOutcomeThenDropDown();
        message_CreateTask.selectDropDownOption("Recharge all declined transactions");
        message_CreateTask.clickSaveOutcome();
        contact_edit = message_CreateTask.clickSave2();
        contact_edit.drawerActions.clickSend();
        //verify Sel Tag exists
        if(contact_edit.verifyTask(value.get("Messages", "task_subject_new"))==null)
        {
            fail("couldn't find task");
        }
        Task_ListAll task_ListAll = contact_edit.menuPrimary.clickTaskListAll();
        if(task_ListAll.verifyTask(value.get("Messages", "task_subject_new"))==null)
        {
            fail("couldn't find task");
        }
        
    }
}
