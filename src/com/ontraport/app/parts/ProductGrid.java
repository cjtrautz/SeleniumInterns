package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class ProductGrid extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//table[@class='ussr-component-grid ussr-table']//input[contains(concat(' ', normalize-space(@class), ' '), ' search ')]")
    protected WebElement productSearch;
    
    public ProductGrid searchProduct(String string)
    {
        waitForAjax(driver,20);
        wait(10).until(ExpectedConditions.visibilityOf(productSearch));
        productSearch.sendKeys(string);
        return this;
    }
}