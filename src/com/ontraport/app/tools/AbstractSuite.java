package com.ontraport.app.tools;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

public class AbstractSuite
{
    public final static long UNIQUE = System.nanoTime();
    public final static int DEFAULT_WAIT = 20;
    protected static WebDriver driver;
    public static WebDriver getDriver ()
    {
        return driver;
    }
    @AfterClass
    public static void afterSuite ()
    {
        driver.close();
        driver.quit();
    }
}
