package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_Create;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateFulfillment extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        Fulfillment_Create fulfillment_Create = fulfillment_ListAll.clickNewFulfillmentList();
        fulfillment_Create.enterFulfillmentListName("SelFulfillment");
        fulfillment_Create.openSendTimePane();
        fulfillment_Create.selectTime("12:00am");
        fulfillment_Create.openFieldPane();
        fulfillment_Create.selectField("First Name");
        fulfillment_ListAll = fulfillment_Create.clickSave();
        fulfillment_ListAll.formSearch.find("SelFulfillment");
        
        //verify fulfillment exists
        if(fulfillment_ListAll.verifyFulfillment("SelFulfillment")==null)
        {
            fail("didnt find fulfillment");
        }
        
    }
}
