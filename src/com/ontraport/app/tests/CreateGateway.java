package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.Gateway_Edit;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateGateway extends AbstractTest
{
    @Test
    public void testCreateGateway ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
        Gateway_Create gateway_Create = gateway_ListAll.clickNewGateway();
        gateway_Create.enterGatewayName("SelGateway");
        gateway_Create.clickGatewayTypeDropdown();
        gateway_Create.selectDrilldownOption("Dummy Gateway");
        gateway_ListAll = gateway_Create.clickSave();
        gateway_ListAll.formSearch.find("SelGateway");
        
        if(gateway_ListAll.verifyGatewayName("SelGateway")==null)
        {
            fail("couldnt find gateway");
        }
        Gateway_Edit gateway_Edit = gateway_ListAll.clickGateway("SelGateway");

        if(gateway_Edit.verifyGatewayName("SelGateway")==null)
        {
            fail("couldnt find gateway name");
        }
        if(gateway_Edit.verifyGatewayTypeDummy()==null)
        {
            fail("couldnt find gateway type");
        }
        if(gateway_Edit.verifyGatewayNickName("SelGateway")==null)
        {
            fail("couldnt find product price");
        }

        
    }
}
