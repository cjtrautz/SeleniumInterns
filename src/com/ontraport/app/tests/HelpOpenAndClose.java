package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.Support_Home;
import com.ontraport.app.tools.AbstractTest;

public class HelpOpenAndClose extends AbstractTest
{
    @Test
    public void testHelpOpenAndClose () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuHelp.open();
        if(contactListAll.menuHelp.verifyOpened()==null)
        {
            fail("couldnt find help menu");
        }
        contactListAll.menuHelp.close();
        if(contactListAll.menuHelp.verifyClosed()==null)
        {
            fail("found help menu");
        }
        
    }
}
