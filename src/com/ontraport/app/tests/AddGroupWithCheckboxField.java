package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class AddGroupWithCheckboxField extends AbstractTest
{
    @Test
    public void testAddGroupWithCheckboxField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();

        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("My First checkbox Group"+AbstractSuite.UNIQUE);
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view & Edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.enterFieldPaneInput("checkbox", 0);
        contactListAll.drawerManageGroups.clickField("SelCheckbox", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("equals", 0);
        contactListAll.drawerManageGroups.enterValue("Everybody", 0, 0);
        contactListAll.drawerManageGroups.clickSave();

        if (contactListAll.drilldownGroup.confirmGroupExists("My First checkbox Group"+AbstractSuite.UNIQUE) == true)
        {
            System.out.println("Exists: Success");
        }
        else
        {
            System.out.println("Exists: Failure");
            fail("Failure");
        }
        contactListAll.drilldownGroup.clickGroupAll();
    }
}
