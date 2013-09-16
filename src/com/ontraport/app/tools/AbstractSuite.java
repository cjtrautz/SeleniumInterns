package com.ontraport.app.tools;

//import java.util.List;
import java.io.File;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.ontraport.app.pages.Login;

public class AbstractSuite
{

    public final static String UNIQUE = String.valueOf(System.nanoTime());
//    public final static String UNIQUE = " "+Long.toHexString(Double.doubleToLongBits(Math.random()));
    public final static int DEFAULT_WAIT = 60;
    public final static int DEFAULT_EXPLICIT_WAIT = 5;
    public final static int DEFAULT_IMPLICIT_WAIT = 10;
    public final static Properties prop = new Properties();
    protected static WebDriver driver;

    public static WebDriver getDriver ()
    {
        return driver;
    }

    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        String browser = "Chrome";

        if (browser.equalsIgnoreCase("Firefox"))
        {
            FirefoxProfile profile = new FirefoxProfile();
//            profile.setEnableNativeEvents(true);
            profile.setPreference("browser.cache.disk.enable", false);
            profile.setPreference("browser.cache.memory.enable", false);
            profile.setPreference("browser.cache.offline.enable", false);
            profile.setPreference("network.http.use-cache", false);
//            JavaScriptError.addExtension(profile);
            driver = new FirefoxDriver(profile);
        }
        else if (browser.equalsIgnoreCase("Chrome"))
        {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            if (new File("../chromedriver").isFile())
            {
                System.setProperty("webdriver.chrome.driver", "../chromedriver");
            }
            else
            {
                capabilities.setCapability("chrome.binary", "chromedriver");
            }
            capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
            driver = new ChromeDriver(capabilities);
        }

        driver.manage()
              .timeouts()
              .implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage()
              .window()
              .setPosition(new Point(0, 0));
        driver.manage()
              .window()
              .maximize();
        Login login = (Login) new Login().init();
        login.open(Login.url);
        login.as("selenium@ontraport.com", "test123");
    }

    @AfterClass
    public static void afterSuite ()
    {
//        final List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
//        System.out.println("---------- JAVASCRIPT ERRORS ----------");
//        System.out.println(jsErrors);
        System.out.flush();
        driver.close();
        driver.quit();
    }

}
