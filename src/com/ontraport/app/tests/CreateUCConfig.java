package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.UltraCart_View;
import com.ontraport.app.tools.AbstractTest;

public class CreateUCConfig extends AbstractTest
{
    @Test
    public void testCreateUCConfig ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        UltraCart_View ultraCart_View = account_View.clickUCConfig();
        
        
        if(ultraCart_View.keyAdding()==null)
        {
            fail("no uc config key");
        }
        
    }
}
