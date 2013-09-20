package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Contact_Export extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-form-input-type-drilldownselect ')]//button")
    private WebElement toggleFieldSelector;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Export']")
    private WebElement export;

    public Contact_Export openFieldPane ()
    {
        toggleFieldSelector.click();
        return this;
        
    }

    public Contact_Export selectField ( String field )
    {
        WebElement fieldOptions = drillDownPane.findElement(By.xpath(".//li/div[text()='" + field + "']"));
        fieldOptions.click();
        return this;
    }

    public Contact_ListAll clickExport ()
    {
        export.click();
        return PageFactory.initElements(driver, Contact_ListAll.class);
    }
    
}
