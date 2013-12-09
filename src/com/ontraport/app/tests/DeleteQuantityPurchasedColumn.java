package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteQuantityPurchasedColumn extends AbstractTest
{
    @Test
    public void testDeleteQuantityPurchasedColumn () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Product_ListAll product_ListAll = contactListAll.menuPrimary.clickProductListAll();
        product_ListAll.formColumnManager.open("Quantity Purchased");
        product_ListAll.formColumnManager.clickTrashCan();
        
        //verify its gone
        if(contactListAll.verifyNotColumn("Quantity Purchased")==null)
        {
            fail("found column");
        }
        
    }
}
