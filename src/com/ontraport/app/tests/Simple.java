package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.Values;
import com.ontraport.app.tools.AbstractTest;

public class Simple extends AbstractTest
{

    public void CreateContact () {  }
    public void SearchContact () {  }
    public void SelectContact () {  }
    public void DeleteContact () {  }
    public void CreateGroup () {  }
    public void SelectGroup () {  }
    public void DeleteGroup () {  }

    @Test
    public void sanity1 () { sanity(); }

    public void sanity2 () { sanity(); }

    public void sanity3 () { sanity(); }

    public void sanity4 () { sanity(); }

    public void sanity5 () { sanity(); }

    public void sanity6 () { sanity(); }

    public void sanity7 () { sanity(); }

    public void sanity8 () { sanity(); }

    public void sanity9 () { sanity(); }

    public void sanity10 () { sanity(); }

    public void sanity11 () { sanity(); }

    public void sanity12 () { sanity(); }

    public void sanity ()
    {
        long started = System.nanoTime();
        Values values = new Values("Active");
        String suffix = AbstractSuite.UNIQUE;
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.drilldownGroup.selectGroup("Group: All");
        if (contactListAll.drilldownGroup.confirmGroupSelected("Group: All") == false)
        {
            fail("Failure: 'Group: All' not selected.");
        }
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName(values.get("group_name")+suffix);
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view & Edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.clickField("First Name", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("starts with", 0);
        contactListAll.drawerManageGroups.enterValue(values.get("contact_first_name")+suffix, 0, 0);
        contactListAll.drawerManageGroups.clickSave();
        if (contactListAll.drilldownGroup.confirmGroupSelected(values.get("group_name")+suffix) == false)
        {
            fail("Failure: '"+values.get("group_name")+suffix+"' not selected.");
        }
        contactListAll.drilldownGroup.selectGroup("Group: All");
        if (contactListAll.drilldownGroup.confirmGroupSelected("Group: All") == false)
        {
            fail("Failure: 'Group: All' not selected.");
        }
        if (contactListAll.drilldownGroup.confirmGroupExists(values.get("group_name")+suffix) == false)
        {
            fail("Failure: '"+values.get("group_name")+suffix+"' does not exist.");
        }
        contactListAll.drilldownGroup.selectGroup(values.get("group_name")+suffix);
        if (contactListAll.drilldownGroup.confirmGroupSelected(values.get("group_name")+suffix) == false)
        {
            fail("Failure: '"+values.get("group_name")+suffix+"' not selected.");
        }
        contactListAll.drilldownGroup.selectGroup("Group: All");
        if (contactListAll.paginator.isDisplayed())
        {
            contactListAll.paginator.openRecordsPerPagePane();
            contactListAll.paginator.clickRecordsPerPage(5);
        }
        for (int i = 0; i < 12; i++)
        {
            Contact_Create contactCreate = contactListAll.clickNewContact();
            contactCreate.enterFirstName(values.get("contact_first_name")+suffix+i);
            contactCreate.enterLastName(values.get("contact_last_name")+suffix+i);
            contactCreate.enterEmail(values.get("contact_email"));
            contactListAll = contactCreate.clickSave();
            contactListAll.formSearch.find(values.get("contact_first_name")+suffix+i);
            if (contactListAll.confirmRowsContain(values.get("contact_first_name")+suffix+i) == false)
            {
                fail("Failure: '"+values.get("contact_first_name")+suffix+i+"' not found.");
            }
            contactListAll.selectAllOnPage();
            contactListAll.drawerActions.clickDeleteContacts();
            if (contactListAll.dialogBox.isDisplayed())
            {
                contactListAll.dialogBox.clickOk();
            }
            contactListAll.formSearch.clear();
        }
        if (contactListAll.paginator.isDisplayed())
        {
            contactListAll.paginator.openRecordsPerPagePane();
            contactListAll.paginator.clickRecordsPerPage(100);
        }
        contactListAll.drilldownGroup.selectGroup(values.get("group_name")+suffix);
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickDelete();
        if (contactListAll.drilldownGroup.confirmGroupNotExists(values.get("group_name")+suffix) == false)
        {
            fail("Failure: '"+values.get("group_name")+suffix+"' still exists.");
        }
        contactListAll.drawerActions.close();
        System.out.println("Completed in "+((System.nanoTime() - started) / 1000000000) + " seconds");
    }
}
