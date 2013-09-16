package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Contact_ListAll extends AbstractPage
{

    protected String   url = "/#!/contact/listAll";

    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']")
    private WebElement uiCollectionHead;

    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr")
    private WebElement uiCollectionBodyRow1;

    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;

    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement uiNewContact;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ',@class,' '),' ussr-component-collection ')]/table")
    protected WebElement      uiCollection;

    public Contact_Create clickNewContact ()
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiNewContact));
        uiNewContact.click();
        return (Contact_Create) new Contact_Create().init();
    }

    public Contact_ListAll selectAllOnPage ()
    {
//        wait(7).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollection)));
        wait(7).until(ExpectedConditions.visibilityOf(uiSelectAll));
        uiSelectAll.click();
        return this;
    }

    public Contact_ListAll selectAllInGroup ()
    {
        return this;
    }

    public Contact_ListAll selectNone ()
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiSelectAll));
        uiSelectAll.click();
        return this;
    }

    public Boolean confirmRowsContain ( String value )
    {
        wait(7).until(ExpectedConditions.visibilityOf(uiCollectionBody));
        Boolean output = uiCollectionBody.findElements(By.xpath(".//tr[contains(.,'"+value+"')]")).size() > 0;
        return output;
    }

}
