package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Field_Editor extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-section-titlebar ')]/a[@href='javascript://']/span")
    private WebElement permision;

    @FindBy(
        how = How.XPATH,
        using = "//ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-primary ')]")
    private WebElement primaryTabs;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='User Permission Exceptions']")
    private WebElement userPermisionTitle;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-pane-header-title ')]")
    private WebElement sectionTitle;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-pane-header-title ')]")
    private WebElement sectionTitle2;
    
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
            using = "//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")
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
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-pane-nav ')]//a[contains(text(), 'Contact Information')]")
    private WebElement contactInformationTab;
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-section-titlebar ')]//span[contains(text(), 'Contact Information')]")
    private WebElement contactInformationTitle;

    public Field_Editor clickAddNewSection ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        newSectionButton.click();
        return this;
        
    }

    public Field_Editor enterSectionTitle ( String oldTitle, String newTitle )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        WebElement titleToEdit = driver.findElement(By.xpath("//span[normalize-space(text())='" + oldTitle + "']"));
        titleToEdit.click();
        input.sendKeys(newTitle+Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.RETURN).build().perform();
        return this;
    }

    public Field_Editor enterSectionDescription ( String title, String oldDescription, String newDescription )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='" + title + "']/ancestor::div/following-sibling::div[text()='" + oldDescription + "']")));
        WebElement descriptionToEdit = driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']/ancestor::div/following-sibling::div[text()='" + oldDescription + "']"));
        descriptionToEdit.click();
        AbstractPart.waitForAjax(driver, 20);
        input.sendKeys(newDescription+Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.RETURN).build().perform();
        return this;
    }

    public Contact_Settings clickSave () 
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(save));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")));
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
        AbstractPart.waitForAjax(driver, 20);
        //save.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(., 'Field Editor')]/span")));
        return (Contact_Settings) new Contact_Settings().init();
    }

    public Contact_Settings clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        cancel.click();
        return (Contact_Settings) new Contact_Settings().init();
        
    }
    public Field_Editor verifySection (String title, String description)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[contains(normalize-space(text()), '" + title + "')]"));
            driver.findElement(By.xpath("//span[contains(normalize-space(text()), '" + title + "')]/ancestor::div/following-sibling::div[text()='" + description + "']"));
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
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
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
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        WebElement deleteSection = driver.findElement(By.xpath("//div[span[contains(text(), '" + title + "')]]/following-sibling::div[@class='ussr-component-section-columns-wrapper']//button[span[text()='Delete Section']]"));
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
                catch(StaleElementReferenceException e1)
                {
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
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        sectionTitle.click();
        return this;
    }
    public Field_Editor clickUserPermissionsExceptionTitle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        userPermisionTitle.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(Keys.RETURN).build().perform();
        return this;
    }

    public DialogBox clickAddField ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        List<WebElement> addFields = driver.findElements(By.xpath("//div[contains(text(), '" + string + "')]/following-sibling::div//a[contains(., 'Add Field')]"));
        addFields.get(i-1).click();
        return (DialogBox) new DialogBox().init();
    }

    public Field_Editor verifyFieldCheckbox ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
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
        AbstractPart.waitForAjax(driver, 20);
      //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
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
              catch(StaleElementReferenceException e1)
              {
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
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
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
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addTab));
        addTab.click();
        AbstractPart.waitForAjax(driver, 20);
        return this;
        
    }

    public void enterNewTabName ( String string, int i ) throws InterruptedException
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary ')]//li/a[contains(text(), 'Untitled')]")));
        wait.until(ExpectedConditions.visibilityOf(overflowList.findElement(By.xpath(".//li/a[contains(text(), 'Untitled')]"))));
        overflowList.findElement(By.xpath(".//li/a[contains(text(), 'Untitled')]")).click();
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(overflowList.findElement(By.xpath(".//input"))));
        overflowList.findElement(By.xpath(".//input")).clear();
        AbstractPart.waitForAjax(driver, 20);
        action.sendKeys(string).perform();
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(overflowList));
        //overflowList.click();
        //AbstractPart.waitForAjax(driver, 20);
        //toggleOverflowMenu.click();
    }

    public Field_Editor verifyOverflowTab ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
        toggleOverflowMenu.click();
        AbstractPart.waitForAjax(driver, 20);
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
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
        toggleOverflowMenu.click();
        wait.until(ExpectedConditions.visibilityOf(overflowCollection));
        return this;
        
    }

    public Field_Editor clickTabName ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(overflowList));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' jb-overflowmenu-menu-secondary ')]//li/a[contains(text(), '" + string + "')]")));
        overflowList.findElement(By.xpath(".//li/a[contains(text(), '" + string + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(deleteTab.get(i-1)));
        return this;
        
    }

    public Field_Editor deleteTab (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(deleteTab.get(i-1)));
        deleteTab.get(i-1).click();
        wait.until(ExpectedConditions.visibilityOf(contactInformationTitle));
        return this;
        
    }

    public Field_Editor verifyNoOverflowTab ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try{
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            //wait.until(ExpectedConditions.visibilityOf(toggleOverflowMenu));
            toggleOverflowMenu.click();
            wait.until(ExpectedConditions.visibilityOf(overflowCollection));
        }
        catch(Exception e){
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

    public Field_Editor verifyFieldDate ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input[@placeholder='Date']"));
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

    public Field_Editor clickDeleteFieldDate ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelDate']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelDate']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldList ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/div[contains(concat(' ', normalize-space(@class), ' '), ' component-subscription-object-selector-target ')]"));
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

    public Field_Editor clickDeleteFieldList ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/div"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelList']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelList']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldLongText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/textarea"));
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

    public Field_Editor clickDeleteLongText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/textarea"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelLongText']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelLongText']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldNumeric ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input[@placeholder='Numeric']"));
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

    public Field_Editor clickDeleteNumeric ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelNumeric']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelNumeric']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input[@placeholder='Price']"));
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

    public Field_Editor clickDeleteFieldPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
       // wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelPrice']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelPrice']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldState ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/button"));
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

    public Field_Editor clickDeleteStateField ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelState']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelState']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input[contains(@placeholder, 'Drop')]"));
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

    public Field_Editor clickDeleteFieldDropdown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelDropdown']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelDropdown']/preceding-sibling::a")).isDisplayed();
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

    public Field_Editor verifyFieldText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input[contains(@placeholder, 'Text')]"));
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

    public Field_Editor clickDeleteFieldText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/preceding-sibling::a"))));
        WebElement moveTo = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']/following-sibling::div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]"))));
        WebElement toDelete = driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-border-dashed-all ')]//label[normalize-space(text())='" + string + "']/preceding-sibling::a/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-trashcan ')]"));
        action.clickAndHold(toDelete).perform();
        action.release(toDelete).perform();
        new WebDriverWait (driver, 15){}.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                try{
                    while(true){
                    d.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
                    d.findElement(By.xpath("//label[normalize-space(text())='SelText']/preceding-sibling::a")).isDisplayed();
                    d.manage()
                    .timeouts()
                    .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                    }
                }
                catch(StaleElementReferenceException e1)
                {
                    while(true){
                        d.manage()
                        .timeouts()
                        .implicitlyWait(0, TimeUnit.SECONDS);
                        d.findElement(By.xpath("//label[normalize-space(text())='SelText']/preceding-sibling::a")).isDisplayed();
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

    public Account_View clickSave2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(save));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")));
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
        //save.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(., 'Field Editor')]/span")));
        return (Account_View) new Account_View().init();
    }

    public Field_Editor clickUserTitle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sectionTitle2));
        sectionTitle2.click();
        return this;
    }

    public Field_Editor clickPermissions ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(permision));
        permision.click();
        return this;
    }

    public Contact_Settings clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (Contact_Settings) new Contact_Settings().init();
    }

    public Field_Editor clickTab ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(primaryTabs));
        wait.until(ExpectedConditions.visibilityOf(primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(i-1) + "']/a"))));
        primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(i-1) + "']/a")).click();
        return this;
    }

    public Field_Editor enterTabName ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(i-1) + "']//input"))));
        primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(i-1) + "']//input")).click();
        primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(i-1) + "']//input")).clear();
        primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(i-1) + "']//input")).sendKeys(string);
        return this;
    }

    public Field_Editor verifyTab ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(primaryTabs));
        try
        {
            primaryTabs.findElement(By.xpath(".//li/a[contains(text(), '" + string + "')]")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Field_Editor moveTab ( int tab, int distance )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(primaryTabs));
        Actions action = new Actions(driver);
        action.dragAndDropBy(primaryTabs.findElement(By.xpath(".//li[@data-tabindex='tab_" + Integer.toString(tab-1) + "']/span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-pane-field-editor-tab-drag-handle ')]")), distance, 0).build().perform();
        return this;
    }
    
}
