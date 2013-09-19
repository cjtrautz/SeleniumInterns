package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractPart;

public class MenuUser extends AbstractPart
{
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']/span")
    private WebElement toggleMenuUser;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[normalize-space(text())='Personal Settings']")
    private WebElement personalSettings;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[normalize-space(text())='Admin']")
    private WebElement admin;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[normalize-space(text())='Log Out']")
    private WebElement logOut;
    
    public MenuUser open () 
    { 
        wait(4).until(ExpectedConditions.visibilityOf(toggleMenuUser));
        toggleMenuUser.click();
        return this; 
    }
    public MenuUser close () { return this; }
    public User_Edit clickPersonalSettings ()
    {
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        personalSettings.click();
        return PageFactory.initElements(driver, User_Edit.class);
    }
    public Account_View clickAdmin ()
    {
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        wait(4).until(ExpectedConditions.visibilityOf(admin));
        admin.click();
        return PageFactory.initElements(driver, Account_View.class);
    }
}
