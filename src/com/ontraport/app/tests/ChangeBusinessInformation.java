package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractTest;

public class ChangeBusinessInformation extends AbstractTest
{
    @Test
    public void testChangeBusinessInformation ()
    {     
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        user_Edit.clickBusinessName();
        user_Edit.enterBusinessName("Selenium");
        user_Edit.clickBusinessNameSave();
        user_Edit.clickBusinessAddress();
        user_Edit.enterBusinessAddress("Selenium");
        user_Edit.clickBusinessAddressSave();
        user_Edit.clickBusinessAddress2();
        user_Edit.enterBusinessAddress2("Selenium");
        user_Edit.clickBusinessAddress2Save();
        user_Edit.clickCity();
        user_Edit.enterCity("Selenium");
        user_Edit.clickCitySave();
        user_Edit.clickState();
        user_Edit.enterState("California");
        user_Edit.clickZip();
        user_Edit.enterZip("Selenium");
        user_Edit.clickZipSave();
        contactListAll = user_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifyBusinessName("Selenium")==null)
        {
            fail("couldn't find verifyBusinessName one");
        }
        if(user_Edit.verifyBusinessAddress("Selenium")==null)
        {
            fail("couldn't find verifyBusinessAddress one");
        }
        if(user_Edit.verifyBusinessAddress2("Selenium")==null)
        {
            fail("couldn't find verifyBusinessAddress2 one");
        }
        if(user_Edit.verifyCity("Selenium")==null)
        {
            fail("couldn't find verifyCity one");
        }
        if(user_Edit.verifyState("California")==null)
        {
            fail("couldn't find verifyState one");
        }
        if(user_Edit.verifyZip("Selenium")==null)
        {
            fail("couldn't find verifyZip one");
        }
        user_Edit.clickBusinessName();
        user_Edit.enterBusinessName("Nick Cross");
        user_Edit.clickBusinessNameSave();
        user_Edit.clickBusinessAddress();
        user_Edit.enterBusinessAddress("897 Cheltenham Road");
        user_Edit.clickBusinessAddressSave();
        user_Edit.clickBusinessAddress2();
        user_Edit.enterBusinessAddress2("26 Chequamegon Bay");
        user_Edit.clickBusinessAddress2Save();
        user_Edit.clickCity();
        user_Edit.enterCity("Santa Barbara");
        user_Edit.clickCitySave();
        user_Edit.clickState();
        user_Edit.enterState("Wisconsin");

        user_Edit.clickZip();
        user_Edit.enterZip("93105");
        user_Edit.clickZipSave();
        contactListAll = user_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifyBusinessName("Nick Cross")==null)
        {
            fail("couldn't find verifyBusinessName");
        }
        if(user_Edit.verifyBusinessAddress("897 Cheltenham Road")==null)
        {
            fail("couldn't find verifyBusinessAddress");
        }
        if(user_Edit.verifyBusinessAddress2("26 Chequamegon Bay")==null)
        {
            fail("couldn't find verifyBusinessAddress2");
        }
        if(user_Edit.verifyCity("Santa Barbara")==null)
        {
            fail("couldn't find verifyCity");
        }
        if(user_Edit.verifyState("Wisconsin")==null)
        {
            fail("couldn't find verifyState");
        }
        if(user_Edit.verifyZip("93105")==null)
        {
            fail("couldn't find verifyZip");
        }

        
    }
}
