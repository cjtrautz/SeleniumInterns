package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OneShoppingCart_View;
import com.ontraport.app.tools.AbstractTest;

public class Create1SCSync extends AbstractTest
{
    @Test
    public void testCreate1SCSync ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        OneShoppingCart_View oneShoppingCart_View = account_View.click1ShoppingCartSyncing();
        
        //verify everything is on the page
        if(oneShoppingCart_View.verify()==null)
        {
            fail("couldn't find 1ShoppingCart Details");
        }
        
    }
}
