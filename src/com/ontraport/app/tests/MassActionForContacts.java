package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;
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
            contact_Create.enterEmail("MassSubscribe" + String.valueOf(i));
            contactListAll = contact_Create.clickSave();
            i++;
        }
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
        contactListAll.drawerActions.selectDrillDown("First Name");
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
            if(contact_Edit.verifyFirstName("Changed")==null)
            {
                fail("couldn't find tag");
            }
            contactListAll = contact_Edit.clickBack();
            l++;
        }


    }
}
