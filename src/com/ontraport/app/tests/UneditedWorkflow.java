package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class UneditedWorkflow extends AbstractTest
{
    @Test
    public void testUneditedWorkflow ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.clickAddEmailStep();
        sequence_CreateStep.openEmailNamePane();
        sequence_CreateStep.selectDrillDownByIndex(1);
        sequence_CreateStep.enterMessageName("SelUnedittedWorkflowTime");
        sequence_CreateStep.clickSaveAsDraft();
        sequence_ListAll = sequence_CreateStep.clickBack();
        sequence_ListAll.menuWorkflow.open();
        
        if(sequence_ListAll.menuWorkflow.verifyUneditedWorkflow("Message: SelUnedittedWorkflowTime")==null)
        {
            fail("couldnt find unedited message");
        }
        Message_Edit message_Edit = sequence_ListAll.menuWorkflow.clickUneditedWorkflow("Message: SelUnedittedWorkflowTime");
//        message_Edit.enterSendOutName("Selenium");
//        message_Edit.enterReplyToEmail("selenium@email.com");
        message_Edit.openMailFromPane();
        message_Edit.selectMailFrom(1);
        message_Edit.enterSubject("SelSubject");
        Message_ListAll message_ListAll = message_Edit.clickSave();
        message_ListAll.formSearch.find("SelUnedittedWorkflow");
        message_ListAll.selectAllOnPage();
        message_ListAll.drawerActions.clickDeleteMessage();
        message_ListAll.dialogBox.clickOk();
        message_ListAll.menuWorkflow.open();
        
        if(message_ListAll.menuWorkflow.verifyNoUneditedWorkflow("Message: SelUnedittedWorkflow")==null)
        {
            fail("found edited message");
        }
        sequence_ListAll.menuWorkflow.close();
        
    }
}
