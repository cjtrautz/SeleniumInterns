package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class OntraportAdmin_Afflink extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='op_affiliate_label']")
    private WebElement affiliateSite;

    public String getLink ()
    {
        AbstractPart.waitForAjax(driver, 20);
        return affiliateSite.getText();
    }
    
}
