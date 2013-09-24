package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateCopyOfTaskMessage extends AbstractTest
{
    @Test
    public void testCreateCopyOfTaskMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        message_TypeSelection.clickTaskCopy();
        Message_CreateTask message_CreateTask = message_TypeSelection.selectTaskCopyOption("SelTaskMessage");
        message_ListAll = message_CreateTask.clickSave();
        message_ListAll.formSearch.find("Copy of SelTaskMessage");
        
      //verify that it exists
        if(message_ListAll.verifyMessage("Copy of SelTaskMessage")==null)
        {
            fail("couldn't find created message");
        }

        Message_Edit message_Edit = message_ListAll.clickSequence("Copy of SelTaskMessage");
        if(message_Edit.verifyOutcome("SelOutcome")==null)
        {
            fail("couldn't find SelOutcome");
        }

    }
}
