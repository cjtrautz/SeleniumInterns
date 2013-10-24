package com.ontraport.app.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class FormColumnManager extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-edit-colunm-header-actions ')]//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-checkmark ')]")
    private WebElement checkMark;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-edit-colunm-header-actions ')]//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]")
    private WebElement trashCan;
    
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-drilldownselect-ul ')]")
    private WebElement fieldPaneCollection;
    
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_collection_column_editor ')]//button")
    private WebElement fieldPaneDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_collection_column_editor ')]//input")
    private WebElement fieldPaneInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[@class='sem-collection-header-display']")
    private WebElement headerColumns;
  
    @FindBy(
            how = How.XPATH,
            using = "//tr[@class='sem-collection-header-display']//a[text()='Zip Code']")
    private WebElement zipCodeColumn;

    @FindBy(
            how = How.XPATH,
            using = "//tr[@class='sem-collection-header-display']//a[text()='Add Column']")
    private WebElement addColumn;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='jb-ace-scroll-track']/div")
    private WebElement scroll;
    
    public FormColumnManager open (String column) throws InterruptedException 
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(headerColumns));
        WebElement columnToEdit = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[text()='" + column + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", columnToEdit);
        waitForAjax(driver, 20);
        Actions actions = new Actions(driver);
        try{
            wait(5).until(ExpectedConditions.visibilityOf(scroll));
        }
        catch(TimeoutException e)
        {
            System.out.println("no scroll");
        }
        actions.dragAndDropBy(scroll, 1000, 0).build().perform();
        System.out.println("scrolled");
        actions.moveToElement(columnToEdit).build().perform();
        WebElement toDelete = driver.findElement(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @style='display: inline;']/span"));
        actions.clickAndHold(toDelete).build().perform();
        actions.release(toDelete).build().perform();
        System.out.println("here3");
        return this;
    }
    public FormColumnManager open () 
    { 
        waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addColumn);
        wait(5).until(ExpectedConditions.visibilityOf(addColumn)); 
        addColumn.click();
        return this;
    }
    public FormColumnManager close () { return this; }
    
    public FormColumnManager clickField ( String field )
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(fieldPaneCollection)); 
        WebElement fieldToChoose = fieldPaneCollection.findElement(By.xpath(".//div[text()='" + field + "']"));
        fieldToChoose.click();
        return this;

    }
    public FormColumnManager openFieldPane ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(fieldPaneDropDown)); 
        fieldPaneDropDown.click(); 
        return this;
    }
    
    public FormColumnManager enterFieldPaneInput (String string)
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(fieldPaneInput)); 
        fieldPaneInput.sendKeys(string); 
        return this;
    }
    
    public FormColumnManager clickCheckMark ()
    {
        waitForAjax(driver, 20);
        checkMark.click();
        return this;

        
    }
    public FormColumnManager clickTrashCan ()
    {
        waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", trashCan);
        wait(5).until(ExpectedConditions.visibilityOf(trashCan)); 
        trashCan.click();
        return this;
    }
}
