package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteContact extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
<<<<<<< HEAD
        contactListAll.formSearch.clear();
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        contactListAll.formSearch.find("SelFirstName");
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }
<<<<<<< HEAD
        contactListAll.formSearch.clear();
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
    }
}
