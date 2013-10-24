package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddStateFieldColumn extends AbstractTest
{
    @Test
    public void testAddStateFieldColumn ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.formColumnManager.open();
        contactListAll.formColumnManager.openFieldPane();
        contactListAll.formColumnManager.enterFieldPaneInput(value.get("Fields", "State_Field"));
        contactListAll.formColumnManager.clickField(value.get("Fields", "State_Field"));
        contactListAll.formColumnManager.clickCheckMark();
        
        //verify its there
        if (contactListAll.verifyColumn(value.get("Fields", "State_Field"))==null)
        {
            fail("couldn't find column");
        }
    }
}
