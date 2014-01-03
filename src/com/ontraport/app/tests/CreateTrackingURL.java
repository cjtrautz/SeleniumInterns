package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.TrackingCampaign_ListAll;
import com.ontraport.app.pages.TrackingContent_ListAll;
import com.ontraport.app.pages.TrackingLeadSource_ListAll;
import com.ontraport.app.pages.TrackingMedium_ListAll;
import com.ontraport.app.pages.TrackingTerm_ListAll;
import com.ontraport.app.pages.TrackingUrlHistory_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateTrackingURL extends AbstractTest
{
    @Test
    public void testCreateTrackingURL () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackingCampaign_ListAll trackingCampaign_ListAll = contactListAll.menuPrimary.clickTrackingCampaignListAll1();
        trackingCampaign_ListAll.clickNewTrackingURL();
        trackingCampaign_ListAll.drawerActions.enterURL(value.get("Tracking", "tracking_destination_URL") + AbstractSuite.UNIQUE); 
        trackingCampaign_ListAll.drawerActions.clickCampaignDropDown();
        trackingCampaign_ListAll.drawerActions.selectCreateNew();
        trackingCampaign_ListAll.drawerActions.enterObjectCreater(value.get("Tracking", "tracking_campaign") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickSave();
        trackingCampaign_ListAll.drawerActions.clickCampaignDropDown();
        trackingCampaign_ListAll.drawerActions.enterCampaignDropDown(String.valueOf(AbstractSuite.UNIQUE));
        trackingCampaign_ListAll.drawerActions.selectDrillDown(value.get("Tracking", "tracking_campaign") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickLeadSourceDropDown();
        trackingCampaign_ListAll.drawerActions.selectCreateNew();
        trackingCampaign_ListAll.drawerActions.enterObjectCreater(value.get("Tracking", "tracking_lead_source") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickSave();
        trackingCampaign_ListAll.drawerActions.clickLeadSourceDropDown();
        trackingCampaign_ListAll.drawerActions.enterLeadSourceDropDown(String.valueOf(AbstractSuite.UNIQUE));
        trackingCampaign_ListAll.drawerActions.selectDrillDown(value.get("Tracking", "tracking_lead_source") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickMediumDropDown();
        trackingCampaign_ListAll.drawerActions.selectCreateNew();
        trackingCampaign_ListAll.drawerActions.enterObjectCreater(value.get("Tracking", "tracking_medium") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickSave();
        trackingCampaign_ListAll.drawerActions.clickMediumDropDown();
        trackingCampaign_ListAll.drawerActions.enterMediumDropDown(String.valueOf(AbstractSuite.UNIQUE));
        trackingCampaign_ListAll.drawerActions.selectDrillDown(value.get("Tracking", "tracking_medium") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickContentDropDown();
        trackingCampaign_ListAll.drawerActions.selectCreateNew();
        trackingCampaign_ListAll.drawerActions.enterObjectCreater(value.get("Tracking", "tracking_content") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickSave();
        trackingCampaign_ListAll.drawerActions.clickContentDropDown();
        trackingCampaign_ListAll.drawerActions.enterContentDropDown(String.valueOf(AbstractSuite.UNIQUE));
        trackingCampaign_ListAll.drawerActions.selectDrillDown(value.get("Tracking", "tracking_content") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickTermDropDown();
        trackingCampaign_ListAll.drawerActions.selectCreateNew();
        trackingCampaign_ListAll.drawerActions.enterObjectCreater(value.get("Tracking", "tracking_term") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickSave();
        trackingCampaign_ListAll.drawerActions.clickTermDropDown();
        trackingCampaign_ListAll.drawerActions.enterTermDropDown(String.valueOf(AbstractSuite.UNIQUE));
        trackingCampaign_ListAll.drawerActions.selectDrillDown(value.get("Tracking", "tracking_term") + AbstractSuite.UNIQUE);
        trackingCampaign_ListAll.drawerActions.clickCreateURL();
        trackingCampaign_ListAll.formSearch.find(value.get("Tracking", "tracking_campaign") + AbstractSuite.UNIQUE);
        if(trackingCampaign_ListAll.verifyCampaign(value.get("Tracking", "tracking_campaign") + AbstractSuite.UNIQUE) == null)
        {
            fail("couldnt find campaign");
        }
        TrackingLeadSource_ListAll TrackingLeadSource_ListAll = trackingCampaign_ListAll.menuPrimary.clickTrackingLeadSourceListAll();
        TrackingLeadSource_ListAll.formSearch.find(value.get("Tracking", "tracking_lead_source") + AbstractSuite.UNIQUE);
        if(TrackingLeadSource_ListAll.verifyLeadSource(value.get("Tracking", "tracking_lead_source") + AbstractSuite.UNIQUE) == null)
        {
            fail("couldnt find campaign");
        }
        TrackingMedium_ListAll trackingMedium_ListAll = TrackingLeadSource_ListAll.menuPrimary.clickTrackingMediumListAll();
        trackingMedium_ListAll.formSearch.find(value.get("Tracking", "tracking_medium") + AbstractSuite.UNIQUE);
        if(trackingMedium_ListAll.verifyMedium(value.get("Tracking", "tracking_medium") + AbstractSuite.UNIQUE) == null)
        {
            fail("couldnt find campaign");
        }
        TrackingContent_ListAll trackingContent_ListAll = trackingMedium_ListAll.menuPrimary.clickTrackingContentListAll();
        trackingContent_ListAll.formSearch.find(value.get("Tracking", "tracking_content") + AbstractSuite.UNIQUE);
        if(trackingContent_ListAll.verifyContent(value.get("Tracking", "tracking_content") + AbstractSuite.UNIQUE) == null)
        {
            fail("couldnt find campaign");
        }
        TrackingTerm_ListAll trackingTerm_ListAll = trackingContent_ListAll.menuPrimary.clickTrackingTermListAll();
        trackingTerm_ListAll.formSearch.find(value.get("Tracking", "tracking_term") + AbstractSuite.UNIQUE);
        if(trackingTerm_ListAll.verifyTerm(value.get("Tracking", "tracking_term") + AbstractSuite.UNIQUE) == null)
        {
            fail("couldnt find campaign");
        }
        TrackingUrlHistory_ListAll trackingUrlHistory_ListAll = trackingTerm_ListAll.menuPrimary.clickTrackingUrlHistoryListAll();
        trackingUrlHistory_ListAll.formSearch.find(value.get("Tracking", "tracking_destination_URL") + AbstractSuite.UNIQUE);
        if(trackingUrlHistory_ListAll.verifyURL(value.get("Tracking", "tracking_destination_URL") + AbstractSuite.UNIQUE) == null)
        {
            fail("couldnt find campaign");
        }
    }
}
