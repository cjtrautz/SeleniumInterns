package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class AddGroupWithDropDownField extends AbstractTest
{
    @Test
    public void testAddGroupWithDropDownField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("My First dropdown Group"+AbstractSuite.UNIQUE);
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view and edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.enterFieldPaneInput("dropdown", 0);
        contactListAll.drawerManageGroups.clickField("SelDropdown", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("Equal To", 0);
        contactListAll.drawerManageGroups.openValuePane(0);
        contactListAll.drawerManageGroups.clickValue("a", 0);
        contactListAll.drawerManageGroups.clickSave();

        if (contactListAll.drilldownGroup.confirmGroupExists("My First dropdown Group"+AbstractSuite.UNIQUE) == true)
        {
            System.out.println("Exists: Success");
        }
        else
        {
            System.out.println("Exists: Failure");
            fail("Failure");
        }
        contactListAll.drawerManageGroups.open();
        if (contactListAll.drawerManageGroups.verifyFieldDropDown("SelDropdown", 0) == null)
        {
            fail("couldnt find field group");
        }
        if (contactListAll.drawerManageGroups.verifyConditionDropDown("Equal To", 0) == null)
        {
            fail("couldnt find condition group");
        }
        if (contactListAll.drawerManageGroups.verifyValueDropDown("a", 0) == null)
        {
            fail("couldnt find value group");
        }
        contactListAll.drilldownGroup.clickGroupAll();
    }
}
