package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class ApiSettings_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//input")
    private WebElement apiName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-form-column']//button[normalize-space(.)='<br>']")
    private WebElement toggleContactOwnerPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-drilldownselect-listview ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement contactOwnerPaneCollection;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='component-api-generate-target-add']/div/div/div/a/span[1]")
    private WebElement addContactsCheckbox;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='component-api-generate-target-delete']/div/div/div/a/span[1]")
    private WebElement deleteContactsCheckbox;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='component-api-generate-target-create-key']/div/div/div/a/span[1]")
    private WebElement createKeyCheckbox;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='component-api-generate-target-search']/div/div/div/a/span[1]")
    private WebElement searchContactsCheckbox;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;

    
    public ApiSettings_Create enterApiName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(apiName));
        apiName.click();
        apiName.clear();
        apiName.sendKeys(name);
        return this;
        
    }

    public ApiSettings_Create openContactOwnerPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleContactOwnerPane));
        toggleContactOwnerPane.click();
        return this;
        
    }

    public ApiSettings_Create selectOwner ( int index )
    {
        AbstractPart.waitForAjax(driver, 20);
       wait.until(ExpectedConditions.visibilityOf(contactOwnerPaneCollection));
       List<WebElement> userOptions = contactOwnerPaneCollection.findElements(By.xpath(".//li"));
       WebElement toSelect = userOptions.get(index-1);
       toSelect.click();
       return this;
        
    }

    public ApiSettings_Create checkAddContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addContactsCheckbox));
        addContactsCheckbox.click();
        return this;
        
    }

    public ApiSettings_Create checkSearchContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchContactsCheckbox));
        searchContactsCheckbox.click();
        return this;
        
    }

    public ApiSettings_Create checkDeleteContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(deleteContactsCheckbox));
        deleteContactsCheckbox.click();
        return this;
        
    }

    public ApiSettings_Create checkCreateKey ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createKeyCheckbox));
        createKeyCheckbox.click();
        return this;
        
    }

    public ApiSettings_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (ApiSettings_ListAll) new ApiSettings_ListAll().init();
    }

    
}
