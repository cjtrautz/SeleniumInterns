package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class LandingPage_Edit extends AbstractPage
{ 
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
            using = "//td[contains(text(), 'Links To:')]/following-sibling::td/input")
    private WebElement linksTo;
    
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
            using = "//img[@title='Rounded']")
    private WebElement rounded;
    
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]//input[@type='TEXT']")
    private WebElement landingPageNameTitle;
    
    @FindBy(how = How.XPATH,
            using = "//td[@id='Menu_Bar']/div/div/table/tbody/tr[3]/td/div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]/table/tbody/tr/td[2]")
    private WebElement landingPageURL;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span")
    private WebElement box;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span/div")
    private WebElement notRectangleBox;
    
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
            using = "//td[contains(text(), 'Page Size:')]/following-sibling::td/div[contains(concat(' ', normalize-space(@style), ' '),' cursor: pointer; ')]")
    private WebElement pageSize;

    public LandingPage_Edit verifyLandingPageTitle ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = landingPageNameTitle.getAttribute("value");
            System.out.println(compare);
            if(compare.equals(value)!=true)
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

    public LandingPage_Edit verifyLandingPageURL ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = landingPageURL.getText();
            System.out.println(compare);
            if(compare.equals("http://" + value + ".respond.ontraport.net")!=true)
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

    public LandingPage_Edit verifyLandingPageShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(box.isDisplayed()!=true)
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
    
    public LandingPage_Edit verifyLandingPageRectangleShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(notRectangleBox.isDisplayed()!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return this;
            }
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

    public LandingPage_Edit clickBackground ()
    {
        AbstractPart.waitForAjax(driver, 20);
        background.click();
        return this;
    }

    public LandingPage_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }

    public LandingPage_Edit verifyBackground ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(driver.findElement(By.xpath("//center[@class='box_canvas']//div[contains(concat(' ', normalize-space(@style), ' '),' rgb" + string +"; ')]")).isDisplayed()!=true)
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

    public LandingPage_Edit clickPageSize ()
    {
        AbstractPart.waitForAjax(driver, 20);
        pageSize.click();
        return this;
    }

    public LandingPage_Edit verifyPageSize ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(driver.findElement(By.xpath("//center[@class='box_canvas']//div[contains(concat(' ', normalize-space(@style), ' '),' width: " + string +"px; height: " + string2 +"px; ')]")).isDisplayed()!=true)
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

    public LandingPage_Edit clickNewSplitTestingVersion ()
    {
        AbstractPart.waitForAjax(driver, 20);
        newVersion.click();
        return this;
    }

    public LandingPage_Edit verifyVersionBPresent ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(versionB.isDisplayed()!=true)
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

    public LandingPage_Edit clickDeleteSplitTestingVersionB ()
    {
        AbstractPart.waitForAjax(driver, 20);
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

    public LandingPage_Edit verifyLandingPageText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = textBody.getText();
            System.out.println(compare);
            if(compare.equals(string)!=true)
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

    public LandingPage_Edit doubleClickText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement text = driver.findElement(By.xpath("//div[contains(concat(' ', @style, ' '),' font-family: Verdana,Geneva,sans-serif; ') and .='" + string + "']"));
        Actions action = new Actions(driver);
        action.doubleClick(text).build().perform();
        return this;
    }
    
    public LandingPage_Edit singleClickText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement text = driver.findElement(By.xpath("//div[contains(concat(' ', @style, ' '),' font-family: Verdana,Geneva,sans-serif; ') and .='" + string + "']"));
        text.click();
        return this;
    }

    public LandingPage_Edit highlightTextRight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
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
        fontDropDown.click();
        return this;
    }

    public LandingPage_Edit selectFontDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement click = driver.findElement(By.xpath("//td[@id='property_cell']//tbody//select/option[text()='" + string + "']"));
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
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(driver.findElement(By.xpath("//font[contains(@face, '" + string2 + "') and .='" + string + "']")).isDisplayed()!=true)
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

    public LandingPage_Edit clickFontSizeDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        fontSizeDropDown.click();
        return this;
    }

    public LandingPage_Edit verifyFontSize ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(driver.findElement(By.xpath("//font[contains(@size, '" + string2 + "') and .='" + string + "']")).isDisplayed()!=true)
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

    public LandingPage_Edit clickBold ()
    {
        AbstractPart.waitForAjax(driver, 20);
        bold.click();
        return this;
    }

    public LandingPage_Edit verifyBold (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//b[.='" + string + "']"));
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
    public LandingPage_Edit clickItalic ()
    {
        AbstractPart.waitForAjax(driver, 20);
        italic.click();
        return this;
    }

    public LandingPage_Edit verifyItalic ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//i[.='" + string + "']"));
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

    public LandingPage_Edit clickUnderline ()
    {
        AbstractPart.waitForAjax(driver, 20);
        underline.click();
        return this;
    }

    public LandingPage_Edit verifyUnderlined ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");    com.ontraport.app.tests.EditLandingPageSplitTesting.class,
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//u[.='" + string + "']"));
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

    public LandingPage_Edit clickCenter ()
    {
        AbstractPart.waitForAjax(driver, 20);
        center.click();
        return this;
    }

    public LandingPage_Edit verifyCenter ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//div[@align='center' and .='" + string + "']"));
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

    public LandingPage_Edit clickLeftAlign ()
    {
        AbstractPart.waitForAjax(driver, 20);
        leftAlign.click();
        return this;
    }

    public LandingPage_Edit verifyLeftAlign ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//div[@align='left' and .='" + string + "']"));
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

    public LandingPage_Edit clickRightAlign ()
    {
        AbstractPart.waitForAjax(driver, 20);
        rightAlign.click();
        return this; 
    }

    public LandingPage_Edit verifyRightAlign ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//div[@align='right' and .='" + string + "']"));
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
    
    public LandingPage_Edit clickMoveLetterSpacer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.dragAndDropBy(letterSpacing, i, 0).build().perform();

        return this;
    }
    
    public LandingPage_Edit verifyLetterSpacing ( double i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' letter-spacing: " + i +"px; ') and .='" + string + "']"));
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
    
    public LandingPage_Edit clickMoveLineSpacer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.dragAndDropBy(lineSpacing, i, 0).build().perform();

        return this;
        
    }

    public LandingPage_Edit verifyLineSpacing ( double i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' line-height: " + i +"; ') and .='" + string + "']"));
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

    public LandingPage_Edit enterLeft ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
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
        left.click();
        return this;
    }

    public LandingPage_Edit verifyLeft ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' left: " + i +"px; ')]"));
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

    public LandingPage_Edit enterTop ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
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
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' top: " + i +"px; ')]"));
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

    public LandingPage_Edit enterWidth ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
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

    public LandingPage_Edit enterWidth ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' width: " + i +"px; ')]"));
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

    public LandingPage_Edit enterHeight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
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
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' height: " + i +"px; ')]"));
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

    public LandingPage_Edit clickCircle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        circle.click();
        return this;
    }
    
    public LandingPage_Edit verifyCircle ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            if(!circleBox.isDisplayed())
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
    
    public LandingPage_Edit verifyCircleImage ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            if(!circleImage.isDisplayed())
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

    public LandingPage_Edit clickShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        box.click();
        return this;
    }

    public LandingPage_Edit clickRounded ()
    {
        AbstractPart.waitForAjax(driver, 20);
        rounded.click();
        return this;
    }
    
    public LandingPage_Edit clickGradient1 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(0)).build().perform();
        return this;
    }

    public LandingPage_Edit clickGradient2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(1)).build().perform();
        return this;
    }

    public LandingPage_Edit verifyRounded ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            if(!roundedBox.isDisplayed())
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
    
    public LandingPage_Edit verifyRoundedImage ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            if(!roundedImage.isDisplayed())
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
    
    public LandingPage_Edit clickColor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        color.click();
        return this;
    }

    public LandingPage_Edit verifyColor ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' rgb" + string + "; ') or div[contains(concat(' ', @style, ' '),' rgb" + string + "; ')]]")).isDisplayed())
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
    public LandingPage_Edit clickMoveOpacity ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.dragAndDropBy(opacity, -i, 0).build().perform();
        return this;
    }

    public LandingPage_Edit verifyOpacity ( double i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span[contains(concat(' ', normalize-space(@style), ' '),' opacity: " + i +"; ')]")).isDisplayed())
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

    public LandingPage_Edit verifyLandingPageSquareGradient ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!squareGradient.isDisplayed())
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
    public LandingPage_Edit clickVertical ()
    {
        AbstractPart.waitForAjax(driver, 20);
        verticalButton.click();
        return this;
    }

    public LandingPage_Edit clickHorizontal ()
    {
        AbstractPart.waitForAjax(driver, 20);
        horizontalButton.click();
        return this;
    }

    public LandingPage_Edit verifyVertical ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!rectangleGradientVertical.isDisplayed())
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

    public LandingPage_Edit verifyHorizontal ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!rectangleGradientHorizontal.isDisplayed())
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
    public LandingPage_Edit verifyImageRectangle ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]")).isDisplayed())
            {
                System.out.println("1");
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
            System.out.println("2");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(driver.findElements(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]/div")).size()==0)
            {
                System.out.println("3");
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return this;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            System.out.println("4");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        System.out.println("5");
        return null;
    }
    public LandingPage_Edit verifyImage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"') or div[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]]")).isDisplayed())
            {
                System.out.println("1");
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
            System.out.println("2");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    
    public LandingPage_Edit clickImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        image.click();
        return this;
    }

    public LandingPage_Edit clickSelectImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        selectImage.click();
        return this;
    }

    public LandingPage_Edit enterLinksTo ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        linksTo.click();
        linksTo.clear();
        linksTo.sendKeys(string);
        return this;
    }

    public LandingPage_Edit verifyLinksTo ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(linksTo.getAttribute("value"));
            if(!linksTo.getAttribute("value").equals(string))
            {
                System.out.println("1");
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
            System.out.println("2");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickHTML ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//div[contains(@style, '/js/ontraport/boxes/images/transp.png') and .='" + string + "']/span")).click();
        return this;
    }

    public LandingPage_Edit verifyForm ( )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!driver.findElement(By.xpath("//div[contains(@style, '/js/ontraport/boxes/images/transp.png')]/span//link")).isEnabled())
            {
                System.out.println("1");
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
            System.out.println("2");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    
}
