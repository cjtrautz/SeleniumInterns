package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class User_Create extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//label[text()='First Name']/following-sibling::div/input")
    private WebElement firstNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Last Name']/following-sibling::div/input")
    private WebElement lastNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Email']/following-sibling::div/input")
    private WebElement emailNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[contains(text(), 'From')]/following-sibling::div/input")
    private WebElement emailFromNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Reply-To Email']/following-sibling::div/input")
    private WebElement replyToNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Role']/following-sibling::div/button")
    private WebElement roleDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Language']/following-sibling::div/button")
    private WebElement languageDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Manager']/following-sibling::div/button")
    private WebElement managerDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='New Password']/following-sibling::div/input")
    private WebElement newPasswordInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Password Confirm']/following-sibling::div/input")
    private WebElement confirmPasswordInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement saveButton;

    public User_Create enterFirstName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameInput.sendKeys(string);
        return this;
        
    }

    public User_Create enterLastName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameInput.sendKeys(string);
        return this;
        
    }

    public User_Create enterEmail ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        emailNameInput.sendKeys(string);
        return this;
        
    }

    public User_Create enterEmailFromName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        emailFromNameInput.sendKeys(string);
        return this;
        
    }

    public User_Create enterReplyToName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        replyToNameInput.sendKeys(string);
        return this;
        
    }

    public User_Create clickRoleDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        roleDropDown.click();
        return this;
        
    }

    public User_Create selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']/li/div[text()='" + string + "']")).click();
        return this;
        
    }

    public User_Create clickLanguageDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        languageDropDown.click();
        return this;
        
    }

    public User_Create clickManagerDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        managerDropDown.click();
        return this;
        
    }

    public User_Create enterNewPassword ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        newPasswordInput.sendKeys(string);
        return this;
        
    }

    public User_Create enterConfirmPassword ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        confirmPasswordInput.sendKeys(string);
        return this;
        
    }

    public User_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[text()='Save']")));
        saveButton.click();
        return PageFactory.initElements(driver, User_ListAll.class);
    }
    
}