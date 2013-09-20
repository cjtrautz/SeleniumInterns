package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;

public class Message_TypeSelection extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement emailMessage;

    public Message_CreateEmail clickEmailCreate ()
    {
        emailMessage.click();
        return (Message_CreateEmail) new Message_CreateEmail().init();
    }
    
}
