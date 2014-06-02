package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class LandingPage_Edit extends AbstractPage
{ 
    @FindBy(how = How.XPATH,
            using = "//body")
    private WebElement body;
    
    @FindBy(how = How.XPATH,
            using = "//textarea")
    private WebElement textarea;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@style), ' '),'http://i.ontraport.com') or div[contains(concat(' ', normalize-space(@style), ' '),'http://i.ontraport.com')]]")
    private WebElement image;
    
    @FindBy(
            how = How.XPATH,
            using = "//td[@id='property_cell']//input[@value='Select Image']")
    private WebElement selectImage;
    
    @FindBy(
            how = How.XPATH,
            using = "//td[contains(text(),'Page URL:')]/following-sibling::td/following-sibling::td")
    private WebElement codeModeURL;
    
    @FindBy(
            how = How.XPATH,
            using = "//td[contains(text(), 'Links To:')]/following-sibling::td/input")
    private WebElement linksTo;
    
    @FindBy(
            how = How.XPATH,
            using = "//td[contains(text(), 'Links To:')]/following-sibling::td/input[contains(concat(' ', normalize-space(@class), ' '),' inpt_text_focus ')]")
    private WebElement linksToFocus;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span/span[contains(concat(' ', normalize-space(@style), ' '),' width: 300px; ')]")
    private WebElement rectangleGradientHorizontal;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span/span[contains(concat(' ', normalize-space(@style), ' '),' height: 200px; ')]")
    private WebElement rectangleGradientVertical;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='inpt_button' and text()='Vertical']")
    private WebElement verticalButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='inpt_button' and text()='Horizontal']")
    private WebElement horizontalButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='gradientBar']/following-sibling::div/center/div[contains(concat(' ', @style, ' '),' cursor: pointer; ')]")
    private List<WebElement> gradientColor;
    
    @FindBy(how = How.XPATH,
            using = "//center[text()='Opacity']/following-sibling::div/img")
    private WebElement opacity;
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='colorSelector']")
    private WebElement color;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Rounded']")
    private WebElement rounded;
    
    @FindBy(how = How.XPATH,
            using = "//a[@title='Source']")
    private WebElement source;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Circle']")
    private WebElement circle;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Height:')]/following-sibling::td/input")
    private WebElement heightInput;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Width:')]/following-sibling::td/input")
    private WebElement widthInput;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Top:')]/following-sibling::td/input")
    private WebElement topInput;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Left:')]")
    private WebElement left;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Left:')]/following-sibling::td/input")
    private WebElement leftInput;
    
    @FindBy(how = How.XPATH,
            using = "//center[text()='Line Spacing']/following-sibling::div/img")
    private WebElement lineSpacing;
    
    @FindBy(how = How.XPATH,
            using = "//center[text()='Letter Spacing']/following-sibling::div/img")
    private WebElement letterSpacing;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Right']")
    private WebElement rightAlign;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Left']")
    private WebElement leftAlign;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Center']")
    private WebElement center;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Italic']")
    private WebElement italic;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Underline']")
    private WebElement underline;
    
    @FindBy(
            how = How.TAG_NAME,
            using = "iframe")
    private WebElement iFrame;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @style, ' '),' font-family: Verdana,Geneva,sans-serif; ')]")
    private WebElement textBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//img[@title='Bold']")
    private WebElement bold;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@style), ' '),' cursor: pointer; ') and contains(text(), 'Version B')]")
    private WebElement versionB;
    
    @FindBy(how = How.XPATH,
            using = "//td[@id='property_cell']//tbody/tr/td[3]//select")
    private WebElement formFontSizeDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//td[@id='property_cell']//tbody/tr/td[2]//select")
    private WebElement fontSizeDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//td[@id='property_cell']//tbody/tr/td[1]//select")
    private WebElement fontDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@style), ' '),' cursor: pointer; ') and contains(text(), 'Version B')]/preceding-sibling::td/img")
    private WebElement versionBDelete;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),' cursor: pointer; ')]//span[contains(text(), 'New Version')]")
    private WebElement newVersion;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[text()='Save']")
    private WebElement save;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-back ')]")
    private WebElement back;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_drill_down_select_field_selector_merge_field_inserter ')]//button")
    private WebElement fieldDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_drill_down_select ')]//button")
    private WebElement formDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]//input[@type='TEXT']")
    private WebElement landingPageNameTitle;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement landingPageName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' moonray-form ')]")
    private WebElement form;
    
    @FindBy(how = How.XPATH,
            using = "//form[contains(concat(' ', normalize-space(@class), ' '),' moonray-form-clearfix ')]")
    private WebElement smartform;
    
    @FindBy(how = How.XPATH,
            using = "//td[@id='Menu_Bar']/div/div/table/tbody/tr[3]/td/div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]/table/tbody/tr/td[2]")
    private WebElement landingPageURL;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span")
    private WebElement box;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/div")
    private List<WebElement> notRectangleBox;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/div[contains(concat(' ', normalize-space(@style), ' '),' width: 42.3202px; ')]")
    private WebElement circleBox;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/div[contains(concat(' ', normalize-space(@style), ' '),' width: 13.7113px; ')]")
    private WebElement circleImage;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/div[contains(concat(' ', normalize-space(@style), ' '),' width: 290px; ')]")
    private WebElement roundedBox;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/div[contains(concat(' ', normalize-space(@style), ' '),' left: 5px; ')]")
    private WebElement roundedImage;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/span[contains(concat(' ', normalize-space(@style), ' '),' width: 300px; ')]")
    private WebElement squareGradient;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Background:')]/following-sibling::td/div[@style='cursor: pointer;']")
    private WebElement background;
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='colorSelector']")
    private WebElement backgroundCodeMode;
    
    @FindBy(how = How.XPATH,
            using = "//select")
    private WebElement select;
    
    @FindBy(how = How.XPATH,
            using = "//input[@class='inpt_checkbox standard_input']")
    private WebElement splitTestCheckbox;

    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Page Alignment:')]/following-sibling::td//select")
    private WebElement codeModePageAlignmentSelect;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Switch View:')]/following-sibling::td//select")
    private WebElement codeModeSplitTestSelect;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'Page Size:')]/following-sibling::td/div[contains(concat(' ', normalize-space(@style), ' '),' cursor: pointer; ')]")
    private WebElement pageSize;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-hosted-domain-target-component ')]//input")
    private WebElement redirectURL;

    public LandingPage_Edit verifyLandingPageTitle ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = landingPageNameTitle.getAttribute("value");
            System.out.println(compare);
            if(compare.equals(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit verifyLandingPageURL ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = landingPageURL.getText();
            System.out.println(compare);
            System.out.println("http://" + value + ".respond.ontraport.net");
            if(compare.equals("http://" + value + ".respond.ontraport.net")!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit verifyLandingPageShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(box.isDisplayed()!=true)
            {
                return null;
            }

        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        
        return this;
    }
    
    public LandingPage_Edit verifyLandingPageRectangleShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(notRectangleBox.size()==0)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return this;
            }

        }
        catch(NoSuchElementException e)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return null;
    }

    public LandingPage_Edit clickBackground ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(background));  
        background.click();
        return this;
    }

    public LandingPage_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));  
        save.click();
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));  
        back.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }

    public LandingPage_Edit verifyBackground ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//center[@class='box_canvas']//div[contains(concat(' ', normalize-space(@style), ' '),' rgb" + string +"; ')]")).isDisplayed();

        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickPageSize ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(pageSize));
        pageSize.click();
        return this;
    }

    public LandingPage_Edit verifyPageSize ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(driver.findElement(By.xpath("//center[@class='box_canvas']//div[contains(concat(' ', normalize-space(@style), ' '),' width: " + string +"px; height: " + string2 +"px; ')]")).isDisplayed()!=true)
            {
                return null;
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickNewSplitTestingVersion ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newVersion));
        newVersion.click();
        return this;
    }

    public LandingPage_Edit verifyVersionBPresent ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(versionB.isDisplayed()!=true)
            {
                return null;
            }

        }
        catch(NoSuchElementException e){

            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickDeleteSplitTestingVersionB ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(versionBDelete));
        versionBDelete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return this;
    }

    public LandingPage_Edit verifyVersionBNotPresent ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(versionB.isDisplayed()!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return this;
            }

        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return null;
    }

    public LandingPage_Edit verifyLandingPageText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = textBody.getText();
            System.out.println(compare);
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

    public LandingPage_Edit doubleClickText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement text = driver.findElement(By.xpath("//div[contains(concat(' ', @style, ' '),' font-family: Verdana,Geneva,sans-serif; ') and .='" + string + "']"));
        wait.until(ExpectedConditions.visibilityOf(text));
        Actions action = new Actions(driver);
        action.doubleClick(text).build().perform();
        return this;
    }
    
    public LandingPage_Edit singleClickText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement text = driver.findElement(By.xpath("//div[contains(concat(' ', @style, ' '),' font-family: Verdana,Geneva,sans-serif; ') and .='" + string + "']"));
        wait.until(ExpectedConditions.visibilityOf(text));
        text.click();
        return this;
    }

    public LandingPage_Edit highlightTextRight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement text = driver.findElement(By.xpath("//body[.='" + string + "']"));
        text.click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).build().perform();
        for(int i = 0; i<string.length(); i++)
        {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
        }
        action.keyUp(Keys.SHIFT).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    public LandingPage_Edit clickFontDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", fontDropDown);
        wait.until(ExpectedConditions.visibilityOf(fontDropDown));
        fontDropDown.click();
        return this;
    }

    public LandingPage_Edit selectFontDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement click = driver.findElement(By.xpath("//td[@id='property_cell']//tbody//select//option[text()='" + string + "']"));
        wait.until(ExpectedConditions.visibilityOf(click));
        click.click();
        AbstractPart.waitForAjax(driver, 20);AbstractPart.waitForAjax(driver, 20);
        Actions actions = new Actions(driver);
        actions.clickAndHold(click).build().perform();
        actions.release().build().perform();
        return this;
    }

    public LandingPage_Edit verifyFont ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(driver.findElement(By.xpath("//font[contains(@face, '" + string2 + "') and .='" + string + "']")).isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){

            return null;
        }
        return this;
    }

    public LandingPage_Edit clickFontSizeDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", fontSizeDropDown);
        wait.until(ExpectedConditions.visibilityOf(fontSizeDropDown));
        fontSizeDropDown.click();
        return this;
    }

    public LandingPage_Edit verifyFontSize ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(driver.findElement(By.xpath("//font[contains(@size, '" + string2 + "') and .='" + string + "']")).isDisplayed()!=true)
            {
                return null;
            }

        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickBold ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bold);
        wait.until(ExpectedConditions.visibilityOf(bold));
        bold.click();
        return this;
    }

    public LandingPage_Edit verifyBold (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//b[.='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    public LandingPage_Edit clickItalic ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", italic);
        wait.until(ExpectedConditions.visibilityOf(italic));
        italic.click();
        return this;
    }

    public LandingPage_Edit verifyItalic ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//i[.='" + string + "']"));
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickUnderline ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", underline);
        wait.until(ExpectedConditions.visibilityOf(underline));
        underline.click();
        return this;
    }

    public LandingPage_Edit verifyUnderlined ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//u[.='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickCenter ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", center);
        wait.until(ExpectedConditions.visibilityOf(center));
        center.click();
        return this;
    }

    public LandingPage_Edit verifyCenter ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//div[@align='center' and .='" + string + "']"));
        }
        catch(NoSuchElementException e){

            return null;
        }
        return this;
    }

    public LandingPage_Edit clickLeftAlign ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", leftAlign);
        wait.until(ExpectedConditions.visibilityOf(leftAlign));
        leftAlign.click();
        return this;
    }

    public LandingPage_Edit verifyLeftAlign ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//div[@align='left' and .='" + string + "']"));

        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickRightAlign ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", rightAlign);
        wait.until(ExpectedConditions.visibilityOf(rightAlign));
        rightAlign.click();
        return this; 
    }

    public LandingPage_Edit verifyRightAlign ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//div[@align='right' and .='" + string + "']"));

        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }
    
    public LandingPage_Edit clickMoveLetterSpacer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", letterSpacing);
        wait.until(ExpectedConditions.visibilityOf(letterSpacing));
        Actions action = new Actions(driver);
        action.dragAndDropBy(letterSpacing, i, 0).build().perform();

        return this;
    }
    
    public LandingPage_Edit verifyLetterSpacing ( double i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' letter-spacing: " + i +"px; ') and .='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    
    public LandingPage_Edit clickMoveLineSpacer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lineSpacing);
        wait.until(ExpectedConditions.visibilityOf(lineSpacing));
        Actions action = new Actions(driver);
        action.dragAndDropBy(lineSpacing, i, 0).build().perform();

        return this;
        
    }

    public LandingPage_Edit verifyLineSpacing ( double i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' line-height: " + i +"; ') and .='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit enterLeft ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leftInput));
        leftInput.click();
        leftInput.clear();
        leftInput.sendKeys(i + Keys.ENTER);
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(leftInput, Keys.ENTER).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
        action.sendKeys(leftInput, Keys.RETURN).build().perform();
        return this;
    }
    
    public LandingPage_Edit clickLeft ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(left));
        left.click();
        return this;
    }

    public LandingPage_Edit verifyLeft ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' left: " + i +"px; ')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit enterTop ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(topInput));
        topInput.click();
        topInput.clear();
        topInput.sendKeys(string + Keys.ENTER);
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(topInput, Keys.ENTER).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
        action.sendKeys(topInput, Keys.RETURN).build().perform();
        return this;
    }

    public LandingPage_Edit verifyTop ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' top: " + i +"px; ')]"));

        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit enterWidth ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(widthInput));
        widthInput.click();
        widthInput.clear();
        widthInput.sendKeys(string + Keys.ENTER);
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(widthInput, Keys.ENTER).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
        action.sendKeys(widthInput, Keys.RETURN).build().perform();
        return this;
    }

    public LandingPage_Edit verifyWidth ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' width: " + i +"px; ')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit enterHeight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(heightInput));
        heightInput.click();
        heightInput.clear();
        heightInput.sendKeys(string + Keys.ENTER);
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(heightInput, Keys.ENTER).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
        action.sendKeys(heightInput, Keys.RETURN).build().perform();
        return this;
    }

    public LandingPage_Edit verifyHeight ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' height: " + i +"px; ')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickCircle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(circle));
        circle.click();
        return this;
    }
    
    public LandingPage_Edit verifyCircle ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!circleBox.isDisplayed())
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    
    public LandingPage_Edit verifyCircleImage ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!circleImage.isDisplayed())
            {
                return null; 
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(box));
        box.click();
        return this;
    }

    public LandingPage_Edit clickRounded ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(rounded));
        rounded.click();
        return this;
    }
    
    public LandingPage_Edit clickGradient1 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gradientColor.get(0)));
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(0)).build().perform();
        return this;
    }

    public LandingPage_Edit clickGradient2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gradientColor.get(1)));
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(1)).build().perform();
        return this;
    }

    public LandingPage_Edit verifyRounded ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!roundedBox.isDisplayed())
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    
    public LandingPage_Edit verifyRoundedImage ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!roundedImage.isDisplayed())
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    
    public LandingPage_Edit clickColor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(color));
        color.click();
        return this;
    }

    public LandingPage_Edit verifyColor ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' rgb" + string + "; ') or div[contains(concat(' ', @style, ' '),' rgb" + string + "; ')]]")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    public LandingPage_Edit clickMoveOpacity ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(opacity));
        Actions action = new Actions(driver);
        action.dragAndDropBy(opacity, -i, 0).build().perform();
        return this;
    }

    public LandingPage_Edit verifyOpacity ( double i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span[contains(concat(' ', normalize-space(@style), ' '),' opacity: " + i +"; ')]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit verifyLandingPageSquareGradient ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!squareGradient.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    public LandingPage_Edit clickVertical ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(verticalButton));
        verticalButton.click();
        return this;
    }

    public LandingPage_Edit clickHorizontal ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(horizontalButton));
        horizontalButton.click();
        return this;
    }

    public LandingPage_Edit verifyVertical ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!rectangleGradientVertical.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit verifyHorizontal ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!rectangleGradientHorizontal.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    public LandingPage_Edit verifyImageRectangle ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        try
        {

            if(driver.findElements(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]/div")).size()==0)
            {
                return this;
            }
        }
        catch(NoSuchElementException e){
            return this;
        }
        return null;
    }
    public LandingPage_Edit verifyImage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"') or div[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public LandingPage_Edit clickImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(image));
        image.click();
        return this;
    }

    public LandingPage_Edit clickSelectImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectImage));
        selectImage.click();
        return this;
    }

    public LandingPage_Edit enterLinksTo ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(linksTo));
        linksTo.click();
        linksToFocus.clear();
        linksToFocus.sendKeys(string);
        return this;
    }

    public LandingPage_Edit verifyLinksTo ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(linksTo.getAttribute("value"));
            if(!linksTo.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickHTML ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@style, '/js/ontraport/boxes/images/transp.png') and .='" + string + "']/span"))));
        driver.findElement(By.xpath("//div[contains(@style, '/js/ontraport/boxes/images/transp.png') and .='" + string + "']/span")).click();
        return this;
    }

    public LandingPage_Edit verifyForm ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span//link")).isEnabled())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){

            return null;
        }
        
        return this;
    }

    public LandingPage_Edit verifyLandingPageHosted ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                //exception handling
            }
            driver.get(string + ".respond.ontraport.net");
            try {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                //exception handling
            }
            if(!driver.findElement(By.xpath("//body//center//div[contains(concat(' ', normalize-space(@style), ' '),' rgb(127,127,127);')]")).isDisplayed())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){

            return null;
        }
        return this;
    }

    public LandingPage_Edit verifyLandingPageHostedWithForm ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                //exception handling
            }
            driver.get(string + ".respond.ontraport.net");
            try {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                //exception handling
            }
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' moonray-form ')]")).isDisplayed())
            {
                return null;
            }

        }
        catch(NoSuchElementException e){

            return null;
        }
        return this;
    }

    public LandingPage_Edit enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageName));
        landingPageName.click();
        landingPageName.clear();
        landingPageName.sendKeys(string);
        return this;
    }

    public LandingPage_Edit verifyName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(landingPageName.getAttribute("value"));
            if(!landingPageName.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public LandingPage_Edit enterTitle ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageNameTitle));
        landingPageNameTitle.click();
        landingPageNameTitle.clear();
        landingPageNameTitle.sendKeys(string);
        return this;
    }

    public LandingPage_Edit clickPageURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageURL));
        landingPageURL.click();
        return this;
    }

    public LandingPage_Edit clickPageAlignment ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(select));
        select.click();
        return this;
    }

    public LandingPage_Edit selectPageAlignment ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(select.findElement(By.xpath(".//option[@value='" + string + "']"))));
        select.findElement(By.xpath(".//option[@value='" + string + "']")).click();
        Actions action = new Actions(driver);
        action.clickAndHold(select.findElement(By.xpath(".//option[@value='" + string + "']"))).build().perform();
        action.release(select.findElement(By.xpath(".//option[@value='" + string + "']"))).build().perform();
        return this;
    }
    
    public LandingPage_Edit selectPageAlignmentCodeMode ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(codeModePageAlignmentSelect.findElement(By.xpath(".//option[@value='" + string + "']"))));
        codeModePageAlignmentSelect.findElement(By.xpath(".//option[@value='" + string + "']")).click();
        Actions action = new Actions(driver);
        action.clickAndHold(codeModePageAlignmentSelect.findElement(By.xpath(".//option[@value='" + string + "']"))).build().perform();
        action.release(codeModePageAlignmentSelect.findElement(By.xpath(".//option[@value='" + string + "']"))).build().perform();
        return this;
    }

    public LandingPage_Edit verifyPageAlignment ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(select.getAttribute("value"));
            if(!select.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public LandingPage_Edit verifyPageAlignmentCodeMode ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(codeModePageAlignmentSelect.getAttribute("value"));
            if(!codeModePageAlignmentSelect.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public LandingPage_Edit verifyText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        try
        {
        WebElement text = driver.findElement(By.xpath("//body[.='" + string + "']"));
        }
        catch(Exception e)
        {
            driver.switchTo().defaultContent();
            return null;
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public LandingPage_Edit verifyLandingPageURLCodeMode ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = codeModeURL.getText();
            System.out.println(compare);
            System.out.println(value + ".respond.ontraport.net");
            if(compare.equals(value + ".respond.ontraport.net")!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickPageURLCodeMode ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(codeModeURL));
        codeModeURL.click();
        return this;
    }

    public LandingPage_Edit clickBackgroundCodeMode ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(backgroundCodeMode));
        backgroundCodeMode.click();
        return this;
    }

    public LandingPage_Edit clickPageAlignmentCodeMode ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(codeModePageAlignmentSelect));
        codeModePageAlignmentSelect.click();
        return this;
    }

    public LandingPage_Edit clickSplitTestDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(codeModeSplitTestSelect));
        codeModeSplitTestSelect.click();
        return this;
    }

    public LandingPage_Edit selectSplitTestDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(codeModeSplitTestSelect.findElement(By.xpath(".//option[@value='" + string + "']"))));
        codeModeSplitTestSelect.findElement(By.xpath(".//option[@value='" + string + "']")).click();
        Actions action = new Actions(driver);
        action.clickAndHold(codeModeSplitTestSelect.findElement(By.xpath(".//option[@value='" + string + "']"))).build().perform();
        action.release(codeModeSplitTestSelect.findElement(By.xpath(".//option[@value='" + string + "']"))).build().perform();
        return this;
    }

    public LandingPage_Edit verifySplitTestCodeMode ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(codeModeSplitTestSelect.getAttribute("value"));
            if(!codeModeSplitTestSelect.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit ucheckIncludePageSplitTesting ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(splitTestCheckbox));
        splitTestCheckbox.click();
        return this;
    }

    public LandingPage_Edit verifySplitTestUnchecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(codeModeSplitTestSelect.isSelected());
            if(splitTestCheckbox.isSelected())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickFieldDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fieldDropDown));
        fieldDropDown.click();
        return this;
    }

    public LandingPage_Edit selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public LandingPage_Edit clickFormDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(formDropDown));
        formDropDown.click();
        return this;
    }

    public LandingPage_Edit verifySmartForm ()
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        try
        {
        if(!form.isDisplayed())
        {
            driver.switchTo().defaultContent();
            return null;
        }
        }
        catch(Exception e)
        {
            driver.switchTo().defaultContent();
            return null;
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public LandingPage_Edit enterMoreText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);
        body.click();
        body.sendKeys(string);
        ((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<p>" + string + "</p>'");
        driver.switchTo().defaultContent();
        return this;
    }

    public LandingPage_Edit clickSource ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(source));
        source.click();
        return this;
    }

    public LandingPage_Edit enterTextArea ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        textarea.click();
        textarea.clear();
        textarea.sendKeys(string);
        return this;
    }

    public LandingPage_Edit clickForm ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(smartform));
        smartform.click();
        return this;
    }

    public LandingPage_Edit verifyFormSize ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!smartform.findElement(By.xpath(".//label[contains(concat(' ', normalize-space(@style), ' '),' font-size: " + string + "px; ')]")).isDisplayed())
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public LandingPage_Edit clickFormFontSizeDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(formFontSizeDropDown));
        formFontSizeDropDown.click();
        return this;
    }

    public LandingPage_Edit verifyFormColor ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//label[contains(concat(' ', @style, ' '),' rgb" + string + "; ')]")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public LandingPage_Edit verifyRedirectURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(string);
            System.out.println(redirectURL.getAttribute("value"));
            if(!redirectURL.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit highlightText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement text = driver.findElement(By.xpath("//body[.='" + string + "']"));
        text.click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).build().perform();
        for(int i = 0; i<string.length(); i++)
        {
            //needs to be changed randomly from right to left or vice versa
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
        }
        action.keyUp(Keys.SHIFT).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    
}
