package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class TrackedDomain_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ontraport_components_form_control_input_text ')]//div[@class='ussr-form-input']")
    private WebElement urlInput;

    public TrackedDomain_Edit verifyURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(urlInput.getText());
            if(!urlInput.getText().equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
}
