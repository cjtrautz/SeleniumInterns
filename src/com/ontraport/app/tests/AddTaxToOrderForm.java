package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddTaxToOrderForm extends AbstractTest
{
    @Test
    public void addTaskToOrderForm () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll formsListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        formsListAll.formSearch.find(value.get("SmartForms", "orderForm"));
        
        SmartFormFe_Edit smartFormEdit = formsListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormEdit.clickProductForm();
        smartFormEdit.clickAddTaxOption();
        smartFormEdit.clickTaxNameInput();
        smartFormEdit.createNewTaxOption();
        smartFormEdit.enterNewTaxName("SelTax" + AbstractSuite.UNIQUE);
        smartFormEdit.enterNewTaxRate("20");
        
        //Bug with Save button not triggering blur on tax.
        //Need this for now to save the new tax option prior to saving
        smartFormEdit.clickPublishForm();
        
        formsListAll = smartFormEdit.clickSave();
        
        smartFormEdit = formsListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormEdit.clickProductForm();
        
        
        if (smartFormEdit.verifyTaxName("SelTax" + AbstractSuite.UNIQUE) == null)
            {
                fail("tax name not set");
            };
        if (smartFormEdit.verifyTaxRate("20") == null)
            {
                fail("tax rate not set");
            };
    }
}