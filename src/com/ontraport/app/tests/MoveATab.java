package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractTest;

public class MoveATab extends AbstractTest
{
    @Test
    public void testMoveATab () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Field_Editor field_Editor = contact_Settings.clickFieldEditor();
        field_Editor.clickTab(2);
        field_Editor.moveTab(2, 300);
        contact_Settings = field_Editor.clickSave();
        field_Editor = contact_Settings.clickFieldEditor();
        
        //verify new section is in the field editor
//        if(field_Editor.verifyTabPosition("Contact History", 4)==null)
//        {
//            fail("couldnt find section");
//        }
        field_Editor.moveTab(2, -150);
        contact_Settings = field_Editor.clickSave();
        contact_Settings.menuPrimary.clickContactListAll();
        
    }
}
