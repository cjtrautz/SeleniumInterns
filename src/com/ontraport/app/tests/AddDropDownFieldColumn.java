package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddDropDownFieldColumn extends AbstractTest
{
    @Test
    public void testAddDropDownFieldColumn ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        contactListAll.formColumnManager.open();
        contactListAll.formColumnManager.openFieldPane();
        contactListAll.formColumnManager.enterFieldPaneInput(value.get("Fields", "Drop_Down_Field"));
        contactListAll.formColumnManager.clickField(value.get("Fields", "Drop_Down_Field"));
        contactListAll.formColumnManager.clickCheckMark();
        
        //verify its there
        if (contactListAll.verifyColumn(value.get("Fields", "Drop_Down_Field"))==null)
        {
            fail("couldn't find column");
        }
    }
}
