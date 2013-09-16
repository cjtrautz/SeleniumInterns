package com.ontraport.app.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class DrilldownGroup extends AbstractPart
{

    @FindBy(how = How.CSS,
            using = "div.chrome-action-bar-group-selector.ussr-group-selector")
    private WebElement root;

    @FindBy(how = How.CSS,
            using = "div.chrome-action-bar-group-selector.ussr-group-selector div.ussr-component-drilldownselect-listview")
    private WebElement list;

    @FindBy(how = How.CSS,
            using = "div.chrome-action-bar-group-selector.ussr-group-selector input")
    private WebElement input;

    @FindBy(how = How.CSS,
            using = "div.chrome-action-bar-group-selector.ussr-group-selector button")
    private WebElement button;

    public DrilldownGroup toggle ()
    {
        wait(3).until(ExpectedConditions.visibilityOf(button)).click();
        return this;
    }

    public DrilldownGroup open ()
    {
        toggle();
        wait(3).until(ExpectedConditions.visibilityOf(list));
        return this;
    }

    public DrilldownGroup close ()
    {
        toggle();
        wait(3).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(list)));
        return this;
    }

    public DrilldownGroup selectGroup (final String name)
    {
        open();

        By loading = By.cssSelector("div.chrome-action-bar-group-selector.ussr-group-selector .ussr-state-loading");
        wait(3).until(ExpectedConditions.invisibilityOfElementLocated(loading));

        WebElement item = list.findElement(By.xpath(".//div[text()='"+name+"']/.."));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", item);
        wait(0).until(isClickable(item));
        wait(3).until(ExpectedConditions.visibilityOf(item)).click();
        wait(3).until(hasAttributeValue(input, "value", name));
        return this;
    }

    public Boolean confirmGroupExists (String name)
    {
        Boolean output = false;
        open();
        output = wait(3).until(hasTextValue(list, name));
        close();
        return output;
    }

    public Boolean confirmGroupNotExists (String name)
    {
        Boolean output = false;
        open();
        output = wait(3).until(hasTextNotValue(list, name));
        close();
        return output;
    }

    public Boolean confirmGroupSelected (String name)
    {
        Boolean output = false;
        open();
        output = wait(3).until(hasAttributeValue(input, "value", name));
        close();
        return output;
    }

    public Boolean confirmGroupNotSelected (String name)
    {
        Boolean output = false;
        open();
        output = wait(3).until(hasAttributeNotValue(input, "value", name));
        close();
        return output;
    }

}
