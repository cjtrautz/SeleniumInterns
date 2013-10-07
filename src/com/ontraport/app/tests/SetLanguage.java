package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.pages.User_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SetLanguage extends AbstractTest
{
    @Test
    public void testSetLanguage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        user_Edit.clickLanguage();
        user_Edit.selectDropDown("Spanish");
        
        //verify language
        if(user_Edit.verifySpanishLanguage()==null)
        {
            fail("couldn't find spanish language");
        }
        
        user_Edit.clickLanguage();
        user_Edit.selectDropDown("Chinese");
        
        //verify language
        if(user_Edit.verifyChineseLanguage()==null)
        {
            fail("couldn't find chinese language");
        }
        
        user_Edit.clickLanguage();
        user_Edit.selectDropDown("Hebrew");
        
        //verify language
        if(user_Edit.verifyHebrewLanguage()==null)
        {
            fail("couldn't find hebrew language");
        }
        
        user_Edit.clickLanguage();
        user_Edit.selectDropDown("Russian");
        
        //verify language
        if(user_Edit.verifyRussianLanguage()==null)
        {
            fail("couldn't find russian language");
        }
        
        user_Edit.clickLanguage();
        user_Edit.selectDropDown("English");
        
        //verify language
        if(user_Edit.verifyEnglishLanguage()==null)
        {
            fail("couldn't find English language");
        }
        
    }
}
