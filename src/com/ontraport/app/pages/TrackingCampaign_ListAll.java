package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class TrackingCampaign_ListAll extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @id, ' '),' ontraport_panel_action_extraction0 ')]")
    private WebElement newTrackingURL;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    public TrackingCampaign_ListAll clickNewTrackingURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newTrackingURL));
        newTrackingURL.click();
        return this;
    }

    public TrackingCampaign_ListAll verifyCampaign ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
}
