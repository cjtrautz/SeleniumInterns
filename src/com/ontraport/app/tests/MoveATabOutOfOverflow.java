package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class MoveATabOutOfOverflow extends AbstractTest
{
    @Test
    public void testMoveATabOutOfOverflow () throws Exception
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contactSettings = contactListAll.menuPrimary.clickContactSettings();
        
        Field_Editor fieldEditor = contactSettings.clickFieldEditor();
        fieldEditor.clickOverflowExpand();
        fieldEditor.clickOverflowTab(2);
        fieldEditor.moveTabOutOfOverflow(2, 1);
        fieldEditor.clickSave();
        
        if (!driver.getCurrentUrl().contains("contact/settings"))
        {
            fail("not returned to contact settings page");
        }
        
        contactSettings.clickFieldEditor();
        
        if(fieldEditor.verifyTab(AbstractTest.getTabName()) == null)
        {
            fail("Tab not in primary list");
        }
    }
}
