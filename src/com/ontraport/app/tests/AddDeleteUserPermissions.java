package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractTest;

public class AddDeleteUserPermissions extends AbstractTest
{
    @Test
    public void testAddDeleteUserPermissions ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        user_Edit.drawerSimpleActions.open();
        user_Edit.drawerSimpleActions.clickAddPermissionException();
        user_Edit.drawerPermissionException.openPermissionExceptionPane();
        user_Edit.drawerPermissionException.clickPermissionException("Can View Contacts");
        user_Edit.drawerPermissionException.openPermissionFeaturesPane();
        user_Edit.drawerPermissionException.clickCanViewContacts("All)");
        user_Edit.drawerPermissionException.clickAddException();
        
        //verify Permission
        if(user_Edit.verifyPermission("Can View Contacts")==null)
        {
            fail("couldn't find permission");
        }
        
        user_Edit.clickPermissionExceptionsCheckBox();
        user_Edit.drawerSimpleActions.clickDeleteException();
        user_Edit.dialogBox.clickOk();
        
        if(user_Edit.verifyNoPermissions()==null)
        {
            fail("found deleted permission");
        }
        //verify Permission is gone
        
    }
}
