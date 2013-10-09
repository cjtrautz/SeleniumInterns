package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class DeleteDateGroup extends AbstractTest
{
    @Test
    public void testDeleteDateGroup ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.drilldownGroup.open();
        contactListAll.drilldownGroup.clickGroup("My First date Group"+AbstractSuite.UNIQUE);
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickDeleteGroup();

        if (contactListAll.drilldownGroup.confirmGroupDoesntExists("My First date Group"+AbstractSuite.UNIQUE) == false)
        {
            fail("didnt delete group in list");
        }
        
    }
}
