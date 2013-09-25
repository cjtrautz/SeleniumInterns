package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Import;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractTest;

public class TryToFailUsageAgreementImport extends AbstractTest
{
    @Test
    public void testTryToFailUsageAgreementImport ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_Import contact_Import = contact_Settings.clickImportContacts();
        contact_Import.clickFirstContactList();
        contact_Import.clickNext();
        DialogBox dialogBox = contact_Import.clickNextWithFail();
        //verify new section is in the field editor
        if(dialogBox.verifyUsageAgreement()==null)
        {
            fail("no usage agreement");
        }
        dialogBox.clickClose();
        contact_Import.menuPrimary.clickContactListAll();
        dialogBox.clickOk();
        
    }
}
