package com.ontraport.app.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Message_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//a[@title='Image']")
    private WebElement ckImageButton;
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement dropDownCollection;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-event ')]//button")
    private WebElement eventDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-target-task-form ')]//button")
    private WebElement formDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-target-task-form ')]//input")
    private WebElement formInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-how ')]//button")
    private WebElement howDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-how ')]//input")
    private WebElement howInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-number ')]//button")
    private WebElement numberDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-number ')]//input")
    private WebElement numberInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-event ')]//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement eventDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-event ')]//input")
    private WebElement eventWhenInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-when ')]//input")
    private WebElement taskWhenNotification;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-recipient ')]//input")
    private WebElement recipientDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-send-name ')]//input")
    private WebElement sendOutNameInput;

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
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]/span[contains(text(), 'Send Test Email')]")
    private WebElement sendTestEmail;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]/span[contains(text(), 'Preview')]")
    private WebElement preview;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='gradientBar']/following-sibling::div/center/div[contains(concat(' ', @style, ' '),' cursor: pointer; ')]")
    private List<WebElement> gradientColor;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-reply ')]//input")
    private WebElement replyToEmailInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-mail-from ')]//button")
    private WebElement toggleMailFromPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-subject ')]//input")
    private WebElement subjectInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement mailFromPane;
    
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
            using = "//span[@class='ussr-message-notification']")
    private WebElement notification;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@title='Source']")
    private WebElement source;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' target-send-name ')]")
    private WebElement sendName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' target-reply ')]")
    private WebElement reply;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' target-subject ')]")
    private WebElement subject;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]")
    private WebElement shape;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span")
    private WebElement shapeClick;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]//div[contains(concat(' ', normalize-space(@style), ' '),' left: 128.84px; ')]")
    private WebElement circleShape;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]//div[contains(concat(' ', normalize-space(@style), ' '),' left: 17.1443px; ')]")
    private WebElement circleImage;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]//div[contains(concat(' ', normalize-space(@style), ' '),' left: 5px; ')]")
    private WebElement roundedShape;

    @FindBy(how = How.XPATH,
            using = "//tbody//tr[contains(concat(' ', normalize-space(@class), ' '),' outcome_rules ')]//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]/span/a")
    private WebElement taskOutcomes;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span/span[contains(concat(' ', normalize-space(@style), ' '),' width: 300px; ') or contains(concat(' ', normalize-space(@style), ' '),' height: 200px; ')]")
    private WebElement rectangleGradient;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span/span[contains(concat(' ', normalize-space(@style), ' '),' width: 300px; ')]")
    private WebElement rectangleGradientHorizontal;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]/span/span[contains(concat(' ', normalize-space(@style), ' '),' height: 200px; ')]")
    private WebElement rectangleGradientVertical;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    private WebElement iFrame;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe")
    private WebElement iFrame2;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Bold']")
    private WebElement boldButton;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Circle']")
    private WebElement circle;
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='colorSelector']")
    private WebElement color;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Rectangle']")
    private WebElement rectangle;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Rounded']")
    private WebElement rounded;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Right']")
    private WebElement alignRight;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Left']")
    private WebElement alignLeft;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Center']")
    private WebElement alignCenter;
    
    @FindBy(how = How.XPATH,
            using = "//a[@title='Center']")
    private WebElement alignCenterEmail;
    
    @FindBy(how = How.XPATH,
            using = "//a[@title='Link']")
    private WebElement linkText;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Italic']")
    private WebElement italic;
    
    @FindBy(how = How.XPATH,
            using = "//img[@title='Underline']")
    private WebElement underline;
    
    @FindBy(how = How.XPATH,
            using = "//center[text()='Line Spacing']/following-sibling::div/img")
    private WebElement lineSpacing;
    
    @FindBy(how = How.XPATH,
            using = "//center[text()='Letter Spacing']/following-sibling::div/img")
    private WebElement letterSpacing;
    
    @FindBy(how = How.XPATH,
            using = "//center[text()='Opacity']/following-sibling::div/img")
    private WebElement opacity;
    
    @FindBy(how = How.XPATH,
            using = "//textarea[contains(concat(' ', normalize-space(@title), ' '),' Rich Text Editor,')]")
    private WebElement sourceText;
    
    @FindBy(how = How.XPATH,
            using = "//textarea[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]")
    private WebElement textArea;
    
    @FindBy(how = How.XPATH,
            using = "//textarea")
    private WebElement textArea2;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//p//img")
    private WebElement mailImage;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;
    
    public Message_Edit enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }
    
    public Message_Edit verifySendName (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(sendName.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = sendName.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public Message_Edit verifyReplyTo (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(reply.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = reply.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public Message_Edit verifySubject (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(subject.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = subject.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Message_Edit verifyBody (String stuff)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("/html//body[normalize-space(.)='" + stuff + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit verifyOutcome ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
            try
            {
                System.out.println(taskOutcomes.getText());
                String compare = taskOutcomes.getText();
                if(compare.equals(name)!=true)
                {
                    return null;
                }
            }
            catch(NoSuchElementException e){
                return null;
            }
            
            return this;
    }
    
    public Message_Edit enterSendOutName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        sendOutNameInput.sendKeys(name);
        return this;
        
    }

    public Message_Edit enterReplyToEmail ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        replyToEmailInput.sendKeys(name);
        return this;
        
    }

    public Message_Edit openMailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        toggleMailFromPane.click();
        return this;
        
    }

    public Message_Edit selectMailFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        selectionOptions.get(i-1).click();
        return this;
        
    }

    public Message_Edit enterSubject ( String subject )
    {
        AbstractPart.waitForAjax(driver, 20);
        subjectInput.sendKeys(subject);
        return this;
        
    }
    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
    
    public Contact_ListAll clickSave2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }

    public Message_Edit verifyTextArea ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(textArea2.getAttribute("value"));
            String compare = textArea2.getAttribute("value");
            if(compare.equals(name)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Message_Edit clickSendTestEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        sendTestEmail.click();
        return this;
        
    }

    public Message_Edit verifyEmailSent ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!notification.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Message_Edit verifyShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!shapeClick.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public Message_Edit verifyRectangle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!shape.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Message_Edit verifyTextSize ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//font[@size='" + string + "PX']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit doubleClickText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        WebElement text = driver.findElement(By.xpath("//div[contains(concat(' ', @style, ' '),' font-family: Verdana,Geneva,sans-serif; ') and .='" + string + "']"));
        Actions action = new Actions(driver);
        action.doubleClick(text).build().perform();
        return this;
    }

    public Message_Edit highlightText ( String string ) 
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame2);
        WebElement text = driver.findElement(By.xpath("//body[.='" + string + "']"));
        text.click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).build().perform();
        for(int i = 0; i<string.length(); i++)
        {
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
        }
        action.keyUp(Keys.SHIFT).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit clickBold ()
    {
        AbstractPart.waitForAjax(driver, 20);
        boldButton.click();
        return this;
    }

    public Message_Edit verifyBold (String string)
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

    public Message_Edit clickItalic ()
    {
        AbstractPart.waitForAjax(driver, 20);
        italic.click();
        return this;
    }

    public Message_Edit verifyItalic ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//i[.='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickUnderline ()
    {
        AbstractPart.waitForAjax(driver, 20);
        underline.click();
        return this;
    }

    public Message_Edit verifyUnderlined ( String string )
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

    public Message_Edit clickAlignCenter ()
    {
        AbstractPart.waitForAjax(driver, 20);
        alignCenter.click();
        return this;
        
    }

    public Message_Edit verifyAlignedCenter ( String string )
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

    public Message_Edit clickAlignLeft ()
    {
        AbstractPart.waitForAjax(driver, 20);
        alignLeft.click();
        return this;
    }

    public Message_Edit verifyAlignedLeft ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//div[@align='left' and .='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit highlightTextRight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame2);
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

    public Message_Edit clickAlignRight ()
    {
        AbstractPart.waitForAjax(driver, 20);
        alignRight.click();
        return this;
    }

    public Message_Edit verifyAlignedRight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//div[@align='right' and .='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickMoveLineSpacer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.dragAndDropBy(lineSpacing, i, 0).build().perform();

        return this;
        
    }

    public Message_Edit verifyLineSpacing ( double i, String string )
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
    
    public Message_Edit selectDropDownOption ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", dropDownCollection.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + option + "')]")));
        dropDownCollection.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return this;
        
    }

    public Message_Edit clickMoveLetterSpacer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.dragAndDropBy(letterSpacing, i, 0).build().perform();

        return this;
    }
    
    public Message_Edit clickWhenDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(eventDropDown));
        eventDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(eventDropDownPane));
        return this;
        
    }

    public Message_Edit verifyLetterSpacing ( double d, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' letter-spacing: " + d +"px; ') and .='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        shapeClick.click();
        return this;
    }

    public Message_Edit clickCircle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        circle.click();
        return this;
    }

    public Message_Edit verifyCircle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!circleShape.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    public Message_Edit verifyCircleImage ()
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

    public Message_Edit clickRounded ()
    {
        AbstractPart.waitForAjax(driver, 20);
        rounded.click();
        return this;
    }

    public Message_Edit verifyRounded ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!roundedShape.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    
    public Message_Edit clickRectangle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        rectangle.click();
        return this;
    }

    public Message_Edit clickColor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        color.click();
        return this;
    }

    public Message_Edit verifyColor ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
           driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' rgb" + string + "; ') or div[contains(concat(' ', @style, ' '),' rgb" + string + "; ')]]")).isDisplayed();
        }
        catch(NoSuchElementException e)
        {
        }
        return this;
    }

    public Message_Edit clickMoveOpacity ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.dragAndDropBy(opacity, -i, 0).build().perform();
        return this;
    }

    public Message_Edit verifyOpacity ( double i )
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

    public Message_Edit verifyGradientRectangle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!rectangleGradient.isDisplayed())
            {

                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickGradient1 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(0)).build().perform();
        return this;
    }

    public Message_Edit clickGradient2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(1)).build().perform();
        return this;
    }

    public Message_Edit clickVertical ()
    {
        AbstractPart.waitForAjax(driver, 20);
        verticalButton.click();
        return this;
    }

    public Message_Edit clickHorizontal ()
    {
        AbstractPart.waitForAjax(driver, 20);
        horizontalButton.click();
        return this;
    }

    public Message_Edit verifyVertical ()
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

    public Message_Edit verifyHorizontal ()
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

    public Message_Edit verifyImageRectangle ( String string )
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
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', normalize-space(@style), ' '),'" + string +"')]/div")).isDisplayed())
            {
                return this;
            }
        }
        catch(NoSuchElementException e){
            return this;
        }
        return null;
    }

    public Message_Edit clickImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        image.click();
        return this;
    }

    public Message_Edit clickSelectImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        selectImage.click();
        return this;
    }

    public Message_Edit verifyOwner ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!recipientDropDownInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){

            return null;
        }
        return this;
    }

    public Message_Edit verifyWhenDays ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!taskWhenNotification.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifyWhen ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!eventWhenInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickHowDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        howDropDown.click();
        return this;
    }

    public Message_Edit clickNumberDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        numberDropDown.click();
        return this;
    }

    public Message_Edit verifyHow ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!howInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifyNumber ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!numberInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickTaskFormDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        formDropDown.click();
        return this;
    }

    public Message_Edit verifyForm ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(formInput.getAttribute("value"));
            if(!formInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit clickCKEditorImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ckImageButton.click();
        return this;
    }

    public Message_Edit clickMailImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.switchTo().frame(iFrame2);
        mailImage.click();
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit typeDelete ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.BACK_SPACE).build().perform();
        return this;
    }
    public Message_Edit verifyCentered (String stuff)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("//p[contains(concat(' ', @style, ' '),' text-align: center; ') and .='" + stuff + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickAlignCenterEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        alignCenterEmail.click();
        return this;
    }

    public Message_Edit clickText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame2);
        WebElement text = driver.findElement(By.xpath("//body[.='" + string + "']"));
        text.click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).build().perform();
        action.sendKeys(Keys.ARROW_LEFT).build().perform();
        action.sendKeys(Keys.ARROW_RIGHT).build().perform();
        action.keyUp(Keys.SHIFT).build().perform();
        driver.switchTo().defaultContent();
        return this;
        
    }

    public Message_Edit clickLinkText ()
    {
        AbstractPart.waitForAjax(driver, 20);
        linkText.click();
        return this;
    }

    public Message_Edit verifyLinkText ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame2);
            WebElement link = driver.findElement(By.xpath("//a[text()='" + string + "']"));
            System.out.println(link.getAttribute("href"));
            if(!link.getAttribute("href").contains(string2))
            {
                driver.switchTo().defaultContent();
                return null;
            }
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit clickSource ()
    {
        AbstractPart.waitForAjax(driver, 20);
        source.click();
        return this;
    }

    public Message_Edit verifySource ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!sourceText.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit enterTextArea ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        sourceText.sendKeys(string);
        return this;
    }

    public Message_Edit verifyUnderlinedIframe ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame2);
            driver.findElement(By.xpath("//u[.='" + string + "']"));
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit clickPreview ()
    {
        AbstractPart.waitForAjax(driver, 20);
        preview.click();
        return this;
    }

    public Message_Edit verifyPreview ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        if(!allWindows.isEmpty())
        {
            for ( String windowId : allWindows)
            {
                try
                {
                    if(driver.switchTo().window(windowId).getTitle().contains("Preview"))
                    {
                        break;
                    }
                }
                catch(NoSuchWindowException e)
                {
                    e.printStackTrace();
                }
            }
        }
        try
        {
            System.out.println(driver.getCurrentUrl());
            if(!driver.getCurrentUrl().equals(AbstractPage.getUrl() + "js/ckeditor/lib/plugins/preview/preview.html"))
            {
                driver.switchTo().window(parentWindow);
                return null; 
            }
            String compare = driver.findElement(By.xpath("//p")).getText();
            System.out.println(compare);
            if(!compare.equals(string))
            {
                driver.switchTo().window(parentWindow);
                return null; 
            }

        }
        catch(NoSuchElementException e){
            driver.switchTo().window(parentWindow);
            return null;
        }
        driver.close();
        driver.switchTo().window(parentWindow);
        return this;
    }

    public Message_Edit verifySourceText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(sourceText.getAttribute("value"));
            if(!sourceText.getAttribute("value").contains(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifyBoldIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("//b[.='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

}
