package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Package_Create extends AbstractPage
{ 
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement packageManagerName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement packageManagerPrice;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='package_manager_add_item']")
    private WebElement addItem;

    public Package_Create enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        packageManagerName.clear();
        packageManagerName.sendKeys(string);
        return this;
    }

    public Package_Create enterPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        packageManagerPrice.clear();
        packageManagerPrice.sendKeys(string);
        return this;
    }

    public Package_Create clickAddItem ()
    {
        AbstractPart.waitForAjax(driver, 20);
        addItem.click();
        return this;
    }
    
}
