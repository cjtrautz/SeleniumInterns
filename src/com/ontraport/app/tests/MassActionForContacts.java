package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class MassActionForContacts extends AbstractTest
{
    @Test
    public void testMassActionForContacts ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        int i = 1;
        while(i<7)
        {
            Contact_Create contact_Create = contactListAll.clickNewContact();
            contact_Create.enterFirstName("MassSubscribe" + String.valueOf(i));
            contact_Create.enterEmail("MassSubscribe" + String.valueOf(i) +"@gmail.com");
            contactListAll = contact_Create.clickSave();
            i++;
        }
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("Dont");
        contact_Create.enterLastName("Dont");
        contact_Create.enterEmail("Dont@gmail.com");
        contactListAll = contact_Create.clickSave();
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("My massaction group");
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view & Edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.clickField("First Name", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("Contains", 0);
        contactListAll.drawerManageGroups.enterValue("MassSubscribe", 0, 0);
        contactListAll.drawerManageGroups.clickSave();
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickSendEmail();
        contactListAll.drawerActions.clickEmailNameDropDown();
        contactListAll.drawerActions.selectDrillDown(value.get("Messages", "email_message"));
        contactListAll.drawerActions.clickSendFromDropDown();
        contactListAll.drawerActions.selectDropDown(1);
        contactListAll.drawerActions.clickEmailFromDropDown();
        contactListAll.drawerActions.selectDropDown(1);
        contactListAll.drawerActions.clickSend();
        AbstractPart.waitForAjax(driver, 15);
        driver.navigate().refresh();
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.paginator.clickFirstPage();
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickSequences();
        contactListAll.drawerActions.clickSequenceDropDown();
        contactListAll.drawerActions.selectDrillDown(value.get("Sequences", "date_rule_sequence"));
        contactListAll.drawerActions.clickSubmit();
        AbstractPart.waitForAjax(driver, 15);
        driver.navigate().refresh();
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickAddRemoveTags();
        contactListAll.drawerActions.clickTagDropDown();
        contactListAll.drawerActions.selectDrillDown(value.get("Admin", "tag"));
        contactListAll.drawerActions.clickSubmit();
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(10);
        int j = 1;
        Contact_Edit contact_Edit = (Contact_Edit) new Contact_Edit().init();
        AbstractPart.waitForAjax(driver, 15);
        driver.navigate().refresh();
        while(j<7)
        {
            contact_Edit = contactListAll.clickContact(j);
            //verify Sel Tag exists
            if(contact_Edit.verifyTag(value.get("Admin", "tag"))==null)
            {
                fail("couldn't find tag");
            }
            contactListAll = contact_Edit.clickBack();
            j++;
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickChangeFieldValue();
        contactListAll.drawerActions.clickFieldDropDown();
        contactListAll.drawerActions.selectDrillDown("Last Name");
        contactListAll.drawerActions.enterValue("Changed");
        contactListAll.drawerActions.clickSaveField();
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(10);
        int l = 1;
        AbstractPart.waitForAjax(driver, 15);
        driver.navigate().refresh();
        while(l<7)
        {
            contact_Edit = contactListAll.clickContact(l);
            //verify Sel Tag exists
            if(contact_Edit.verifyLastName("Changed")==null)
            {
                fail("couldn't find last name");
            }
            contactListAll = contact_Edit.clickBack();
            l++;
        }
        
        contactListAll.drawerManageGroups.open();
        contactListAll.drilldownGroup.clickGroupAll();


    }
}
