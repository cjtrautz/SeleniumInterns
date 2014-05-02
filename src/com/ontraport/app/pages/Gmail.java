package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;


public class Gmail extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tr[td[contains(., '(2)')] and td[contains(., 'BroadcastSubject')]]")
    private WebElement broadCastEmails;
    
    @FindBy(how = How.XPATH,
            using = "//tr[td[contains(., '(2)')] and td[contains(., 'SelScheduledBroadcast')]]")
    private WebElement scheduledBroadCastEmails;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(., 'SelScheduledBroadcast')]/ancestor::tr/td[@class='xW xY ']/span")
    private WebElement scheduledBroadcastTime;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='SelScheduledOneOff']")
    private WebElement oneOffScheduledEmail;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(., 'SelScheduledOneOff')]/ancestor::tr/td[@class='xW xY ']/span")
    private WebElement scheduledOneOffTime;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='ImmediateSubject']")
    private WebElement immedEmail;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(., 'ImmediateSubject')]/ancestor::tr/td[@class='xW xY ']/span")
    private WebElement immedEmailTime;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='DelayedSubject']")
    private WebElement delayedEmail;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(., 'DelayedSubject')]/ancestor::tr/td[@class='xW xY ']/span")
    private WebElement delayedEmailTime;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='DateSubject']")
    private WebElement dateEmail;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='Please confirm your subscription.']")
    private WebElement doubleOptin;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(., 'DateSubject')]/ancestor::tr/td[@class='xW xY ']/span")
    private WebElement dateEmailTime;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='SelSubject']")
    private WebElement testEmail;
    
    @FindBy(how = How.XPATH,
            using = "//span[.='OneOffSubject']")
    private WebElement oneOffEmail;
    
    @FindBy(how = How.XPATH,
            using = "//input[@id='Email']")
    private WebElement userName;
    
    @FindBy(how = How.XPATH,
            using = "//input[@id='Passwd']")
    private WebElement password;
    
    @FindBy(how = How.XPATH,
            using = "//input[@id='signIn']")
    private WebElement signIn;
    
    @FindBy(how = How.XPATH,
        using = "//span[@name='Confirmation Email']")
    private WebElement confirmationEmail;
    
    @FindBy(how = How.XPATH,
        using = "//a[contains(@href, 'https://forms.ontraport.com')]")
    private WebElement link;
    
    @FindBy(how = How.XPATH,
            using = "//a[contains(@href, 'http://forms.ontraport.com')]")
        private WebElement doubleOptinLink;
    
    @FindBy(how = How.XPATH,
        using = "//div[@class=' G-atb D E']//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private WebElement delete;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id=':31']")
        private WebElement primary;

    public Gmail enterUserName ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        try{
            wait.until(ExpectedConditions.visibilityOf(userName));
            userName.sendKeys(string);
        }
        catch(NoSuchElementException e)
        {
            
        }
        return this;
    }

    public Gmail enterPassword ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(password));
            password.sendKeys(string);
        }
        catch(NoSuchElementException e)
        {
        
        }
        return this;
    }

    public Gmail clickSignIn ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(signIn));
            signIn.click();
        }
        catch(NoSuchElementException e)
        {
            
        }
        return this;
        
    }

    public Gmail clickConfirmationEmail ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(confirmationEmail));
            confirmationEmail.click();
        }
        catch(NoSuchElementException e)
        {
            driver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOf(confirmationEmail));
            confirmationEmail.click();
        }
        return this;
        
    }

    public Gmail clickLink ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();
        //driver.switchTo().defaultContent();
        return this;
        
    }

    public Gmail clickDelete ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        //driver.switchTo().defaultContent();
        try
        {
            wait.until(ExpectedConditions.visibilityOf(delete));
            delete.click();
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(delete));
            delete.click();
        }
       // wait.until(ExpectedConditions.visibilityOf(primary));
        return this;
        
    }

    public Gmail clickMessageFrom ()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(testEmail));
            testEmail.click();
        }
        catch(NoSuchElementException e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(testEmail));
                testEmail.click();
            }
            catch(NoSuchElementException e2){
                return null;
            }
        }
        return this;
    }

    public Gmail clickOneOffEmail ()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(oneOffEmail));
            oneOffEmail.click();
        }
        catch(NoSuchElementException e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(oneOffEmail));
                oneOffEmail.click();
            }
            catch(NoSuchElementException e2){
                return null;
            }
        }
        return this;
    }
    
    public Gmail clickDoubleOptin ()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(doubleOptin));
            doubleOptin.click();
        }
        catch(NoSuchElementException e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(doubleOptin));
                doubleOptin.click();
            }
            catch(NoSuchElementException e2){
                return null;
            }
        }
        return this;
    }

    public Gmail clickBroadcastEmails ()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(broadCastEmails));
            broadCastEmails.click();
        }
        catch(NoSuchElementException e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(broadCastEmails));
                broadCastEmails.click();
            }
            catch(NoSuchElementException e2){
                return null;
            }
        }
        return this;
    }

    public String getImmediateSubjectTime ()
    {
        String parse = null;
        int yep = 0;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(immedEmailTime));
            parse = immedEmailTime.getText();
            String delim = "[ :]";
            String[] stuff = parse.split(delim);
            String finale = stuff[0] + stuff[1] + stuff[2];
            System.out.println(finale);
            //yep = Integer.parseInt(finale);
            wait.until(ExpectedConditions.visibilityOf(immedEmail));
            immedEmail.click();
        }
        catch(NoSuchElementException e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(immedEmailTime));
                parse = immedEmailTime.getText();
                String delim = "[ :]";
                String[] stuff = parse.split(delim);
                String finale = stuff[0] + stuff[1] + stuff[2];
                System.out.println(finale);
                //yep = Integer.parseInt(finale);
                wait.until(ExpectedConditions.visibilityOf(immedEmail));
                immedEmail.click();
            }
            catch(NoSuchElementException e2){
                return null;
            }
        }
        return parse;
    }

    public Gmail clickDelayEmailAndVerifyTime ( String time )
    {
        int yep = 0;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(delayedEmailTime));
            String parse = delayedEmailTime.getText();
            String delim = "[ :]";
            String[] stuff = parse.split(delim);
            String finale = stuff[0] + stuff[1];
            System.out.println(finale);
            yep = Integer.parseInt(finale);
            int hours1 = yep/100; 
            System.out.println(hours1);
            int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
            if(stuff[2].equals("pm") && (!stuff[1].equals("12")))
            {
                System.out.println("not 12 pm1");
                yep2=yep2+720;
            }
            if(stuff[2].equals("am") && stuff[1].equals("12"))
            {
                System.out.println("12 am1");
                yep2=yep2+720;
            }
            String delim2 = "[ :]";
            String[] stuff2 = time.split(delim2);
            String finale2 = stuff2[0] + stuff2[1];
            System.out.println(finale2);
            int newTime = Integer.parseInt(finale2);
            int hours2 = newTime/100; 
            System.out.println(hours2);
            int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
            if(stuff2[2].equals("pm") && (!stuff2[1].equals("12")))
            {
                System.out.println("not 12 pm");
                time2=time2+720;
            }
            if(stuff2[2].equals("am") && stuff2[1].equals("12"))
            {
                System.out.println("12 am");
                time2=time2+720;
            }
            System.out.println(yep2 + "and" + time2);
            if((time2+10) > yep2 | yep2 > (time2+45))
            {
                return null;
            }
            wait.until(ExpectedConditions.visibilityOf(delayedEmail));
            delayedEmail.click();
        }
        catch(Exception e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(delayedEmailTime));
                String parse = delayedEmailTime.getText();
                String delim = "[ :]";
                String[] stuff = parse.split(delim);
                String finale = stuff[0] + stuff[1];
                System.out.println(finale);
                yep = Integer.parseInt(finale);
                int hours1 = yep/100; 
                System.out.println(hours1);
                int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
                if(stuff[2].equals("pm") && !stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                if(stuff[2].equals("am") && stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                String delim2 = "[ :]";
                String[] stuff2 = time.split(delim2);
                String finale2 = stuff2[0] + stuff2[1];
                System.out.println(finale2);
                int newTime = Integer.parseInt(finale2);
                int hours2 = newTime/100; 
                System.out.println(hours2);
                int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
                if(stuff2[2].equals("pm") && !stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                if(stuff2[2].equals("am") && stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                System.out.println(yep2 + "and" + time2);
                if((time2+10) > yep2 | yep2 > (time2+45))
                {
                    return null;
                }
                wait.until(ExpectedConditions.visibilityOf(delayedEmail));
                delayedEmail.click();
            }
            catch(Exception e2){
                return null;
            }
        }
        return this;
    }

    public Gmail clickAndVerifyDateEmail ()
    {
        int yep = 0;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(dateEmailTime));
            String parse = dateEmailTime.getText();
            String delim = "[ :]";
            String[] stuff = parse.split(delim);
            String finale = stuff[0] + stuff[1];
            System.out.println(finale);
            yep = Integer.parseInt(finale);
            int hours1 = yep/100; 
            System.out.println(hours1);
            int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
            if(stuff[2].equals("pm") && !stuff[1].equals("12"))
            {
                yep2=yep2+720;
            }
            if(stuff[2].equals("am") && stuff[1].equals("12"))
            {
                yep2=yep2+720;
            }
            String[] stuff2 = AbstractTest.getDateTime().split(delim);
            int time = Integer.parseInt(stuff2[0] + stuff2[1]);
            int hours2 = time/100; 
            System.out.println(hours2);
            int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
            if(stuff2[2].equals("PM") && !stuff2[1].equals("12"))
            {
                time2=time2+720;
            }
            if(stuff2[2].equals("AM") && stuff2[1].equals("12"))
            {
                time2=time2+720;
            }
            System.out.println(yep2 + "and" + time2);
            if((time2) > yep2 | yep2 > (time2+20))
            {
                return null;
            }
            wait.until(ExpectedConditions.visibilityOf(dateEmail));
            dateEmail.click();
        }
        catch(Exception e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(dateEmailTime));
                String parse = dateEmailTime.getText();
                String delim = "[ :]";
                String[] stuff = parse.split(delim);
                String finale = stuff[0] + stuff[1];
                System.out.println(finale);
                yep = Integer.parseInt(finale);
                int hours1 = yep/100; 
                System.out.println(hours1);
                int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
                if(stuff[2].equals("pm") && !stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                if(stuff[2].equals("am") && stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                String[] stuff2 = AbstractTest.getDateTime().split(delim);
                int time = Integer.parseInt(stuff2[0] + stuff2[1]);
                int hours2 = time/100; 
                System.out.println(hours2);
                int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
                if(stuff2[2].equals("PM") && !stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                if(stuff2[2].equals("AM") && stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                System.out.println(yep2 + "and" + time2);
                if((time2) > yep2 | yep2 > (time2+10))
                {
                    return null;
                }
                wait.until(ExpectedConditions.visibilityOf(dateEmail));
                dateEmail.click();
            }
            catch(Exception e2){
                return null;
            }
        }
        return this;
    }
    public Gmail clickAndVerifyScheduledBroadcastEmail ()
    {
        int yep = 0;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(scheduledBroadcastTime));
            String parse = scheduledBroadcastTime.getText();
            String delim = "[ :]";
            String[] stuff = parse.split(delim);
            String finale = stuff[0] + stuff[1];
            System.out.println(finale);
            yep = Integer.parseInt(finale);
            int hours1 = yep/100; 
            System.out.println(hours1);
            int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
            if(stuff[2].equals("pm") && !stuff[1].equals("12"))
            {
                yep2=yep2+720;
            }
            if(stuff[2].equals("am") && stuff[1].equals("12"))
            {
                yep2=yep2+720;
            }
            String[] stuff2 = AbstractTest.getScheduledBlastTime().split(delim);
            int time = Integer.parseInt(stuff2[0] + stuff2[1]);
            int hours2 = time/100; 
            System.out.println(hours2);
            int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
            if(stuff2[2].equals("PM") && !stuff2[1].equals("12"))
            {
                time2=time2+720;
            }
            if(stuff2[2].equals("AM") && stuff2[1].equals("12"))
            {
                time2=time2+720;
            }
            System.out.println(yep2 + "and" + time2);
            if((time2-5) > yep2 | yep2 > (time2+20))
            {
                return null;
            }
            wait.until(ExpectedConditions.visibilityOf(scheduledBroadCastEmails));
            scheduledBroadCastEmails.click();
        }
        catch(Exception e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(scheduledBroadcastTime));
                String parse = scheduledBroadcastTime.getText();
                String delim = "[ :]";
                String[] stuff = parse.split(delim);
                String finale = stuff[0] + stuff[1];
                System.out.println(finale);
                yep = Integer.parseInt(finale);
                int hours1 = yep/100; 
                System.out.println(hours1);
                int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
                if(stuff[2].equals("pm") && !stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                if(stuff[2].equals("am") && stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                String[] stuff2 = AbstractTest.getScheduledBlastTime().split(delim);
                int time = Integer.parseInt(stuff2[0] + stuff2[1]);
                int hours2 = time/100; 
                System.out.println(hours2);
                int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
                if(stuff2[2].equals("PM") && !stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                if(stuff2[2].equals("AM") && stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                System.out.println(yep2 + "and" + time2);
                if((time2-5) > yep2 | yep2 > (time2+20))
                {
                    return null;
                }
                wait.until(ExpectedConditions.visibilityOf(scheduledBroadCastEmails));
                scheduledBroadCastEmails.click();
            }
            catch(Exception e2){
                return null;
            }
        }
        return this;
    }

    public Gmail clickAndVerifyScheduledOneOffEmail ()
    {
        int yep = 0;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(scheduledOneOffTime));
            String parse = scheduledOneOffTime.getText();
            String delim = "[ :]";
            String[] stuff = parse.split(delim);
            String finale = stuff[0] + stuff[1];
            System.out.println(finale);
            yep = Integer.parseInt(finale);
            int hours1 = yep/100; 
            System.out.println(hours1);
            int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
            if(stuff[2].equals("pm") && !stuff[1].equals("12"))
            {
                yep2=yep2+720;
            }
            if(stuff[2].equals("am") && stuff[1].equals("12"))
            {
                yep2=yep2+720;
            }
            String[] stuff2 = AbstractTest.getScheduledOneOffTime().split(delim);
            int time = Integer.parseInt(stuff2[0] + stuff2[1]);
            int hours2 = time/100; 
            System.out.println(hours2);
            int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
            if(stuff2[2].equals("PM") && !stuff2[1].equals("12"))
            {
                time2=time2+720;
            }
            if(stuff2[2].equals("AM") && stuff2[1].equals("12"))
            {
                time2=time2+720;
            }
            System.out.println(yep2 + "and" + time2);
            if((time2-5) > yep2 | yep2 > (time2+20))
            {
                return null;
            }
            wait.until(ExpectedConditions.visibilityOf(oneOffScheduledEmail));
            oneOffScheduledEmail.click();
        }
        catch(Exception e){

            driver.navigate().refresh();
            try
            {
                wait.until(ExpectedConditions.visibilityOf(scheduledOneOffTime));
                String parse = scheduledOneOffTime.getText();
                String delim = "[ :]";
                String[] stuff = parse.split(delim);
                String finale = stuff[0] + stuff[1];
                System.out.println(finale);
                yep = Integer.parseInt(finale);
                int hours1 = yep/100; 
                System.out.println(hours1);
                int yep2 = (hours1*60) + Integer.parseInt(stuff[1]);
                if(stuff[2].equals("pm") && !stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                if(stuff[2].equals("am") && stuff[1].equals("12"))
                {
                    yep2=yep2+720;
                }
                String[] stuff2 = AbstractTest.getScheduledOneOffTime().split(delim);
                int time = Integer.parseInt(stuff2[0] + stuff2[1]);
                int hours2 = time/100; 
                System.out.println(hours2);
                int time2 = (hours2*60) + Integer.parseInt(stuff2[1]);
                if(stuff2[2].equals("PM") && !stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                if(stuff2[2].equals("AM") && stuff2[1].equals("12"))
                {
                    time2=time2+720;
                }
                System.out.println(yep2 + "and" + time2);
                if((time2-5) > yep2 | yep2 > (time2+20))
                {
                    return null;
                }
                wait.until(ExpectedConditions.visibilityOf(oneOffScheduledEmail));
                oneOffScheduledEmail.click();
            }
            catch(Exception e2){
                return null;
            }
        }
        return this;
    }

    public Gmail clickDoubleOptinLink ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(doubleOptinLink));
        doubleOptinLink.click();
        //driver.switchTo().defaultContent();
        return this;
    }
    
}
