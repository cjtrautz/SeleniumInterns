package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_Create;
import com.ontraport.app.pages.Fulfillment_Edit;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditFulfillmentSendNotificationTo extends AbstractTest
{
    @Test
    public void testEditFulfillmentSendNotificationTo ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        Fulfillment_Edit fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        fulfillment_Edit.enterEmailAddress(1, value.get("Admin", "test_email2"));
        fulfillment_Edit.enterEmailSubject(1, value.get("Admin", "test2"));
        fulfillment_Edit.enterEmailMessage(1, value.get("Admin", "test2"));
        fulfillment_ListAll = fulfillment_Edit.clickSave();
        fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_list"));
        
        //verify fulfillment exists
        if(fulfillment_ListAll.verifyFulfillment(value.get("Admin", "fulfillment_list"))==null)
        {
            fail("didnt find fulfillment");
        }
        fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        if(fulfillment_Edit.verifyFieldValue(1, "First Name")==null)
        {
            fail("didnt find fulfillment field vale");
        }
        if(fulfillment_Edit.verifyFulfillmentName(value.get("Admin", "fulfillment_list"))==null)
        {
            fail("didnt find fulfillment list name");
        }
        if(fulfillment_Edit.verifySubject(1, value.get("Admin", "test2"))==null)
        {
            fail("didnt find fulfillment schedular");
        }
        if(fulfillment_Edit.verifyEmail(1, value.get("Admin", "test_email2"))==null)
        {
            fail("didnt find fulfillment schedular");
        }
        if(fulfillment_Edit.verifyMessage(1, value.get("Admin", "test2"))==null)
        {
            fail("didnt find fulfillment schedular");
        }
        

    }
}
