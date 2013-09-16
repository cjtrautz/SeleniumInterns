package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Contact_Create extends AbstractPage
{


    @FindBy(how = How.ID,
            using = "ussr-chrome-page")
    private WebElement uiPage;

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
        wait(3).until(ExpectedConditions.visibilityOf(uiFirstName));
        uiFirstName.sendKeys(name);
        return this;
    }

    public Contact_Create enterLastName (String name)
    {
        wait(3).until(ExpectedConditions.visibilityOf(uiLastName));
        uiLastName.sendKeys(name);
        return this;
    }

    public Contact_Create enterEmail (String email)
    {
        wait(3).until(ExpectedConditions.visibilityOf(uiEmail));
        uiEmail.sendKeys(email);
        return this;
    }

    public Contact_ListAll clickSave ()
    {
        wait(3).until(ExpectedConditions.visibilityOf(uiSave));
        uiSave.click();
        wait(7).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiPage)));
        return (Contact_ListAll) new Contact_ListAll().init();
    }

}
