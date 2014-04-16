package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Task_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class EnsureTaskOutcomeWorksOnCompletion extends AbstractTest
{
    @Test
    public void testEnsureTaskOutcomeWorksOnCompletion ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("Task");
        contact_Create.enterLastName("Outcome");
        contact_Create.enterEmail("task@email.com");
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find("task@email.com");
        
       //verify that the contact Exists
        if(contactListAll.verifyContact("task@email.com")==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_edit = contactListAll.clickContact(1);
        contact_edit.clickNotesAndTasksTab();
        contact_edit.clickNewTask();
        contact_edit.drawerActions.clickTaskNameDropDown();
        Message_CreateTask message_CreateTask = contact_edit.drawerActions.createNewTask();
        message_CreateTask.enterTaskName("TaskOutcomeTest");
        message_CreateTask.enterTaskSubjectName("TaskOutcomeTest");
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
        message_CreateTask.selectDropDownOption("Add Contact to Tag");
        message_CreateTask.clickOutcomeThenDropDown();
        message_CreateTask.selectDropDownOption(value.get("Admin", "tag"));
        message_CreateTask.clickSaveOutcome();
        contact_edit = message_CreateTask.clickSave2();
        contact_edit.drawerActions.clickSend();
        //verify Sel Tag exists
        if(contact_edit.verifyTask("TaskOutcomeTest")==null)
        {
            fail("couldn't find task");
        }
        contact_edit.selectAllTasks();
        contact_edit.clickMarkComplete();
        contact_edit.dialogBox.clickWhatHappenedDropDown();
        contact_edit.dialogBox.selectDrillDown("SelOutcomeForContactThatsAdded" + AbstractSuite.UNIQUE);
        contact_edit.dialogBox.clickMarkComplete();
        contact_edit.clickBack();
        contactListAll.formSearch.find("task@email.com");
        contact_edit = contactListAll.clickContact(1);
        if(contact_edit.verifyTag(value.get("Admin", "tag"))==null)
        {
            fail("couldnt verify outcome");
        }
        contactListAll = contact_edit.menuPrimary.clickContactListAll();
        contactListAll.formSearch.find("task@email.com");
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }

        contactListAll.formSearch.clear();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find("TaskOutcomeTest");
        message_ListAll.selectAllOnPage();
        message_ListAll.drawerActions.clickDeleteMessage();
        message_ListAll.dialogBox.clickOk();
        
        //verify
        if(message_ListAll.verifyNoMessage()==null)
        {
            fail("found deleted message");
        }
        
    }
}
