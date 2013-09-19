package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

public class User_Edit extends AbstractPage
{

    @FindBy(how=How.XPATH,
            using="//tbody[@class='ussr-component-collection-body']")
    private WebElement permissionCollectionBody;
    
    @FindBy(how=How.XPATH,
            using="//th[contains(concat(' ', @class, ' '),' ussr-component-collection-select-all-rows ')]")
    private WebElement selectAllEmptyCheckBox;
    
    public User_Edit verifyPermission (String permission)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            permissionCollectionBody.findElement(By.xpath(".//a[text()='" + permission + "']"));
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
    
    public User_Edit verifyNoPermissions ()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            permissionCollectionBody.findElement(By.xpath("//td[contains(concat(' ', @class, ' '),' ussr-collection-empty ')]"));
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
    
    public void clickPermissionExceptionsCheckBox ()
    {
        //wait.until(ExpectedConditions.stalenessOf(selectAllEmptyCheckBox));
        selectAllEmptyCheckBox.click();
        
    }
    
}
