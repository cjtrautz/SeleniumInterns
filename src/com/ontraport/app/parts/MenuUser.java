package com.ontraport.app.parts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.OPPackage_View;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.pages.User_ListAll;
import com.ontraport.app.tools.AbstractPart;

public class MenuUser extends AbstractPart
{
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']/span")
    private WebElement toggleMenuUser;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='javascript://']")
    private WebElement menuUserName;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='#!/user/edit&id=1']")
    private WebElement personalSettings;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='#!/user/listAll']")
    private WebElement manageUsers;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='#!/account/view']")
    private WebElement admin;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='#!/op_package/view']")
    private WebElement account;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-user']//a[@href='Login/logout']")
    private WebElement logOut;
    
    public MenuUser open () 
    { 
        waitForAjax(driver, 20);
        wait(4).until(ExpectedConditions.visibilityOf(toggleMenuUser));
        wait(4).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ussr-header-nav-option-user']/span")));
        wait(4).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ussr-header-nav-option-user']//a[@href='javascript://']")));

        toggleMenuUser.click();
        return this; 
    }
    public MenuUser close () { return this; }
    public User_Edit clickPersonalSettings ()
    {
        waitForAjax(driver, 20);
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        personalSettings.click();
        return (User_Edit) new User_Edit().init();
    }
    public Account_View clickAdmin ()
    {
        waitForAjax(driver, 20);
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        wait(4).until(ExpectedConditions.visibilityOf(admin));
        admin.click();
        return (Account_View) new Account_View().init();
    }
    public User_ListAll clickManageUsers ()
    {
        waitForAjax(driver, 20);
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        wait(4).until(ExpectedConditions.visibilityOf(manageUsers));
        manageUsers.click();
        return (User_ListAll) new User_ListAll().init();
    }
    public OPPackage_View clickAccount ()
    {
        waitForAjax(driver, 20);
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        wait(4).until(ExpectedConditions.visibilityOf(account));
        account.click();
        return (OPPackage_View) new OPPackage_View().init();
    }
    public void clickLogOut ()
    {
        try
        {
            waitForAjax(driver, 20);
            Thread.sleep(1500);
        }
        catch(Exception e)
        {
            
        }
        wait(4).until(ExpectedConditions.visibilityOf(logOut));
        logOut.click();
        
    }

}
