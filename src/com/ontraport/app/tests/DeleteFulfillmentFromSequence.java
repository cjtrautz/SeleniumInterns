package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteFulfillmentFromSequence extends AbstractTest
{
    @Test
    public void testDeleteFulfillmentFromSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_from_sequence"));
        fulfillment_ListAll.selectAllOnPage();
        fulfillment_ListAll.drawerActions.clickDeleteList();
        fulfillment_ListAll.dialogBox.clickOk();
        
        //verify
        if(fulfillment_ListAll.verifyNoFulfillment()==null)
        {
            fail("found deleted fulfillment");
        }
        
    }
}
