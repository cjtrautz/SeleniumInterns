package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OPPackage_View;
import com.ontraport.app.tools.AbstractTest;

public class AccountClickHere extends AbstractTest
{
    @Test
    public void testAccountClickHere ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        OPPackage_View oPPackage_View = contactListAll.menuUser.clickAccount();
        oPPackage_View.clickHere();
        if(oPPackage_View.verifyAbuseDesk()==null)
        {
            fail("No export");
        }
       
        
    }
}
