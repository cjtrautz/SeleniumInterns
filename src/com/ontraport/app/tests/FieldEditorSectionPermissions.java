package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class FieldEditorSectionPermissions extends AbstractTest
{
    @Test
    public void testFieldEditorSectionPermissions ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickPermissions();
        field_Editor.dialogBox.uncheckCanEdit();
        field_Editor.dialogBox.clickSave();
        contact_Settings = field_Editor.clickSave();
        field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickPermissions();
        
        //verify new section is in the field editor
        if(field_Editor.dialogBox.verifyUncheckedCanEdit()==null)
        {
            fail("couldnt find unchecked edit");
        }
        
        field_Editor.dialogBox.checkCanEdit();
        field_Editor.dialogBox.clickSave();
        contact_Settings = field_Editor.clickSave();
        field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickPermissions();
        if(field_Editor.dialogBox.verifyCheckedCanEdit()==null)
        {
            fail("couldnt find unchecked edit");
        }
        
    }
}
