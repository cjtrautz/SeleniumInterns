package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteDateCreatedColumn extends AbstractTest
{
    @Test
    public void testDeleteDateCreatedColumn () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Product_ListAll product_ListAll = contactListAll.menuPrimary.clickProductListAll();
        product_ListAll.formColumnManager.open("Date Created");
        product_ListAll.formColumnManager.clickTrashCan();
        
        //verify its gone
        if(contactListAll.verifyNotColumn("Date Created")==null)
        {
            fail("found column");
        }
        
    }
}
