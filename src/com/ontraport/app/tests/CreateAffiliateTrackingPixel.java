package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OneShoppingCart_View;
import com.ontraport.app.pages.OntraportAdmin_TrackingPixel;
import com.ontraport.app.tools.AbstractTest;

public class CreateAffiliateTrackingPixel extends AbstractTest
{
    @Test
    public void testCreateAffiliateTrackingPixel ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        OntraportAdmin_TrackingPixel ontraportAdmin_TrackingPixel = account_View.clickGetAffiliateTrackingPixel();
        
        //verify Additional Fields is present on the page
        if(ontraportAdmin_TrackingPixel.verify()==null)
        {
            fail("couldnt find affiliate tracking pixel details");
        }
        
    }
}
