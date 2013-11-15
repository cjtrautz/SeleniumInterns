package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.Gateway_Edit;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateGatewayNetworkMerchantsInc extends AbstractTest
{
    @Test
    public void testCreateGatewayNetworkMerchantsInc ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
        Gateway_Create gateway_Create = gateway_ListAll.clickNewGateway();
        gateway_Create.enterGatewayName(value.get("Sales", "gateway_network_merchants_inc"));
        gateway_Create.clickGatewayTypeDropdown();
        gateway_Create.selectDrilldownOption("Network Merchants Inc");
        gateway_Create.enterNetworkMerchantUsername(value.get("Sales", "login"));
        gateway_Create.enterNetwork(value.get("Sales", "login1"));
        gateway_ListAll = gateway_Create.clickSave();
        gateway_ListAll.formSearch.find(value.get("Sales", "gateway_network_merchants_inc"));
        
        if(gateway_ListAll.verifyGatewayName(value.get("Sales", "gateway_network_merchants_inc"))==null)
        {
            fail("couldnt find gateway");
        }
        Gateway_Edit gateway_Edit = gateway_ListAll.clickGateway(value.get("Sales", "gateway_network_merchants_inc"));

        if(gateway_Edit.verifyGatewayName(value.get("Sales", "gateway_network_merchants_inc"))==null)
        {
            fail("couldnt find gateway name");
        }
        if(gateway_Edit.verifyNetworkMerchantUsername(value.get("Sales", "login"))==null)
        {
            fail("couldnt find product price");
        }
        if(gateway_Edit.verifyNetworkMerchantPassword(value.get("Sales", "login1"))==null)
        {
            fail("couldnt find product price");
        }

        
    }
}
