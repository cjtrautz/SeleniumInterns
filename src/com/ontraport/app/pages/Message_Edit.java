package com.ontraport.app.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-form_control_drill_down_select_field_selector_merge_field_inserter ')]//button")
    private WebElement toggleMergeFieldPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_date ')]//input")
    private WebElement taskDueDate;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_name ')]//input")
    private WebElement taskSubject;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement taskNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//th[contains(concat(' ', @class, ' '),' ussr-component-collection-cell-type-text ') and @data-header='name']/a")
    private WebElement nameColumn;
    
    @FindBy(
            how = How.XPATH,
            using = "//center[contains(concat(' ', @class, ' '),' box_canvas ')]//div[contains(concat(' ', @style, ' '),' font-family: ')]")
    private WebElement postcardTextArea;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[contains(text(),'Cancel')]")
    private WebElement cancel;
    
    @FindBy(
            how = How.XPATH,
            using = "//textarea[contains(concat(' ', @class, ' '),' cke_source ')]")
    private WebElement textareaSource;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-plaintext-merge ')]//button")
    private WebElement mergeDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_date ')]//input")
    private WebElement dueDateInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_owner ')]//input")
    private WebElement taskOwnerInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_name ')]//input")
    private WebElement subjectTaskInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-who ')]//input")
    private WebElement whoInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='layer_box']//div[@class='side_prop_label']")
    private WebElement newItem;
    
    @FindBy(
            how = How.XPATH,
            using = "//td[@id='property_cell']//input")
    private List<WebElement> shapeInputs;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='layer_box']//div[@class='item_label']")
    private WebElement firstItem;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='layer_box']//div[@class='item_label']//input")
    private List<WebElement> layersInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[td[img[@src='/js/ontraport/boxes/images/create_text.jpg']]]/following-sibling::tr//img[@src='/js/ontraport/boxes/images/trash.png']")
    private WebElement deleteTextLayer;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[td[img[@src='/js/ontraport/boxes/images/create_text.jpg']]]/following-sibling::tr//img[@src='/js/ontraport/boxes/images/copy.png']")
    private WebElement copyTextLayer;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[td[img[@src='/js/ontraport/boxes/images/create_text.jpg']]]/following-sibling::tr//img[@src='/js/ontraport/boxes/images/visible.png']")
    private WebElement visible;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[td[img[@src='/js/ontraport/boxes/images/create_text.jpg']]]/following-sibling::tr//img[@src='/js/ontraport/boxes/images/invisible.png']")
    private WebElement invisible;
    
    @FindBy(
            how = How.XPATH,
            using = "//tr[td[img[@src='/js/ontraport/boxes/images/create_text.jpg']]]//img[@src='/js/ontraport/boxes/images/layer_move.png']")
    private WebElement moveLayer;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='Menu_Bar']//td[normalize-space(text())='Back']")
    private WebElement backView;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@title='Image']")
    private WebElement ckImageButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe[@class='cke_panel_frame']")
    private WebElement iframePanel;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='cke_panel_list']/li/a/h2")
    private WebElement firstStyle;
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement dropDownCollection;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement name;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-event ')]//button")
    private WebElement eventDropDown;
    
    
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-location-editor-plaintext-editor ')]//textarea")
    private WebElement plainTextArea;
    
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
            how = How.CSS,
            using = "body")
    private WebElement body;
    
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
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__preview ')]")
    private WebElement preview2;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__maximize ')]")
    private WebElement maximize;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__specialchar ')]")
    private WebElement specialCharacter;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_combo_button ')]")
    private WebElement stylesDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__pastetext ')]")
    private WebElement pasteText;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__justifyblock ')]")
    private WebElement justify;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__unlink ')]")
    private WebElement unlink;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__undo ')]")
    private WebElement undo;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__redo ')]")
    private WebElement redo;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__bold ')]")
    private WebElement bold;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__italic ')]")
    private WebElement italicize;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__strike ')]")
    private WebElement strikeThrough;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__numberedlist ')]")
    private WebElement orderedList;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__bulletedlist ')]")
    private WebElement unOrderedList;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__blockquote ')]")
    private WebElement quote;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__justifyright ')]")
    private WebElement rightAlign;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__table ')]")
    private WebElement table;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__horizontalrule ')]")
    private WebElement horizontalLine;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__justifyleft ')]")
    private WebElement leftAlign;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__removeformat ')]")
    private WebElement removeFormatting;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__paste ')]")
    private WebElement paste;
    
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
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),' font-family: Verdana,Geneva,sans-serif; ')]")
    private List<WebElement> textAreaPostcard;
    
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
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'object_selector_NAME_send_from')]//button")
    private WebElement sendFromDropDown;
    
    public Message_Edit enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.clear();
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
    
    public Message_Edit verifyBodyContains (String stuff)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("/html//body[contains(normalize-space(.), '" + stuff + "')]"));
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
        wait.until(ExpectedConditions.visibilityOf(nameColumn));  
        nameColumn.click();
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskOutcomes));  
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
        wait.until(ExpectedConditions.visibilityOf(sendOutNameInput));  
        sendOutNameInput.click();
        sendOutNameInput.clear();
        sendOutNameInput.sendKeys(name);
        return this;
        
    }

    public Message_Edit enterReplyToEmail ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(replyToEmailInput));  
        replyToEmailInput.click();
        replyToEmailInput.clear();
        replyToEmailInput.sendKeys(name);
        return this;
        
    }

    public Message_Edit openMailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMailFromPane)); 
        toggleMailFromPane.click();
        return this;
        
    }

    public Message_Edit selectMailFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        wait.until(ExpectedConditions.visibilityOf(selectionOptions.get(i-1))); 
        selectionOptions.get(i-1).click();
        return this;
        
    }

    public Message_Edit enterSubject ( String subject )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(subjectInput)); 
        subjectInput.click();
        subjectInput.clear();
        subjectInput.sendKeys(subject);
        return this;
        
    }
    
    public Message_Edit enterMessageBodySource ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textareaSource));
        textareaSource.click();
        textareaSource.clear();
        textareaSource.sendKeys(string);
        return this;
    }
    
    public Message_ListAll clickSave ()
    {
        driver.switchTo().defaultContent();
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
    
    public Contact_ListAll clickSave2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save)); 
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
        wait.until(ExpectedConditions.visibilityOf(sendTestEmail)); 
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
        wait.until(ExpectedConditions.visibilityOf(text)); 
        Actions action = new Actions(driver);
        action.doubleClick(text).build().perform();
        return this;
    }

    public Message_Edit highlightText ( String string ) 
    {
        //this works by clicking the text and highlighting by holding shift 
        //and hitting the arrow key as many times as the length of the string
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.tagName("iframe"));
        wait.until(ExpectedConditions.visibilityOf(iFrame2)); 
        driver.switchTo().frame(iFrame2);
        WebElement text = driver.findElement(By.xpath("//body[.='" + string + "']"));
        text.click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).build().perform();
        for(int i = 0; i<string.length(); i++)
        {
            //sometimes changes to Arrow_left
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
        }
        action.keyUp(Keys.SHIFT).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit clickBold ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(boldButton)); 
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
        wait.until(ExpectedConditions.visibilityOf(italic)); 
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
        wait.until(ExpectedConditions.visibilityOf(underline)); 
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
        wait.until(ExpectedConditions.visibilityOf(alignCenter)); 
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
        wait.until(ExpectedConditions.visibilityOf(alignLeft)); 
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
        wait.until(ExpectedConditions.visibilityOf(iFrame2)); 
        driver.switchTo().frame(iFrame2);
        WebElement text = driver.findElement(By.xpath("//body[contains(., '" + string + "')]"));
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
        wait.until(ExpectedConditions.visibilityOf(alignRight)); 
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
        wait.until(ExpectedConditions.visibilityOf(lineSpacing)); 
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
        wait.until(ExpectedConditions.visibilityOf(letterSpacing)); 
        action.dragAndDropBy(letterSpacing, i, 0).build().perform();

        return this;
    }
    
    public Message_Edit clickWhenDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(eventDropDown));
        eventDropDown.click();
        //wait.until(ExpectedConditions.visibilityOf(eventDropDownPane));
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
        wait.until(ExpectedConditions.visibilityOf(shapeClick)); 
        shapeClick.click();
        return this;
    }

    public Message_Edit clickCircle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(circle)); 
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
        wait.until(ExpectedConditions.visibilityOf(rounded)); 
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
        wait.until(ExpectedConditions.visibilityOf(rectangle)); 
        rectangle.click();
        return this;
    }

    public Message_Edit clickColor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(color)); 
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
        wait.until(ExpectedConditions.visibilityOf(opacity)); 
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
        wait.until(ExpectedConditions.visibilityOf(gradientColor.get(0))); 
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(0)).build().perform();
        return this;
    }

    public Message_Edit clickGradient2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gradientColor.get(1))); 
        Actions action = new Actions(driver);
        action.doubleClick(gradientColor.get(1)).build().perform();
        return this;
    }

    public Message_Edit clickVertical ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(verticalButton)); 
        verticalButton.click();
        return this;
    }

    public Message_Edit clickHorizontal ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(horizontalButton));
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
        wait.until(ExpectedConditions.visibilityOf(image));
        image.click();
        return this;
    }

    public Message_Edit clickSelectImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectImage));
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
        wait.until(ExpectedConditions.visibilityOf(howDropDown));
        howDropDown.click();
        return this;
    }

    public Message_Edit clickNumberDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(numberDropDown));
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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", formDropDown);
        wait.until(ExpectedConditions.visibilityOf(formDropDown));
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
        wait.until(ExpectedConditions.visibilityOf(ckImageButton));
        ckImageButton.click();
        return this;
    }

    public Message_Edit clickMailImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame2));
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
        wait.until(ExpectedConditions.visibilityOf(alignCenterEmail));
        alignCenterEmail.click();
        return this;
    }

    public Message_Edit clickText ( String string )
    {
        //this highlights the message's text by clicking and holding shift while u
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.tagName("iframe"));
        wait.until(ExpectedConditions.visibilityOf(iFrame2));
        driver.switchTo().frame(iFrame2);
        WebElement text = driver.findElement(By.xpath("//body[contains(., '" + string + "')]"));
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
        wait.until(ExpectedConditions.visibilityOf(linkText));
        linkText.click();
        return this;
    }

    public Message_Edit verifyLinkText ( String string, String string2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame2);
            WebElement link = driver.findElement(By.xpath("//a[.='" + string + "']"));
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
    
    public Message_Edit verifyUnLinkText ( String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.switchTo().frame(iFrame2);
            WebElement link = driver.findElement(By.xpath("//a[contains(text(), '" + string + "')]"));
            System.out.println(link.getAttribute("href"));
            if(link.getAttribute("href")==null)
            {
                driver.switchTo().defaultContent();
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return this;
            }
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        driver.switchTo().defaultContent();
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return null;
    }

    public Message_Edit clickSource ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(source));
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
        wait.until(ExpectedConditions.visibilityOf(sourceText));
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
        wait.until(ExpectedConditions.visibilityOf(preview));
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

    public Message_Edit clickCKEditorPreview ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(preview2));
        preview2.click();
        return this;
    }

    public Message_Edit clickPaste ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(paste));
        paste.click();
        return this;
    }

    public Message_Edit clickPlainPaste ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(pasteText));
        pasteText.click();
        return this;
    }
    public Message_Edit enterMessageBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);
        body.click();
        body.clear();
        body.sendKeys(string);
        ((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<p>" + string + "</p>'");
        driver.switchTo().defaultContent();
        return this;
        
    }

    public Message_Edit clickUndo ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(undo));
        undo.click();
        return this;
    }

    public Message_Edit clickRedo ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(redo));
        redo.click();
        return this;
    }

    public Message_Edit clickBoldEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(bold));
        bold.click();
        return this;
    }

    public Message_Edit verifyBoldButtonIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("//strong[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickItalicizeEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(italicize));
        italicize.click();
        return this;
    }

    public Message_Edit verifyItalicizeIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("//em[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickRemoveFormating ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(removeFormatting));
        removeFormatting.click();
        return this;
    }

    public Message_Edit verifyNoFormatIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("//p[contains(text(), '" + string + "')]"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickStrikeThroughEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(strikeThrough));
        strikeThrough.click();
        return this;
    }

    public Message_Edit verifyStrikeThroughIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//s[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickOrderedList ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(orderedList));
        orderedList.click();
        return this;
    }

    public Message_Edit verifyOrderedListIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//ol[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickUnOrderedList ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(unOrderedList));
        unOrderedList.click();
        return this;
    }

    public Message_Edit verifyUnOrderedListIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//ul[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickQuote ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(quote));
        quote.click();
        return this;
    }

    public Message_Edit verifyQuoteIFrame ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//blockquote[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickAlignRightEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(rightAlign));
        rightAlign.click();
        return this;
    }

    public Message_Edit verifyRightAligned ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//p[normalize-space(.)='" + string + "' and @style='text-align: right;']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickAlignLeftEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leftAlign));
        leftAlign.click();
        return this;
    }

    public Message_Edit verifyLeftAligned ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//p[normalize-space(.)='" + string + "']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here2");
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//p[@style]"));
            driver.switchTo().defaultContent();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        
        return null;
    }

    public Message_Edit clickAlignJustifyEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(justify));
        justify.click();
        return this;
    }

    public Message_Edit verifyJustifiedAligned ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//p[normalize-space(.)='" + string + "' and @style='text-align: justify;']"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickUnLinkText ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(unlink));
        unlink.click();
        return this;
    }

    public Message_Edit clickTable ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(table));
        table.click();
        return this;
    }

    public Message_Edit verifyTable ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//table/tbody"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickHorizontalLine ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(horizontalLine));
        horizontalLine.click();
        return this;
    }

    public Message_Edit verifyLine ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//hr"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickInsertSpecialCharacter ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(specialCharacter));
        specialCharacter.click();
        return this;
    }

    public Message_Edit verifySpecialCharacterAlmostEqual ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//body[contains(., '≈')]"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickStylesDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(stylesDropDown));
        stylesDropDown.click();
        return this;
    }

    public Message_Edit clickFirstStyle (String window)
    {
        AbstractPart.waitForAjax(driver, 20);  
        wait.until(ExpectedConditions.visibilityOf(iframePanel));
        driver.switchTo().frame(iframePanel);
        wait.until(ExpectedConditions.visibilityOf(firstStyle));
        firstStyle.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB);
        driver.switchTo().window(window);
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit verifyStyle ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.switchTo().frame(iFrame);
            System.out.println("here");
            driver.findElement(By.xpath("//body[normalize-space(.)='" + string + "']/h2[@style]"));
            driver.switchTo().defaultContent();
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        
        
        return this;
    }

    public Message_Edit clickMaximize ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(maximize));
        maximize.click();
        return this;
    }

    public Message_Edit verifyMaximize ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            driver.findElement(By.xpath("//body[contains(concat(' ', normalize-space(@style), ' '),' z-index: 9995; ')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        
        return this;
    }

    public Message_Edit verifyPlainTextBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(plainTextArea.getAttribute("value"));
            if(!plainTextArea.getAttribute("value").contains(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    
    public Message_Edit clickNewItem ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newItem));  
        newItem.click();
        return this;
    }

    public Message_Edit doubleClickInsertText (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textAreaPostcard.get(i-1)));  
        Actions action = new Actions(driver);
        action.doubleClick(textAreaPostcard.get(i-1)).build().perform();
        return this;
        
    }

    public Message_Edit enterText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame2));  
        driver.switchTo().frame(iFrame2);
        Actions action = new Actions(driver);
        action.sendKeys(string).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit clickBackView ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(backView));  
        backView.click();
        return this;
    }

    public Message_Edit verifyBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//center[@class='box_canvas']//div[contains(normalize-space(text()),'Reserved for Address')]")).isDisplayed())
            {
                System.out.println("here");
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        
        return this;
    }

    public Message_Edit verifyPostcardText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!driver.findElement(By.xpath("//center[@class='box_canvas']//div[normalize-space(text())='" + string + "']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        
        return this;
    }
    
    public Message_Edit verifyNoPostcardText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            System.out.println("here");
            if(!driver.findElement(By.xpath("//center[@class='box_canvas']//div[normalize-space(text())='" + string + "']")).isDisplayed())
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

    public Message_Edit clickDeleteTextLayer ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(deleteTextLayer));  
        deleteTextLayer.click();
        Alert alerts = driver.switchTo().alert();
        alerts.accept();
        return this;
    }

    public Message_Edit clickCopyText ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(copyTextLayer));  
        copyTextLayer.click();
        return this;
    }

    public Message_Edit clickHideTextLayer ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(visible));  
        visible.click();
        return this;
    }

    public Message_Edit clickShowTextLayer ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(invisible));  
        invisible.click();
        return this;
    }

    public Message_Edit clickFirstLayer ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(firstItem));  
        firstItem.click();
        return this;
    }

    public Message_Edit clickMoveTextLayer ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(moveLayer));  
        Actions action = new Actions(driver);
        action.dragAndDropBy(moveLayer, 0, i).build().perform();
        return this;
    }

    public Message_Edit verifyOrderLayer ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(layersInput.get(i-1).getAttribute("value"));
            if(!layersInput.get(i-1).getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        
        return this;
    }

    public Message_Edit enterLeft ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(shapeInputs.get(0)));  
        shapeInputs.get(0).click();
        shapeInputs.get(0).clear();
        shapeInputs.get(0).sendKeys(i + Keys.RETURN);
        return this;
    }

    public Object verifyLeft ( int i )
    {
    AbstractPart.waitForAjax(driver, 20);
    try
    {
        System.out.println("here");
        if(!driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' left: " + i + "px; ')]")).isDisplayed())
        {
            return null;
        }
    }
    catch(NoSuchElementException e){
        return null;
    }
    
    
    return this;
    }

    public Message_Edit enterTop ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(shapeInputs.get(1)));  
        shapeInputs.get(1).click();
        shapeInputs.get(1).clear();
        shapeInputs.get(1).sendKeys(string + Keys.RETURN);
        return this;
    }

    public Message_Edit verifyTop ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' top: " + i + "px; ')]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit enterWidth ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(shapeInputs.get(2)));  
        shapeInputs.get(2).click();
        shapeInputs.get(2).clear();
        shapeInputs.get(2).sendKeys(string + Keys.RETURN);
        return this;
    }

    public Message_Edit verifyWidth ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' width: " + i + "px; ')]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit enterHeight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(shapeInputs.get(3)));  
        shapeInputs.get(3).click();
        shapeInputs.get(3).clear();
        shapeInputs.get(3).sendKeys(string + Keys.RETURN);
        return this;
    }

    public Message_Edit verifyHeight ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!driver.findElement(By.xpath("//span[contains(concat(' ', @style, ' '),' height: " + i + "px; ')]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(name));
        name.click();
        name.clear();
        name.sendKeys(string +Keys.RETURN);
        return this;
    }

    public Message_Edit verifyName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!name.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit enterMessageBodyMore ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);
        body.sendKeys(string);
        ((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<p>" + string + "</p>'");
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit verifyDueDate ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            
            System.out.println("here");
            if(!dueDateInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifyWho ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!whoInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifySubjectTask ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!subjectTaskInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifyTaskOwner ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!taskOwnerInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Message_Edit verifyTextAreaContains ( String dateTime )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("here");
            if(!textArea2.getAttribute("value").contains(dateTime))
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }
    public Message_Edit verifyPostcardTextAreaContains ( String sting )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println("yeah");
            if(!postcardTextArea.getText().contains(sting))
            {
                System.out.println("no");
                return null;
            }
        }
        catch(Exception e){
            System.out.println("uh oh");
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public Message_Edit enterMessageSMSBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//textarea")).sendKeys(string);
        return this;
    }

    public Message_Edit clickMergeFieldDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mergeDropDown));  
        mergeDropDown.click();
        return this;
    }

    public Message_Edit enterNewMessageSMSBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//textarea")).click();
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys(string);
        return this;
    }

    public Message_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));  
        cancel.click();
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Sequence_CreateStep clickSaveToStep ()
    {
        driver.switchTo().defaultContent();
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (Sequence_CreateStep) new Sequence_CreateStep().init();
    }

    public Message_Edit enterTextWithClear ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame2));  
        driver.switchTo().frame(iFrame2);
        body.click();
        body.clear();
        body.sendKeys(string);
        ((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<p>" + string + "</p>'");
        driver.switchTo().defaultContent();
        return this;
    }

    public Message_Edit enterTaskName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskNameInput));
        taskNameInput.sendKeys(string);
        return this;
    }

    public Message_Edit enterTaskSubjectName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskSubject));
        taskSubject.sendKeys(string);
        return this;
    }

    public Message_Edit enterDueDate ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskDueDate));
        taskDueDate.sendKeys(string);
        return this;
    }

    public Sequence_CreateStep clickSaveToSequence ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (Sequence_CreateStep) new Sequence_CreateStep().init();
    }

    public Message_Edit openSendFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sendFromDropDown));
        sendFromDropDown.click();
        return this;
    }

    public Message_Edit selectSendFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mailFromPane));
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        wait.until(ExpectedConditions.visibilityOf(selectionOptions.get(i-1)));
        selectionOptions.get(i-1).click();
        return this;
    }
    
    public Message_Edit openMergeFieldPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMergeFieldPane));
        toggleMergeFieldPane.click();
        return this;
        
    }

    public Message_Edit selectMergeField ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']"))));
        mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='[Warning! This message contains merge fields; it could produce very large output.]']")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//textarea"))));
        driver.findElement(By.xpath("//textarea")).sendKeys("Sel");
        return this;
    }

}
