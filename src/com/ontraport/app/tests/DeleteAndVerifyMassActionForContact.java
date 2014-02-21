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
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(10);
        int k = 1;
        AbstractPart.waitForAjax(driver, 15);
        driver.navigate().refresh();
        Contact_Edit contact_Edit = (Contact_Edit) new Contact_Edit().init();
        while(k<7)
        {
            contact_Edit = contactListAll.clickContact(k);
            //verify Sel Tag exists
            if(contact_Edit.verifySequence(value.get("Sequences", "date_rule_sequence"))==null)
            {
                fail("couldn't find sequence" + k);
            }
            contactListAll = contact_Edit.clickBack();
            k++;
        }
      
        contactListAll.formSearch.find("Changed");
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }
    }
}
