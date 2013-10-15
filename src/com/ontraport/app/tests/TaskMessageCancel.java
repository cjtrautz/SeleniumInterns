package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class TaskMessageCancel extends AbstractTest
{
    @Test
    public void testTaskMessageCancel ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        Message_CreateTask message_CreateTask = message_TypeSelection.clickTaskCreate();
        message_ListAll = message_CreateTask.clickCancel();
        
        //verify that it exists
        if(message_ListAll.verifyPage()==null)
        {
            fail("couldn't find message list all page");
        }


    }
}
