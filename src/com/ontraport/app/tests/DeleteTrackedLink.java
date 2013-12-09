package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.TrackingLinks_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTrackedLink extends AbstractTest
{
    @Test
    public void testDeleteTrackedLink () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackingLinks_ListAll trackingLinks_ListAll = contactListAll.menuPrimary.clickTrackingLinksListAll();
        trackingLinks_ListAll.formSearch.find(value.get("Tracking", "tracking_link_name"));
        trackingLinks_ListAll.selectAll();
        trackingLinks_ListAll.drawerActions.clickDeleteTrackedLink();
        trackingLinks_ListAll.dialogBox.clickOk();
        if(trackingLinks_ListAll.verifyNoTrackedLinks()==null)
        {
            fail("found deleted tracked link");
        }
    }
}
