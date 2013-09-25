package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Product_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-tab-container']//label[.='Name']/following-sibling::div/input")
    private WebElement nameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-tab-container']//label[.='Price']/following-sibling::div/input")
    private WebElement priceInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement save;

    public Product_Create enterProductName ( String name )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-component-tab-container']//label[.='Name']/following-sibling::div/input")));
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
        return this;
        
    }

    public Product_Create enterProductPrice ( String price )
    {
        priceInput.clear();
        priceInput.sendKeys(price);
        return this;
        
    }

    public Product_ListAll clickSave ()
    {
        save.click();
        return PageFactory.initElements(driver, Product_ListAll.class);
    }
    
}
