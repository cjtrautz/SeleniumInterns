package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Contact_Edit extends AbstractPage
{
    @FindBy(how=How.XPATH,
            using="//label[text()='Last Name']/following-sibling::div/input")
    private WebElement lastNameInput;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', normalize-space(@class), ' '),' component-subscription-object-selector-target ')]//button")
    private WebElement sequenceDropDown;
    
    @FindBy(how=How.XPATH,
            using="//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]//a")
    private WebElement subjectTask;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(@class, 'bulk_mail_TYPE')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-section-data ')]")
    private WebElement bulkEmailStatus;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_section ')][2]//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sub-collection-add-new ')]")
    private WebElement newTask;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Last Name']/following-sibling::button")
    private WebElement lastNameSave;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Last Name']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement lastNameField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='First Name']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement firstNameField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='First Name']/following-sibling::div/input")
    private WebElement firstNameInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='First Name']/following-sibling::button")
    private WebElement firstNameSave;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-note-create-target-text ')]//textarea")
    private WebElement textArea;
    
    @FindBy(
            how = How.XPATH, 
            using = "//a[normalize-space(text())='Notes and Tasks']")
    private WebElement notesAndTasksTab;
    
    @FindBy(
            how = How.XPATH, 
            using = "//a[normalize-space(text())='Referral Info']")
    private List<WebElement> referralInfoTab;
    
    //NEED TO FIX
    @FindBy(how=How.XPATH,
            using="//div[contains(@class, 'NAME_program_id')]//span[@class='ussr-section-data']")
    private WebElement affiliateProgramField;
    
    @FindBy(how=How.XPATH,
            using="//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-quick-object-creator-target-sae-button ')]//button")
    private WebElement affiliateProgramSaveAndEdit;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', normalize-space(@class), ' '),' create-new-form ')]//input")
    private WebElement affiliateProgramNameInput;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-section ')][2]//th//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-empty ')]")
    private WebElement selectAllTasks;
    
    @FindBy(
            how = How.XPATH, 
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-section ')][2]//li[@data-value='0']")
    private WebElement markComplete;
    
    @FindBy(
            how = How.XPATH, 
            using = "//div[normalize-space(@class)='ussr-chrome-panel-pane-header-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH, 
            using = "//div[@class='ussr-component-sub-collection-add-new']/span[text()='NEW Note']")
    private WebElement newNote;
    
    @FindBy(
            how = How.XPATH, 
            using = "//span[normalize-space(text())='Save']")
    private WebElement saveNote;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
  
    @FindBy(how = How.XPATH,
            using = "//div[@class='ussr-component-tab-container']/div[2]/div[2]//table")
    private WebElement taskBody;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_section ')][2]//thead//th/a")
    private WebElement taskSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//span[text()='Contact Information']")
    private WebElement contactInformationTitle;
    
    @FindBy(how = How.XPATH,
            using = "//a[contains(concat(' ', normalize-space(@class), ' '),' jb-overflowmenu-menu-secondary-handle ')]/span")
    private WebElement overflowIcon;
    
    public Contact_Edit clickLastName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameField.click();
        return this;
        
    }

    public Contact_Edit enterLastName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameInput.sendKeys(string);
        return this;
        
    }

    public Contact_Edit clickLastNameSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameSave.click();
        return this;
        
    }
    
    public Contact_Edit clickNotesAndTasksTab ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(notesAndTasksTab));
        notesAndTasksTab.click();
        return this;
        
    }
    
    public Contact_Edit clickReferralInfoTab ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(referralInfoTab.get(0)));
            referralInfoTab.get(0).click();
        }
        catch (Exception e)
        {
            wait.until(ExpectedConditions.visibilityOf(overflowIcon));
            overflowIcon.click();
            AbstractPart.waitForAjax(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(referralInfoTab.get(1)));
            referralInfoTab.get(1).click();
        }
        return this;
    }

    public Contact_Edit clickNewNote ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody)));
        wait.until(ExpectedConditions.visibilityOf(newNote));
        newNote.click();
        return this;
        
    }

    public Contact_Edit enterNote ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        textArea.sendKeys(string);
        return this;
        
    }

    public Contact_Edit clickSaveNote ()
    {
        AbstractPart.waitForAjax(driver, 20);
        saveNote.click();
        return this;
        
    }
    
    public Contact_Edit selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(taskBody)));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
        uiSelectAll.click();
        return this;
        
    }
    
    public Contact_Edit verifyNote (String note)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(8, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + note + "']"));
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
    
    public Contact_Edit verifyNoNote (String note)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@class='ussr-component-tab-container']/div[1]//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]"));
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
    
    public Contact_Edit verifyFieldValue (String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(8, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//div[normalize-space(text())='" + value + "']"));
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
    
    public Contact_Edit verifyDrilldownValue (String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[normalize-space(text())='" + value + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Contact_Edit verifyTag ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(8, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//label[normalize-space(text())='Contact Tags']/following-sibling::div//ul//li[contains(., '" + string + "')]"));
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

    public Contact_Edit deleteTag ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath(".//label[normalize-space(text())='Contact Tags']/following-sibling::div//ul//li[contains(., '" + string + "')]/a/span")).click();
        return this;
    }

    public Contact_Edit verifyNoTag ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(8, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//label[normalize-space(text())='Contact Tags']/following-sibling::div//ul//li[contains(., '" + string + "')]"));
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

    public Contact_Edit clickFirstName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameField.click();
        return this;
    }

    public Contact_Edit enterFirstName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameInput.sendKeys(string);
        return this;
    }

    public Contact_Edit clickFirstNameSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameSave.click();
        return this;
    }

    public Contact_Edit verifyFirstName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = firstNameField.getText();
        if(compare.equals(string)!=true)
        {
            return null;
        }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Contact_Edit verifyLastName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = lastNameField.getText();
        if(compare.equals(string)!=true)
        {
            return null;
        }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Contact_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }

    public Contact_Edit clickSequenceDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sequenceDropDown));
        sequenceDropDown.click();
        return this;
    }

    public Contact_Edit selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        wait.until(ExpectedConditions.visibilityOf(drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]"))));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public Contact_Edit verifySequence ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//label[normalize-space(text())='Sequences']/following-sibling::div//ul//li[contains(., '" + string + "')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Contact_Edit clickNewTask ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newTask));
        newTask.click();
        return this;
    }

    public Contact_Edit verifyTask ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(subjectTask));
            String compare = subjectTask.getText();
        if(compare.equals(string)!=true)
        {
            return null;
        }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Contact_Edit selectTask ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskSelectAll));
        taskSelectAll.click();
        return this;
    }

    public Contact_Edit clickAffiliateProgram ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(affiliateProgramField));
        affiliateProgramField.click();
        return this;
    }
    
    public Contact_Edit enterNewAffiliateProgramName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(affiliateProgramNameInput));
        affiliateProgramNameInput.sendKeys(string);
        return this;
    }
    
    public AffiliateProgram_Create clickAffiliateProgramSaveAndEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(affiliateProgramSaveAndEdit));
        affiliateProgramSaveAndEdit.click();
        return (AffiliateProgram_Create) new AffiliateProgram_Create().init();
    }

    public Contact_Edit selectAllTasks ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.click(selectAllTasks).build().perform();
        return this;
    }

    public Contact_Edit clickMarkComplete ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(markComplete));
        markComplete.click();
        return this;
    }

    public Contact_Edit verifyDoubleOptin ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(bulkEmailStatus));
            String compare = bulkEmailStatus.getText();
            if(compare.equals("Double Opt-In")!=true)
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

