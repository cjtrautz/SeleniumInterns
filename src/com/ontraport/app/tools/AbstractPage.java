/**
 * 
 */
package com.ontraport.app.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.parts.CKEditorDialogBox;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.DrawerActions;
import com.ontraport.app.parts.DrawerManageGroups;
import com.ontraport.app.parts.DrawerPermissionException;
import com.ontraport.app.parts.DrawerSimpleActions;
import com.ontraport.app.parts.DrilldownGroup;
import com.ontraport.app.parts.DropBox;
import com.ontraport.app.parts.FormColumnManager;
import com.ontraport.app.parts.FormSearch;
import com.ontraport.app.parts.MenuHelp;
import com.ontraport.app.parts.MenuPrimary;
import com.ontraport.app.parts.MenuUser;
import com.ontraport.app.parts.MenuWorkflow;
import com.ontraport.app.parts.Paginator;
import com.ontraport.app.parts.Pin;

public abstract class AbstractPage
{
    // GENERAL ---------------------------------------------------------------------------------------------------------
    protected static String             password                    = "test123";
    protected static String             login                       = "colton@sendpepper.com";
    protected static String             url                         = "https://staging.ontraport.com/";
    private static String               latch                       = "?track_requests=1";
    protected WebDriver                 driver                      = AbstractSuite.getDriver();
    protected WebDriverWait             wait                        = new WebDriverWait(AbstractSuite.getDriver(), AbstractSuite.DEFAULT_WAIT);
    // PARTS -----------------------------------------------------------------------------------------------------------
    public DropBox                      dropBox                     = (DropBox) new DropBox().init();
    public CKEditorDialogBox            ckEditorDialogBox           = (CKEditorDialogBox) new CKEditorDialogBox().init();
    public Pin                          pin                         = (Pin) new Pin().init();
    public MenuPrimary                  menuPrimary                 = (MenuPrimary) new MenuPrimary().init();
    public MenuUser                     menuUser                    = (MenuUser) new MenuUser().init();
    public MenuHelp                     menuHelp                    = (MenuHelp) new MenuHelp().init();
    public MenuWorkflow                 menuWorkflow                = (MenuWorkflow) new MenuWorkflow().init();
    public DrawerActions                drawerActions               = (DrawerActions) new DrawerActions().init();
    public DrawerManageGroups           drawerManageGroups          = (DrawerManageGroups) new DrawerManageGroups().init();
    public DrilldownGroup               drilldownGroup              = (DrilldownGroup) new DrilldownGroup().init();
    public FormSearch                   formSearch                  = (FormSearch) new FormSearch().init();
    public FormColumnManager            formColumnManager           = (FormColumnManager) new FormColumnManager().init();
    public DialogBox                    dialogBox                   = (DialogBox) new DialogBox().init();
    public Paginator                    paginator                   = (Paginator) new Paginator().init();
    public DrawerSimpleActions          drawerSimpleActions         = (DrawerSimpleActions) new DrawerSimpleActions().init();
    public DrawerPermissionException    drawerPermissionException   = (DrawerPermissionException) new DrawerPermissionException().init();
    // SELECTORS -------------------------------------------------------------------------------------------------------
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      linkPageFirst;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      linkPageBack;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      linkPageNext;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      linkPageLast;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      inputPageGoTo;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      drilldownRecordsPerPage;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiPin;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiUnpin;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiAddColumn;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiSelectAll;
//    @FindBy(how = How.XPATH,
//            using = "//div[@id='ontraport_panel_action_group_actions']")
//    protected WebElement      uiToggleDrawerActions;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiToggleDrawerManageGroups;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiToggleDrilldownGroup;
//    @FindBy(how = How.XPATH,
//            using = "")
//    protected WebElement      uiToggleDrilldownRecordsPerPage;
    public AbstractPage open ( String url )
    {
        driver.get(AbstractPage.url + AbstractPage.getLatch() + url);
        return null;
    }
    public AbstractPage open ( String url, Boolean login )
    {
        if (login == false)
        {
            driver.get(AbstractPage.url + AbstractPage.getLatch() + url);
        } else {
            driver.get(AbstractPage.url + url + AbstractPage.getLatch());
        }
        return null;
    }
    public AbstractPage init ()
    {
        ElementLocatorFactory finder =  new AjaxElementLocatorFactory(driver, AbstractSuite.DEFAULT_WAIT);
        PageFactory.initElements(finder, this);
        return this;
    }
    public static void setUrl (String url)
    {
        AbstractPage.url = url;
    }
    public static String getUrl ()
    {
        return AbstractPage.url;
    }
    public static void setLogin (String login)
    {
        AbstractPage.login = login;
    }
    public static String getLogin ()
    {
        return AbstractPage.login;
    }
    public static void setPassword (String pass)
    {
        AbstractPage.password = pass;
    }
    public static String getPassword ()
    {
        return AbstractPage.password;
    }
    public static String getLatch ()
    {
        return latch;
    }
    public static void setLatch ( String latch )
    {
        AbstractPage.latch = latch;
    }

}
