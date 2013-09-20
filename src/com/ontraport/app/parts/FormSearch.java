package com.ontraport.app.parts;

<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
=======
import org.openqa.selenium.Keys;
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.WebDriverWait;
=======
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2

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
<<<<<<< HEAD
    private WebElement collection;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-pane-header-title ')]")
    private WebElement title;
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td")
    private WebElement firstCell;
    public FormSearch find ( String text )
    {
        try{
            wait(10).until(ExpectedConditions.visibilityOf(title));
        }
        catch(StaleElementReferenceException e)
        {
            wait(10).until(ExpectedConditions.visibilityOf(title));
        }
        wait(10).until(ExpectedConditions.visibilityOf(collection));
        wait(3).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))));
        uiSearch.click();
        uiSearch.sendKeys(text+Keys.ENTER);
        wait(4).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(firstCell)));
        wait(8).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class='ussr-component-collection-body']/tr[1]/td[span[a[contains(text(), '" + text + "')]] or div[span[@class='ussr-state-empty']] or span[contains(text(), '" + text + "')]]"))));
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
=======
    private WebElement firstRow;
    public FormSearch find ( String text )
    {
        wait(3).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(firstRow)));
        uiSearch.sendKeys(text+Keys.ENTER);
        
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
        return this;
    }
    public FormSearch clear ()
    {
        uiClear.click();
        return this;
    }
}
