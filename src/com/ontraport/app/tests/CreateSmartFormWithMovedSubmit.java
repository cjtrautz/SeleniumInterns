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

public class CreateSmartFormWithMovedSubmit extends AbstractTest
{
    @Test
    public void testCreateSmartFormWithMovedSubmit () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.clickSmartFormName();
        smartFormFe_Create.dialogBox.enterName(value.get("SmartForms", "move_submit"));
        smartFormFe_Create.dialogBox.clickSave();
        smartFormFe_Create.dragAndDropSubmit(-200);
        smartFormFe_ListAll = smartFormFe_Create.clickSave();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "move_submit"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "move_submit"))==null)
        {
            fail("couldn't find smartform");
        }
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "move_submit"));
        if(smartFormFe_Edit.verifySubmitButton()==null)
        {
            fail("couldnt find title field");
        }
    }
}
