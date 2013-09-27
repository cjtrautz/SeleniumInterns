package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Contact_Create extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-section-titlebar ')]/span[text()='Sequences and Tags']")
    private WebElement sequencesAndTagsTitle;
    @FindBy(how = How.XPATH,
            using = "//label[text()='First Name']/following-sibling::div/input")
    private WebElement uiFirstName;
    @FindBy(how = How.XPATH,
            using = "//label[text()='Last Name']/following-sibling::div/input")
    private WebElement uiLastName;
    @FindBy(how = How.XPATH,
            using = "//label[text()='Email']/following-sibling::div/input")
    private WebElement uiEmail;
    @FindBy(how = How.XPATH,
            using = "//button/span[text()='Save']")
    private WebElement uiSave;
    public Contact_Create enterFirstName (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sequencesAndTagsTitle));
        wait.until(ExpectedConditions.visibilityOf(uiFirstName));
        uiFirstName.sendKeys(name);
        return this;
    }
    public Contact_Create enterLastName (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiLastName));
        uiLastName.sendKeys(name);
        return this;
    }
    public Contact_Create enterEmail (String email)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiEmail));
        uiEmail.sendKeys(email);
        return this;
    }
    public Contact_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiSave));
        uiSave.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }
}
