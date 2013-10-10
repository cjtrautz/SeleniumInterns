package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class WordPress_TypeSelection extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/wordpress/create&type=2']/button")
    private WebElement newWordPress;

    public WordPress_CreateType2 clickCreateNewWordPressSite ()
    {
        AbstractPart.waitForAjax(driver, 20);
        newWordPress.click();
        return (WordPress_CreateType2) new WordPress_CreateType2().init();
    }
    
}
