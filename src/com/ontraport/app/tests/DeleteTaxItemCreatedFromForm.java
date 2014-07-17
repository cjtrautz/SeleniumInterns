package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.pages.Taxes_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTaxItemCreatedFromForm extends AbstractTest
{
    @Test
    public void testDeleteTaxItemCreatedFromForm ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SalesReport_Settings salesReportSettings = contactListAll.menuPrimary.clickSalesReportSettings();
        
        Taxes_ListAll taxesListAll = salesReportSettings.clickTaxTypes();
        
        taxesListAll.formSearch.find("SelTax" + AbstractSuite.UNIQUE);
        
        if (taxesListAll.verifyTaxItem("SelTax" + AbstractSuite.UNIQUE) == null)
            {
                fail("tax item does not exist");
            };
        taxesListAll.selectAllOnPage();
        taxesListAll.drawerActions.clickDeleteTaxItem();
        taxesListAll.dialogBox.clickOk();
        
        if (taxesListAll.verifyNoTax() == null)
        {
            fail("tax item still exists");
        }
    }
}
