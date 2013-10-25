package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.ApiSettings_Create;
import com.ontraport.app.pages.ApiSettings_Edit;
import com.ontraport.app.pages.ApiSettings_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditAPIKeysBack extends AbstractTest
{ 
    @Test
    public void testEditAPIKeysBack ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        ApiSettings_ListAll apiSettings_ListAll = account_View.clickOntraportApiInstructionsAndKeyManager();
        ApiSettings_Edit apiSettings_Edit = apiSettings_ListAll.clickAPI(value.get("Admin", "api_name"));
        apiSettings_ListAll = apiSettings_Edit.clickBack();

        //verify SelAPI exists
        if(apiSettings_ListAll.verifyPage()==null)
        {
            fail("couldnt find api page");
        }


        
    }
}
