package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddCheckboxFieldColumn extends AbstractTest
{
    @Test
    public void testAddCheckboxFieldColumn ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        contactListAll.formColumnManager.open();
        contactListAll.formColumnManager.openFieldPane();
        contactListAll.formColumnManager.enterFieldPaneInput(value.get("Fields", "Checkbox_Field"));
        contactListAll.formColumnManager.clickField(value.get("Fields", "Checkbox_Field"));
        contactListAll.formColumnManager.clickCheckMark();
        
        //verify its there
        if (contactListAll.verifyColumn(value.get("Fields", "Checkbox_Field"))==null)
        {
            fail("couldn't find column");
        }
    }
}
