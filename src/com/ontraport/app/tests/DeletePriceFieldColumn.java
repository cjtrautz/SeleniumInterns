package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeletePriceFieldColumn extends AbstractTest
{
    @Test
    public void testDeletePriceFieldColumn () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.formColumnManager.openNum(value.get("Fields", "Price_Field"));
        contactListAll.formColumnManager.clickTrashCan();
        
        //verify its gone
        if(contactListAll.verifyNotColumn(value.get("Fields", "Price_Field"))==null)
        {
            fail("found column");
        }
        
    }
}
