package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.TrackingUrlHistory_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTrackingURL extends AbstractTest
{
    @Test
    public void testDeleteTrackingURL () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackingUrlHistory_ListAll trackingUrlHistory_ListAll = contactListAll.menuPrimary.clickTrackingUrlHistoryListAll();
        trackingUrlHistory_ListAll.formSearch.find(value.get("Tracking", "tracking_destination_URL") + AbstractSuite.UNIQUE);
        trackingUrlHistory_ListAll.selectAll();
        trackingUrlHistory_ListAll.drawerActions.clickDeleteURLHistory();
        trackingUrlHistory_ListAll.dialogBox.clickOk();
        
        if(trackingUrlHistory_ListAll.verifyNoURL()==null)
        {
            fail("found deleted URL");
        }
    }
}
