package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class User_Edit extends AbstractPage
{

    @FindBy(how=How.XPATH,
            using="//tbody[@class='ussr-component-collection-body']")
    private WebElement permissionCollectionBody;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Language']/following-sibling::div/span")
    private WebElement languageField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Timezone']/following-sibling::div")
    private WebElement timezoneField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='First Name']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement firstNameField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='First Name']/following-sibling::div/input")
    private WebElement firstNameInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='First Name']/following-sibling::button")
    private WebElement firstNameSave;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Last Name']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement lastNameField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Last Name']/following-sibling::div/input")
    private WebElement lastNameInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Last Name']/following-sibling::button")
    private WebElement lastNameSave;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Email']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement emailField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Email']/following-sibling::div/input")
    private WebElement emailInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Email']/following-sibling::button")
    private WebElement emailSave;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Telephone']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement telephoneField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Telephone']/following-sibling::div/input")
    private WebElement telephoneInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Telephone']/following-sibling::button")
    private WebElement telephoneSave;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Cell Phone']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement cellPhoneField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Cell Phone']/following-sibling::div/input")
    private WebElement cellPhoneInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Cell Phone']/following-sibling::button")
    private WebElement cellPhoneSave;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Fax']/following-sibling::div/div[@class='ussr-form-input']")
    private WebElement faxField;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Fax']/following-sibling::div/input")
    private WebElement faxInput;
    
    @FindBy(how=How.XPATH,
            using="//label[text()='Fax']/following-sibling::button")
    private WebElement faxSave;
    
    @FindBy(how=How.XPATH,
            using="//th[contains(concat(' ', @class, ' '),' ussr-component-collection-select-all-rows ')]")
    private WebElement selectAllEmptyCheckBox;
    
    public User_Edit verifyPermission (String permission)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            permissionCollectionBody.findElement(By.xpath(".//a[text()='" + permission + "']"));
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
    
    public User_Edit verifyNoPermissions ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            permissionCollectionBody.findElement(By.xpath("//td[contains(concat(' ', @class, ' '),' ussr-collection-empty ')]"));
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
    
    public User_Edit clickPermissionExceptionsCheckBox ()
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.stalenessOf(selectAllEmptyCheckBox));
        selectAllEmptyCheckBox.click();
        return this;
        
    }

    public User_Edit verifySection ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement title = null;
        try
        {
        title = driver.findElement(By.xpath("//span[normalize-space(text())='" + string + "']"));
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", title);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(title.isDisplayed()!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null; 
            }
            if(driver.findElement(By.xpath("//span[normalize-space(text())='" + string + "']/ancestor::div/following-sibling::div[text()='" + string2 + "']")).isDisplayed()!=true)
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

    public User_Edit verifyField ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement field = null;
        try
        {
        field = driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']"));
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", field);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(field.isDisplayed()!=true)
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

    public User_Edit verifyNotSection ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[normalize-space(text())='" + string + "']"));
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

    public User_Edit clickFirstName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameField.click();
        return this;
        
    }

    public User_Edit enterFirstName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameInput.sendKeys(string);
        return this;
        
    }

    public User_Edit clickFirstNameSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        firstNameSave.click();
        return this;
        
    }

    public User_Edit clickLastName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameField.click();
        return this;
        
    }

    public User_Edit enterLastName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameInput.sendKeys(string);
        return this;
        
    }

    public User_Edit clickLastNameSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        lastNameSave.click();
        return this;
        
    }

    public User_Edit clickEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        emailField.click();
        return this;
        
    }

    public User_Edit enterEmail ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        emailInput.sendKeys(string);
        return this;
        
    }

    public User_Edit clickEmailSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        emailSave.click();
        return this;
        
    }

    public User_Edit clickTelephone ()
    {
        AbstractPart.waitForAjax(driver, 20);
        telephoneField.click();
        return this;
        
    }

    public User_Edit enterTelephone ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        telephoneInput.sendKeys(string);
        return this;
        
    }

    public User_Edit clickTelephoneSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        telephoneSave.click();
        return this;
        
    }

    public User_Edit clickCellPhone ()
    {
        AbstractPart.waitForAjax(driver, 20);
        cellPhoneField.click();
        return this;
        
    }

    public User_Edit enterCellPhone ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        cellPhoneInput.sendKeys(string);
        return this;
        
    }

    public User_Edit clickCellPhoneSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        cellPhoneSave.click();
        return this;
        
    }

    public User_Edit clickFax ()
    {
        AbstractPart.waitForAjax(driver, 20);
        faxField.click();
        return this;
        
    }

    public User_Edit enterFax ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        faxInput.sendKeys(string);
        return this;
        
    }

    public User_Edit clickFaxSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        faxSave.click();
        return this;
        
    }

    public User_Edit verifyFirstName ( String string )
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

    public User_Edit verifyLastName ( String string )
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

    public User_Edit verifyEmail ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = emailField.getText();
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

    public User_Edit verifyTelephone ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = telephoneField.getText();
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

    public User_Edit verifyCellPhone ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = cellPhoneField.getText();
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

    public User_Edit verifyFax ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = faxField.getText();
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

    public User_Edit clickTimezone ()
    {
        AbstractPart.waitForAjax(driver, 20);
        timezoneField.click();
        return this;
        
    }

    public User_Edit selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']/li/div[text()='" + string + "']")).click();
        return this;
        
    }

    public User_Edit verifyTimezone ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = timezoneField.getText();
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

    public User_Edit clickLanguage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        languageField.click();
        return this;
    }

    public User_Edit verifySpanishLanguage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contactos']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Tareas']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Ventas']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Socios']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sitios']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Seguimiento']")).isDisplayed())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public User_Edit verifyChineseLanguage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='联系人']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='任务']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='销售']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='合作伙伴']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='网站']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='跟踪']")).isDisplayed())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public User_Edit verifyHebrewLanguage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='אנשי קשר']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='משימות']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='מכירות']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='שותפים']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='אתרים']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='מעקב']")).isDisplayed())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public User_Edit verifyRussianLanguage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Контакты']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Задачи']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Продажи']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Партнеры']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Сайты']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Отслеживание']")).isDisplayed())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Object verifyEnglishLanguage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Tasks']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sales']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Partners']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sites']")).isDisplayed())
            {
                return null;
            }
            if(!driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Tracking']")).isDisplayed())
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
