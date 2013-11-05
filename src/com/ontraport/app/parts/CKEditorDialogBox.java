package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
        urlInput.get(index).sendKeys(string);
        return this;
    }
    public CKEditorDialogBox enterURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        urlInput.get(0).sendKeys(string);
        return this;
    }

    public CKEditorDialogBox clickOk (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        ok.get(i).click();
        return this;
    }

    public CKEditorDialogBox verifyURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(urlInput.get(0).getAttribute("value"));
            String compare = urlInput.get(0).getAttribute("value");
            if(compare.equals(string)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public CKEditorDialogBox verifyURLContains ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(urlInput.get(0).getAttribute("value"));
            String compare = urlInput.get(0).getAttribute("value");
            if(compare.contains(string)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    public CKEditorDialogBox verifyURL ( String string, int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(urlInput.get(index).getAttribute("value"));
            String compare = urlInput.get(index).getAttribute("value");
            if(compare.equals(string)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                System.out.println("here4");
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            System.out.println("here5");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public CKEditorDialogBox verifyURLContains ( String string, int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(urlInput.get(index).getAttribute("value"));
            String compare = urlInput.get(index).getAttribute("value");
            if(compare.contains(string)!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public CKEditorDialogBox clickSelectHostedImage (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        selectHostedImage.get(i).click();
        return this;
    }
    public CKEditorDialogBox enterIframePasteBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        body.sendKeys(string);
        driver.switchTo().defaultContent();
        return this;
    }

    
}
