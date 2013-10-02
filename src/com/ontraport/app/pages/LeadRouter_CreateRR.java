package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class LeadRouter_CreateRR extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[.='Add User']")
    private WebElement addUser;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@type='text']")
    private WebElement leadRouterName;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@placeholder='Select...']")
    private WebElement dropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' lead_rout_entry_target_list ')]")
    private WebElement leadRouterEntryList;
    
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement save;
    
    public LeadRouter_CreateRR enterRouterName (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownInput));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.visibilityOf(leadRouterName));
        leadRouterName.sendKeys(name);
        return this;
    }

    public LeadRouter_CreateRR openWhoPane ( int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        try{
            leadRouterEntryList.findElement(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-lead_rout_target ')][" + index + "]//button")).click();
        }
        catch(NoSuchElementException e){
            addUser.click();
            leadRouterEntryList.findElement(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-lead_rout_target ')][" + index + "]//button")).click();
        }
        return this;
        
    }

    public LeadRouter_CreateRR selectWho ( int index, int index2 )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leadRouterEntryList.findElement(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-lead_rout_target ')][" + index + "]")).findElement(By.xpath(".//ul[@class='ussr-component-drilldownselect-ul']/li/div"))));
        List<WebElement> dropDownOptions = leadRouterEntryList.findElement(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-lead_rout_target ')][" + index + "]")).findElements(By.xpath(".//ul[@class='ussr-component-drilldownselect-ul']/li/div"));
        System.out.println(dropDownOptions.size());
        WebElement select = dropDownOptions.get(index2-1);
        select.click();
        return this;
    }

    public LeadRouter_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (LeadRouter_ListAll) new LeadRouter_ListAll().init();
    }
    
}
