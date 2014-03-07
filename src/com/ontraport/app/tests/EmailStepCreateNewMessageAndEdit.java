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

public class EmailStepCreateNewMessageAndEdit extends AbstractTest
{
    @Test
    public void testEmailStepCreateNewMessageAndEdit ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        Sequence_CreateStep sequence_CreateStep = sequence_TypeSelection.clickStepSequenceCreate();
        sequence_CreateStep.clickAddEmailStep();
        sequence_CreateStep.openEmailNamePane();
        sequence_CreateStep.selectDrillDownByIndex(1);
        sequence_CreateStep.enterMessageName("VerifyCreateAndEdit");
        Message_Edit message_Edit = sequence_CreateStep.clickSaveAndEdit();

//        message_Edit.enterSendOutName("Selenium");
//        message_Edit.enterReplyToEmail("selenium@email.com");
        message_Edit.openSendFromPane();
        message_Edit.selectSendFrom(1);
        message_Edit.openMailFromPane();
        message_Edit.selectMailFrom(1);
        message_Edit.enterSubject("SelSubject");
        sequence_CreateStep = message_Edit.clickSaveToStep();

        if(sequence_CreateStep.verifyPageFromStepCreate()==null)
        {
            fail("didnt go back to sequence create page");
        }
        if(sequence_CreateStep.verifyEmailName("VerifyCreateAndEdit")==null)
        {
            fail("didnt go back to sequence create page");
        }
        sequence_ListAll = sequence_CreateStep.clickBack();
        Message_ListAll message_ListAll = sequence_ListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find("VerifyCreateAndEdit");
        message_ListAll.selectAllOnPage();
        message_ListAll.drawerActions.clickDeleteMessage();
        message_ListAll.dialogBox.clickOk();
        
        //verify
        if(message_ListAll.verifyNoMessage()==null)
        {
            fail("found deleted message");
        }
        
    }
}
