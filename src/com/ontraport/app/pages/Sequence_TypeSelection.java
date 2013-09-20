package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_TypeSelection extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/sequence/create&type=step']/button")
    private WebElement stepSequenceCreate;
    
<<<<<<< HEAD
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/sequence/create&type=date']/button")
    private WebElement dateSequenceCreate;
    
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
    public Sequence_CreateStep clickStepSequenceCreate ()
    {
        stepSequenceCreate.click();
        return PageFactory.initElements(driver, Sequence_CreateStep.class);
<<<<<<< HEAD
    }

    public Sequence_CreateDate clickDateSequenceCreate ()
    {
        dateSequenceCreate.click();
        return PageFactory.initElements(driver, Sequence_CreateDate.class);
    }
    
}
=======
    }}
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
