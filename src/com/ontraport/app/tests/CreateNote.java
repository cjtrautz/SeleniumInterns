package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateNote extends AbstractTest
{
    @Test
    public void testCreateNote ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Edit contact_Edit = contactListAll.clickContact(1);
        contact_Edit.clickNotesAndTasksTab();
        contact_Edit.clickNewNote();
        contact_Edit.enterNote("SelNote");
        contact_Edit.clickSaveNote();
        contact_Edit.menuPrimary.clickContactListAll();
        contact_Edit = contactListAll.clickContact(1);
        contact_Edit.clickNotesAndTasksTab();
        
        //verify note exists
        if(contact_Edit.verifyNote("SelNote")==null)
        {
            fail("couldnt find note");
        }
        
    }
}
