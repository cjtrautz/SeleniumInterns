package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.ontraport.app.tools.AbstractPage;

public class Gmail extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//input[@id='Email']")
    private WebElement userName;
    
    @FindBy(how = How.XPATH,
            using = "//input[@id='Passwd']")
    private WebElement password;
    
    @FindBy(how = How.XPATH,
            using = "//input[@id='signIn']")
    private WebElement signIn;
    
    @FindBy(how = How.XPATH,
        using = "//span[@name='Confirmation E-Mail']")
    private WebElement confirmationEmail;
    
    @FindBy(how = How.XPATH,
        using = "//a[contains(@href, 'https://forms.ontraport.com')]")
    private WebElement link;
    
    @FindBy(how = How.XPATH,
        using = "//div[@class=' G-atb D E']//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private WebElement delete;
    @FindBy(how = How.XPATH,
            using = "//div[@id=':31']")
        private WebElement primary;

    public Gmail enterUserName ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        userName.sendKeys(string);
        return this;
    }

    public Gmail enterPassword ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        password.sendKeys(string);
        return this;
    }

    public Gmail clickSignIn ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        signIn.click();
        return this;
        
    }

    public Gmail clickConfirmationEmail ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        try
        {
            confirmationEmail.click();
        }
        catch(NoSuchElementException e)
        {
            driver.navigate().refresh();
            confirmationEmail.click();
        }
        return this;
        
    }

    public Gmail clickLink ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        link.click();
        //driver.switchTo().defaultContent();
        return this;
        
    }

    public Gmail clickDelete ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        //driver.switchTo().defaultContent();
        delete.click();
       // wait.until(ExpectedConditions.visibilityOf(primary));
        return this;
        
    }
    
}
