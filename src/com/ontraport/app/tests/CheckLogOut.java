package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractTest;

public class CheckLogOut extends AbstractTest
{
    @Test
    public void testCheckLogOut ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        if ( driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size() == 0 )
        {
            fail("Can't find Affiliates page");
        }
        Login login = (Login) new Login().init();
        login.open(Login.url);
        login.as("nick@ontraport.com", "Lughead1");
        
    }
}
