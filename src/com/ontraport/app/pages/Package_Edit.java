package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Package_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' package_manager_price ')]//input")
    private WebElement packageManagerPrice;

    public Package_Edit verifyPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = packageManagerPrice.getAttribute("value");
            System.out.println(compare);
            if(!compare.equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {  
            return null;
        }
        return this;
    }

    public Package_Edit verifyField ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath(".//tr[contains(., '" + string +"') and contains(.,'" + string2 + "')]"));
        }
        catch(NoSuchElementException e)
        {  
            return null;
        }
        return this;
    }
    
}
