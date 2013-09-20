package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTag  extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Tag_ListAll tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find("SelTag");
        tag_ListAll.selectAllOnPage();
        tag_ListAll.drawerActions.clickDeleteTag();
        tag_ListAll.dialogBox.clickOk();
        tag_ListAll.menuUser.open();
        account_View = tag_ListAll.menuUser.clickAdmin();
        tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find("SelTag");
        
        //verify
        if(tag_ListAll.verifyNoTag()==null)
        {
            fail("deleted tag found");
        }
        
    }
}
