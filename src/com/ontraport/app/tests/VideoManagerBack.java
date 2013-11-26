package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.ZencoderVideo_Create;
import com.ontraport.app.pages.ZencoderVideo_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class VideoManagerBack extends AbstractTest
{
    @Test
    public void testVideoManagerBack () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        ZencoderVideo_ListAll zencoderVideo_ListAll =account_View.clickVideoManager();
        ZencoderVideo_Create zencoderVideo_Create = zencoderVideo_ListAll.clickNewVideo();
        zencoderVideo_ListAll = zencoderVideo_Create.clickBack();
        
        if(zencoderVideo_ListAll.verifyPage()==null)
        {
            fail("couldnt find video list all page");
        }
    }
}
