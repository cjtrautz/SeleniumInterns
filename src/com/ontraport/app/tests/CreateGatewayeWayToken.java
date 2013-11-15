package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.Gateway_Edit;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateGatewayeWayToken extends AbstractTest
{
    @Test
    public void testCreateGatewayeWayToken ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
        Gateway_Create gateway_Create = gateway_ListAll.clickNewGateway();
        gateway_Create.enterGatewayName(value.get("Sales", "gateway_eway_token"));
        gateway_Create.clickGatewayTypeDropdown();
        gateway_Create.selectDrilldownOption("eWAY Token");
        gateway_Create.enterCustomerId(value.get("Sales", "login"));
        gateway_Create.enterRefundPass(value.get("Sales", "login1"));
        gateway_Create.enterUsername(value.get("Sales", "login2"));
        gateway_Create.enterPassword(value.get("Sales", "login3"));
        gateway_ListAll = gateway_Create.clickSave();
        gateway_ListAll.formSearch.find(value.get("Sales", "gateway_eway_token"));
        
        if(gateway_ListAll.verifyGatewayName(value.get("Sales", "gateway_eway_token"))==null)
        {
            fail("couldnt find gateway");
        }
        Gateway_Edit gateway_Edit = gateway_ListAll.clickGateway(value.get("Sales", "gateway_eway_token"));

        if(gateway_Edit.verifyGatewayName(value.get("Sales", "gateway_eway_token"))==null)
        {
            fail("couldnt find gateway name");
        }
        if(gateway_Edit.verifyCustomerId(value.get("Sales", "login"))==null)
        {
            fail("couldnt find product price");
        }
        if(gateway_Edit.verifyRefundPass(value.get("Sales", "login1"))==null)
        {
            fail("couldnt find product price");
        }
        if(gateway_Edit.verifyUsername(value.get("Sales", "login2"))==null)
        {
            fail("couldnt find product price");
        }
        if(gateway_Edit.verifyPassword(value.get("Sales", "login3"))==null)
        {
            fail("couldnt find product price");
        }

        
    }
}
