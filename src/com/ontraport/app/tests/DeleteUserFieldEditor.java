package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractTest;

public class DeleteUserFieldEditor extends AbstractTest
{
    @Test
    public void testDeleteUserFieldEditor ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Field_Editor field_Editor = account_View.clickUserFieldEditor();
        field_Editor.clickDeleteFieldText("SelText");
        field_Editor.clickDeleteSection("SelTitle");
        account_View = field_Editor.clickSave2();
        account_View.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifyNotSection("SelTitle")==null)
        {
            fail("couldnt find section");
        }

        
    }
}
