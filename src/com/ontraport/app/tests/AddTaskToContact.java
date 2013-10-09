package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.ApiSettings_ListAll;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_Create;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddTaskToContact extends AbstractTest
{
    @Test
    public void testAddTagToContact ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Edit contact_edit = contactListAll.clickContact(1);
        contact_edit.clickNotesAndTasksTab();
//        contact_edit.clickNewTask();
//        contact_edit.drawerActions.clickTaskNameDropDown();
//        contact_edit.drawerActions.selectDrillDown("SelTaskMessage");
//        contact_edit.drawerActions.clickSend();
//        //verify Sel Tag exists
//        if(contact_Edit.verifyTag("SelTag")==null)
//        {
//            fail("couldn't find tag");
//        }
//        contact_Edit.deleteTag("SelTag");
//        if(contact_Edit.verifyNoTag("SelTag")==null)
//        {
//            fail("couldn't find tag");
//        }
        
    }
}
