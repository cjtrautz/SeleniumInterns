package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddPriceFieldColumn extends AbstractTest
{
    @Test
    public void testAddPriceFieldColumn ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.formColumnManager.open();
        contactListAll.formColumnManager.openFieldPane();
        contactListAll.formColumnManager.enterFieldPaneInput(value.get("Fields", "Price_Field"));
        contactListAll.formColumnManager.clickField(value.get("Fields", "Price_Field"));
        contactListAll.formColumnManager.clickCheckMark();
        contactListAll.formColumnManager.waitForTotals();
        
        //verify its there
        if (contactListAll.verifyColumn(value.get("Fields", "Price_Field"))==null)
        {
            fail("couldn't find column");
        }
    }
}
