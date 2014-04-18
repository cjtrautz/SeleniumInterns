package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractTest;

public class SetTimezone extends AbstractTest
{
    @Test
    public void testSetTimezone ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        user_Edit.clickTimezone();
        user_Edit.selectDropDown("Addis Ababa");
        contactListAll = user_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        //verify Permission
        if(user_Edit.verifyTimezone("Los Angeles")==null)
        {
            fail("couldn't find timezone");
        }
        
        user_Edit.clickTimezone();
        user_Edit.selectDropDown("PST");
        contactListAll = user_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifyTimezone("PST")==null)
        {
            fail("couldn't find timezone");
        }
        //verify Permission is gone
        
    }
}
