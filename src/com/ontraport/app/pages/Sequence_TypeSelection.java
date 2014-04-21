package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Sequence_TypeSelection extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/sequence/create&type=step']/button")
    private WebElement stepSequenceCreate;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@type='step']/button/span")
    private WebElement workflowStepSequenceCreate;

    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/sequence/create&type=date']/button")
    private WebElement dateSequenceCreate;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@type='step']//button")
    private WebElement stepDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@type='date']//button")
    private WebElement dateDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement dropDownList;

    public Sequence_CreateStep clickStepSequenceCreate ()
    {
        AbstractPart.waitForAjax2(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(stepSequenceCreate));
        stepSequenceCreate.click();
        return (Sequence_CreateStep) new Sequence_CreateStep().init();

    }
    
    public Sequence_CreateStep workflowClickStepSequenceCreate ()
    {
        AbstractPart.waitForAjax2(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(workflowStepSequenceCreate));
        workflowStepSequenceCreate.click();
        return (Sequence_CreateStep) new Sequence_CreateStep().init();

    }

    public Sequence_CreateDate clickDateSequenceCreate ()
    {
        AbstractPart.waitForAjax2(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dateSequenceCreate));
        dateSequenceCreate.click();
        return (Sequence_CreateDate) new Sequence_CreateDate().init();
    }

    public Sequence_TypeSelection clickStepSequenceDropDown ()
    {
        AbstractPart.waitForAjax2(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(stepDropDown));
        stepDropDown.click();
        return this;
    }

    public Sequence_Edit selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownList.findElement(By.xpath(".//li/div[text()='" + string + "']"))));
        dropDownList.findElement(By.xpath(".//li/div[text()='" + string + "']")).click();
        return (Sequence_Edit) new Sequence_Edit().init();
    }

    public Sequence_TypeSelection clickDateSequenceDropDown ()
    {
        AbstractPart.waitForAjax2(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dateDropDown));
        dateDropDown.click();
        return this;
    }
    
}

