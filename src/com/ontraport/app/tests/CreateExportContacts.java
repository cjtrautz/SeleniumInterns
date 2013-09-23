package com.ontraport.app.tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_Export;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OntraportAdmin_ListExports;
import com.ontraport.app.tools.AbstractTest;

public class CreateExportContacts extends AbstractTest
{
    @Test
    public void testCreateExportContacts ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.selectAllOnPage();
        Contact_Export contact_Export = contactListAll.drawerActions.clickExportContacts();
        contact_Export.openFieldPane();
        contact_Export.selectField("First Name");
        contactListAll = contact_Export.clickExport();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        OntraportAdmin_ListExports ontraportAdmin_ListExports = account_View.clickExportedLists();
        
        //verify todays date is present in proper form: DateFormat dateFormat = new SimpleDateFormat("M_d_yyyy");
        if(ontraportAdmin_ListExports.verifyExportedList()==null)
        {
            fail("couldnt find exported list");
        }
        
    }
}
