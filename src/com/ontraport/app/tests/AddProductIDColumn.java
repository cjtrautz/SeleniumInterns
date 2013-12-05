package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.pages.Purchase_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddProductIDColumn extends AbstractTest
{
    @Test
    public void testAddProductIDColumn ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Product_ListAll product_ListAll = contactListAll.menuPrimary.clickProductListAll();
        product_ListAll.formColumnManager.open();
        product_ListAll.formColumnManager.openFieldPane();
        product_ListAll.formColumnManager.clickField("Product Id");
        product_ListAll.formColumnManager.clickCheckMark();
        
        //verify its there
        if (contactListAll.verifyColumn("Product Id")==null)
        {
            fail("couldn't find column");
        }
    }
}
