package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class AddNewSection extends AbstractTest
{
    @Test
    public void testAddNewSection ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickAddNewSection();
        field_Editor.enterSectionTitle("Untitled", "SelTitle");
        field_Editor.clickTitle();
        field_Editor.enterSectionDescription("SelTitle", "Section Description", "SelDescription");
        contact_Settings = field_Editor.clickSave();
        contactListAll = contact_Settings.menuPrimary.clickContactListAll();
        driver.navigate().refresh();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        field_Editor = contact_Settings.clickFieldEditor();
        
        //verify new section is in the field editor
        if(field_Editor.verifySection("SelTitle", "SelDescription")==null)
        {
            fail("couldnt find section");
        }
        
        field_Editor.clickCancel();
        field_Editor.dialogBox.clickOk();
        
    }
}
