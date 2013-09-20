package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_Create;
import com.ontraport.app.pages.Product_Edit;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateProduct extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Product_ListAll product_ListAll = contactListAll.menuPrimary.clickProductListAll();
        Product_Create product_Create = product_ListAll.clickNewProduct();
        product_Create.enterProductName("SelProduct");
        product_Create.enterProductPrice("800.00");
        product_ListAll = product_Create.clickSave();
        product_ListAll.formSearch.find("SelProduct");
        
        //verify product exists
        if(product_ListAll.verifyProduct("SelProduct")==null)
        {
            fail("couldnt find product");
        }

        Product_Edit product_Edit = product_ListAll.clickProduct("SelProduct");
        if(product_Edit.verifyName("SelProduct")==null)
        {
            fail("couldnt find product name");
        }
        if(product_Edit.verifyPrice("$800.00")==null)
        {
            fail("couldnt find product price");
        }

        
    }
}
