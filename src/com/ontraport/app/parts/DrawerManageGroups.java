package com.ontraport.app.parts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

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
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_field']//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-listview ')]")
    private List<WebElement> uiFieldList;

    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_condition']//button")
    private List<WebElement> uiToggleConditionPane;

    @FindBy(how=How.XPATH,
            using = "//tr[contains(concat(' ',@class,' '),' sem_condition_row ')]//td[@class='sem_condition']//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-listview ')]")
    private List<WebElement> uiConditionList;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '), ' sem-segment-entry ')]")
    private List<WebElement> uiInputValueRows;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '), ' group-editor-buttons ')]//button[@value='Save']")
    private WebElement uiButtonSave;
    
    @FindBy(how = How.XPATH,
    using = "//div[contains(concat(' ',@class,' '), ' group-editor-buttons ')]//button[@value='Delete Group']")
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
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleGroupPermissionsPane));
        uiToggleGroupPermissionsPane.click();
        return this;
    }
    public DrawerManageGroups clickPermissions ( String permissions )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiGroupPermissionsList));
        uiGroupPermissionsList.findElement(By.xpath(".//li/div[text()='"+permissions+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiGroupPermissionsList)));
        return this;
    }
    public DrawerManageGroups openFieldPane (int row)
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleFieldPane.get(row)));
        uiToggleFieldPane.get(row).click();
        return this;
    }
    public DrawerManageGroups clickField ( String field,  int row )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiFieldList.get(row).findElement(By.xpath(".//div[text()='"+field+"']"))));
        uiFieldList.get(row).findElement(By.xpath(".//div[text()='"+field+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiFieldList.get(row))));
        return this;
    }
    public DrawerManageGroups openConditionPane (int row)
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleFieldPane.get(row)));
        uiToggleConditionPane.get(row).click();
        return this;
    }
    public DrawerManageGroups clickCondition ( String condition, int row )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf(uiConditionList.get(row).findElement(By.xpath(".//div[text()='"+condition+"']"))));
        uiConditionList.get(row).findElement(By.xpath(".//div[text()='"+condition+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiConditionList.get(row))));
        return this;
    }
    public DrawerManageGroups enterValue ( String value, int row, int index )
    {
        waitForAjax(driver, 20);
        wait(1).until(ExpectedConditions.visibilityOf( uiInputValueRows.get(row).findElement(By.xpath("//tr[@class='sem_condition_row']["+(index+1)+"]//td[@class='sem_value']//input"))));
        uiInputValueRows.get(row).findElement(By.xpath("//tr[@class='sem_condition_row']["+(index+1)+"]//td[@class='sem_value']//input")).sendKeys(value);
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
}
