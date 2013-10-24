package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddTextFieldColumn extends AbstractTest
{
    @Test
    public void testAddTextFieldColumn ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.formColumnManager.open();
        contactListAll.formColumnManager.openFieldPane();
        contactListAll.formColumnManager.enterFieldPaneInput(value.get("Fields", "Text_Field"));
        contactListAll.formColumnManager.clickField(value.get("Fields", "Text_Field"));
        contactListAll.formColumnManager.clickCheckMark();
        
        //verify its there
        if (contactListAll.verifyColumn(value.get("Fields", "Text_Field"))==null)
        {
            fail("couldn't find column");
        }
    }
}
