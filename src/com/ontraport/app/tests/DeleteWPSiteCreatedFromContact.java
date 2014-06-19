package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteWPSiteCreatedFromContact extends AbstractTest
{
    @Test
    public void testDeleteAffiliateProgram () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        WordPress_ListAll wp_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        wp_ListAll.formSearch.find("WPSiteFromContact"+AbstractSuite.UNIQUE);
        wp_ListAll.selectAllOnPage();
        wp_ListAll.drawerActions.clickDeleteWordPressSite();
        wp_ListAll.dialogBox.clickOk();
        
        //verify
        if(wp_ListAll.verifyNoWordPressSite()==null)
        {
            fail("found deleted wordpress site");
        }
    }
}