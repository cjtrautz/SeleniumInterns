package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Login extends AbstractPage
{
    public static String url = "/login.html?track_requests=1";
    @FindBy(how = How.XPATH,
            using = "//input[@id='username']")
    private WebElement   loginInputUsername;
    @FindBy(how = How.XPATH,
            using = "//input[@id='password']")
    private WebElement   loginInputPassword;
    @FindBy(how = How.XPATH,
            using = "//input[@id='login_button']")
    private WebElement   loginInputSubmit;
    public Contact_ListAll as ( String username, String password )
    {
        wait.until(ExpectedConditions.visibilityOf(loginInputUsername));
        loginInputUsername.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(loginInputPassword));
        loginInputPassword.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(loginInputSubmit));
        loginInputSubmit.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }
}
