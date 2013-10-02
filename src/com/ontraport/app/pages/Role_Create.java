package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Role_Create extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-form_control_input_text ')]//input")
    private WebElement roleName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-form_control_drill_down_select_object_selector ')]//button")
    private WebElement roleManagerDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement saveButton;

    public Role_Create enterRoleName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        roleName.sendKeys(string);
        return this;
        
    }

    public Role_Create clickRoleManagerDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        roleManagerDropDown.click();
        return this;
        
    }

    public Role_Create selectDropDown ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//li"));
        options.get(i-1).click();
        return this;
        
    }

    public Role_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        saveButton.click();
        return (Role_ListAll) new Role_ListAll().init();
    }
    
}
