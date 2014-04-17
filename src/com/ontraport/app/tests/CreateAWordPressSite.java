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

public class CreateAWordPressSite extends AbstractTest
{
    @Test
    public void testCreateAWordPressSite ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        WordPress_ListAll wordPress_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        WordPress_TypeSelection wordPress_TypeSelection = wordPress_ListAll.clickNewWebsite();
        WordPress_CreateType2 wordPress_CreateType2 = wordPress_TypeSelection.clickCreateNewWordPressSite();
        wordPress_CreateType2.enterWordPressSiteName("SelWordPressSite"  + AbstractSuite.UNIQUE);
        wordPress_CreateType2.enterDomainName("seleniumwordpress2" + AbstractSuite.UNIQUE);
        wordPress_CreateType2.enterMembershipLevel("Level1");
        wordPress_CreateType2.clickAddMembershipLevel();
        wordPress_CreateType2.clickSave();
        //cant get this to work in jenkins without it
        try
        {
            Thread.sleep(13000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String password= wordPress_CreateType2.dialogBox.getPasswordCredentials();
        AbstractTest.setWPpass(password);
        wordPress_CreateType2.dialogBox.clickClose2();
        wordPress_ListAll = wordPress_CreateType2.clickBack();
        wordPress_ListAll.formSearch.find("seleniumwordpress2");
        
        //verify product exists
        if(wordPress_ListAll.verifyLandingPage("seleniumwordpress2"  + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find wp");
        }

        WordPress_Edit wordPress_Edit = wordPress_ListAll.clickPage("seleniumwordpress2"  + AbstractSuite.UNIQUE);
        //not sure how to wait to see if website has been hosted yet efficiently
        if(wordPress_Edit.verifyWordPressName("SelWordPressSite"  + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find wp name");
        }
        if(wordPress_Edit.verifyWordPressURL("seleniumwordpress2" + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find wp url");
        }
        if(wordPress_Edit.verifyWordpressMembership("Level1")==null)
        {
            fail("couldnt find wp membership level");
        }
        if(wordPress_Edit.verifyHosted(value.get("WordPress", "wordpress_domain") + AbstractSuite.UNIQUE, password)==null)
        {
            fail("couldnt find wp membership hosted");
        }

        
    }
}
