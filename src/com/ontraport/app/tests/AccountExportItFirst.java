package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OPPackage_View;
import com.ontraport.app.tools.AbstractTest;
/**
  @brief Check Exporting page
  @return fails no export if cant verify page
  @author Nick Cross <nick@ontraport.com>
 
 */
public class AccountExportItFirst extends AbstractTest
{
    @Test
    public void testAccountExportItFirst ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        OPPackage_View oPPackage_View = contactListAll.menuUser.clickAccount();
        oPPackage_View.clickExportItFirst();
        if(oPPackage_View.verifyExport()==null)
        {
            fail("No export");
        }
       
        
    }
}
