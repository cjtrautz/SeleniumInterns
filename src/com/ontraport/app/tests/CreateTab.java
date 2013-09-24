package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class CreateTab extends AbstractTest
{
    @Test
    public void testAddNewSection ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickAddNewTab();
        field_Editor.enterNewTabName("SelTab", 8);
        //field_Editor.clickTitle();
        contact_Settings = field_Editor.clickSave();
        field_Editor = contact_Settings.clickFieldEditor();
        
        //verify new section is in the field editor
        if(field_Editor.verifyOverflowTab("SelTab")==null)
        {
            fail("couldnt find section");
        }
        
        field_Editor.clickCancel();
        field_Editor.dialogBox.clickOk();
        
    }
}
