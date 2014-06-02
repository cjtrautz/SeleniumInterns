package com.ontraport.app.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateOrderformWithGatewayWorkflow extends AbstractTest
{
    @Test
    public void testCreateOrderformWithGatewayWorkflow () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();

        smartFormFe_Create.sendSmartFormName(value.get("SmartForms", "orderForm"));
        smartFormFe_Create.clickSellProducts();
        smartFormFe_Create.clickAddProduct();
        smartFormFe_Create.dialogBox.clickProductName(); 
        smartFormFe_Create.dialogBox.selectProductDrillDown(value.get("Sales", "product"));
        smartFormFe_Create.dialogBox.clickDone();
        smartFormFe_Create.clickAddPaymentMethod();
        smartFormFe_Create.clickGatewayDropDown();
        smartFormFe_Create.selectCreateNewGateway();
        smartFormFe_Create.enterGatewayNameNoReturn(value.get("Sales", "gateway"));
        Gateway_Create gateway_Create = smartFormFe_Create.clickSaveAndEditGateway();
        gateway_Create.clickGatewayTypeDropdown();
        gateway_Create.selectDrilldownOption("Dummy Gateway");
        gateway_Create.enterGatewayNickName(value.get("Sales", "gateway"));
        smartFormFe_Create = gateway_Create.clickSaveToOrderform();
        smartFormFe_Create.dialogBox.clickGrid(); 
        
        if(smartFormFe_Create.verifyGateway2(value.get("Sales", "gateway"))==null)
        {
            fail("couldn't find gateway");
        }
        
        smartFormFe_Create.clickSave();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "orderForm"));


        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "orderForm"))==null)
        {
            fail("couldn't find smartform");
        }        

       
      

        
    }
}