package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractTest;

public class ChangeUserInfo extends AbstractTest
{
    @Test
    public void testChangeUserInfo ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        user_Edit.clickFirstName();
        user_Edit.enterFirstName("Selenium");
        user_Edit.clickFirstNameSave();
        user_Edit.clickLastName();
        user_Edit.enterLastName("Selenium");
        user_Edit.clickLastNameSave();
        user_Edit.clickEmail();
        user_Edit.enterEmail("Selenium");
        user_Edit.clickEmailSave();
        user_Edit.clickTelephone();
        user_Edit.enterTelephone("Selenium");
        user_Edit.clickTelephoneSave();
        user_Edit.clickCellPhone();
        user_Edit.enterCellPhone("Selenium");
        user_Edit.clickCellPhoneSave();
        user_Edit.clickFax();
        user_Edit.enterFax("Selenium");
        user_Edit.clickFaxSave();
        contactListAll = user_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifyFirstName("Selenium")==null)
        {
            fail("couldn't find firstName");
        }
        if(user_Edit.verifyLastName("Selenium")==null)
        {
            fail("couldn't find lasttName");
        }
        if(user_Edit.verifyEmail("Selenium")==null)
        {
            fail("couldn't find email");
        }
        if(user_Edit.verifyTelephone("Selenium")==null)
        {
            fail("couldn't find telephone");
        }
        if(user_Edit.verifyCellPhone("Selenium")==null)
        {
            fail("couldn't find cellphone");
        }
        if(user_Edit.verifyFax("Selenium")==null)
        {
            fail("couldn't find fax");
        }
        
        user_Edit.clickFirstName();
        user_Edit.enterFirstName("Nicholas");
        user_Edit.clickFirstNameSave();
        user_Edit.clickLastName();
        user_Edit.enterLastName("Cross");
        user_Edit.clickLastNameSave();
        user_Edit.clickEmail();
        user_Edit.enterEmail("nick@ontraport.com");
        user_Edit.clickEmailSave();
        user_Edit.clickTelephone();
        user_Edit.enterTelephone("6082980004");
        user_Edit.clickTelephoneSave();
        user_Edit.clickCellPhone();
        user_Edit.enterCellPhone("6086980624");
        user_Edit.clickCellPhoneSave();
        user_Edit.clickFax();
        user_Edit.enterFax("N/A");
        user_Edit.clickFaxSave();
        contactListAll = user_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuUser.open();
        user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifyFirstName("Nicholas")==null)
        {
            fail("couldn't find real firstName");
        }
        if(user_Edit.verifyLastName("Cross")==null)
        {
            fail("couldn't find real last Name");
        }
        if(user_Edit.verifyEmail("nick@ontraport.com")==null)
        {
            fail("couldn't find email");
        }
        if(user_Edit.verifyTelephone("6082980004")==null)
        {
            fail("couldn't find telephone");
        }
        if(user_Edit.verifyCellPhone("6086980624")==null)
        {
            fail("couldn't find cellphone");
        }
        if(user_Edit.verifyFax("N/A")==null)
        {
            fail("couldn't find fax");
        }

        
    }
}
