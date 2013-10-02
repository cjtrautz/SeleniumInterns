package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_Import;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.OPPackage_View;
import com.ontraport.app.pages.UltraCart_View;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractTest;

public class AccountAddAPackage extends AbstractTest
{
    @Test
    public void testAccountAddAPackage()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        OPPackage_View oPPackage_View = contactListAll.menuUser.clickAccount();
        oPPackage_View.clickAddPackage();
        if(oPPackage_View.dialogBox.verifyPopUpAddPackage()==null)
        {
            fail("No pop up");
        }
        oPPackage_View.dialogBox.clickCancel();
        
    }
}
