package com.ontraport.app.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class OntraportAdmin_ListExports extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collection;

    public Object verifyExportedList ()
    {
        AbstractPart.waitForAjax(driver, 20);
        DateFormat dateFormat = new SimpleDateFormat("M_d_yyyy");
        // get current date time with Date()
        Date date = new Date();
        String name = dateFormat.format(date);
        try
        {
            System.out.println(name);
            wait.until(ExpectedConditions.visibilityOf(collection.findElement(By.xpath(".//a[contains(text(),'" + name + "')]")))); 
            collection.findElement(By.xpath(".//a[contains(text(),'" + name + "')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
}
