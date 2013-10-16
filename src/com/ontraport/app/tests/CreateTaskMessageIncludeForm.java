package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateTaskMessageIncludeForm extends AbstractTest
{
    @Test
    public void testCreateTaskMessageIncludeForm ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "task_message_notifications"));
        Message_Edit message_Edit = message_ListAll.clickMessage(value.get("Messages", "task_message_notifications"));
        message_Edit.clickTaskFormDropDown();
        message_Edit.selectDropDownOption(value.get("SmartForms", "orderForm"));
        message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find(value.get("Messages", "task_message_notifications"));
        
        //verify that it exists
        if(message_ListAll.verifyMessage(value.get("Messages", "task_message_notifications"))==null)
        {
            fail("couldn't find created message");
        }

        message_Edit = message_ListAll.clickMessage(value.get("Messages", "task_message_notifications"));
        if(message_Edit.verifyForm(value.get("SmartForms", "orderForm"))==null)
        {
            fail("couldn't find form");
        }

       

    }
}
