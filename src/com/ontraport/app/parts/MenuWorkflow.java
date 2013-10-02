package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPart;

public class MenuWorkflow extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-workflow']/a[@href='javascript://']")
    protected WebElement workflowOpen;
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='ussr-workflow-menu-close position-absolute-zero']//a[@class='ussr-icon ussr-icon-circle-file']")
    protected WebElement workflowClose;
    
    public MenuWorkflow open () { 
        waitForAjax(driver, 20);
        workflowOpen.click();
        return this; 
        }

    public MenuWorkflow close ()
    {
        waitForAjax(driver, 20);
        workflowClose.click();
        return this; 
        
    }

}
