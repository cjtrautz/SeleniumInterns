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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest
{
    protected static String wordpressPassword = "";
    protected static String dateTime = "";
    public static Values value = new Values();
    protected static WebDriver driver = AbstractSuite.getDriver();
    @Rule
    public Screenshot          screenshotTestRule = new Screenshot();
    public AbstractTest ()
    {
        //driver = AbstractSuite.getDriver();
    }
    @BeforeClass
    public static void beforeTest ()
    {
        AbstractPart.waitForAjax(driver, 30);
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        driver.navigate().refresh();
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
}
