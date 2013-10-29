package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.Support_Home;
import com.ontraport.app.tools.AbstractTest;

public class HelpSendEmail extends AbstractTest
{
    @Test
    public void testHelpSendEmail () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuHelp.open();
        contactListAll.menuHelp.clickEmail();
        if(contactListAll.dropBox.verifySugestion()==null)
        {
            fail("couldnt find support page");
        }
        
    }
}
