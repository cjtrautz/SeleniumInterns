package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
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
        
    }
}
