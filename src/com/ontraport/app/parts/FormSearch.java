package com.ontraport.app.parts;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.ontraport.app.tools.AbstractPart;

public class FormSearch extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//input[@type='search']")
    private WebElement       uiSearch;
    @FindBy(how = How.XPATH,
            using = "//input[@type='search']/following-sibling::a")
    private WebElement       uiClear;
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collection;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-pane-header-title ')]")
    private WebElement title;
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr")
    private WebElement firstCell;
    public FormSearch find ( String text )
    {
        waitForAjax(driver, 20);
        try{
            wait(10).until(ExpectedConditions.visibilityOf(title));
        }
        catch(StaleElementReferenceException e)
        {
            wait(10).until(ExpectedConditions.visibilityOf(title));
        }
        try{
            wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))));
        }
        catch(StaleElementReferenceException e)
        {
            wait(5).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))));
        }
        try
        {
            wait(15).until(ExpectedConditions.visibilityOf(collection));
        }
        catch(StaleElementReferenceException e)
        {
            wait(15).until(ExpectedConditions.visibilityOf(collection));
        }
        uiSearch.click();
        uiSearch.sendKeys(text+Keys.ENTER);
        waitForAjax(driver, 20);
        try{
            wait(4).until(ExpectedConditions.visibilityOf(firstCell));  
        }
        catch(StaleElementReferenceException e)
        {
            wait(4).until(ExpectedConditions.visibilityOf(firstCell));
        }
        try{
            wait(8).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class='ussr-component-collection-body']/tr[1]/td[span[a[contains(text(), '" + text + "')]] or div[span[@class='ussr-state-empty']] or span[contains(text(), '" + text + "')]]")));  
        }
        catch(StaleElementReferenceException e)
        {
            wait(8).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class='ussr-component-collection-body']/tr[1]/td[span[a[contains(text(), '" + text + "')]] or div[span[@class='ussr-state-empty']] or span[contains(text(), '" + text + "')]]")));
        }
        
        
//        new WebDriverWait (driver, 10){}.until(new ExpectedCondition<Boolean>()
//                                               {
//                                                   @Override
//                                                   public Boolean apply(WebDriver d){
//                                                       Integer a = d.findElements(By.xpath("//tbody[@class='ussr-component-collection-body']//tr")).size();
//                                                       Integer b = Integer.parseInt(d.findElement(By.xpath("//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-meta-count-number ')]")).getText()); 
//                                                       System.out.println(a);
//                                                       System.out.println(b);
//                                                       return (a.intValue()==b.intValue());
//                                                   }
//                                               });

    return this;
    }

    public FormSearch clear ()
    {
        waitForAjax(driver, 20);
        uiClear.click();
        return this;
    }
}
