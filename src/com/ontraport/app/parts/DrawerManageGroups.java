package com.ontraport.app.parts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class DrawerManageGroups extends AbstractPart
{

    @FindBy(how = How.CSS,
            using = "div.ussr-state-loading")
    private WebElement uiLoading;

    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_group_edit']")
    private WebElement uiToggleDrawerManageGroupsPane;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '),' ussr-chrome-panel-action-drawer-content ')]")
    private WebElement uiDrawerManageGroupsPane;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '),' ussr-chrome-panel-action-drawer-content ')]//ul")
    private WebElement uiDrawerManageGroupsPaneUL;

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
    private WebElement uiButtonDelete;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]")
    private WebElement uiSelectedGroupDisplayHook;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-group_selector ')]//input")
    private WebElement uiInputGroupSelector;

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
        uiToggleDrawerManageGroupsPane.click();
        return this;
    }

    public DrawerManageGroups enterGroupName ( String groupname )
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiInputGroupName));
        uiInputGroupName.clear();
        uiInputGroupName.sendKeys(groupname);
        return this;
    }

    public DrawerManageGroups openGroupPermissionsPane ()
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiToggleGroupPermissionsPane));
        uiToggleGroupPermissionsPane.click();
        return this;
    }

    public DrawerManageGroups clickPermissions ( String permissions )
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiGroupPermissionsList));
        uiGroupPermissionsList.findElement(By.xpath(".//li/div[text()='"+permissions+"']")).click();
        wait(7).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiGroupPermissionsList)));
        return this;
    }

    public DrawerManageGroups openFieldPane (int row)
    {
        wait(7).until(ExpectedConditions.visibilityOfAllElements(uiToggleFieldPane));
        uiToggleFieldPane.get(row).click();
        return this;
    }

    public DrawerManageGroups clickField ( String field,  int row )
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiFieldList.get(row)));
        uiFieldList.get(row).findElement(By.xpath(".//div[text()='"+field+"']")).click();
        wait(7).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiFieldList.get(row))));
        return this;
    }

    public DrawerManageGroups openConditionPane (int row)
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiToggleConditionPane.get(row)));
        uiToggleConditionPane.get(row).click();
        return this;
    }

    public DrawerManageGroups clickCondition ( String condition, int row )
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiConditionList.get(row)));
        uiConditionList.get(row).findElement(By.xpath(".//div[text()='"+condition+"']")).click();
        wait(7).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiConditionList.get(row))));
        return this;
    }

    public DrawerManageGroups enterValue ( String value, int row, int index )
    {
        WebElement we = uiInputValueRows.get(row).findElement(By.xpath("//tr[@class='sem_condition_row']["+(index+1)+"]//td[@class='sem_value']//input"));
        wait(7).until(ExpectedConditions.visibilityOf(we));
        we.sendKeys(value);
        return this;
    }

    public DrawerManageGroups clickSave ()
    {
        if (!uiDrawerManageGroupsPane.isDisplayed())
        {
            open();
        }
        wait(7).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiDrawerManageGroupsPane)));
        wait(7).until(ExpectedConditions.visibilityOf(uiButtonSave)).click();
        wait(7).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiInputGroupSelector)));
        if (uiDrawerManageGroupsPane.isDisplayed())
        {
            wait(7).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiDrawerManageGroupsPane)));
        }
        return this;
    }

    public DrawerManageGroups clickDelete ()
    {
        if (!uiDrawerManageGroupsPane.isDisplayed())
        {
            open();
        }
        wait(7).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiDrawerManageGroupsPane)));
        wait(7).until(ExpectedConditions.visibilityOf(uiButtonDelete)).click();
        wait(7).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiInputGroupSelector)));
        if (uiDrawerManageGroupsPane.isDisplayed())
        {
            wait(7).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiDrawerManageGroupsPane)));
        }
        return this;
    }

}
