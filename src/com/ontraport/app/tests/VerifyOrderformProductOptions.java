package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class VerifyOrderformProductOptions extends AbstractTest
{
    @Test
    public void testVerifyOrderformProductOptions () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "orderForm"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "orderForm"))==null)
        {
            fail("couldn't find smartform");
        }
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormFe_Edit.clickProductForm();
        smartFormFe_Edit.clickAddOrEditProducts();
        if(smartFormFe_Edit.dialogBox.verifyPrdouctOptions()==null)
        {
            fail("couldnt find orderform product options");
        }

        
    }
}
