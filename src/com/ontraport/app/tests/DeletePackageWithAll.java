package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Package_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeletePackageWithAll extends AbstractTest
{
    @Test
    public void testDeletePackageWithAll () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Package_ListAll package_ListAll = account_View.clickPackageManager();
        package_ListAll.formSearch.find(value.get("Packages", "package_all"));
        package_ListAll.selectAllOnPage();
        package_ListAll.drawerActions.clickDeletePackages();
        package_ListAll.dialogBox.clickOk();
        
        //verify
        if(package_ListAll.verifyNoPackage()==null)
        {
            fail("deleted package found");
        }
    }
}
