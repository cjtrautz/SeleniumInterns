package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteUser extends AbstractTest
{
    @Test
    public void testDeleteUser ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        User_ListAll user_ListAll = contactListAll.menuUser.clickManageUsers();
        user_ListAll.formSearch.find("FirstSelenium");
        user_ListAll.selectAllOnPage();
        user_ListAll.drawerActions.clickDeleteUser();
        user_ListAll.drawerActions.clickReassignContacts();
        user_ListAll.drawerActions.selectDropDown(1);
        user_ListAll.drawerActions.clickDelete();
        
        //verify
        if(user_ListAll.verifyNoUser()==null)
        {
            fail("found deleted user");
        }
        
    }
}
