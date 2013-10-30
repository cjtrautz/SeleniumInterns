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
import org.openqa.selenium.support.ui.ExpectedConditions;

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
            using = "//td[contains(text(), 'Page Size:')]/following-sibling::td/div[contains(concat(' ', normalize-space(@style), ' '),' cursor: pointer; ')]")
    private WebElement pageSize;

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
            if(notRectangleBox.size()==0)
            {
                return this;
            }

        }
        catch(NoSuchElementException e){

            return this;
        }
        
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
            if(versionB.isDisplayed()!=true)
            {
                return this;
            }

        }
        catch(NoSuchElementException e){
            return this;
        }
        
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
        wait.until(ExpectedConditions.visibilityOf(fontDropDown));
        fontDropDown.click();
        return this;
    }

    public LandingPage_Edit selectFontDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement click = driver.findElement(By.xpath("//td[@id='property_cell']//tbody//select/option[text()='" + string + "']"));
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

    public LandingPage_Edit enterWidth ( int i )
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

    
}
