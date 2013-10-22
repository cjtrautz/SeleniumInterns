package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class UploadToAttachmentManager extends AbstractTest
{
    @Test
    public void testUploadToAttachmentManager () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        account_View.clickAttachmentManager();
        account_View.dialogBox.clickUpload();
        account_View.dialogBox.enterURL("http://images6.alphacoders.com/316/316963.jpg");
        account_View.dialogBox.clickGo();
        account_View.dialogBox.clickClose();
        driver.navigate().refresh();
        Thread.sleep(3000);
        account_View.clickAttachmentManager();
        account_View.dialogBox.clickBrowse();
        account_View.formSearch.find("http://images6.alphacoders.com/316/316963.jpg");
        
        //verify App Name, ID, Redirect, and Visits
        if(account_View.dialogBox.verifyAttachement("http://images6.alphacoders.com/316/316963.jpg")==null)
        {
            fail("couldnt find attachment");
        }

        
    }
}
