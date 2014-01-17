package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OntraportAdmin_Afflink;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractTest;

public class AffiliateLink extends AbstractTest
{
    @Test
    public void testAffiliateLink ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        OntraportAdmin_Afflink ontraportAdmin_Afflink = account_View.clickSoftwareAffiliateLinks();
        
        driver.get(ontraportAdmin_Afflink.getLink());
        
        //verify that page works
        if ( driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size() == 0 )
        {
            fail("Can't find Affiliates page");
        }
        
        driver.navigate().back();
        
        //wait for app to load
        //AbstractPart.waitForAjax(driver, 20);
        
    }
}
