package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Import;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractTest;

public class ImportContacts extends AbstractTest
{
    @Test
    public void testTryToFailUsageAgreementImport ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_Import contact_Import = contact_Settings.clickImportContacts();
        contact_Import.clickFirstContactList();
        contact_Import.clickNext();
        //contact_Import.checkUsageAgreement();
        contact_Import.clickNextMerge();
        //contact_Import.clickNextAddRules();
        //contactListAll = contact_Import.clickFinish();
//        if(contactListAll.verifyBeingImportedAndClose()==null)
//        {
//            fail("not importing");
//        }
//        if(contactListAll.verifyBeingProcessedAndClose()==null)
//        {
//            fail("not processing");
//        }
//        if(contactListAll.verifyDoneAndClick()==null)
//        {
//            fail("not done");
//        }
//        if(contactListAll.verifyContact("bart@thesimpsons.com")==null)
//        {
//            fail("not done");
//        }
//        if(contactListAll.verifyNumberOfContacts(7)==null)
//        {
//            fail("not done");
//        }
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }
        
    }
}
