package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SalesReport_Recharge;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class RetryTransactionsDecimal extends AbstractTest
{
    @Test
    public void testRetryTransactionsDecimal () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        SalesReport_Recharge salesReport_Recharge = salesReport_Settings.clickRechargeSettings();
        salesReport_Recharge.enterRetryCreditCardsEvery(".");
        salesReport_Settings = salesReport_Recharge.clickSave();
        
        if(salesReport_Recharge.verifyRetryCardError()==null)
        {
            fail("allowed save");
        }
    }
}
