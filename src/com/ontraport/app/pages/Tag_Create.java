package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Tag_Create extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-form_control_input_text ')]//input")
    private WebElement tagNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement save;

    public Tag_Create enterTagName ( String name )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-component-form_control_input_text ')]//input")));
        wait.until(ExpectedConditions.visibilityOf(tagNameInput));
        tagNameInput.sendKeys(name);
        return this;
        
    }

    public Tag_ListAll clickSave ()
    {
        save.click();
        return PageFactory.initElements(driver, Tag_ListAll.class);
    }
    
}
