package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteSmartFormWithConditions  extends AbstractTest
{
    @Test
    public void testDeleteSmartFormWithConditions ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "conditions"));
        smartFormFe_ListAll.selectAllOnPage();
        smartFormFe_ListAll.drawerActions.clickDeleteSmartForm();
        smartFormFe_ListAll.dialogBox.clickOk();
        
        //verify
        if(smartFormFe_ListAll.verifyNoSmartForm()==null)
        {
            fail("deleted order form found");
        }
        
    }
}
