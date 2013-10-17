package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
            using = "//a[@href='#!/sequence/create&type=date']/button")
    private WebElement dateSequenceCreate;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@type='step']//button")
    private WebElement stepDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement dropDownList;

    public Sequence_CreateStep clickStepSequenceCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        stepSequenceCreate.click();
        return (Sequence_CreateStep) new Sequence_CreateStep().init();

    }

    public Sequence_CreateDate clickDateSequenceCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        dateSequenceCreate.click();
        return (Sequence_CreateDate) new Sequence_CreateDate().init();
    }

    public Sequence_TypeSelection clickStepSequenceDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        stepDropDown.click();
        return this;
    }

    public Sequence_Edit selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        dropDownList.findElement(By.xpath(".//li/div[text()='" + string + "']")).click();
        return (Sequence_Edit) new Sequence_Edit().init();
    }
    
}

