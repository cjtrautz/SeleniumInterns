package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

public class Facebook_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_input_text ')]//label[text()='Name your App']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement nameYourApp;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_input_text ')]//label[text()='Application ID']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement applicationID;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_input_text ')]//label[text()='Redirect']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement redirect;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_input_text ')]//label[text()='Visits']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement visits;
    
    public Facebook_Edit verifyFacebookName (String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(nameYourApp));
            String compare = nameYourApp.getText();
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    } 
    
    public Facebook_Edit verifyApplicationId (String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(applicationID));
            String compare = applicationID.getText();
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    
    public Facebook_Edit verifyRedirect (String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(redirect));
            String compare = redirect.getText();
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    
    public Facebook_Edit verifyVisits (String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(visits));
            String compare = visits.getText();
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
}
