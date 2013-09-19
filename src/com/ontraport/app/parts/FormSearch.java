package com.ontraport.app.parts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class FormSearch extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//input[@type='search']")
    private WebElement       uiSearch;
    @FindBy(how = How.XPATH,
            using = "//input[@type='search']/following-sibling::a")
    private WebElement       uiClear;
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement firstRow;
    public FormSearch find ( String text )
    {
        wait(3).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(firstRow)));
        uiSearch.sendKeys(text+Keys.ENTER);
        
        return this;
    }
    public FormSearch clear ()
    {
        uiClear.click();
        return this;
    }
}
