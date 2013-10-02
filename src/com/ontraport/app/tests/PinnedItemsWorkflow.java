package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.OneShoppingCart_View;
import com.ontraport.app.pages.OntraportAdmin_TrackingPixel;
import com.ontraport.app.tools.AbstractTest;

public class PinnedItemsWorkflow extends AbstractTest
{
    @Test
    public void testPinnedItemsWorkflow ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.pin.pin();
        message_ListAll.menuWorkflow.open();
        
        if(message_ListAll.menuWorkflow.verifyPinnedWorkflow("Message: List")==null)
        {
            fail("couldnt find pinned messages");
        }
        message_ListAll.menuWorkflow.close();
        message_ListAll.pin.unPin();
        message_ListAll.menuWorkflow.open();
        if(message_ListAll.menuWorkflow.verifyNoPinnedWorkflow("Message: List")==null)
        {
            fail("found pinned messages");
        }
        message_ListAll.menuWorkflow.close();
        
    }
}
