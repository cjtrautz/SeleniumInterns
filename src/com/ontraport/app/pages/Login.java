package com.ontraport.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Login extends AbstractPage
{
    public static String url = "/";
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
        final String previousURL = driver.getCurrentUrl();
        wait.until(ExpectedConditions.visibilityOf(loginInputUsername));
        loginInputUsername.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(loginInputPassword));
        loginInputPassword.sendKeys(password);
        AbstractPart.waitForAjax(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(loginInputSubmit));
        loginInputSubmit.click();
//        wait.until(new ExpectedCondition<Boolean>()
//            {
//                public Boolean apply (WebDriver d)
//                {
//                    return (previousURL.equals(d.getCurrentUrl()) == false);
//                }
//            }
//        );
        return (Contact_ListAll) new Contact_ListAll().init();
    }
    public Object verifyPage ()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(loginInputUsername));
            String url = driver.getCurrentUrl();
            if(!url.equals("https://app.ontraport.com/login.php"))
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return this;
    }
}
