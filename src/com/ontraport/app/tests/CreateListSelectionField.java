package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class CreateListSelectionField extends AbstractTest
{
    @Test
    public void testCreateListSelectionField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickAddField("SelDescription", 1);
        field_Editor.dialogBox.enterFieldName("SelList");
        field_Editor.dialogBox.clickFieldTypeDropDown();
        field_Editor.dialogBox.selectField("List Selection");
        field_Editor.dialogBox.enterAddOption("a");
        field_Editor.dialogBox.clickAdd();
        field_Editor.dialogBox.clickSave("SelList");
        contact_Settings = field_Editor.clickSave();
        contactListAll = contact_Settings.menuPrimary.clickContactListAll();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        field_Editor = contact_Settings.clickFieldEditor();
        driver.navigate().refresh();
        
        //verify new section is in the field editor
        if(field_Editor.verifyFieldList("SelList")==null)
        {
            fail("couldnt find list field");
        }
        
        field_Editor.clickCancel();
        
    }
}
