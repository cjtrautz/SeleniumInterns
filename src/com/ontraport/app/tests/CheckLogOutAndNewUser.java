package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CheckLogOutAndNewUser extends AbstractTest
{
    @Test
    public void testCheckLogOut () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='menu-item-9']//a[.='Features']")));
        }
        catch(Exception e)
        {
            System.out.println("Can't find log out page 1");
        }
        Login login = (Login) new Login().init();
        login.open(Login.url);
        login.as("Selenium" + AbstractSuite.UNIQUE + "@email.com", "test123");
        if(contactListAll.verifyPage()==null)
        {
            fail("couldnt find selenium log in");
        }
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
        AbstractPart.waitForAjax(driver, 25);
        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='menu-item-9']//a[.='Features']")));
        }
        catch(Exception e)
        {
            System.out.println("Can't find log out page 2");
        }
        login = (Login) new Login().init();
        login.open(Login.url);
        login.as(AbstractPage.getLogin(), AbstractPage.getPassword());
        Thread.sleep(10000);
        
    }
}
