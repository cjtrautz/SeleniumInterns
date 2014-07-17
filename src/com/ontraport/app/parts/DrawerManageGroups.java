package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DrawerManageGroups extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_group_edit']")
    private WebElement uiToggleDrawerManageGroupsPane;

    @FindBy(how = How.XPATH,
            using = "//label[text()='Group Name']/following-sibling::div/input")
    private WebElement uiInputGroupName;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Group Permissions']/following-sibling::div/input")
    private WebElement uiInputGroupPermissions;

    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', @class, ' '),' group_editor_public ')]//button")
    private WebElement uiToggleGroupPermissionsPane;

    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ',@class,' '),' group_editor_public ')]//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-menu ')]")
    private WebElement uiGroupPermissionsList;

    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_field']//button")
    private List<WebElement> uiToggleFieldPane;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_field']//input")
    private List<WebElement> uiFieldPaneInput;

    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_field']//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-listview ')]")
    private List<WebElement> uiFieldList;

    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_condition']//button")
    private List<WebElement> uiToggleConditionPane;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_condition']//input")
    private List<WebElement> uiConditionPaneInput;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_value']//button")
    private List<WebElement> uiToggleValuePane;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_value']//div[contains(concat(' ',@class,' '),' ussr-form-input-type-checkbox ')]/div/a")
    private List<WebElement> uiValueCheckbox;
   
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_value']//div[contains(concat(' ',@class,' '),' ussr-form-input-type-checkbox ')]/div/a/span[@class='ussr-icon ussr-icon-checkbox-checked']")
    private List<WebElement> uiValueCheckboxChecked;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_value']//div[contains(concat(' ',@class,' '),' ussr-form-input-type-checkbox ')]/div/a/span[@class='ussr-icon ussr-icon-checkbox-empty']")
    private List<WebElement> uiValueCheckboxEmpty;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[contains(@class, 'sem_value')]//input")
    private List<WebElement> uiValuePaneInput;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[contains(@class, 'sem_value')]//textarea")
    private List<WebElement> uiValuePaneTextArea;

    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_condition']//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-listview ')]")
    private List<WebElement> uiConditionList;
    
    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_value']//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-listview ')]")
    private List<WebElement> uiValueList;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '), ' sem-segment-entry ')]")
    private List<WebElement> uiInputValueRows;

    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ',@class,' '), ' sem-save-button ')]")
    private WebElement uiButtonSave;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ',@class,' '), ' sem-new-button ')]")
    private WebElement uiButtonNew;
    
    @FindBy(how = How.XPATH,
    using = "//button[contains(concat(' ',@class,' '), ' sem-delete-button ')]")
private WebElement uiButtonDeleteGroup;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]")
    private WebElement uiSelectedGroupDisplayHook;

    public DrawerManageGroups open ()
    {
        toggle();
        return this;
    }
    public DrawerManageGroups close ()
    {
        toggle();
        return this;
    }
    public DrawerManageGroups toggle ()
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleDrawerManageGroupsPane));
        uiToggleDrawerManageGroupsPane.click();
        return this;
    }
    public DrawerManageGroups enterGroupName ( String groupname )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiInputGroupName));
        uiInputGroupName.sendKeys(groupname);
        return this;
    }
    public DrawerManageGroups openGroupPermissionsPane ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(uiToggleGroupPermissionsPane));
        uiToggleGroupPermissionsPane.click();
        return this;
    }
    public DrawerManageGroups clickPermissions ( String permissions )
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(uiGroupPermissionsList));
        wait(5).until(ExpectedConditions.visibilityOf(uiGroupPermissionsList.findElement(By.xpath(".//li/div[contains(text(), '"+permissions+"')]"))));
        Actions action = new Actions(driver);
        action.click(uiGroupPermissionsList.findElement(By.xpath(".//li/div[contains(text(), '"+permissions+"')]"))).build().perform();
        wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiGroupPermissionsList)));
        return this;
    }
    public DrawerManageGroups openFieldPane (int row)
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(uiToggleFieldPane.get(row)));
        uiToggleFieldPane.get(row).click();
        return this;
    }
    
    public DrawerManageGroups enterFieldPaneInput (String string, int row)
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(uiToggleFieldPane.get(row)));
        uiFieldPaneInput.get(row).sendKeys(string);
        return this;
    }
    
    public DrawerManageGroups clickField ( String field,  int row )
    {
        waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", uiFieldList.get(row).findElement(By.xpath(".//div[contains(text(), '"+field+"')]")));
        wait(1).until(ExpectedConditions.visibilityOf(uiFieldList.get(row).findElement(By.xpath(".//div[contains(text(), '"+field+"')]"))));
        uiFieldList.get(row).findElement(By.xpath(".//div[contains(text(), '"+field+"')]")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiFieldList.get(row))));
        return this;
    }
    public DrawerManageGroups openConditionPane (int row)
    {
        waitForAjax(driver, 20);
        //idk how else to do this
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        wait(10).until(ExpectedConditions.visibilityOf(uiToggleConditionPane.get(row)));
        uiToggleConditionPane.get(row).click();
        return this;
    }
    public DrawerManageGroups clickCondition ( String condition, int row )
    {
        waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(uiConditionList.get(row).findElement(By.xpath(".//div[contains(text(), '"+condition+"')]"))));
        uiConditionList.get(row).findElement(By.xpath(".//div[contains(text(), '"+condition+"')]")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN).build().perform();
        wait(10).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiConditionList.get(row))));
        return this;
    }
    public DrawerManageGroups enterValue ( String value, int row, int index )
    {
        waitForAjax(driver, 20);
        List<WebElement> ya = uiInputValueRows.get(row).findElements(By.xpath("//tr[@class='sem_condition_row']//td[contains(@class,'sem_value')]//input"));
        ya.get(index).click();
        ya.get(index).clear();
        ya.get(index).sendKeys(value);
        return this;
    }
    public DrawerManageGroups enterValueTextArea ( String value, int row, int index )
    {
        waitForAjax(driver, 20);
        List<WebElement> ya = uiInputValueRows.get(row).findElements(By.xpath("//tr[@class='sem_condition_row']//td[contains(@class,'sem_value')]//textarea"));
        ya.get(index).sendKeys(value);
        return this;
    }
    public Boolean confirmGroupApplied (final String name)
    {
        waitForAjax(driver, 20);
        try
        {
            wait(1).until(ExpectedConditions.stalenessOf(uiSelectedGroupDisplayHook.findElement(By.xpath(".//button[@value='0']"))));
            return true;
        }
        catch (TimeoutException te)
        {
            return false;
        }
    }
    public DrawerManageGroups clickSave ()
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiButtonSave));
        uiButtonSave.click();
        return this;
    }
    public DrawerManageGroups clickNew ()
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiButtonNew));
        uiButtonNew.click();
        return this;
    }
    public DrawerManageGroups clickDeleteGroup ()
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiButtonDeleteGroup));
        uiButtonDeleteGroup.click();
        return this;
        
    }
    public DrawerManageGroups verifyGroupPermissions ( String string )
    {
        waitForAjax(driver, 20);
        try
        {
            String value = uiInputGroupPermissions.getAttribute("value");
            System.out.println(value);
            if(value.equals(string))
            {
                return this;
            }
        }
        catch (TimeoutException te)
        {
            return null;
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
        return null;
    }
    public DrawerManageGroups openValuePane ( int i )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleValuePane.get(i)));
        uiToggleValuePane.get(i).click();
        return this;
        
    }
    public DrawerManageGroups clickValue ( String string, int i )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiValueList.get(i).findElement(By.xpath(".//div[@title='"+string+"']"))));
        wait(1).until(ExpectedConditions.elementToBeClickable(uiValueList.get(i).findElement(By.xpath(".//div[@title='"+string+"']"))));
        Actions action = new Actions(driver);
        action.click(uiValueList.get(i).findElement(By.xpath(".//div[@title='"+string+"']"))).build().perform();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiValueList.get(i))));
        return this;
        
    }
    public DrawerManageGroups verifyFieldDropDown ( String string, int row )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait(3).until(ExpectedConditions.visibilityOf(uiFieldPaneInput.get(row)));
            String compare = uiFieldPaneInput.get(row).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(string)!=true)
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
    public DrawerManageGroups verifyConditionDropDown ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait(3).until(ExpectedConditions.visibilityOf(uiConditionPaneInput.get(i)));
            String compare = uiConditionPaneInput.get(i).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(string)!=true)
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
    public DrawerManageGroups verifyValueDropDown ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait(3).until(ExpectedConditions.visibilityOf(uiValuePaneInput.get(i)));
            String compare = uiValuePaneInput.get(i).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(string)!=true)
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
    public DrawerManageGroups verifyValueTextArea ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait(3).until(ExpectedConditions.visibilityOf(uiValuePaneTextArea.get(i)));
            String compare = uiValuePaneTextArea.get(i).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(string)!=true)
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
    public DrawerManageGroups clickValueCheckbox (int i)
    {
        waitForAjax(driver, 20);
        uiValueCheckbox.get(i).click();
        return this;
        
    }
    public DrawerManageGroups verifyValueChecked ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(uiValueCheckboxChecked.get(i).isDisplayed());
            //System.out.println(value);
            if(!uiValueCheckboxChecked.get(i).isDisplayed())
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
