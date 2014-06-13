package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class ZencoderVideo_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[text()='Cancel']")
    private WebElement cancel;
    
    @FindBy(how = How.XPATH,
            using = "//input[contains(concat(' ', normalize-space(@type), ' '),' file ')]")
    private WebElement videoUploadInput;


    public ZencoderVideo_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (ZencoderVideo_ListAll) new ZencoderVideo_ListAll().init();
    }


    public ZencoderVideo_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (ZencoderVideo_ListAll) new ZencoderVideo_ListAll().init();
    }


    public ZencoderVideo_ListAll sendFile ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(videoUploadInput));
        ((JavascriptExecutor)driver).executeScript("$(\"input[type=file]\").removeClass(\"display-none\");");
        //Actions action = new Actions(driver);
        //action.sendKeys(videoUploadInput, string).build().perform();
        videoUploadInput.sendKeys(string);
        return (ZencoderVideo_ListAll) new ZencoderVideo_ListAll().init();
    }
    
}
