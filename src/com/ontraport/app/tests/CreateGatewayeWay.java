package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.Gateway_Edit;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateGatewayeWay extends AbstractTest
{
    @Test
    public void testCreateGatewayeWay ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
        Gateway_Create gateway_Create = gateway_ListAll.clickNewGateway();
        gateway_Create.enterGatewayName(value.get("Sales", "gateway_eway"));
        gateway_Create.clickGatewayTypeDropdown();
        gateway_Create.selectDrilldownOption("eWAY");
        gateway_Create.enterlogin(value.get("Sales", "login"));
        gateway_Create.enterKey(value.get("Sales", "login1"));
        gateway_ListAll = gateway_Create.clickSave();
        gateway_ListAll.formSearch.find(value.get("Sales", "gateway_eway"));
        
        if(gateway_ListAll.verifyGatewayName(value.get("Sales", "gateway_eway"))==null)
        {
            fail("couldnt find gateway");
        }
        Gateway_Edit gateway_Edit = gateway_ListAll.clickGateway(value.get("Sales", "gateway_eway"));

        if(gateway_Edit.verifyGatewayName(value.get("Sales", "gateway_eway"))==null)
        {
            fail("couldnt find gateway name");
        }
        if(gateway_Edit.verifyLogin(value.get("Sales", "login"))==null)
        {
            fail("couldnt find product price");
        }
        if(gateway_Edit.verifyKey(value.get("Sales", "login1"))==null)
        {
            fail("couldnt find product price");
        }

        
    }
}
