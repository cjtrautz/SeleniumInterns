package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class DeleteGatewayAuthorizeNet extends AbstractTest
{
    @Test
    public void testDeleteGatewayAuthorizeNet ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
        gateway_ListAll.formSearch.find(value.get("Sales", "gateway_authorize_net"));
        gateway_ListAll.selectGateway(value.get("Sales", "gateway_authorize_net"));
        gateway_ListAll.drawerActions.clickDeleteGateway();
        gateway_ListAll.dialogBox.clickOk();
         
         //verify
         if(gateway_ListAll.verifyNoGateway()==null)
         {
             fail("found delete gateway");
         }
        
    }
}
