package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class DrawerActions extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_group_actions']")
    protected WebElement      uiToggleDrawerActions;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Contacts')]")
    private WebElement uiDeleteContacts;
    public DrawerActions clickDeleteContacts ()
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiDeleteContacts));
        uiDeleteContacts.click();
        return this;
    }
    public DrawerActions open ()
    {
        uiToggleDrawerActions.click();
        return this;
    }
    public DrawerActions close ()
    {
        uiToggleDrawerActions.click();
        return this;
    }
}
