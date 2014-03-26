package com.ontraport.app.parts;

import java.util.List;

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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-edit-colunm-header ')]")
    private WebElement draggableColumn;
    
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
            using = "//tr[@class='sem-collection-header-display']/th[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-cell ')]")
    private List<WebElement> headerColumnCells;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[@class='sem-collection-header-display']/th[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-cell ')]")
    private List<WebElement> headerColumnCells2;
  
    @FindBy(
            how = How.XPATH,
            using = "//tr[@class='sem-collection-header-display']//a[text()='Zip Code']")
    private WebElement zipCodeColumn;

    @FindBy(
            how = How.XPATH,
            using = "//tr[@class='sem-collection-header-display']//th[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-cell-type-add-col ')]")
    private WebElement addColumn;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='jb-ace-scroll-track']/div")
    private WebElement scroll;
    
    public FormColumnManager open (String column) throws InterruptedException 
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(headerColumns));
        WebElement columnToEdit = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[normalize-space(text())='" + column + "']"));
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
        try
        {
        actions.dragAndDropBy(scroll, 1000, 0).build().perform();
        }
        catch(Exception e1)
        {
            
        }
        wait(5).until(ExpectedConditions.visibilityOf(columnToEdit));
        System.out.println("scrolled");
        actions.moveToElement(columnToEdit).build().perform();
        wait(5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @style='display: inline;']/span")));
        WebElement toDelete = driver.findElement(By.xpath("//a[normalize-space(text())='" + column + "']/following-sibling::div/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-col-edit ') and @style='display: inline;']/span"));
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
        wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fieldPaneCollection))); 
        wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fieldPaneCollection.findElement(By.xpath(".//div[contains(text(), '" + field + "')]"))))); 
        wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(fieldPaneCollection.findElement(By.xpath(".//div[contains(text(), '" + field + "')]"))))); 
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//div[text()='" + field + "']")));
        driver.findElement(By.xpath(".//div[text()='" + field + "']")).click();
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
        wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fieldPaneCollection.findElement(By.xpath(".//div[contains(text(), '" + string + "')]"))))); 
        wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(fieldPaneCollection.findElement(By.xpath(".//div[contains(text(), '" + string + "')]"))))); 
        return this;
    }
    
    public FormColumnManager clickCheckMark ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(checkMark))); 
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
    public int getColumnIndex ( String string )
    {
        waitForAjax(driver, 20);
        int count = 1;
        for(WebElement t : headerColumnCells)
        {
            System.out.println(t.findElement(By.xpath(".//a")).getText());
            if(t.findElement(By.xpath(".//a")).getText().equals(string))
            {
                break;
            }
            count=count+1;
        }
        System.out.println(count);
        return count;
    }
    public FormColumnManager clickColumnAndMove ( int i )
    {
        waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        wait(5).until(ExpectedConditions.visibilityOf(draggableColumn));  
        action.clickAndHold(draggableColumn );
        action.moveByOffset(i, 0);
        action.release(draggableColumn );
        action.build().perform();
        wait(5).until(ExpectedConditions.visibilityOf(draggableColumn));
        //need to wait for column editor to settle into a place
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return this;
    }
    public FormColumnManager verifyColumnEarlier ( String string, int index )
    {
        waitForAjax(driver, 20);
        int count = 1;
        for(WebElement j : headerColumnCells2)
        {
            System.out.println(j.findElement(By.xpath(".//a")).getText());
            if(j.findElement(By.xpath(".//a")).getText().equals(string))
            {
                System.out.println("break");
                break;
            }
            count=count+1;
        }
        System.out.println(count);
        if(count<index)
        {
            return this;
        }
        return null;
    }
    public FormColumnManager verifyColumn ( String string )
    {
        waitForAjax(driver, 20);
        try
        {
            if(!fieldPaneDropDown.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return this;
    }
}
