package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_CreateType2;
import com.ontraport.app.pages.WordPress_Edit;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.pages.WordPress_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class WordPressSiteSwitchBetweenDomain extends AbstractTest
{
    @Test
    public void testWordPressSiteSwitchBetweenDomain ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        WordPress_ListAll wordPress_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        WordPress_TypeSelection wordPress_TypeSelection = wordPress_ListAll.clickNewWebsite();
        WordPress_CreateType2 wordPress_CreateType2 = wordPress_TypeSelection.clickCreateNewWordPressSite();
        wordPress_CreateType2.clickUseYourOwnDomain();
        if(wordPress_CreateType2.verifyOwnDomain()==null)
        {
            fail("couldnt find own domain");
        }
        wordPress_CreateType2.clickUseOurDomain();
        if(wordPress_CreateType2.verifyOurDomain()==null)
        {
            fail("couldnt find our domain");
        }
        
    }
}
