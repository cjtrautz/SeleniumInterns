package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.ApiSettings_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.pages.Tag_Create;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateOrderform extends AbstractTest
{
    @Test
    public void testCreateOrderform () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.clickSmartFormName();
        smartFormFe_Create.dialogBox.enterName("SelOrderform");
        smartFormFe_Create.dialogBox.clickSave();
        smartFormFe_Create.clickSellProducts();
        smartFormFe_Create.clickAddProduct();
        smartFormFe_Create.dialogBox.clickProductName();
        smartFormFe_Create.dialogBox.selectCreateNew();
        smartFormFe_Create.dialogBox.enterProductName("Dollar");
        smartFormFe_Create.dialogBox.clickGrid();
        smartFormFe_Create.dialogBox.enterPrice("1");
        smartFormFe_Create.dialogBox.clickDone();
        smartFormFe_Create.clickAddPaymentMethod();
        smartFormFe_Create.clickGatewayDropDown();
        smartFormFe_Create.selectDropDown("SelGateway");
        smartFormFe_Create.clickSave();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find("SelOrderform");

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm("SelOrderform")==null)
        {
            fail("couldn't find smartform");
        }
        
    }
}
