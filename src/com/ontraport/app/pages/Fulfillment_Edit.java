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

public class Fulfillment_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//label[text()='Fulfillment list name']/following-sibling::div/input[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input ')]")
    private WebElement fulfillmentListNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-frequency-scheduler-target-time ')]//input")
    private WebElement frequencySchedulerTime;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-fields ')]")
    private WebElement fulfillmentTargetFields;    
    
    public Fulfillment_Edit verifyFulfillmentName (String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(fulfillmentListNameInput));
            String compare = fulfillmentListNameInput.getAttribute("value");
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
    
    public Fulfillment_Edit verifyFrequencyScheduler (String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(frequencySchedulerTime));
            String compare = frequencySchedulerTime.getAttribute("value");
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
    public Fulfillment_Edit verifyFieldValue (int index, String value)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(fulfillmentTargetFields));
            List<WebElement> fulfillmentFieldAreas= fulfillmentTargetFields.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sortablelist-option ')]/span"));
            String compare = fulfillmentFieldAreas.get(index-1).getText();
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
