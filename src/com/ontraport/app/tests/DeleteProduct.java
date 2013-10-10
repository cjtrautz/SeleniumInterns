package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteProduct extends AbstractTest
{
    @Test
    public void testDeleteProduct ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Product_ListAll product_ListAll = contactListAll.menuPrimary.clickProductListAll();
        product_ListAll.formSearch.find("SelProduct");
        product_ListAll.selectAllOnPage();
        product_ListAll.drawerActions.clickDeleteProduct();
        product_ListAll.dialogBox.clickOk();
        //verify
        if(product_ListAll.verifyNoProduct()==null)
        {
            fail("deleted [roduct found");
        }
    }
}
