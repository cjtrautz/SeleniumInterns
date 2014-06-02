package com.ontraport.app.tools;

import java.io.FileOutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractTest
{
    protected static String scheduledOneOffTime = "";
    protected static String scheduledBlastTime = "";
    protected static String wordpressPassword = "";
    protected static String dateTime = "";
    protected static String tabName = "";
    protected static String reTabName = "";
    protected static String formURL = "";
    public static Values value = new Values();
    protected static WebDriver driver = AbstractSuite.getDriver();
    @Rule
    public Screenshot          screenshotTestRule = new Screenshot();
    public AbstractTest ()
    {
        //driver = AbstractSuite.getDriver();
    }
    @BeforeClass
    public static void beforeTest () throws InterruptedException
    {
        //AbstractPart.waitForAjax(driver, 30);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
        AbstractPart.waitForAjax2(driver, 30);
    }
    @Before
    public void beforeEachTest ()
    {}
    @After
    public void afterEachTest ()
    {}
    @AfterClass
    public static void afterTest ()
    {
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
    }
    class Screenshot implements MethodRule
    {
        public Statement apply ( final Statement statement, final FrameworkMethod frameworkMethod, final Object o )
        {
            return new Statement()
            {
                @Override
                public void evaluate () throws Throwable
                {
                    try
                    {
                        statement.evaluate();
                    }
                    catch (Throwable t)
                    {
                        captureScreenshot(frameworkMethod.getName());
                        throw t;
                    }
                }
                public void captureScreenshot ( String fileName )
                {
                    try
                    {
                        FileOutputStream out = new FileOutputStream("screenshots/failure-" + fileName + ".png");
                        out.write(( (TakesScreenshot) driver ).getScreenshotAs(OutputType.BYTES));
                        out.close();
                    }
                    catch (Exception e)
                    {}
                }
            };
        }
    }
    public static void setWPpass (String pass)
    {
        AbstractTest.wordpressPassword = pass;
    }
    public static String getWPpass ()
    {
        return AbstractTest.wordpressPassword;
    }
    
    public static void setDateTime (String time)
    {
        AbstractTest.dateTime = time;
    }
    public static String getDateTime ()
    {
        return AbstractTest.dateTime;
    }
    public static void setScheduledBlastTime (String time)
    {
        AbstractTest.scheduledBlastTime = time;
    }
    public static String getScheduledBlastTime ()
    {
        return AbstractTest.scheduledBlastTime;
    }
    public static void setScheduledOneOffTime (String time)
    {
        AbstractTest.scheduledOneOffTime = time;
    }
    public static String getScheduledOneOffTime ()
    {
        return AbstractTest.scheduledOneOffTime;
    }
    public static String getTabName ()
    {
        return AbstractTest.tabName;
    }
    public static void setTabName (String tab)
    {
        AbstractTest.tabName = tab;
    }
    public static void setTabReName ( String attribute )
    {
        AbstractTest.reTabName = attribute;
    }
    public static String getTabReName ()
    {
        return AbstractTest.reTabName;
    }
    public static void setHostedFormURL ( String url )
    {
        AbstractTest.formURL = url;
    }
    public static String getHostedFormURL ()
    {
        return AbstractTest.formURL;
    }
}