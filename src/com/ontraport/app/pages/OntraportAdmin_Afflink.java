package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;

public class OntraportAdmin_Afflink extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-section-components']/div[3]/div[2]")
    private WebElement affiliateSite;

    public String getLink ()
    {
        return affiliateSite.getText();
    }
    
}
