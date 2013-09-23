package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Facebook_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteFacebook extends AbstractTest
{
    @Test
    public void testDeleteFacebook ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Facebook_ListAll facebook_ListAll = account_View.clickFacebook();
        facebook_ListAll.formSearch.find("SelFacebook");
        facebook_ListAll.selectAllOnPage();
        facebook_ListAll.drawerActions.clickDeleteFacebookApp();
        facebook_ListAll.dialogBox.clickOk();
        facebook_ListAll.menuUser.open();
        account_View = facebook_ListAll.menuUser.clickAdmin();
        facebook_ListAll = account_View.clickFacebook();
        facebook_ListAll.formSearch.find("SelFacebook");  
                
        //verify
        if(facebook_ListAll.verifyNoFacebook()==null)
        {
            fail("found deleted facebook app");
        }
        
    }
}
