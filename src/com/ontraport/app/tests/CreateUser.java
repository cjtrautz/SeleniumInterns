package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Create;
import com.ontraport.app.pages.User_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateUser extends AbstractTest
{
    @Test
    public void testCreateUser()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        User_ListAll user_ListAll = contactListAll.menuUser.clickManageUsers();
        user_ListAll.clickNewUser();
        User_Create user_Create = user_ListAll.dialogBox.clickAgree();
        user_Create.enterFirstName("FirstSelenium");
        user_Create.enterLastName("LastSelenium");
        user_Create.enterEmail("Selenium@gmail.com");
        user_Create.enterEmailFromName("Selenium@gmail.com");
        user_Create.enterReplyToName("Selenium@gmail.com");
        user_Create.clickRoleDropDown();
        user_Create.selectDropDown("SeleniumRole");
        user_Create.clickLanguageDropDown();
        user_Create.selectDropDown("English");
        user_Create.clickManagerDropDown();
        user_Create.selectDropDown(1);
        user_Create.enterNewPassword("test");
        user_Create.enterConfirmPassword("test");
        user_ListAll = user_Create.clickSave();
        user_ListAll.formSearch.find("FirstSelenium");
        
        if(user_ListAll.verifyUser("FirstSelenium LastSelenium")==null)
        {
            fail("no Role");
        }
        
    }
}
