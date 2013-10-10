package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteOrderForm  extends AbstractTest
{
    @Test
    public void testDeleteOrderForm ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find("SelOrderform");
        smartFormFe_ListAll.selectAllOnPage();
        smartFormFe_ListAll.drawerActions.clickDeleteSmartForm();
        smartFormFe_ListAll.dialogBox.clickOk();
        
        //verify
        if(smartFormFe_ListAll.verifyNoSmartForm()==null)
        {
            fail("deleted order form found");
        }
        
        Product_ListAll product_ListAll = smartFormFe_ListAll.menuPrimary.clickProductListAll();
        product_ListAll.formSearch.find("Dollar");
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
