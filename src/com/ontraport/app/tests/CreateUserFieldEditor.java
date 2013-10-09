package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractTest;

public class CreateUserFieldEditor extends AbstractTest
{
    @Test
    public void testCreateUserFieldEditor ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Field_Editor field_Editor = account_View.clickUserFieldEditor();
        field_Editor.clickAddNewSection();
        field_Editor.enterSectionTitle("Untitled", "SelTitle");
        field_Editor.clickUserTitle();
        field_Editor.enterSectionDescription("SelTitle", "Section Description", "SelDescription");
        field_Editor.clickUserTitle();
        field_Editor.clickAddField("SelDescription", 1);
        field_Editor.dialogBox.enterFieldName("SelText");
        field_Editor.dialogBox.clickFieldTypeDropDown();
        field_Editor.dialogBox.selectField("Text");
        field_Editor.dialogBox.clickSave("SelText");
        account_View = field_Editor.clickSave2();
        account_View.menuUser.open();
        User_Edit user_Edit = contactListAll.menuUser.clickPersonalSettings();
        
        if(user_Edit.verifySection("SelTitle", "SelDescription")==null)
        {
            fail("couldnt find section");
        }
        if(user_Edit.verifyField("SelText")==null)
        {
            fail("couldnt find field");
        }
        
        
    }
}
