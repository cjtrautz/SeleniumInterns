package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Task_ListAll extends AbstractPage
{
    @FindBy(how=How.XPATH,
            using="//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]//a")
    private WebElement subjectTask;

    public Task_ListAll verifyTask ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = subjectTask.getText();
        if(compare.equals(string)!=true)
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
