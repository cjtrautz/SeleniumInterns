package com.ontraport.app.parts;

<<<<<<< HEAD
import org.openqa.selenium.By;
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
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
<<<<<<< HEAD
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='javascript://']")
    private WebElement menuUserName;
    
    @FindBy(
            how = How.XPATH,
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
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
<<<<<<< HEAD
        wait(4).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ussr-header-nav-option-user']/span")));
        wait(4).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ussr-header-nav-option-user']//a[@href='javascript://']")));
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
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
