package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_CreateType2;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.pages.WordPress_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateWordPressBack extends AbstractTest
{
    @Test
    public void testCreateWordPressBack () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        WordPress_ListAll wordPress_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        WordPress_TypeSelection wordPress_TypeSelection =  wordPress_ListAll.clickNewWebsite();
        WordPress_CreateType2 wordPress_CreateType2 = wordPress_TypeSelection.clickCreateNewWordPressSite();
        wordPress_CreateType2.enterWordPressSiteName("SelWordPressSite"  + AbstractSuite.UNIQUE);
        wordPress_CreateType2.enterDomainName("seleniumwordpress2" + AbstractSuite.UNIQUE);
        wordPress_CreateType2.enterMembershipLevel("Level1");
        wordPress_CreateType2.clickAddMembershipLevel();
        wordPress_ListAll = wordPress_CreateType2.clickBack();
        wordPress_ListAll.formSearch.find("seleniumwordpress2");
        if(wordPress_ListAll.verifyNoWordPressSite()==null)
        {
            fail("found delete wp");
        }
    }
}
