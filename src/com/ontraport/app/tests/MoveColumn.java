package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class MoveColumn extends AbstractTest
{
    @Test
    public void testMoveColumn () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        int index = contactListAll.formColumnManager.getColumnIndex("ZIP CODE");
        contactListAll.formColumnManager.open("Zip Code");
        contactListAll.formColumnManager.clickColumnAndMove(-300);
        contactListAll.formColumnManager.clickCheckMark();
        
        //verify its gone
        if(contactListAll.formColumnManager.verifyColumnEarlier("ZIP CODE", index)==null)
        {
            fail("found column not moved");
        }
        
    }
}
