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

public class ExistingWordPressSiteTryPilotPress extends AbstractTest
{
    @Test
    public void testExistingWordPressSiteTryPilotPress ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        WordPress_ListAll wordPress_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        wordPress_ListAll.formSearch.find(value.get("WordPress", "existing_wordpress_site"));
        
        //verify product exists
        if(wordPress_ListAll.verifyLandingPage(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE + ".com")==null)
        {
            fail("couldnt find wp");
        }

        WordPress_Edit wordPress_Edit = wordPress_ListAll.clickPage(value.get("WordPress", "existing_wordpress_site")  + AbstractSuite.UNIQUE + ".com");
        //not sure how to wait to see if website has been hosted yet efficiently
        if(wordPress_Edit.verifyPilotPress()==null)
        {
            fail("couldnt find pilotpress page");
        }


        
    }
}
