package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_Create;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateATag extends AbstractTest
{
    @Test
    public void testCreateATag ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Tag_ListAll tag_ListAll = account_View.clickManageTags();
        Tag_Create tag_Create = tag_ListAll.clickNewTag();
        tag_Create.enterTagName("SelTag");
        tag_ListAll = tag_Create.clickSave();
        tag_ListAll.formSearch.find("SelTag");
        
        //verify Sel Tag exists
        if(tag_ListAll.verifyTag("SelTag")==null)
        {
            fail("couldn't find tag");
        }
        
    }
}
