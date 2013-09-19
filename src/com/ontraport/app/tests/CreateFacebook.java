package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Facebook_Create;
import com.ontraport.app.pages.Facebook_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateFacebook extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Facebook_ListAll facebook_ListAll = account_View.clickFacebook();
        Facebook_Create facebook_Create = facebook_ListAll.clickNewFacebookApp();
        facebook_Create.enterAppName("SelFacebook");
        facebook_Create.enterAppID("SelFacebook");
        facebook_Create.enterRedirect("SelFacebook");
        facebook_Create.enterVisits("0");
        facebook_ListAll = facebook_Create.clickSave();
        
        //verify App Name, ID, Redirect, and Visits
        if(facebook_ListAll.verifyFacebook("SelFacebook")==null)
        {
            fail("couldnt find Facebook app");
        }
        
    }
}
