package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Fulfillment_Create;
import com.ontraport.app.pages.Fulfillment_Edit;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Fulfillment_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateFulfillmentFromSequence extends AbstractTest
{
    @Test
    public void testCreateFulfillmentFromSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.enterSequenceName(value.get("Sequences", "sequence_edit_fulfillment"));
        sequence_CreateStep.clickAddFulfillmentStep();
        sequence_CreateStep.openFulfillmentDropDownPane(1);
        sequence_CreateStep.clickCreateNewMessage();
        sequence_CreateStep.enterName(value.get("Admin", "fulfillment_from_sequence"));
        Fulfillment_Edit fulfillment_Edit = sequence_CreateStep.clickSaveAndEditFul();
        fulfillment_Edit.openCompileListTimePane();
        fulfillment_Edit.selectCompileListTime("Monthly");
        fulfillment_Edit.openDayPane();
        fulfillment_Edit.selectTime("5");
        fulfillment_Edit.openFieldPane();
        fulfillment_Edit.selectField("First Name");
        fulfillment_Edit.enterEmailNotification("sel@email.com");
        fulfillment_Edit.enterEmailSubject("selSubject");
        fulfillment_Edit.enterEmailMessage("SelMessage");
        Sequence_Edit sequence_Edit = fulfillment_Edit.clickSaveToSequence();
        if(sequence_CreateStep.verifySequenceName(value.get("Sequences", "sequence_edit_fulfillment"))==null)
        {
            fail("couldn't find message body");
        }
        if(sequence_CreateStep.verifyFulfillmentDropDown(value.get("Admin", "fulfillment_from_sequence"))==null)
        {
            fail("couldnt find fulfillment");
        }
        sequence_CreateStep.menuUser.open();
        Account_View account_View = sequence_CreateStep.menuUser.clickAdmin();
        Fulfillment_ListAll fulfillment_ListAll = account_View.clickFulfillmentManager();
        fulfillment_ListAll.formSearch.find(value.get("Admin", "fulfillment_from_sequence"));
        
        //verify fulfillment exists
        if(fulfillment_ListAll.verifyFulfillment(value.get("Admin", "fulfillment_from_sequence"))==null)
        {
            fail("didnt find fulfillment");
        }
        fulfillment_Edit = fulfillment_ListAll.clickFulfillment(value.get("Admin", "fulfillment_from_sequence"));
        if(fulfillment_Edit.verifyFieldValue(1, "First Name")==null)
        {
            fail("didnt find fulfillment field vale");
        }
        if(fulfillment_Edit.verifyFulfillmentName(value.get("Admin", "fulfillment_from_sequence"))==null)
        {
            fail("didnt find fulfillment list name");
        }
        if(fulfillment_Edit.verifySchedular("Monthly")==null)
        {
            fail("didnt find fulfillment schedular");
        }

    }
}
