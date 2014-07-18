package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_Create;
import com.ontraport.app.pages.Fulfillment_Edit;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateFulfillment extends AbstractTest
{
    @Test
    public void testCreateFulfillment ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        Fulfillment_Create fulfillment_Create = fulfillment_ListAll.clickNewFulfillmentList();
        fulfillment_Create.enterFulfillmentListName(value.get("Admin", "fulfillment_list"));
        fulfillment_Create.openSendTimePane();
        fulfillment_Create.selectTime(value.get("Admin", "fulfillment_time"));
        fulfillment_Create.openFieldPane();
        fulfillment_Create.selectField("First Name");
        fulfillment_Create.enterEmailNotification(value.get("Admin", "fulfillment_email"));
        fulfillment_Create.enterEmailSubject(value.get("Admin", "fulfillment_email_subject"));
        fulfillment_Create.enterEmailMessage(value.get("Admin", "fulfillment_email_message"));
        fulfillment_ListAll = fulfillment_Create.clickSave();
        fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_list"));
        
        //verify fulfillment exists
        if(fulfillment_ListAll.verifyFulfillment("SelFulfillment")==null)
        {
            fail("didnt find fulfillment");
        }
        Fulfillment_Edit fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        if(fulfillment_Edit.verifyFieldValue(1, "First Name")==null)
        {
            fail("didnt find fulfillment field vale");
        }
        if(fulfillment_Edit.verifyFulfillmentName(value.get("Admin", "fulfillment_list"))==null)
        {
            fail("didnt find fulfillment list name");
        }
        if(fulfillment_Edit.verifySchedular("Daily")==null)
        {
            fail("didnt find fulfillment schedular");
        }

    }
}
