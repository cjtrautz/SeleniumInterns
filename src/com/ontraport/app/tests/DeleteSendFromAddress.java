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

public class DeleteSendFromAddress extends AbstractTest
{
    @Test
    public void testDeleteSendFromAddress () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Sender_View sender_View = account_View.clickSendFrom();
        sender_View.clickRemove("njcross1990@gmail.com");
        
        if(sender_View.verifyNoSendFrom("njcross1990@gmail.com")==null)
        {
            fail("couldnt find Facebook app");
        }



        
    }
}