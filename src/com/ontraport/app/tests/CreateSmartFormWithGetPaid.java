package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateSmartFormWithGetPaid extends AbstractTest
{
    @Test
    public void testCreateSmartFormWithGetPaid () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.clickSmartFormName();
        smartFormFe_Create.dialogBox.enterName(value.get("SmartForms", "get_paid"));
        smartFormFe_Create.dialogBox.clickSave();
        smartFormFe_Create.clickGetPaid();
        smartFormFe_ListAll = smartFormFe_Create.clickSave();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "get_paid"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "get_paid"))==null)
        {
            fail("couldn't find smartform");
        }
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "get_paid"));
        if(smartFormFe_Edit.verifyGetPaid()==null)
        {
            fail("couldnt find title field2");
        }
    }
}
