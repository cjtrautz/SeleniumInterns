package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Message_CreatePostcard extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='layer_box']//div[@class='side_prop_label']")
    private WebElement newItem;

    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;
    
    public Message_CreatePostcard enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }

    public Message_CreatePostcard clickNewItem ()
    {
        AbstractPart.waitForAjax(driver, 20);
        newItem.click();
        return this;
    }

    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
    
}
