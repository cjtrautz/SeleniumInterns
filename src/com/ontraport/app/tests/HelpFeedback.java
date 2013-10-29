package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.Support_Home;
import com.ontraport.app.tools.AbstractTest;

public class HelpFeedback extends AbstractTest
{
    @Test
    public void testHelpFeedback () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuHelp.open();
        Support_Home support_Home = contactListAll.menuHelp.clickFeedback();

        if(support_Home.verifyFeature()==null)
        {
            fail("couldnt find feature page");
        }
        
    }
}
