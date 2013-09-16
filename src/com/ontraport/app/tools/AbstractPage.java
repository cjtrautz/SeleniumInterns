/**
 * 
 */
package com.ontraport.app.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.DrawerActions;
import com.ontraport.app.parts.DrawerManageGroups;
import com.ontraport.app.parts.DrilldownGroup;
import com.ontraport.app.parts.FormColumnManager;
import com.ontraport.app.parts.FormSearch;
import com.ontraport.app.parts.MenuHelp;
import com.ontraport.app.parts.MenuPrimary;
import com.ontraport.app.parts.MenuUser;
import com.ontraport.app.parts.MenuWorkflow;
import com.ontraport.app.parts.Paginator;

/**
 * @author Bill Brown
 *
 */
public abstract class AbstractPage
{

    protected final static int DEFAULT_WAIT         = 12;

    // GENERAL ---------------------------------------------------------------------------------------------------------
    protected String          url                   = "https://app.ontraport.com";
    protected WebDriver       driver                = AbstractSuite.getDriver();

    // PARTS -----------------------------------------------------------------------------------------------------------
    public MenuPrimary        menuPrimary           = (MenuPrimary) new MenuPrimary().init();
    public MenuUser           menuUser              = (MenuUser) new MenuUser().init();
    public MenuHelp           menuHelp              = (MenuHelp) new MenuHelp().init();
    public MenuWorkflow       menuWorkflow          = (MenuWorkflow) new MenuWorkflow().init();
    public DrawerActions      drawerActions         = (DrawerActions) new DrawerActions().init();
    public DrawerManageGroups drawerManageGroups    = (DrawerManageGroups) new DrawerManageGroups().init();
    public DrilldownGroup     drilldownGroup        = (DrilldownGroup) new DrilldownGroup().init();
    public FormSearch         formSearch            = (FormSearch) new FormSearch().init();
    public FormColumnManager  formColumnManager     = (FormColumnManager) new FormColumnManager().init();
    public DialogBox          dialogBox             = (DialogBox) new DialogBox().init();
    public Paginator          paginator             = (Paginator) new Paginator().init();

    // SELECTORS -------------------------------------------------------------------------------------------------------

    @FindBy(how     = How.ID,
            using   = "ussr-chrome-panel-pane")
    protected WebElement    uiPane;

    @FindBy(how     = How.CSS,
            using   = "div.ussr-component-collection")
    protected WebElement    uiCollection;

    @FindBy(how     = How.CSS,
            using   = "div.ussr-component-collection>table")
    protected WebElement    uiCollectionTable;

    @FindBy(how     = How.CSS,
            using   = "div.ussr-component-collection>table>tbody.ussr-component-collection-body")
    protected WebElement    uiCollectionTbody;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    linkPageFirst;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    linkPageBack;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    linkPageNext;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    linkPageLast;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    inputPageGoTo;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    drilldownRecordsPerPage;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiPin;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiUnpin;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiAddColumn;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiSelectAll;

    @FindBy(how     = How.XPATH,
            using   = "//div[@id='ontraport_panel_action_group_actions']")
    protected WebElement    uiToggleDrawerActions;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiToggleDrawerManageGroups;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiToggleDrilldownGroup;

    @FindBy(how     = How.XPATH,
            using   = "")
    protected WebElement    uiToggleDrilldownRecordsPerPage;

    @FindBy(how     = How.XPATH,
            using   = "//div[contains(concat(' ', @class, ' '),' ussr-chrome-panel-pane ')]")
    protected WebElement    uiContentPane;

    public AbstractPage open ( String url )
    {
        driver.get(this.url + url);
        return null;
    }

    public AbstractPage init ()
    {
        return PageFactory.initElements(driver, this.getClass());
    }

    public WebDriverWait wait (int time)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait output = new WebDriverWait(driver, time);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        return output;
    }

    public WebElement waitForContentPane ()
    {
        return wait(60).until(ExpectedConditions.visibilityOf(uiContentPane));
    }

    public ExpectedCondition<Boolean> hasAttributeValue (   final WebElement we,
                                        final String name,
                                        final String value )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return we.getAttribute(name).toLowerCase().equals(value.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> hasAttributeNotValue (   final WebElement we,
                                        final String name,
                                        final String value )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return !we.getAttribute(name).toLowerCase().equals(value.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> hasTextValue (   final WebElement we,
                                   final String text )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return we.getText().toLowerCase().contains(text.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> hasTextNotValue (  final WebElement we,
                                                    final String text )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return !we.getText().toLowerCase().contains(text.toLowerCase());
            }
        };
    }

    public ExpectedCondition<Boolean> isClickable ( final WebElement we )
    {
        return new ExpectedCondition<Boolean> ()
        {
            public Boolean apply(WebDriver d)
            {
                return ((we != null && we.isDisplayed() && we.isEnabled()) ? true : false);
//                return !we.getText().toLowerCase().contains(text.toLowerCase());
            }
        };
    }

}
