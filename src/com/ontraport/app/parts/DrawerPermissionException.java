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

    public void openPermissionExceptionPane ()
    {
        togglePermissionExceptionPane.click();       
    }

    public void clickPermissionException ( String permission )
    {
        permissionExceptionPane.findElement(By.xpath(".//div[normalize-space(text())='" + permission + "']")).click();        
    }

    public void openPermissionFeaturesPane ()
    {
        togglePermissionFeaturesPane.click();        
    }

    public void clickCanViewContacts ( String permissionFeature )
    {
        permissionFeaturesPane.findElement(By.xpath(".//div[normalize-space(text())='" + permissionFeature + "']")).click();         
    }

    public void clickAddException ()
    {
        addException.click();
        
    }
    
}
