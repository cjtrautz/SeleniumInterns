package com.ontraport.app.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPart
{
    protected static int trys = 0;
    protected final static int DEFAULT_WAIT = 10;
    protected WebDriver     driver = AbstractSuite.getDriver();
    public static boolean waitForAjax ( WebDriver driver, int timeOutInSeconds )
    {
        
        boolean jQcondition = false;
        try
        {
            new WebDriverWait(driver, timeOutInSeconds){}
            .until(new ExpectedCondition<Boolean>()
            {
                @Override
                public Boolean apply ( WebDriver driverObject )
                {
                    return (Boolean) ( (JavascriptExecutor) driverObject ).executeScript("return ontraport.activeRequests === 0");
                }
            });
            jQcondition = (Boolean) ( (JavascriptExecutor) driver )
                        .executeScript( "return window.ontraport != undefined "
                                      + "&& ontraport.activeRequests != undefined "
                                      + "&& ontraport.activeRequests === 0" );
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(AbstractSuite.getDriver(), 30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-state-loading ')]")));
            driver.manage().timeouts().implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return jQcondition;
        }
        catch (Exception e)
        {
            System.out.println( ( (JavascriptExecutor) driver ).executeScript("return ontraport.activeRequests"));
            e.printStackTrace();
        }
        return jQcondition;
    }
    public static boolean waitForAjax2 ( WebDriver driver, int timeOutInSeconds )
    {
        AbstractPart.setTrys(0);
        boolean jQcondition = false;
        try
        {
            new WebDriverWait(driver, timeOutInSeconds){}
            .until(new ExpectedCondition<Boolean>()
            {
                @Override
                public Boolean apply ( WebDriver driverObject )
                {
                    return (Boolean) ( (JavascriptExecutor) driverObject ).executeScript("return ontraport.activeRequests === 0");
                }
            });
            jQcondition = (Boolean) ( (JavascriptExecutor) driver )
                        .executeScript( "return window.ontraport != undefined "
                                      + "&& ontraport.activeRequests != undefined "
                                      + "&& ontraport.activeRequests === 0" );
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(AbstractSuite.getDriver(), 30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-state-loading ')]")));
            driver.manage().timeouts().implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return jQcondition;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            driver.navigate().refresh();
            if(AbstractPart.getTrys()==0)
            {
                AbstractPart.setTrys(1);
                waitForAjax3(driver, 20);
            }
        }
        return jQcondition;
    }
    public static boolean waitForAjax3 ( WebDriver driver, int timeOutInSeconds )
    {
        
        boolean jQcondition = false;
        try
        {
            new WebDriverWait(driver, timeOutInSeconds){}
            .until(new ExpectedCondition<Boolean>()
            {
                @Override
                public Boolean apply ( WebDriver driverObject )
                {
                    return (Boolean) ( (JavascriptExecutor) driverObject ).executeScript("return ontraport.activeRequests === 0");
                }
            });
            jQcondition = (Boolean) ( (JavascriptExecutor) driver )
                        .executeScript( "return window.ontraport != undefined "
                                      + "&& ontraport.activeRequests != undefined "
                                      + "&& ontraport.activeRequests === 0" );
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(AbstractSuite.getDriver(), 30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-state-loading ')]")));
            driver.manage().timeouts().implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return jQcondition;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            driver.navigate().refresh();
            if(AbstractPart.getTrys()==0)
            {
                AbstractPart.setTrys(1);
                waitForAjax3(driver, 20);
            }
        }
        return jQcondition;
    }
    public WebDriverWait wait (int time)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait output = new WebDriverWait(AbstractSuite.getDriver(), time);
        driver.manage().timeouts().implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return output;
    }
    public AbstractPart init ()
    {
        ElementLocatorFactory finder =  new AjaxElementLocatorFactory(driver, AbstractSuite.DEFAULT_WAIT);
        PageFactory.initElements(finder, this);
        return this;
    }
    public static int getTrys ()
    {
        return trys;
    }
    public static void setTrys ( int trys )
    {
        AbstractPart.trys = trys;
    }
}
