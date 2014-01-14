package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sender_View;
import com.ontraport.app.tools.AbstractTest;

public class DeleteSendFromAddress extends AbstractTest
{
    @Test
    public void testDeleteSendFromAddress () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Sender_View sender_View = account_View.clickSendFrom();
        sender_View.clickRemove("seleniumontraport@gmail.com");
        
        if(sender_View.verifyNoSendFrom("seleniumontraport@gmail.com")==null)
        {
            fail("couldnt find Facebook app");
        }



        
    }
}
