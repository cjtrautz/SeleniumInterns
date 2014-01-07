package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class CKEditorDialogBox extends AbstractPart
{
    @FindBy(
            how = How.XPATH,
            using = "//body")
    private WebElement body;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe[@class='cke_pasteframe']")
    private WebElement iframe;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@title='Almost equal to']")
    private WebElement almostEqual;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@name='info']//label[text()='URL']/following-sibling::div//input[@class='cke_dialog_ui_input_text']")
    private List<WebElement> urlInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@name='info']//span[text()='Select Hosted image']")
    private List<WebElement> selectHostedImage;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='cke_dialog_ui_button' and text()='OK']")
    private List<WebElement> ok;

    public CKEditorDialogBox enterURL ( String string, int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(urlInput.get(index)));
        urlInput.get(index).sendKeys(string);
        return this;
    }
    public CKEditorDialogBox enterURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(urlInput.get(0)));
        urlInput.get(0).sendKeys(string);
        return this;
    }

    public CKEditorDialogBox clickOk (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(ok.get(i)));
        ok.get(i).click();
        return this;
    }

    public CKEditorDialogBox verifyURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait(30).until(ExpectedConditions.visibilityOf(urlInput.get(0)));
            System.out.println(urlInput.get(0).getAttribute("value"));
            String compare = urlInput.get(0).getAttribute("value");
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

    public CKEditorDialogBox verifyURLContains ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait(30).until(ExpectedConditions.visibilityOf(urlInput.get(0)));
            System.out.println(urlInput.get(0).getAttribute("value"));
            String compare = urlInput.get(0).getAttribute("value");
            if(compare.contains(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public CKEditorDialogBox verifyURL ( String string, int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait(10).until(ExpectedConditions.visibilityOf(urlInput.get(index)));
            System.out.println(urlInput.get(index).getAttribute("value"));
            String compare = urlInput.get(index).getAttribute("value");
            if(compare.contains(string)!=true)
            {
                System.out.println("here4");
                return null;
            }
        }
        catch(NoSuchElementException e){
            System.out.println("here5");
            return null;
        }
        
        return this;
    }

    public CKEditorDialogBox verifyURLContains ( String string, int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait(30).until(ExpectedConditions.visibilityOf(urlInput.get(index)));
            System.out.println(urlInput.get(index).getAttribute("value"));
            String compare = urlInput.get(index).getAttribute("value");
            if(compare.contains(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public CKEditorDialogBox clickSelectHostedImage (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(selectHostedImage.get(i)));
        selectHostedImage.get(i).click();
        return this;
    }
    public CKEditorDialogBox enterIframePasteBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        body.sendKeys(string);
        ((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<p>" + string + "</p>'");
        driver.switchTo().defaultContent();
        return this;
    }
    public CKEditorDialogBox clickAlmostEqualTo ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(almostEqual));
        almostEqual.click();
        return this;
    }

    
}
