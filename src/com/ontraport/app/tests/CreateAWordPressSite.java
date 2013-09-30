package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.LandingPage_CreateType1;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.pages.Product_Create;
import com.ontraport.app.pages.Product_Edit;
import com.ontraport.app.pages.Product_ListAll;
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
        wordPress_CreateType2.enterWordPressSiteName("SelWordPressSite");
        wordPress_CreateType2.enterDomainName("seleniumwordpress2");
        wordPress_CreateType2.enterMembershipLevel("Level1");
        wordPress_CreateType2.clickAddMembershipLevel();
        wordPress_CreateType2.clickSave();
        wordPress_ListAll = wordPress_CreateType2.dialogBox.clickClose2();
        wordPress_ListAll.formSearch.find("seleniumwordpress2");
        
        //verify product exists
        if(wordPress_ListAll.verifyLandingPage("SelWordPressSite")==null)
        {
            fail("couldnt find wp");
        }

        WordPress_Edit wordPress_Edit = wordPress_ListAll.clickPage("SelWordPressSite");
        //not sure how to wait to see if website has been hosted yet efficiently
        if(wordPress_Edit.verifyWordPressName("SelWordPressSite")==null)
        {
            fail("couldnt find wp name");
        }
        if(wordPress_Edit.verifyWordPressURL("seleniumwordpress2")==null)
        {
            fail("couldnt find wp url");
        }
        if(wordPress_Edit.verifyWordpressMembership("Level1")==null)
        {
            fail("couldnt find wp membership level");
        }

        
    }
}
