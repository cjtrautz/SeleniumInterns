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

public class CreateTrackedLink extends AbstractTest
{
    @Test
    public void testCreateTrackedLink () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackingLinks_ListAll trackingLinks_ListAll = contactListAll.menuPrimary.clickTrackingLinksListAll();
        TrackingLinks_Create trackingLinks_Create = trackingLinks_ListAll.clickNewTrackedLink();
        trackingLinks_Create.enterName(value.get("Tracking", "tracking_link_name"));
        trackingLinks_Create.enterDestinationURL(value.get("Tracking", "tracking_link_url"));
        trackingLinks_ListAll = trackingLinks_Create.clickSave();
        trackingLinks_ListAll.formSearch.find(value.get("Tracking", "tracking_link_name"));
        
        if(trackingLinks_ListAll.verifyTrackedLink(value.get("Tracking", "tracking_link_name"))==null)
        {
            fail("couldnt find tracked link");
        }
        TrackingLinks_Edit trackingLinks_Edit = trackingLinks_ListAll.clickTrackedLink(value.get("Tracking", "tracking_link_name"));
        if(trackingLinks_Edit.verifyName(value.get("Tracking", "tracking_link_name"))==null)
        {
            fail("couldnt find tracked link name");
        }
        if(trackingLinks_Edit.verifyDestinationLink(value.get("Tracking", "tracking_link_url"))==null)
        {
            fail("couldnt find destination url");
        }
    }
}
