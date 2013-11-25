package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class TrackedDomain_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newTrackedDomain;

    public TrackedDomain_Create clickNewTrackedDomain ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newTrackedDomain));
        newTrackedDomain.click();
        return (TrackedDomain_Create) new TrackedDomain_Create().init();
    }
    
}
