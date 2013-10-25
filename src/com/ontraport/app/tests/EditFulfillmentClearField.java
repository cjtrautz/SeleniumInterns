package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_Create;
import com.ontraport.app.pages.Fulfillment_Edit;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditFulfillmentClearField extends AbstractTest
{
    @Test
    public void testEditFulfillmentClearField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        Fulfillment_Edit fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        fulfillment_Edit.clearAllFields();
        
        if(fulfillment_Edit.verifyNumberOfFields(0)==null)
        {
            fail("didnt find createATask checked");
        }
        fulfillment_Edit.openFieldPane();
        fulfillment_Edit.selectDrillDown("Last Name");
        fulfillment_ListAll = fulfillment_Edit.clickSave();
        fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_list"));
      //verify fulfillment exists
        if(fulfillment_ListAll.verifyFulfillment(value.get("Admin", "fulfillment_list"))==null)
        {
            fail("didnt find fulfillment");
        }
        fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_list"));
        if(fulfillment_Edit.verifyFieldValue(1, "Last Name")==null)
        {
            fail("didnt find fulfillment field vale");
        }

    }
}
