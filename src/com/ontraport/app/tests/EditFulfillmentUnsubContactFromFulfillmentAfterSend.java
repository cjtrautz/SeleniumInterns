package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_Create;
import com.ontraport.app.pages.Fulfillment_Edit;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditFulfillmentUnsubContactFromFulfillmentAfterSend extends AbstractTest
{
    @Test
    public void testEditFulfillmentUnsubContactFromFulfillmentAfterSend ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        Fulfillment_Edit fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        fulfillment_Edit.clickUsubscribeContactFromFulfillmentAfterSend();
        fulfillment_ListAll = fulfillment_Edit.clickSave();
        fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_list"));
        
        //verify fulfillment exists
        if(fulfillment_ListAll.verifyFulfillment(value.get("Admin", "fulfillment_list"))==null)
        {
            fail("didnt find fulfillment");
        }
        fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        if(fulfillment_Edit.verifyUsubscribeContactFromFulfillmentAfterSendChecked()==null)
        {
            fail("didnt find UnsubContactFromFulfillmentAfterSend checked");
        }
        

    }
}
