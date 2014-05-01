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
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Rule_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-checked ')]")
    private WebElement checkedCheckBox;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]")
    private WebElement whenEvents;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]")
    private WebElement ifEvents;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]")
    private WebElement thenEvents;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//ul[contains(concat(' ', normalize-space(@class), ' '),' component-simple-list-target-ul ')]")
    private WebElement thenEventsList;
    
    public Rule_Edit verifyIfTextArea (int index, String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(ifEvents));
            List<WebElement> thenTextAreas= ifEvents.findElements(By.xpath(".//textarea"));
            String compare = thenTextAreas.get(index-1).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyTextLabel (String text)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[text()='" + text + "']"));
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
    public Rule_Edit verifyTextDiv (String text)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[text()='" + text + "']"));
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

    public Rule_Edit verifyText (String text)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[text()=\"" + text + "\"]"));
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
      public Rule_Edit verifyTDText (String text)
        {
            AbstractPart.waitForAjax(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(ifEvents));
            try
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//td[text()='" + text + "']"));
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
    public Rule_Edit verifyHeaderText (String text)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//th[text()='" + text + "']"));
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

    public Rule_Edit verifyThenTextArea (int index, String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(thenEvents));
            List<WebElement> thenTextAreas= thenEvents.findElements(By.xpath(".//textarea"));
            String compare = thenTextAreas.get(index-1).getAttribute("value");
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
    public Rule_Edit verifyWhenDropDownInputText (int index, String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(whenEvents));
            List<WebElement> whenDropDowns = whenEvents.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-drilldownselect ')]"));
            String compare = whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
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
    
    public Rule_Edit verifyIfDropDownInputText (int index, String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(whenEvents));
            List<WebElement> whenDropDowns = ifEvents.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-drilldownselect ')]"));
            String compare = whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
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

     
    public Rule_Edit verifyThenDropDownInputText (int index, String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(whenEvents));
            List<WebElement> whenDropDowns = thenEvents.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-drilldownselect ')]"));
            System.out.println(whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
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
    public Rule_Edit verifyChecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            if(!checkedCheckBox.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyThenInput ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        try
        {
            List<WebElement> stuff = thenEvents.findElements(By.xpath(".//input"));
            System.out.println(stuff.get(i-1).getAttribute("value"));
            if(!stuff.get(i-1).getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyWhenDropDownInputTextContains ( int index, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(whenEvents));
            List<WebElement> whenDropDowns = whenEvents.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-drilldownselect ')]"));
            String compare = whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
            if(compare.contains(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyIfDropDownInputTextContains ( int index, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(whenEvents));
            List<WebElement> whenDropDowns = ifEvents.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-drilldownselect ')]"));
            String compare = whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
            if(compare.contains(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyThenDropDownInputTextContains ( int index, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(whenEvents));
            List<WebElement> whenDropDowns = thenEvents.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-drilldownselect ')]"));
            String compare = whenDropDowns.get(index-1).findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
            if(compare.contains(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyIfInput ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            List<WebElement> stuff = ifEvents.findElements(By.xpath(".//input"));
            System.out.println(stuff.get(i-1).getAttribute("value"));
            if(!stuff.get(i-1).getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Rule_Edit verifyThenList ( int i, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(ifEvents));
            List<WebElement> thenTextAreas= thenEventsList.findElements(By.xpath(".//li"));
            String compare = thenTextAreas.get(i-1).getText();
            System.out.println(compare);
            //System.out.println(value);
            if(compare.contains(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    } 

}
