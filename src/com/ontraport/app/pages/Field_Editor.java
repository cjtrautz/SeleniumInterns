package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

public class Field_Editor extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-section-titlebar ')]")
    private WebElement sectionTitle;
    
    @FindBy(
            how = How.CSS,
            using = "input.ussr-widget-editinplace-input")
    private WebElement input;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']")
    private WebElement newSectionButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[span[text()='Save']]")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button/span[text()='Cancel']")
    private WebElement cancel;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-pane-field-editor-add-tab ')]/span")
    private WebElement addTab;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary ')]")
    private WebElement overflowList;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-pane-field-editor-tab-empty-message ')]/button")
    private List<WebElement> deleteTab;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary-handle ')]/span")
    private WebElement toggleOverflowMenu;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary-handle ')]/following-sibling::ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary ')]")
    private WebElement overflowCollection;

    public Field_Editor clickAddNewSection ()
    {
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        newSectionButton.click();
        return this;
        
    }

    public Field_Editor enterSectionTitle ( String oldTitle, String newTitle )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        WebElement titleToEdit = driver.findElement(By.xpath("//span[normalize-space(text())='" + oldTitle + "']"));
        titleToEdit.click();
        input.sendKeys(newTitle+Keys.ENTER);
        return this;
    }

    public Field_Editor enterSectionDescription ( String title, String oldDescription, String newDescription )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        WebElement descriptionToEdit = driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']/ancestor::div/following-sibling::div[text()='" + oldDescription + "']"));
        descriptionToEdit.click();
        input.sendKeys(newDescription+Keys.ENTER);
        return this;
    }

    public Contact_Settings clickSave ()
    {
        wait.until(ExpectedConditions.visibilityOf(save));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")));
        save.click();
        save.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(., 'Field Editor')]/span")));
        return PageFactory.initElements(driver, Contact_Settings.class);
    }

    public Contact_Settings clickCancel ()
    {
        cancel.click();
        return PageFactory.initElements(driver, Contact_Settings.class);
        
    }
    public Field_Editor verifySection (String title, String description)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']"));
            driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']/ancestor::div/following-sibling::div[text()='" + description + "']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
        
    }
    public Field_Editor verifyNotSection (String title)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        return null;
        
    }

    public Field_Editor clickDeleteSection (String title)
    {
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        WebElement deleteSection = driver.findElement(By.xpath("//div[span[text()='" + title + "']]/following-sibling::div[@class='ussr-component-section-columns-wrapper']//button[span[text()='Delete Section']]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", deleteSection);
        deleteSection.click();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//span[normalize-space(text())='SelTitle']")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(NoSuchElementException e)
                {
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    return true;    
                }
            }
        });
        return this;
    }
    
    public Field_Editor clickTitle ()
    {
        sectionTitle.click();
        return this;
    }

    public DialogBox clickAddField ( String string, int i )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        List<WebElement> addFields = driver.findElements(By.xpath("//div[contains(text(), '" + string + "')]/following-sibling::div//a[contains(., 'Add Field')]"));
        addFields.get(i-1).click();
        return PageFactory.initElements(driver, DialogBox.class);
    }

    public Field_Editor verifyFieldCheckbox ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/a/span[@class='ussr-icon ussr-icon-checkbox-empty']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
        
    }

    public Field_Editor clickDeleteFieldCheckbox ( String string ) throws InterruptedException
    {
      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
      WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/a/span[@class='ussr-icon ussr-icon-checkbox-empty']"));
      Actions action = new Actions(driver);
      action.moveToElement(moveTo).build().perform();
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
      //Thread.sleep(2000);
      WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
      //action.moveToElement(toDelete);
      //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
      //action.perform();
      //Thread.sleep(1000);
      action.clickAndHold(toDelete).perform();
      //Thread.sleep(2000);
      action.release(toDelete).perform();
      //driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]")).click();
      new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
          @Override
          public Boolean apply(WebDriver d){
              try{
                  while(true){
                  d.manage()
                  .timeouts()
                  .implicitlyWait(0, TimeUnit.SECONDS);
                  d.findElement(By.xpath("//label[normalize-space(text())='SelCheckbox']/preceding-sibling::a")).isDisplayed();
                  d.manage()
                  .timeouts()
                  .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                  }
              }
              catch(NoSuchElementException e)
              {
                  d.manage()
                  .timeouts()
                  .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                  return true;    
              }
          }
      });
      //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
      return this;
        
    }

    public Field_Editor verifyNotField ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/a/span[@class='ussr-icon ussr-icon-checkbox-empty']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        return null;
    }

    public Field_Editor clickAddNewTab ()
    {
        wait.until(ExpectedConditions.visibilityOf(addTab));
        addTab.click();
        return this;
        
    }

    public void enterNewTabName ( String string, int i )
    {
        wait.until(ExpectedConditions.visibilityOf(overflowList));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary ')]//li/a[contains(text(), 'Untitled')]")));
        overflowList.findElement(By.xpath(".//li/a[contains(text(), 'Untitled')]")).click();
        wait.until(ExpectedConditions.visibilityOf(deleteTab.get(i-1)));
        driver.findElement(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary ')]//li/a/input")).sendKeys(string+Keys.ENTER);
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']")).click();
        wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
        toggleOverflowMenu.click();
    }

    public Field_Editor verifyOverflowTab ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
        toggleOverflowMenu.click();
        wait.until(ExpectedConditions.visibilityOf(overflowCollection));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            overflowList.findElement(By.xpath(".//li/a[contains(text(), '" + string + "')]")).isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public Field_Editor clickOverflowExpand ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
        toggleOverflowMenu.click();
        wait.until(ExpectedConditions.visibilityOf(overflowCollection));
        return this;
        
    }

    public Field_Editor clickTabName ( String string, int i )
    {
        wait.until(ExpectedConditions.visibilityOf(overflowList));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[contains(text(), '" + string + "')]")));
        overflowList.findElement(By.xpath(".//li/a[contains(text(), 'Untitled')]")).click();
        wait.until(ExpectedConditions.visibilityOf(deleteTab.get(i-1)));
        return this;
        
    }

    public Field_Editor deleteTab (int i)
    {
        wait.until(ExpectedConditions.visibilityOf(deleteTab.get(i-1)));
        deleteTab.get(i-1).click();
        return this;
        
    }

    public Field_Editor verifyNoOverflowTab ( String string )
    {
        try{
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
            toggleOverflowMenu.click();
            wait.until(ExpectedConditions.visibilityOf(overflowCollection));
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            overflowList.findElement(By.xpath(".//li/a[contains(text(), '" + string + "')]")).isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        return null;
    }
    
}
