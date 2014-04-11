package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.ApiSettings_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteAPIKeys extends AbstractTest
{
    @Test
    public void testDeleteAPIKeys ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        ApiSettings_ListAll apiSettings_ListAll = account_View.clickOntraportApiInstructionsAndKeyManager();
        apiSettings_ListAll.formSearch.find("SelAPI");
        apiSettings_ListAll.selectAllOnPage();
        apiSettings_ListAll.drawerActions.clickDeleteAPIKey();
        apiSettings_ListAll.dialogBox.clickOk();
        apiSettings_ListAll.menuUser.open();
        account_View = apiSettings_ListAll.menuUser.clickAdmin();
        apiSettings_ListAll = account_View.clickOntraportApiInstructionsAndKeyManager();
        apiSettings_ListAll.formSearch.find("SelAPI");

        //verify
        if(apiSettings_ListAll.verifyNoAPIKey()==null)
        {
            fail("found API Key");
        }
    }
}
