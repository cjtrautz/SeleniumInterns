package com.ontraport.app.tools.bb;

import java.io.File;
import java.io.FileOutputStream;
//import java.util.List;

//import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

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
    protected static WebDriver driver;
    @Rule
    public Screenshot          screenshotTestRule = new Screenshot();
    public AbstractTest ()
    {
        driver = AbstractSuite.getDriver();
    }
    @BeforeClass
    public static void beforeTest ()
    {}
    @Before
    public void beforeEachTest ()
    {}
    @After
    public void afterEachTest ()
    {}
    @AfterClass
    public static void afterTest ()
    {
//        final List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
//        if (!jsErrors.isEmpty())
//        {
//            System.out.println("---------- TEST TRIGGERED JAVASCRIPT ERRORS ----------");
//            System.out.println(jsErrors);
//            System.out.flush();
//        }
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
                        new File(".bachelor/screenshots/").mkdirs();
                        FileOutputStream out = new FileOutputStream(".bachelor/screenshots/failure-" + fileName + ".png");
                        out.write(( (TakesScreenshot) driver ).getScreenshotAs(OutputType.BYTES));
                        out.close();
                    }
                    catch (Exception e)
                    {}
                }
            };
        }
    }
}
