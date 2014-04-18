package com.ontraport.app.tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class UploadVideo extends AbstractTest
{
    @Test
    public void testUploadVideo () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        ZencoderVideo_ListAll zencoderVideo_ListAll = account_View.clickVideoManager();
        ZencoderVideo_Create zencoderVideo_Create = zencoderVideo_ListAll.clickNewVideo();
        zencoderVideo_ListAll = zencoderVideo_Create.sendFile("/home/**/workspace/com.ontraport.app/etc/spacetestSMALL_512kb.mp4");
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy  h:mm a");
        Date date = new Date();
        if(zencoderVideo_ListAll.verifyUploadDate(dateFormat.format(date))==null)
        {
            fail("couldnt find video");
        }
        
    }
}
