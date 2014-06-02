package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void testChangePassword () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        User_ListAll user_ListAll = contactListAll.menuUser.clickManageUsers();
        user_ListAll.formSearch.find("FirstSelenium");
        User_Edit user_Edit = user_ListAll.clickUser("Selenium" + AbstractSuite.UNIQUE + "@email.com", "test");
        user_Edit.clickPasswordField();
        user_Edit.enterNewPassword("changed1");
        user_Edit.enterNewPasswordConfirm("changed1");
        user_Edit.clickChangePassword();
        
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
        login.as("Selenium" + AbstractSuite.UNIQUE + "@email.com", "changed1");
        Thread.sleep(10000);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        if(contactListAll.verifyPage()==null)
        {
            fail("couldnt find new user password");
        }
        contactListAll.menuUser.open();
        contactListAll.menuUser.clickLogOut();
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
