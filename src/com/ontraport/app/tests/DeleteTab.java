package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTab extends AbstractTest
{
    @Test
    public void testDeleteTab ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickOverflowExpand();
        //field_Editor.clickTabName("SelTab");
        //this is for jenkins because the screen is smaller but on local should be 8
        field_Editor.deleteTab("SELTAB", "SelTab");
        contact_Settings = field_Editor.clickSave();
        field_Editor = contact_Settings.clickFieldEditor();
        
        //verify new section is in the field editor
        if(field_Editor.verifyNoTab("SelTab")==null)
        {
            fail("couldnt find section");
        }
        
        field_Editor.clickCancel();
        
    }
}
