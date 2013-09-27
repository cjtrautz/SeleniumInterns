package com.ontraport.app.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPart;

public class DrawerPermissionException extends AbstractPart
{
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', @class, ' '),' target_permission_list ')]//button")
    private WebElement togglePermissionExceptionPane;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', @class, ' '),' permissions-target-features ')]//button")
    private WebElement togglePermissionFeaturesPane;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', @class, ' '),' target_permission_list ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement permissionExceptionPane;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', @class, ' '),' permissions-target-features ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement permissionFeaturesPane;
    
    @FindBy(how=How.XPATH,
            using="//div[@class='target_controls']/span[contains(concat(' ', @class, ' '),' target_add_exception ')]//span[normalize-space(text())='Add Exception']")
    private WebElement addException;

    public DrawerPermissionException openPermissionExceptionPane ()
    {
        waitForAjax(driver, 20);
        togglePermissionExceptionPane.click();
        return this;
    }

    public DrawerPermissionException clickPermissionException ( String permission )
    {
        waitForAjax(driver, 20);
        permissionExceptionPane.findElement(By.xpath(".//div[normalize-space(text())='" + permission + "']")).click(); 
        return this;
    }

    public DrawerPermissionException openPermissionFeaturesPane ()
    {
        waitForAjax(driver, 20);
        togglePermissionFeaturesPane.click();        
        return this;
    }

    public DrawerPermissionException clickCanViewContacts ( String permissionFeature )
    {
        waitForAjax(driver, 20);
        permissionFeaturesPane.findElement(By.xpath(".//div[normalize-space(text())='" + permissionFeature + "']")).click();      
        return this;
    }

    public DrawerPermissionException clickAddException ()
    {
        waitForAjax(driver, 20);
        addException.click();
        return this;
        
    }
    
}
