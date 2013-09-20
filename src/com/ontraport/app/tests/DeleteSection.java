package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class DeleteSection extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickDeleteSection("SelTitle");
        contact_Settings = field_Editor.clickSave();
        field_Editor = contact_Settings.clickFieldEditor();
        
        //verify
        
        
        field_Editor.clickCancel();
        field_Editor.dialogBox.clickOk();
        
    }
}
