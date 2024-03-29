package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Message_CreatePostcard extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(concat(' ', @class, ' '),' ussr-component-drilldownselect-ul ')]")
    private WebElement drillDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ontraport_components_form_control_drill_down_select_field_selector_merge_field_inserter ')]//button")
    private WebElement mergeFieldDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ontraport_components_form_control_drill_down_select_field_selector_merge_field_inserter ')]//input")
    private WebElement mergeFieldDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='layer_box']//div[@class='side_prop_label']")
    private WebElement newItem;
    
    @FindBy(
            how = How.XPATH,
            using = "//td[@id='property_cell']//tbody/tr/td[2]//select")
    private WebElement selectFontSize;

    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-back ')]")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//body")
    private WebElement body;
    
    @FindBy(
            how = How.TAG_NAME,
            using = "iframe")
    private WebElement iFrame;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),' font-family: Verdana,Geneva,sans-serif; ')]")
    private WebElement textArea;
    
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
        wait.until(ExpectedConditions.visibilityOf(newItem));  
        newItem.click();
        return this;
    }

    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));  
        save.click();
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));  
        back.click();
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Message_CreatePostcard doubleClickInsertText ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.click();
        Actions action = new Actions(driver);
        action.doubleClick(textArea).build().perform();
        return this;
        
    }

    public Message_CreatePostcard enterText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame));  
        driver.switchTo().frame(iFrame);
        Actions action = new Actions(driver);
        action.sendKeys(string).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_CreatePostcard doubleClickText (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        WebElement text = driver.findElement(By.xpath("//body[text()='" + string + "']"));
        text.click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).build().perform();
        for(int i = 0; i<string.length(); i++)
        {
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
        }
        action.keyUp(Keys.SHIFT).build().perform();
        driver.switchTo().defaultContent();
        return this;
        
    }

    public Message_CreatePostcard selectSize ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(string).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
//        Select selecter = new Select(driver.findElement(By.xpath("//td[@id='property_cell']//tbody/tr/td[2]//select")));
//        selecter.selectByValue(string);
        return this;
        
    }

    public Message_CreatePostcard clickFontDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectFontSize));  
        selectFontSize.click();
        return this;
        
    }

    public Message_CreatePostcard clickMergeFieldDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mergeFieldDropDown));  
        mergeFieldDropDown.click();
        return this;
    }

    public Message_CreatePostcard enterMergeFieldPane ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mergeFieldDropDownInput));  
        mergeFieldDropDownInput.sendKeys(string);
        return this;
    }

    public Message_CreatePostcard selectDropDownOption ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));  
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }
    
}
