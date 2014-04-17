package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class ZencoderVideo_ListAll extends AbstractPage
{   
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newVideo;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    public ZencoderVideo_Create clickNewVideo ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newVideo));
        newVideo.click();
        return (ZencoderVideo_Create) new ZencoderVideo_Create().init();
    }

    public ZencoderVideo_ListAll verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()='Videos']")).isDisplayed())
            {
                return null;
            }
            if(!uiCollectionBody.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public ZencoderVideo_ListAll verifyUploadDate ( String format )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(format);
            if(!driver.findElement(By.xpath("//a[contains(@href, '#!/zencoder_video/edit&id') and @title='" + format + "']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
}
