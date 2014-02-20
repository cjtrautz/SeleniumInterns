package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.pages.User_ListAll;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class ChangePassword extends AbstractTest
{
    @Test
    public void testChangePassword ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        User_ListAll user_ListAll = contactListAll.menuUser.clickManageUsers();
        user_ListAll.formSearch.find("FirstSelenium");
        User_Edit user_Edit = user_ListAll.clickUser("Selenium" + AbstractSuite.UNIQUE + "@email.com", "test");
        user_Edit.clickPasswordField();
        user_Edit.enterNewPassword("changed");
        user_Edit.enterNewPasswordConfirm("changed");
        user_Edit.clickChangePassword();
        
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        if ( driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size() == 0 )
        {
            fail("Can't find Affiliates page");
        }
        Login login = (Login) new Login().init();
        login.open(Login.url);
        login.as("Selenium" + AbstractSuite.UNIQUE + "@email.com", "changed");
        if(contactListAll.verifyPage()==null)
        {
            fail("couldnt find new user password");
        }
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        if ( driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size() == 0 )
        {
            fail("Can't find Affiliates page");
        }
        login = (Login) new Login().init();
        login.open(Login.url);
        login.as(AbstractPage.getLogin(), AbstractPage.getPassword());
        
    }
}