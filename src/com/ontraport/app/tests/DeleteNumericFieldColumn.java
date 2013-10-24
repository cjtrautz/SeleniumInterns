package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteNumericFieldColumn extends AbstractTest
{
    @Test
    public void testDeleteNumericFieldColumn () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.formColumnManager.open(value.get("Fields", "Numeric_Field"));
        contactListAll.formColumnManager.clickTrashCan();
        
        //verify its gone
        if(contactListAll.verifyNotColumn(value.get("Fields", "Numeric_Field"))==null)
        {
            fail("found column");
        }
        
    }
}
