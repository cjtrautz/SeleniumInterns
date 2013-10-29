package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.pages.Support_Home;
import com.ontraport.app.tools.AbstractTest;

public class HelpWatchVideos extends AbstractTest
{
    @Test
    public void testHelpWatchVideos () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuHelp.open();
        Support_Home support_Home = contactListAll.menuHelp.clickSupport();
 
        if(support_Home.verifyPage()==null)
        {
            fail("couldnt find support page");
        }
        
    }
}
