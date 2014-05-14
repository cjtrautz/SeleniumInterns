package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateOrderformWithTaxAndShipping extends AbstractTest
{
    @Test
    public void testCreateOrderformWithTaxAndShipping () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.sendSmartFormName(value.get("SmartForms", "tax_orderform"));
        smartFormFe_Create.clickSellProducts();
        smartFormFe_Create.clickAddProduct();
        smartFormFe_Create.dialogBox.clickProductName();
        smartFormFe_Create.dialogBox.selectProductDrillDown(value.get("Sales", "product"));
        smartFormFe_Create.dialogBox.clickDone();
        smartFormFe_Create.clickAddShippingMethod();
        smartFormFe_Create.clickShippingNameInput();
        smartFormFe_Create.clickCreateNew();
        smartFormFe_Create.enterShippingName(value.get("SmartForms", "shipping"));
        smartFormFe_Create.enterShippingPrice(value.get("SmartForms", "shipping_price"));
        smartFormFe_Create.clickAddTaxOption();
        smartFormFe_Create.clickTaxNameInput();
        smartFormFe_Create.clickCreateNew();
        smartFormFe_Create.enterTaxName(value.get("SmartForms", "tax"));
        smartFormFe_Create.enterTaxPercent(value.get("SmartForms", "tax_rate"));
        smartFormFe_Create.clickAddPaymentMethod();
        smartFormFe_Create.clickGatewayDropDown();
        smartFormFe_Create.selectDropDown(value.get("Sales", "gateway_paypal_payments_pro"));
        smartFormFe_Create.clickSave();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "tax_orderform"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "tax_orderform"))==null)
        {
            fail("couldn't find smartform");
        }
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "tax_orderform"));
        smartFormFe_Edit.clickPaymentMethod();
        if(smartFormFe_Edit.verifyTaxName(value.get("SmartForms", "tax"))==null)
        {
            fail("couldn't find tax");
        }
        if(smartFormFe_Edit.verifyTaxRate(value.get("SmartForms", "tax_rate_format"))==null)
        {
            fail("couldn't find tax rate");
        }
        if(smartFormFe_Edit.verifyShippingName(value.get("SmartForms", "shipping"))==null)
        {
            fail("couldn't find rule");
        }
        if(smartFormFe_Edit.verifyShippingPrice(value.get("SmartForms", "shipping_price_format"))==null)
        {
            fail("couldn't find if");
        }

        
    }
}
