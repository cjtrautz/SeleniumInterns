package com.ontraport.app.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPart
{
    protected final static int DEFAULT_WAIT = 10;
    protected WebDriver     driver = AbstractSuite.getDriver();
    public WebDriverWait wait (int time)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait output = new WebDriverWait(AbstractSuite.getDriver(), time);
        driver.manage().timeouts().implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return output;
    }
    public AbstractPart init ()
    {
        return PageFactory.initElements(driver, this.getClass());
    }
}
