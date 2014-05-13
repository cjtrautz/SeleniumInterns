package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class AddGroupWithDateField extends AbstractTest
{
    @Test
    public void testAddGroupWithDateField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("My First date Group"+AbstractSuite.UNIQUE);
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view & Edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.enterFieldPaneInput("date", 0);
        contactListAll.drawerManageGroups.clickField("SelDate", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("Equal To", 0);
        contactListAll.drawerManageGroups.enterValue("1/1/2014", 0, 0);
        contactListAll.drawerManageGroups.clickSave();

        if (contactListAll.drilldownGroup.confirmGroupExists("My First date Group"+AbstractSuite.UNIQUE) == true)
        {
            System.out.println("Exists: Success");
        }
        else
        {
            System.out.println("Exists: Failure");
            fail("Failure");
        }
        contactListAll.drawerManageGroups.open();
        if (contactListAll.drawerManageGroups.verifyFieldDropDown("SelDate", 0) == null)
        {
            fail("couldnt find field group");
        }
        if (contactListAll.drawerManageGroups.verifyConditionDropDown("Equal To", 0) == null)
        {
            fail("couldnt find condition group");
        }
        if (contactListAll.drawerManageGroups.verifyValueDropDown("01/01/2014", 0) == null)
        {
            fail("couldnt find value group");
        }
        contactListAll.drilldownGroup.clickGroupAll();
    }
}
