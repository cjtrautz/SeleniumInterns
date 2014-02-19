package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Contact_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-message-notification ')]")
    private WebElement notification;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-helper-cursor-pointer ')]")
    private WebElement uiSelectAllInGroup;
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-message-notification ')]")
    private WebElement notification2;
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-message-notification ')]")
    private WebElement notification3;
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-message-notification ')]/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-component-message-close ')]")
    private WebElement notificationClose;
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-message-notification ')]/a[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-component-message-close ')]")
    private WebElement notificationClose2;
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-message-notification ')]/a[contains(concat(' ', normalize-space(@href), ' '), ' javascript:ontraport.Panes.Contact.goToHome(true) ')]")
    private WebElement notificationGo;
    
    public static String    url = "/#!/contact/listAll";
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
            using = "//tbody[@class='ussr-component-collection-body']/tr/td[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-collection-cell-type-text ')]/span/a")
    private WebElement uiCollectionBodyFirstCell;
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr")
    private List<WebElement> uiCollectionBodyRows;
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement uiNewContact;
    @FindBy(how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//div[div[contains(concat(' ', normalize-space(@class), ' '), ' user-leading-container ')] or table[tbody[tr[td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]]]]]")
    private WebElement emptyCell;
    @FindBy(how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//div[div[contains(concat(' ', normalize-space(@class), ' '), ' user-leading-container ')] or table[tbody[tr[td[2]]]]]")
    private WebElement firstCellOrContactAddOptions;

    public Contact_Create clickNewContact ()
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        wait.until(ExpectedConditions.visibilityOf(uiNewContact));
        uiNewContact.click();
        return (Contact_Create) new Contact_Create().init();
    }
    public Contact_ListAll selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
              .timeouts()
              .implicitlyWait(0, TimeUnit.SECONDS);
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        }
        driver.manage()
              .timeouts()
              .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        try
        {
            uiSelectAll.click();
        }
        catch(StaleElementReferenceException e)
        {
            uiSelectAll.click();
        }
        return this;
    }
    public Contact_ListAll selectAllInGroup ()
    {
        AbstractPart.waitForAjax(driver, 20);
        uiSelectAllInGroup.click();
        return this;
    }
    public Contact_ListAll selectNone ()
    {
        AbstractPart.waitForAjax(driver, 20);
        uiSelectAll.click();
        return this;
    }
    public Contact_ListAll verifyColumn (String column)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            uiCollectionHead.findElement(By.xpath(".//a[text()='" + column + "']"));
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
    public Contact_ListAll verifyNotColumn (String column)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            uiCollectionHead.findElement(By.xpath(".//a[text()='" + column + "']"));
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
    public Contact_Edit clickContact ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        }
        try
        {
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll)); 
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        }
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td[2]/span")));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td[2]/span")));
        }
        catch(TimeoutException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td[2]/span")));
        }
        try
        {
            driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td[2]/span/a")).click();
        }
        catch(StaleElementReferenceException e)
        {
            driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td[2]/span/a")).click();
        }
        return (Contact_Edit) new Contact_Edit().init();
    }
    public Contact_ListAll verifyContact (String contact)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + contact + "']"));
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
    
    public Contact_ListAll verifyNoContact ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            emptyCell.isDisplayed();
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
    public Contact_Edit clickContact ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        }
        try
        {
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll)); 
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        }
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td//a[contains(text(), '" + string + "')]")));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td//a[contains(text(), '" + string + "')]")));
        }
        catch(TimeoutException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td//a[contains(text(), '" + string + "')]")));
        }
        try
        {
            driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td//a[contains(text(), '" + string + "')]")).click();
        }
        catch(StaleElementReferenceException e)
        {
            driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td//a[contains(text(), '" + string + "')]")).click();
        }
        return (Contact_Edit) new Contact_Edit().init();
    }
    public Contact_ListAll selectContact (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll)); 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td[2]/span")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr[" + i + "]/td")).click();
        return this;
        
    }
    public Contact_ListAll verifyNumberOfContactsPerPage ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='ussr-component-collection-body']//tr"));
            System.out.println(rows.size());
            if(rows.size()!=i)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Contact_ListAll verifyQued ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!notification.isDisplayed())
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
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
    public Contact_ListAll verifyBeingImportedAndClose ()
    {  
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(notification))); 
            if(!notification.isDisplayed())
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            wait.until(ExpectedConditions.visibilityOf(notificationClose));
            notificationClose.click();
            //wait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.visibilityOf(notification)))); 
        }
        catch(Exception e)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return this;
    }
    public Contact_ListAll verifyBeingProcessedAndClose ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(notification2)));  
            if(!notification2.isDisplayed())
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            System.out.println("here");
            wait.until(ExpectedConditions.visibilityOf(notificationClose2));
            notificationClose2.click();
        }
        catch(Exception e)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return this;
    }
    public Contact_ListAll verifyDoneAndClick ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(notification3)));  
            if(!notification3.isDisplayed())
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(notificationGo)));  
            notificationGo.click();
        }
        catch(Exception e)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            e.printStackTrace();
            return null;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.navigate().refresh();
        AbstractPart.waitForAjax(driver, 20);
        return this;
    }
    public Contact_ListAll verifyNumberOfContacts ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(uiCollectionBodyRows.size()!=i)
            {
                return null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }
    public Contact_Edit clickFirstContact ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyFirstCell));
        uiCollectionBodyFirstCell.click();
        return (Contact_Edit) new Contact_Edit().init();
    }
    public Contact_ListAll verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.getCurrentUrl().contains("#!/contact/listAll"))
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()=\"No contacts yet... let's create some!\" or text()='Contacts']")).isDisplayed())
            {
                return null;
            }
            if(!firstCellOrContactAddOptions.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }


    
}
