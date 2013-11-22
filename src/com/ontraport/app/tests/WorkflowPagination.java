package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.pages.Affiliate_Settings;
import com.ontraport.app.pages.Affiliate_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.pages.Purchase_ListAll;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.pages.SalesReport_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.pages.Task_ListAll;
import com.ontraport.app.pages.TrackedDomain_ListAll;
import com.ontraport.app.pages.TrackingCampaign_ListAll;
import com.ontraport.app.pages.TrackingContent_ListAll;
import com.ontraport.app.pages.TrackingLeadSource_ListAll;
import com.ontraport.app.pages.TrackingLinks_ListAll;
import com.ontraport.app.pages.TrackingMedium_ListAll;
import com.ontraport.app.pages.TrackingTerm_ListAll;
import com.ontraport.app.pages.TrackingUrlHistory_ListAll;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class WorkflowPagination extends AbstractTest
{
    @Test
    public void testWorkflowPagination ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.pin.pin();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.pin.pin();
        Sequence_ListAll sequence_ListAll = message_ListAll.menuPrimary.clickSequenceListAll();
        sequence_ListAll.pin.pin();
        Rule_ListAll rule_ListAll =sequence_ListAll.menuPrimary.clickRuleListAll();
        rule_ListAll.pin.pin();
        SmartFormFe_ListAll smartFormFe_ListAll = rule_ListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.pin.pin();
        Task_ListAll task_ListAll = smartFormFe_ListAll.menuPrimary.clickTaskListAll();
        task_ListAll.pin.pin();
        Purchase_ListAll purchase_ListAll = task_ListAll.menuPrimary.clickPurchaseListAll();
        purchase_ListAll.pin.pin();
        Product_ListAll product_ListAll = purchase_ListAll.menuPrimary.clickProductListAll();
        product_ListAll.pin.pin();
        Affiliate_ListAll affiliate_ListAll = product_ListAll.menuPrimary.clickAffiliateListAll();
        affiliate_ListAll.pin.pin();
        AffiliateProgram_ListAll affiliateProgram_ListAll = affiliate_ListAll.menuPrimary.clickAffiliateProgramListAll();
        affiliateProgram_ListAll.pin.pin();
        LandingPage_ListAll landingPage_ListAll = affiliateProgram_ListAll.menuPrimary.clickLandingPageListAll2();
        landingPage_ListAll.pin.pin();
        WordPress_ListAll wordPress_ListAll = landingPage_ListAll.menuPrimary.clickWordPressListAll();
        wordPress_ListAll.pin.pin();
        TrackedDomain_ListAll trackeDomain_ListAll = wordPress_ListAll.menuPrimary.clickTrackedDomainListAll();
        trackeDomain_ListAll.pin.pin();
        TrackingCampaign_ListAll trackingCampaign_ListAll = trackeDomain_ListAll.menuPrimary.clickTrackingCampaignListAll2();
        trackingCampaign_ListAll.pin.pin();
        TrackingLeadSource_ListAll trackingLeadSource_ListAll = trackingCampaign_ListAll.menuPrimary.clickTrackingLeadSourceListAll();
        trackingLeadSource_ListAll.pin.pin();
        TrackingMedium_ListAll trackingMedium_ListAll = trackingLeadSource_ListAll.menuPrimary.clickTrackingMediumListAll();
        trackingMedium_ListAll.pin.pin();
        TrackingContent_ListAll trackingContent_ListAll = trackingMedium_ListAll.menuPrimary.clickTrackingContentListAll();
        trackingContent_ListAll.pin.pin();
        TrackingTerm_ListAll trackingTerm_ListAll = trackingContent_ListAll.menuPrimary.clickTrackingTermListAll();
        trackingTerm_ListAll.pin.pin();
        TrackingUrlHistory_ListAll trackingURLHistory_ListAll = trackingTerm_ListAll.menuPrimary.clickTrackingUrlHistoryListAll();
        trackingURLHistory_ListAll.pin.pin();
        TrackingLinks_ListAll trackingLinks_ListAll = trackingURLHistory_ListAll.menuPrimary.clickTrackingLinksListAll();
        trackingLinks_ListAll.pin.pin();
        trackingLinks_ListAll.menuWorkflow.open();
        
        if(trackingLinks_ListAll.menuWorkflow.verifyPagination()==null)
        {
            fail("couldnt find pagination messages");
        }
        
        trackingLinks_ListAll.menuWorkflow.close();
        trackingLinks_ListAll.pin.unPin();
        contactListAll = trackingLinks_ListAll.menuPrimary.clickContactListAll();
        contactListAll.pin.unPin();
        message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.pin.unPin();
        sequence_ListAll = message_ListAll.menuPrimary.clickSequenceListAll();
        sequence_ListAll.pin.unPin();
        rule_ListAll =sequence_ListAll.menuPrimary.clickRuleListAll();
        rule_ListAll.pin.unPin();
        smartFormFe_ListAll = rule_ListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.pin.unPin();
        task_ListAll = smartFormFe_ListAll.menuPrimary.clickTaskListAll();
        task_ListAll.pin.unPin();
        purchase_ListAll = task_ListAll.menuPrimary.clickPurchaseListAll();
        purchase_ListAll.pin.unPin();
        product_ListAll = purchase_ListAll.menuPrimary.clickProductListAll();
        product_ListAll.pin.unPin();
        affiliate_ListAll = product_ListAll.menuPrimary.clickAffiliateListAll();
        affiliate_ListAll.pin.unPin();
        affiliateProgram_ListAll = affiliate_ListAll.menuPrimary.clickAffiliateProgramListAll();
        affiliateProgram_ListAll.pin.unPin();
        landingPage_ListAll = affiliateProgram_ListAll.menuPrimary.clickLandingPageListAll2();
        landingPage_ListAll.pin.unPin();
        wordPress_ListAll = landingPage_ListAll.menuPrimary.clickWordPressListAll();
        wordPress_ListAll.pin.unPin();
        trackeDomain_ListAll = wordPress_ListAll.menuPrimary.clickTrackedDomainListAll();
        trackeDomain_ListAll.pin.unPin();
        trackingCampaign_ListAll = trackeDomain_ListAll.menuPrimary.clickTrackingCampaignListAll2();
        trackingCampaign_ListAll.pin.unPin();
        trackingLeadSource_ListAll = trackingCampaign_ListAll.menuPrimary.clickTrackingLeadSourceListAll();
        trackingLeadSource_ListAll.pin.unPin();
        trackingMedium_ListAll = trackingLeadSource_ListAll.menuPrimary.clickTrackingMediumListAll();
        trackingMedium_ListAll.pin.unPin();
        trackingContent_ListAll = trackingMedium_ListAll.menuPrimary.clickTrackingContentListAll();
        trackingContent_ListAll.pin.unPin();
        trackingTerm_ListAll = trackingContent_ListAll.menuPrimary.clickTrackingTermListAll();
        trackingTerm_ListAll.pin.unPin();
        trackingURLHistory_ListAll = trackingTerm_ListAll.menuPrimary.clickTrackingUrlHistoryListAll();
        trackingURLHistory_ListAll.pin.unPin();


    }
}
