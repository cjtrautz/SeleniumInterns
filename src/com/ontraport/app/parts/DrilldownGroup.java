package com.ontraport.app.parts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DrilldownGroup extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]")
    private WebElement uiGroupSelector;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]//button[@value='0' or]")
    private WebElement uiButtonGroupSelectorAll;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]//button")
    private WebElement uiButtonGroupSelector;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]")
    private WebElement groupSelectorPane;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]//li/div[text()='Group: All']")
    private WebElement groupAll;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-drilldownselect-menu ')]")
    private WebElement drillDownMenu;
    public DrilldownGroup toggle ()
    {
        wait(1).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiButtonGroupSelector)));
        uiButtonGroupSelector.click();
        return this;
    }
    public DrilldownGroup open ()
    {
        toggle();
        return this;
    }
    public DrilldownGroup close ()
    {
        toggle();
        return this;
    }
    public Boolean confirmGroupExists (String name)
    {
        open();
        System.out.println(uiGroupSelector.findElement(By.xpath(".//div[text()='"+name+"']")).getText());
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if (uiGroupSelector.findElement(By.xpath(".//div[text()='"+name+"']")).getText().equals(name))
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                close();
                return true;
            }
            else
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                close();
                return false;
            }
        }
        catch (NoSuchElementException nsee)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            close();
            return false;
        }
    }
    public Boolean confirmGroupDoesntExists (String name)
    {
        open();
        //System.out.println(uiGroupSelector.findElement(By.xpath(".//div[text()='"+name+"']")).getText());
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if (uiGroupSelector.findElement(By.xpath(".//div[text()='"+name+"']")).getText().equals(name))
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                close();
                return false;
            }
            else
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                close();
                return true;
            }
        }
        catch (NoSuchElementException nsee)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            close();
            return true;
        }
    }
    public Boolean confirmGroupNotAll ()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(2, TimeUnit.SECONDS);
            if (wait(1).until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiButtonGroupSelectorAll)))) != null)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return true;
            }
            else
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return false;
            }
        }
        catch (NoSuchElementException nsee)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return true;
        }

    }
    public Boolean confirmGroupAll ()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(2, TimeUnit.SECONDS);
            
            if (wait(1).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiButtonGroupSelectorAll))) != null)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return true;
            }
            else
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return false;
            }
        }
        catch (NoSuchElementException nsee)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return true;
        }

    }
    public DrilldownGroup clickGroupAll ()
    {
        open();
        wait(1).until(ExpectedConditions.visibilityOf(groupSelectorPane));
        groupAll.click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(drillDownMenu)));
        return this;
        
    }
    public DrilldownGroup clickGroup ( String name )
    {
        wait(1).until(ExpectedConditions.visibilityOf(groupSelectorPane));
        groupSelectorPane.findElement(By.xpath(".//li/div[text()='" + name + "']")).click();
        return this;
        
    }
}
