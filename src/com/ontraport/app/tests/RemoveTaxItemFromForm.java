package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.pages.Taxes_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class RemoveTaxItemFromForm extends AbstractTest
{
    @Test
    public void removeTaxItemFromForm () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll formsListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        formsListAll.formSearch.find(value.get("SmartForms", "orderForm"));
        
        SmartFormFe_Edit smartFormEdit = formsListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormEdit.clickProductForm();
        smartFormEdit.removeTaxItem("SelTax" + AbstractSuite.UNIQUE);
        
        formsListAll = smartFormEdit.clickSave();
        
        formsListAll.formSearch.find(value.get("SmartForms", "orderForm"));
        smartFormEdit = formsListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormEdit.clickProductForm();
        
        if (!(smartFormEdit.verifyNoTax("SelTax" + AbstractSuite.UNIQUE) == null))
            {
                fail("tax still exists");
            };
    }
}