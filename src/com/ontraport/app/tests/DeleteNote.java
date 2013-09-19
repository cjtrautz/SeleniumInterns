package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteNote extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Edit contact_Edit = contactListAll.clickContact(1);
        contact_Edit.clickNotesAndTasksTab();
        contact_Edit.selectAllOnPage();
        contact_Edit.drawerSimpleActions.clickDelete();
        contact_Edit.dialogBox.clickOk();
        
        //verify
        if(contact_Edit.verifyNoNote("SelNote")==null)
        {
            fail("found deleted contact");
        }
        
    }
}
