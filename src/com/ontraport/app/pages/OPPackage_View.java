package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class OPPackage_View extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='(Add a package)']")
    private WebElement addPackage;

    public OPPackage_View clickAddPackage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        addPackage.click();
        return this;
        
    }
    
}
