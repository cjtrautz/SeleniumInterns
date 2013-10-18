package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Facebook_Create;
import com.ontraport.app.pages.Facebook_Edit;
import com.ontraport.app.pages.Facebook_ListAll;
import com.ontraport.app.pages.Gmail;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Sender_View;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractTest;

public class SendTestEmail extends AbstractTest
{
    @Test
    public void testSendTestEmail () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find("SelEmailMessage");
        Message_Edit message_Edit = message_ListAll.clickMessage("SelEmailMessage");
        message_Edit.clickSendTestEmail();
        message_Edit.dialogBox.enterEmail("njcross1990@gmail.com");
        message_Edit.dialogBox.clickSend();
        if(message_Edit.verifyEmailSent()==null)
        {
            fail("no notification of sent email");
        }
        Thread.sleep(20000);
        driver.get("gmail.com");
        driver.navigate().refresh();
        Gmail gmail = (Gmail) new Gmail().init();
        gmail.enterUserName("njcross1990@gmail.com");
        gmail.enterPassword("Lughead1");
        gmail.clickSignIn();
        driver.navigate().refresh();
        if(gmail.clickMessageFrom()==null)
        {
            fail("couldnt find sent message");
        }

        gmail.clickDelete();
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch(NoAlertPresentException e)
        {
            
        }
        driver.get(AbstractPage.getUrl() + Contact_ListAll.url);
        AbstractPart.waitForAjax(driver, 30);
//        contactListAll.menuUser.open();
//        account_View = contactListAll.menuUser.clickAdmin();
//        sender_View = account_View.clickSendFrom();
        //Thread.sleep(3000);




        
    }
}
