package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class EditGroupPermission extends AbstractTest
{
    @Test
    public void testEditGroupPermission ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.drilldownGroup.open();
        contactListAll.drilldownGroup.clickGroup("My First Group"+AbstractSuite.UNIQUE);
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Only I can edit, everyone can view");
        contactListAll.drawerManageGroups.clickSave();
        contactListAll.drawerManageGroups.open();

        if (contactListAll.drawerManageGroups.verifyGroupPermissions("Only I can edit, everyone can view") == null)
        {
            fail("didnt select only I can edit, everyone can view");
        }
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Only I can view and edit");
        contactListAll.drawerManageGroups.clickSave();
        contactListAll.drawerManageGroups.open();

        if (contactListAll.drawerManageGroups.verifyGroupPermissions("Only I can view and edit") == null)
        {
            fail("didnt select only I can view and edit");
        }
        
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view and edit");
        contactListAll.drawerManageGroups.clickSave();
        contactListAll.drawerManageGroups.open();

        if (contactListAll.drawerManageGroups.verifyGroupPermissions("Everyone can view and edit") == null)
        {
            fail("didnt select only I can view and edit");
        }
        contactListAll.drawerManageGroups.close();
        contactListAll.drilldownGroup.clickGroupAll();
    }
}
