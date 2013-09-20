package com.ontraport.app.parts.bb;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;

    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '),' ussr-component-collection ')]/table")
    protected WebElement      uiCollection;

    public FormSearch find ( String text )
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiCollectionBody));
        uiSearch.sendKeys(text+Keys.ENTER);
        wait(7).until(ExpectedConditions.visibilityOf(uiCollection));
        return this;
    }

    public FormSearch clear ()
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiClear));
        uiClear.click();
        return this;
    }

}
