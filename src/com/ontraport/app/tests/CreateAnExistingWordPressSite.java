package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_CreateType1;
import com.ontraport.app.pages.WordPress_CreateType2;
import com.ontraport.app.pages.WordPress_Edit;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.pages.WordPress_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateAnExistingWordPressSite extends AbstractTest
{
    @Test
    public void testCreateAnExistingWordPressSite()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        WordPress_ListAll wordPress_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        WordPress_TypeSelection wordPress_TypeSelection = wordPress_ListAll.clickNewWebsite();
        WordPress_CreateType1 wordPress_CreateType1 = wordPress_TypeSelection.clickCreateExistingWordPressSite();
        wordPress_CreateType1.enterWordPressSiteName(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE);
        wordPress_CreateType1.enterDomainName(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE + ".com");
        wordPress_CreateType1.enterMembershipLevel(value.get("WordPress", "level") );
        wordPress_CreateType1.clickAddMembershipLevel();
        wordPress_CreateType1.clickSave();
        wordPress_ListAll.formSearch.find(value.get("WordPress", "existing_wordpress_site"));
        
        //verify product exists
        if(wordPress_ListAll.verifyLandingPage(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE + ".com")==null)
        {
            fail("couldnt find wp");
        }

        WordPress_Edit wordPress_Edit = wordPress_ListAll.clickPage(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE + ".com");
        //not sure how to wait to see if website has been hosted yet efficiently
        if(wordPress_Edit.verifyWordPressName(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find wp name");
        }
        if(wordPress_Edit.verifyExistingWordPressURL(value.get("WordPress", "existing_wordpress_site") + AbstractSuite.UNIQUE + ".com")==null)
        {
            fail("couldnt find wp url");
        }
        if(wordPress_Edit.verifyWordpressMembership(value.get("WordPress", "level"))==null)
        {
            fail("couldnt find wp membership level");
        }

        
    }
}
