package com.ontraport.app.tools;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.pages.Login;

public class AbstractSuite
{
    public final static long UNIQUE = System.nanoTime();
<<<<<<< HEAD
    public final static int DEFAULT_WAIT = 15;
=======
    public final static int DEFAULT_WAIT = 10;
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
    protected static WebDriver driver;
    public static WebDriver getDriver ()
    {
        return driver;
    }
    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        driver = new FirefoxDriver(profile);
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
        login.as("nick@ontraport.com", "Lughead1");
        WebDriverWait wait = new WebDriverWait(driver, 20);
<<<<<<< HEAD
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[div[@class='user-leading-container'] or table[tbody[tr[td[2]]]]]")));
=======
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class='ussr-component-collection-body']/tr/td[2]")));
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
    }
    @AfterClass
    public static void afterSuite ()
    {
        driver.close();
        driver.quit();
    }
}
