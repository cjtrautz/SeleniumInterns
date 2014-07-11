package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteAndVerifyMassActionForContact extends AbstractTest
{
    @Test
    public void testDeleteAndVerifyMassActionForContact () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.formSearch.find("Dont");
        Contact_Edit contact_Edit = contactListAll.clickContact(1);
        if(contact_Edit.verifyLastName("Dont")==null)
        {
            fail("found last name");
        }
        if(contact_Edit.verifyNoTag(value.get("Admin", "tag"))==null)
        {
            fail("found tag");
        }
        if(contact_Edit.verifyNoSequence(value.get("Sequences", "date_rule_sequence"))==null)
        {
            fail("found tag");
        }
        contact_Edit.clickContactHistory();
        if(contact_Edit.verifyNoLogItem(value.get("Messages", "email_subject"))==null)
        {
            fail("found contact log email");
        }
        contactListAll = contact_Edit.clickBack();

        contactListAll.drilldownGroup.open();
        contactListAll.drilldownGroup.clickGroup("My massaction group");
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(10);
        int k = 1;
        AbstractPart.waitForAjax(driver, 15);
        driver.navigate().refresh();
        contact_Edit = (Contact_Edit) new Contact_Edit().init();
        while(k<7)
        {
            contact_Edit = contactListAll.clickContact(k);
            //verify Sel Tag exists
            if(contact_Edit.verifySequence(value.get("Sequences", "date_rule_sequence"))==null)
            {
                fail("couldn't find sequence" + k);
            }
            contact_Edit.clickContactHistory();
            if(contact_Edit.verifyLogItem(value.get("Messages", "email_subject"))==null)
            {
                fail("couldn't find contact log email" + k);
            }
            contactListAll = contact_Edit.clickBack();
            k++;
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.sendDelete();
        contactListAll.dialogBox.clickOk();
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickDeleteGroup();

        if (contactListAll.drilldownGroup.confirmGroupDoesntExists("My First Group"+AbstractSuite.UNIQUE) == false)
        {
            fail("didnt delete group in list");
        }
        contactListAll.formSearch.find("Dont");
        if(contactListAll.verifyContact("Dont@gmail.com")==null)
        {
            fail("couldnt find created contact");
        }
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.sendDelete();
        contactListAll.dialogBox.clickOk();
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }
    }
}
