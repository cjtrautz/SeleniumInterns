package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class Simple extends AbstractTest
{
    @Test
    public void sanity () throws InterruptedException
    {

        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();

        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("My First Group"+AbstractSuite.UNIQUE);
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view & Edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.clickField("First Name", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("equals", 0);
        contactListAll.drawerManageGroups.enterValue("Everybody", 0, 0);
        contactListAll.drawerManageGroups.clickSave();

        if (contactListAll.drilldownGroup.confirmGroupNotAll() == true)
        {
            System.out.println("Not all: Success");
        }
        else
        {
            System.out.println("Not all: Failure");
            fail("Failure");
        }

        if (contactListAll.drilldownGroup.confirmGroupExists("My First Group"+AbstractSuite.UNIQUE) == true)
        {
            System.out.println("Exists: Success");
        }
        else
        {
            System.out.println("Exists: Failure");
            fail("Failure");
        }

        /*
        if (contactListAll.drawerManageGroups.confirmGroupApplied("My First Group"+AbstractSuite.UNIQUE) == false)
        {
            System.out.println("Failure");
            fail("Failure");
        }
        else
        {
            System.out.println("Success");
        }
        */
//
//        if (contactListAll.paginator.isDisplayed())
//        {
//            contactListAll.paginator.openRecordsPerPagePane();
//            contactListAll.paginator.clickRecordsPerPage(5);
//        }
//
//        for (int i = 0; i < 10; i++)
//        {
//            Contact_Create contactCreate = contactListAll.clickNewContact();
//            contactCreate.enterFirstName("Everybody"+AbstractSuite.UNIQUE);
//            contactCreate.enterLastName("Testing");
//            contactCreate.enterEmail("testing@ontraport.com");
//            contactListAll = contactCreate.clickSave();
//            contactListAll.formSearch.find("Everybody"+AbstractSuite.UNIQUE);
//            contactListAll.selectAllOnPage();
//            contactListAll.drawerActions.clickDeleteContacts();
//            if (contactListAll.dialogBox.isDisplayed())
//            {
//                contactListAll.dialogBox.clickOk();
//            }
//            contactListAll.formSearch.clear();
//        }
//
//        if (contactListAll.paginator.isDisplayed())
//        {
//            contactListAll.paginator.openRecordsPerPagePane();
//            contactListAll.paginator.clickRecordsPerPage(100);
//        }
//
//            contactListAll.confirmRowsContain("everybody");
//        contactListAll.drawerActions.close();
//Thread.sleep(5000);
    }
}
