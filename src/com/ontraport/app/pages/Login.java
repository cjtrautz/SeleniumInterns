package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Login extends AbstractPage
{
    public static String url = "/login.html";

    @FindBy(how = How.XPATH,
            using = "//input[@id='username']")
    private WebElement   loginInputUsername;

    @FindBy(how = How.XPATH,
            using = "//input[@id='password']")
    private WebElement   loginInputPassword;

    @FindBy(how = How.XPATH,
            using = "//input[@id='login_button']")
    private WebElement   loginInputSubmit;

    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']")
    private WebElement uiCollectionHead;

    @FindBy(how = How.CSS,
            using = ".ontraport_panes_contact")
    protected WebElement      uiCollection;

    public Contact_ListAll as ( String username, String password )
    {
        wait(7).until(ExpectedConditions.visibilityOf(loginInputUsername));
        loginInputUsername.sendKeys(username);
        wait(7).until(ExpectedConditions.visibilityOf(loginInputPassword));
        loginInputPassword.sendKeys(password);
        wait(7).until(ExpectedConditions.visibilityOf(loginInputSubmit));
        loginInputSubmit.click();
        wait(15).until(ExpectedConditions.visibilityOf(uiCollection));
//        waitForContentPane();
        return PageFactory.initElements(driver, Contact_ListAll.class);
    }

}
