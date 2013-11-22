package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class WordPress_TypeSelection extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/wordpress/create&type=2']/button")
    private WebElement newWordPress;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/wordpress/create&type=1']/button")
    private WebElement existingWordPress;

    public WordPress_CreateType2 clickCreateNewWordPressSite ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newWordPress));
        newWordPress.click();
        return (WordPress_CreateType2) new WordPress_CreateType2().init();
    }

    public WordPress_CreateType1 clickCreateExistingWordPressSite ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(existingWordPress));
        existingWordPress.click();
        return (WordPress_CreateType1) new WordPress_CreateType1().init();
    }
    
}
