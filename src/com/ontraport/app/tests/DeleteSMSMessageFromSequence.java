package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.pages.Sequence_ListAll;

public class DeleteSMSMessageFromSequence extends AbstractTest
{
    @Test
    public void testDeleteSMSMessageFromSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        sequence_ListAll.formSearch.find(value.get("Sequences", "sms_from_sequence"));
     // I dont know why but it refuses to actually click in step below. No fail. Works in DeleteSMSMessage.java
        sequence_ListAll.selectAllOnPage(); 
        sequence_ListAll.drawerActions.clickDeleteSequences();
        sequence_ListAll.dialogBox.clickOk();
        
        //verify
        if(sequence_ListAll.verifyNoSequence()==null)
        {
            fail("found deleted sequence");
        }
        
        Message_ListAll message_ListAll = sequence_ListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "sms_from_sequence"));
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
