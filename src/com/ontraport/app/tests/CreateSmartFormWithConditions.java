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

public class CreateSmartFormWithConditions extends AbstractTest
{
    @Test
    public void testCreateSmartFormWithConditions () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        smartFormFe_Create.sendSmartFormName(value.get("SmartForms", "conditions"));
        smartFormFe_Create.clickConditions();
        smartFormFe_Create.dialogBox.clickAddRuleFields();
        smartFormFe_Create.dialogBox.clickIfConditionDropDown();
        smartFormFe_Create.dialogBox.selectIfOption("First Name");
        smartFormFe_Create.dialogBox.clickIfConditionOperatorDropDown();
        smartFormFe_Create.dialogBox.selectIfOption("Contains");
        smartFormFe_Create.dialogBox.enterIfValue("abc");
        smartFormFe_Create.dialogBox.clickOutcomeActionDropDown();
        smartFormFe_Create.dialogBox.selectThenOption("Hide");
        smartFormFe_Create.dialogBox.clickOutcomeFieldDropDown();
        smartFormFe_Create.dialogBox.selectThenOption("Last Name");
        smartFormFe_Create.dialogBox.clickSaveCondition();
        smartFormFe_Create.dialogBox.clickAddRuleRedirect();
        smartFormFe_Create.dialogBox.clickIfConditionDropDown();
        smartFormFe_Create.dialogBox.selectIfOption("First Name");
        smartFormFe_Create.dialogBox.clickIfConditionOperatorDropDown();
        smartFormFe_Create.dialogBox.selectIfOption("Ends With");
        smartFormFe_Create.dialogBox.enterIfValue("abc");
        smartFormFe_Create.dialogBox.enterRedirectSite("http://www.google.com");
        smartFormFe_Create.dialogBox.clickSaveCondition();
        smartFormFe_Create.dialogBox.clickDone();
        smartFormFe_ListAll = smartFormFe_Create.clickSave();
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "conditions"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "conditions"))==null)
        {
            fail("couldn't find smartform");
        }
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "conditions"));
        smartFormFe_Create.clickConditions();
        if(smartFormFe_Edit.dialogBox.verifyShowOrHideFields("Hide", "Last Name", "First Name", "contains", "abc")==null)
        {
            fail("couldnt find title field");
        }
        
        if(smartFormFe_Edit.dialogBox.verifyRedirectOnSubmitRule("First Name", "Ends-with", "abc", "http://www.google.com")==null)
        {
            fail("couldnt find title field");
        }
    }
}
