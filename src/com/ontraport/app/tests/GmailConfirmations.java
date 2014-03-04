package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gmail;
import com.ontraport.app.pages.Sender_View;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class GmailConfirmations extends AbstractTest
{
    @Test
    public void testGmailConfirmations () throws InterruptedException
    {
        driver.get("https://mail.google.com");
        try
        {
        driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
        }
        catch(Exception e)
        {
            
        }
        Gmail gmail = (Gmail) new Gmail().init();
        gmail.enterUserName("seleniumontraport@gmail.com");
        gmail.enterPassword("Test12345");
        gmail.clickSignIn();
        if(gmail.clickOneOffEmail()==null)
        {
            fail("couldint find one ofr email");
        }
        gmail.clickDelete();
        if(gmail.clickBroadcastEmails()==null)
        {
            fail("couldint find broadcast email");
        }
        gmail.clickDelete();
        if(gmail.clickAndVerifyDateEmail()==null)
        {
            fail("couldint find Date email");
        }
        gmail.clickDelete();
        if(gmail.clickAndVerifyScheduledBroadcastEmail()==null)
        {
            fail("couldint find scheduled broadcast email");
        }
        gmail.clickDelete();
        if(gmail.clickAndVerifyScheduledOneOffEmail()==null)
        {
            fail("couldint find schedule one off email");
        }
        gmail.clickDelete();
        String time = null;
        time = gmail.getImmediateSubjectTime();
        if(time==null)
        {
            fail("couldnt find immediate sequence email");
        }
        gmail.clickDelete();
        if(gmail.clickDelayEmailAndVerifyTime(time)==null)
        {
            fail("couldnt verify delay sequence step");
        }
        gmail.clickDelete();
        gmail.clickConfirmationEmail();
        gmail.clickLink();
        gmail.clickDelete();
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.switchTo().defaultContent();
        }
        catch(Exception e)
        {
            
        }
        driver.get(AbstractPage.getUrl() + AbstractPage.getLatch() + Sender_View.url);
        AbstractPart.waitForAjax(driver, 30);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='chrome-company-logo ussr-helper-position-reset']")));
        //verify App Name, ID, Redirect, and Visits
        Sender_View sender_View = (Sender_View) new Sender_View().init();
        if(sender_View.verifyConfirmed("seleniumontraport@gmail.com")==null)
        {
            fail("couldnt find send from address");
        }
        driver.get("mail.google.com");
          gmail = (Gmail) new Gmail().init();
          gmail.clickDoubleOptin();
          gmail.clickDoubleOptinLink();
          gmail.clickDelete();
          try{
              Alert alert = driver.switchTo().alert();
              alert.accept();
              driver.switchTo().defaultContent();
          }
          catch(Exception e)
          {
              
          }
          driver.get(AbstractPage.getUrl() + AbstractPage.getLatch() + Contact_ListAll.url);
          AbstractPart.waitForAjax(driver, 30);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='chrome-company-logo ussr-helper-position-reset']")));
          //verify App Name, ID, Redirect, and Visits
          Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
          contact_ListAll.formSearch.find(value.get("Contacts", "double_optin_email"));
          Contact_Edit contact_Edit = contact_ListAll.clickContact(value.get("Contacts", "double_optin_email"));
          if(contact_Edit.verifyDoubleOptin()==null)
          {
              fail("couldnt verify double opted in");
          }
          contact_ListAll = contact_Edit.menuPrimary.clickContactListAll();
          contact_ListAll.formSearch.find(value.get("Contacts", "double_optin_email"));
          contact_ListAll.selectAllOnPage();
          contact_ListAll.drawerActions.clickDeleteContacts();
          contact_ListAll.dialogBox.clickOk();
          
          //verify its gone
          if(contact_ListAll.verifyNoContact()==null)
          {
              fail("found deleted contatct");
          }
          driver.get("mail.google.com");
            gmail = (Gmail) new Gmail().init();
          
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
         

  
    }
}
