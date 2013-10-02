package com.ontraport.app.tools.bb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPart
{
    protected final static int  DEFAULT_WAIT    = 12;
    protected WebDriver         driver          = AbstractSuite.getDriver();

    public WebDriverWait wait (int time)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait output = new WebDriverWait(driver, time);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        return output;
    }

    public AbstractPart init ()
    {
        ElementLocatorFactory finder =  new AjaxElementLocatorFactory(driver, AbstractSuite.DEFAULT_WAIT);
        PageFactory.initElements(finder, this);
        return this;
    }

    public ExpectedCondition<Boolean> hasAttributeValue (   final WebElement we,
                                        final String name,
                                        final String value )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return we.getAttribute(name).toLowerCase().equals(value.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> hasAttributeNotValue (   final WebElement we,
                                        final String name,
                                        final String value )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return !we.getAttribute(name).toLowerCase().equals(value.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> hasTextValue (   final WebElement we,
                                   final String text )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return we.getText().toLowerCase().contains(text.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> hasTextNotValue (  final WebElement we,
                                                    final String text )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return !we.getText().toLowerCase().contains(text.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> isClickable ( final WebElement we )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return ((we != null && we.isDisplayed() && we.isEnabled()) ? true : false);
//                return !we.getText().toLowerCase().contains(text.toLowerCase());
            }
        };
    }

}
