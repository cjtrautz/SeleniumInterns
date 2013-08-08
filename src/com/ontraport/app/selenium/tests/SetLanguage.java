package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class SetLanguage extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void test() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	    driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Personal Settings']")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//a[.='Password & Misc.']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='English']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Spanish']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contactos']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Tareas']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Ventas']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Socios']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sitios']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Seguimiento']")));
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Spanish']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Chinese']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='联系人']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='任务']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='销售']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='合作伙伴']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='网站']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='跟踪']")));
       
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Chinese']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Hebrew']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='אנשי קשר']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='משימות']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='מכירות']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='שותפים']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='אתרים']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='מעקב אחר']")));
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Hebrew']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Russian']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Контакты']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Задачи']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Продажи']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Партнеры']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Сайты']")));
        assertTrue(appUtilities.isElementPresent(driver,By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Отслеживание']")));
        
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Russian']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='English']")).click();
	    
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
