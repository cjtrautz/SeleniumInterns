package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.TrackingLinks_Create;
import com.ontraport.app.pages.TrackingLinks_Edit;
import com.ontraport.app.pages.TrackingLinks_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class EditTrackedLinkName extends AbstractTest
{
    @Test
    public void testEditTrackedLinkName () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackingLinks_ListAll trackingLinks_ListAll = contactListAll.menuPrimary.clickTrackingLinksListAll();
        TrackingLinks_Edit trackingLinks_Edit = trackingLinks_ListAll.clickTrackedLink(value.get("Tracking", "tracking_link_name"));
        trackingLinks_Edit.clickName();
        trackingLinks_Edit.enterName(value.get("Tracking", "tracking_link_name2"));
        trackingLinks_Edit.clickSaveName();
        trackingLinks_ListAll = trackingLinks_Edit.clickBack();
        trackingLinks_ListAll.formSearch.find(value.get("Tracking", "tracking_link_name2"));
        
        if(trackingLinks_ListAll.verifyTrackedLink(value.get("Tracking", "tracking_link_name2"))==null)
        {
            fail("couldnt find tracked link");
        }
        trackingLinks_Edit = trackingLinks_ListAll.clickTrackedLink(value.get("Tracking", "tracking_link_name2"));
        if(trackingLinks_Edit.verifyName(value.get("Tracking", "tracking_link_name2"))==null)
        {
            fail("couldnt find tracked link name");
        }
        trackingLinks_Edit.clickName();
        trackingLinks_Edit.enterName(value.get("Tracking", "tracking_link_name"));
        trackingLinks_Edit.clickSaveName();
        trackingLinks_ListAll = trackingLinks_Edit.clickBack();
    }
}
