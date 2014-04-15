package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class CreateTextField extends AbstractTest
{
    @Test
    public void testCreateTextField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickAddField("SelDescription", 3);
        field_Editor.dialogBox.enterFieldName("SelText");
        field_Editor.dialogBox.clickFieldTypeDropDown();
        field_Editor.dialogBox.selectField("Text");
        field_Editor.dialogBox.clickSave("SelText");
        contact_Settings = field_Editor.clickSave();
        contactListAll = contact_Settings.menuPrimary.clickContactListAll();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        field_Editor = contact_Settings.clickFieldEditor();
        driver.navigate().refresh();
        
        //verify new section is in the field editor
        if(field_Editor.verifyFieldText("SelText")==null)
        {
            fail("couldnt find date field");
        }
        
        field_Editor.clickCancel();
        
    }
}
