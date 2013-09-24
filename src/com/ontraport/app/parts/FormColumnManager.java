package com.ontraport.app.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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
    
    public FormColumnManager open (String column) throws InterruptedException 
    {
        wait(5).until(ExpectedConditions.visibilityOf(headerColumns));
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addColumn);
        //wait(1).until(ExpectedConditions.visibilityOf(columnToEdit));
        //WebElement pencil = headerColumns.findElement(By.xpath(".//a[text()='" + column + "']/following-sibling::div/a[3]/span"));
        //Actions actions = new Actions(driver);
        //WebElement columnToEdit = headerColumns.findElement(By.xpath(".//a[text()='" + column + "']"));
        //WebElement columnToMove = headerColumns.findElement(By.xpath(".//th"));
        //actions.moveToElement(columnToMove);
//        actions.moveToElement(columnToEdit);
//        actions.perform();
        //WebElement pencil = driver.findElement(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ')]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(zipCodeColumn).perform();
        
        //Thread.sleep(3000);
        wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Zip Code']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @style='display: inline;']/span")));
        wait(3).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Zip Code']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @style='display: inline;']/span")));
        WebElement toDelete = driver.findElement(By.xpath("//a[text()='Zip Code']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @style='display: inline;']/span"));
        actions.clickAndHold(toDelete).perform();
        actions.release(toDelete).perform();
        //wait(3).until(ExpectedConditions.visibilityOf(zipCodePencil2));
//
      // zipCodePencil2.click();
       //zipCodePencil2.click();
        //actions.moveToElement(pencil);
        //actions.click();
        //actions.perform();

//        wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ')]/span")));
//        wait(3).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ')]/span")));
//        System.out.println("here2");
//        //action.click(driver.findElement(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ')]/span"))).perform();    
//        columnToEdit.click();
//        wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ')]/span")));
//        wait(3).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ')]/span")));
        //driver.findElement(By.xpath("//a[text()='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @href='javascript://']/span")).click();
        System.out.println("here3");
        return this;
    }
    public FormColumnManager open () 
    { 
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addColumn);
        wait(5).until(ExpectedConditions.visibilityOf(addColumn)); 
        addColumn.click();
        return this;
    }
    public FormColumnManager close () { return this; }
    
    public FormColumnManager clickField ( String field )
    {
        wait(5).until(ExpectedConditions.visibilityOf(fieldPaneCollection)); 
        WebElement fieldToChoose = fieldPaneCollection.findElement(By.xpath(".//div[text()='" + field + "']"));
        fieldToChoose.click();
        return this;

    }
    public FormColumnManager openFieldPane ()
    {
        wait(5).until(ExpectedConditions.visibilityOf(fieldPaneDropDown)); 
        fieldPaneDropDown.click(); 
        return this;

    }
    public FormColumnManager clickCheckMark ()
    {
        checkMark.click();
        return this;

        
    }
    public FormColumnManager clickTrashCan ()
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", trashCan);
        wait(5).until(ExpectedConditions.visibilityOf(trashCan)); 
        trashCan.click();
        return this;
    }
}
