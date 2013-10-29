package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
        driver.get("mail.google.com");
        Gmail gmail = (Gmail) new Gmail().init();
        gmail.enterUserName("njcross1990@gmail.com");
        gmail.enterPassword("Lughead1");
        gmail.clickSignIn();
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
        if(sender_View.verifyConfirmed("njcross1990@gmail.com")==null)
        {
            fail("couldnt find send from address");
        }
          driver.get("gmail.com");
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
