package com.ontraport.app.parts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.pages.ApiSettings_Edit;
import com.ontraport.app.pages.Support_Home;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DropBox extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//iframe[@id='zenbox_body']")
    private WebElement iframe;
    
    @FindBy(how = How.XPATH,
            using = "//section[@id='suggestions_form']//input[@id='suggestions_query']")
    private WebElement sugestionInput;

    public DropBox verifySugestion ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.switchTo().frame(iframe);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            if(!sugestionInput.isDisplayed())
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                driver.switchTo().defaultContent();
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
            driver.switchTo().defaultContent();
            return null;
        }
        driver.switchTo().defaultContent();
        return this;
    }
    
}
