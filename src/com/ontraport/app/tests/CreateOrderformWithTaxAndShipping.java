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
    public void testCreateOrderform () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.clickSmartFormName();
        smartFormFe_Create.dialogBox.enterName(value.get("SmartForms", "tax_orderform"));
        smartFormFe_Create.dialogBox.clickSave();
        smartFormFe_Create.clickSellProducts();
        smartFormFe_Create.clickAddProduct();
        smartFormFe_Create.dialogBox.clickProductName();
        smartFormFe_Create.dialogBox.selectProductDrillDown(value.get("Sales", "product"));
        smartFormFe_Create.dialogBox.clickDone();
        smartFormFe_Create.clickAddPaymentMethod();
        smartFormFe_Create.clickGatewayDropDown();
        smartFormFe_Create.selectDropDown(value.get("Sales", "gateway_paypal_payments_pro"));
        smartFormFe_Create.clickAddShippingMethod();
        smartFormFe_Create.clickShippingNameInput();
        smartFormFe_Create.clickCreateNew();
        smartFormFe_Create.enterShippingName(value.get("SmartForms", "shipping"));
        smartFormFe_Create.enterShippingPrice(value.get("SmartForms", "shipping_price"));
        smartFormFe_Create.clickAddTaxOption();
        //smartFormFe_Create.clickTaxNameInput();
        smartFormFe_Create.clickCreateNew();
        //smartFormFe_Create.enterTaxName(value.get("SmartForms", "shipping"));
        //smartFormFe_Create.enterTaxPercent(value.get("SmartForms", "shipping_price"));
        smartFormFe_Create.clickSave();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find("SelOrderform");

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm("SelOrderform")==null)
        {
            fail("couldn't find smartform");
        }
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        if(smartFormFe_Edit.verifyTag(value.get("Contacts", "tag"))==null)
        {
            fail("couldn't find tag");
        }
        if(smartFormFe_Edit.verifySequence(value.get("Sequences", "step_rule_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        if(smartFormFe_Edit.verifyRule(value.get("SmartForms", "rule_name"))==null)
        {
            fail("couldn't find rule");
        }
        smartFormFe_Edit.clickRule(value.get("SmartForms", "rule_name"));
        if(smartFormFe_Edit.verifyIfDropDown(value.get("Contacts", "tag"))==null)
        {
            fail("couldn't find if");
        }
        if(smartFormFe_Edit.verifyThenInput("First Name", 1)==null)
        {
            fail("couldn't find then");
        }
        if(smartFormFe_Edit.verifyThenInput(value.get("SmartForms", "change"), 2)==null)
        {
            fail("couldn't find then 2");
        }
        
    }
}
