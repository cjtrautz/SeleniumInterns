package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteSmartFormField extends AbstractTest
{
    @Test
    public void testDeleteSmartFormField () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "add_field"));
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "add_field"));
        smartFormFe_Edit.clickField("title");
        smartFormFe_Edit.deleteActiveField();
        driver.switchTo().alert().accept();
        smartFormFe_Edit.clickSave();
        smartFormFe_ListAll = smartFormFe_Edit.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "add_field"));
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "add_field"))==null)
        {
            fail("couldn't find smartform");
        }
        smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "add_field"));
        if(smartFormFe_Edit.verifyField(4)==null)
        {
            fail("didnt delete field");
        }
    }
}
