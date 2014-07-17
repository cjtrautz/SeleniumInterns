package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateOrderform extends AbstractTest
{
    @Test
    public void testCreateOrderform () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.sendSmartFormName(value.get("SmartForms", "orderForm"));
        smartFormFe_Create.clickSellProducts();
        smartFormFe_Create.clickAddProduct();
        smartFormFe_Create.dialogBox.clickProductName();
        smartFormFe_Create.dialogBox.selectCreateNew();
        smartFormFe_Create.dialogBox.enterProductName("Dollar" + AbstractSuite.UNIQUE);
        smartFormFe_Create.dialogBox.clickGrid();
        smartFormFe_Create.dialogBox.enterPrice("6.00");
        smartFormFe_Create.dialogBox.clickTaxableDropDown();
        smartFormFe_Create.dialogBox.select("true");
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
        smartFormFe_Create.selectDropDown("SelGateway");
        smartFormFe_Create.clickGatewayDropDown();
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
        smartFormFe_Edit.clickSettings();
        smartFormFe_Edit.clickTagDropDown();
        smartFormFe_Edit.selectDropDown(value.get("Contacts", "tag"));
        smartFormFe_Edit.clickSequenceDropDown();
        smartFormFe_Edit.selectDropDown(value.get("Sequences", "step_rule_sequence"));
        smartFormFe_Edit.clickAddRule();
        smartFormFe_Edit.enterRuleName(value.get("SmartForms", "rule_name"));
        smartFormFe_Edit.clickThenDropDown();
        smartFormFe_Edit.enterThenInputForDropDown("Change", 1);
        smartFormFe_Edit.selectDropDown("Change the value of a field");
        smartFormFe_Edit.clickThenDropDown();
        smartFormFe_Edit.selectDropDown("Office Phone");
        smartFormFe_Edit.enterThenInput("5555555", 2);
        smartFormFe_Edit.clickRuleSave();
        smartFormFe_Edit.clickSave();  
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "orderForm"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "orderForm"))==null)
        {
            fail("couldn't find smartform");
        }
        smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormFe_Edit.clickSettings();
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
        if(smartFormFe_Edit.verifyThenInput("Office Phone", 1)==null)
        {
            fail("couldn't find then");
        }
        if(smartFormFe_Edit.verifyThenInput("5555555", 2)==null)
        {
            fail("couldn't find then 2");
        }
        
    }
}
