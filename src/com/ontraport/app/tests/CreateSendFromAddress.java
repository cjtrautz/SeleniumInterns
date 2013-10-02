package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Facebook_Create;
import com.ontraport.app.pages.Facebook_Edit;
import com.ontraport.app.pages.Facebook_ListAll;
import com.ontraport.app.pages.Gmail;
import com.ontraport.app.pages.Sender_View;
import com.ontraport.app.tools.AbstractTest;

public class CreateSendFromAddress extends AbstractTest
{
    @Test
    public void testCreateSendFromAddress () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Sender_View sender_View = account_View.clickSendFrom();
        sender_View.clickAddEmail();
        sender_View.dialogBox.enterEmailAddress("njcross1990@gmail.com");
        sender_View.dialogBox.addEmail("njcross1990@gmail.com");
        driver.get("gmail.com");
        Gmail gmail = (Gmail) new Gmail().init();
        gmail.enterUserName("njcross1990@gmail.com");
        gmail.enterPassword("Lughead1");
        gmail.clickSignIn();
        gmail.clickConfirmationEmail();
        gmail.clickLink();
        gmail.clickDelete();
        driver.get("http://app.ontraport.com/?track_requests=1/#!/sender/view");
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='chrome-company-logo ussr-helper-position-reset']")));
        //verify App Name, ID, Redirect, and Visits
        if(sender_View.verifyConfirmed("njcross1990@gmail.com")==null)
        {
            fail("couldnt find Facebook app");
        }


        
    }
}