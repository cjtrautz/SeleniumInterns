package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractTest;

public class CreateTextField extends AbstractTest
{
    @Test
    public void testCreateTextField ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        DialogBox dialogBox = field_Editor.clickAddField("SelDescription", 3);
        dialogBox.enterFieldName("SelText");
        dialogBox.clickFieldTypeDropDown();
        dialogBox.selectField("Text");
        dialogBox.clickSave("SelText");
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
        field_Editor.dialogBox.clickOk();
        
    }
}
