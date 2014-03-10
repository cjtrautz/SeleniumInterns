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

public class MoveATabToOverflow extends AbstractTest
{
    @Test
    public void testMoveATabToOverflow () throws Exception
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contactSettings = contactListAll.menuPrimary.clickContactSettings();
        
        Field_Editor fieldEditor = contactSettings.clickFieldEditor();
        fieldEditor.clickOverflowExpand();
        fieldEditor.clickTab(2);
        fieldEditor.moveTabToOverflow(2);
        fieldEditor.clickSave();
        
        if (!driver.getCurrentUrl().contains("contact/settings"))
        {
            fail("not returned to contact settings page");
        }
        
        contactSettings.clickFieldEditor();
        
        fieldEditor.clickOverflowExpand();
        
        if(fieldEditor.verifyTabInOverflow(AbstractTest.getTabName()) == null)
        {
            fail("Tab not in overflow");
        }
    }
}
