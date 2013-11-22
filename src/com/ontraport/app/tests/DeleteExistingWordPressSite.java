package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteExistingWordPressSite extends AbstractTest
{
    @Test
    public void testDeleteExistingWordPressSite ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        WordPress_ListAll wordPress_ListAll = contactListAll.menuPrimary.clickWordPressListAll();
        wordPress_ListAll.formSearch.find(value.get("WordPress", "existing_wordpress_site"));
        wordPress_ListAll.selectAllOnPage();
        wordPress_ListAll.drawerActions.clickDeleteWordPressSite();
        wordPress_ListAll.dialogBox.clickOk();
         
         //verify
         if(wordPress_ListAll.verifyNoWordPressSite()==null)
         {
             fail("found delete wp");
         }
        
    }
}
