package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.ApiSettings_Create;
import com.ontraport.app.pages.ApiSettings_Edit;
import com.ontraport.app.pages.ApiSettings_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OntraportAdmin_TrackingPixel;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractTest;

public class CreateAPIKeys extends AbstractTest
{ 
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        ApiSettings_ListAll apiSettings_ListAll = account_View.clickOntraportApiInstructionsAndKeyManager();
        ApiSettings_Create apiSettings_Create = apiSettings_ListAll.clickNewApiKey();
        apiSettings_Create.enterApiName("SelAPI");
        apiSettings_Create.openContactOwnerPane();
        apiSettings_Create.selectOwner(1);
        apiSettings_Create.checkAddContacts();
        apiSettings_Create.checkSearchContacts();
        apiSettings_Create.checkDeleteContacts();
        apiSettings_Create.checkCreateKey();
        apiSettings_ListAll = apiSettings_Create.clickSave();
        apiSettings_ListAll.formSearch.find("SelAPI");
        
        //verify SelAPI exists
        if(apiSettings_ListAll.verifyAPIKey("SelAPI")==null)
        {
            fail("couldnt find create api name");
        }

        ApiSettings_Edit apiSettings_Edit = apiSettings_ListAll.clickAPI("SelAPI");
        if(apiSettings_Edit.verifyAddContacts()==null)
        {
            fail("add contacts not checked");
        }
        if(apiSettings_Edit.verifyAppID()==null)
        {
            fail("app id not displayed");
        }
        if(apiSettings_Edit.verifyCreateKey()==null)
        {
            fail("create key not checked");
        }
        if(apiSettings_Edit.verifyDeleteContacts()==null)
        {
            fail("delete contacts not checked");
        }
        if(apiSettings_Edit.verifyKey()==null)
        {
            fail("key is not displayed");
        }
        if(apiSettings_Edit.verifySearchContacts()==null)
        {
            fail("search contacts not checked");
        }

        
    }
}
