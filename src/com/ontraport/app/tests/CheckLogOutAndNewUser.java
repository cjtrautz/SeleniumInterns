package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CheckLogOutAndNewUser extends AbstractTest
{
    @Test
    public void testCheckLogOut ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        if ( driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size() == 0 )
        {
            fail("Can't find log out page 1");
        }
        Login login = (Login) new Login().init();
        login.open(Login.url);
        login.as("Selenium" + AbstractSuite.UNIQUE + "@email.com", "test");
        if(contactListAll.verifyPage()==null)
        {
            fail("couldnt find selenium log in");
        }
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        AbstractPart.waitForAjax(driver, 15);
        if ( driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size() == 0 )
        {
            fail("Can't find log out page2");
        }
        login = (Login) new Login().init();
        login.open(Login.url);
        login.as(AbstractPage.getLogin(), AbstractPage.getPassword());
        
    }
}
