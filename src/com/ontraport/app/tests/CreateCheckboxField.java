package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractTest;

public class CreateCheckboxField extends AbstractTest
{
    @Test
    public void testCreateCheckboxField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        DialogBox dialogBox = field_Editor.clickAddField("SelDescription", 1);
        dialogBox.enterFieldName("SelCheckbox");
        dialogBox.clickFieldTypeDropDown();
        dialogBox.selectField("Checkbox");
        dialogBox.clickSave("SelCheckbox");
        contact_Settings = field_Editor.clickSave();
        contactListAll = contact_Settings.menuPrimary.clickContactListAll();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        field_Editor = contact_Settings.clickFieldEditor();
        driver.navigate().refresh();
        
        //verify new section is in the field editor
        if(field_Editor.verifyFieldCheckbox("SelCheckbox")==null)
        {
            fail("couldnt find checkbox field");
        }
        
        field_Editor.clickCancel();
        field_Editor.dialogBox.clickOk();
        
    }
}
