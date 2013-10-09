package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteUploadToAttachmentManager extends AbstractTest
{
    @Test
    public void testDeleteUploadToAttachmentManager ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        account_View.clickAttachmentManager();
        account_View.dialogBox.clickBrowse();
        account_View.formSearch.find("http://images6.alphacoders.com/316/316963.jpg");
        account_View.dialogBox.selectAll();
        account_View.drawerSimpleActions.clickDelete();
        account_View.dialogBox.clickOk();
        account_View.dialogBox.clickBrowse();
        
        //verify App Name, ID, Redirect, and Visits
        if(account_View.dialogBox.verifyNoAttachement()==null)
        {
            fail("found deleted attachment");
        }

        
    }
}
