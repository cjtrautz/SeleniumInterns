package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class MessageTemplate_TypeSelection extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/message_template/create&type=1']/button")
    private WebElement createDoubleOptIn;

    public MessageTemplate_CreateType1 clickCreateDoubleOptIn ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createDoubleOptIn));
        createDoubleOptIn.click();
        return (MessageTemplate_CreateType1) new MessageTemplate_CreateType1().init();
    }
    
}
