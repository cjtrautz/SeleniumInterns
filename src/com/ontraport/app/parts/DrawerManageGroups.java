package com.ontraport.app.parts;

import java.util.List;

import org.openqa.selenium.By;
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
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleDrawerManageGroupsPane));
        uiToggleDrawerManageGroupsPane.click();
        return this;
    }
    public DrawerManageGroups enterGroupName ( String groupname )
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiInputGroupName));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiInputGroupName.sendKeys(groupname);
        return this;
    }
    public DrawerManageGroups openGroupPermissionsPane ()
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleGroupPermissionsPane));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiToggleGroupPermissionsPane.click();
        return this;
    }
    public DrawerManageGroups clickPermissions ( String permissions )
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiGroupPermissionsList));
        uiGroupPermissionsList.findElement(By.xpath(".//li/div[text()='"+permissions+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiGroupPermissionsList)));
        return this;
    }
    public DrawerManageGroups openFieldPane (int row)
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleFieldPane.get(row)));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiToggleFieldPane.get(row).click();
        return this;
    }
    public DrawerManageGroups clickField ( String field,  int row )
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiFieldList.get(row).findElement(By.xpath(".//div[text()='"+field+"']"))));
=======
        wait(1).until(ExpectedConditions.visibilityOf(uiFieldList.get(row)));
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiFieldList.get(row).findElement(By.xpath(".//div[text()='"+field+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiFieldList.get(row))));
        return this;
    }
    public DrawerManageGroups openConditionPane (int row)
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleFieldPane.get(row)));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiToggleConditionPane.get(row).click();
        return this;
    }
    public DrawerManageGroups clickCondition ( String condition, int row )
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiConditionList.get(row).findElement(By.xpath(".//div[text()='"+condition+"']"))));
=======
        wait(1).until(ExpectedConditions.visibilityOf(uiConditionList.get(row)));
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiConditionList.get(row).findElement(By.xpath(".//div[text()='"+condition+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiConditionList.get(row))));
        return this;
    }
    public DrawerManageGroups enterValue ( String value, int row, int index )
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf( uiInputValueRows.get(row).findElement(By.xpath("//tr[@class='sem_condition_row']["+(index+1)+"]//td[@class='sem_value']//input"))));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiInputValueRows.get(row).findElement(By.xpath("//tr[@class='sem_condition_row']["+(index+1)+"]//td[@class='sem_value']//input")).sendKeys(value);
        return this;
    }
    public Boolean confirmGroupApplied (final String name)
    {
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
        wait(1).until(ExpectedConditions.visibilityOf(uiButtonSave));
        uiButtonSave.click();
        return this;
    }
    public DrawerManageGroups clickDeleteGroup ()
    {
<<<<<<< HEAD
        wait(1).until(ExpectedConditions.visibilityOf(uiButtonDeleteGroup));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        uiButtonDeleteGroup.click();
        return this;
        
    }
}
