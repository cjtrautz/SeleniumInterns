package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

    public Sequence_CreateStep clickStepSequenceCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        stepSequenceCreate.click();
        return PageFactory.initElements(driver, Sequence_CreateStep.class);

    }

    public Sequence_CreateDate clickDateSequenceCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        dateSequenceCreate.click();
        return PageFactory.initElements(driver, Sequence_CreateDate.class);
    }
    
}

