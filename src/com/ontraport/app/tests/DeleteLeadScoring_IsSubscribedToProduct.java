package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_ScoreEdit;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractTest;

public class DeleteLeadScoring_IsSubscribedToProduct extends AbstractTest
{
    @Test
    public void testDeleteLeadScoring_IsSubscribedToProduct ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_ScoreEdit contact_ScoreEdit = contact_Settings.clickLeadScoring();
        contact_ScoreEdit.clickDeleteCondition();
        contact_ScoreEdit.enterDegradationPercent("0");
        contactListAll = contact_ScoreEdit.clickSave();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        contact_ScoreEdit = contact_Settings.clickLeadScoring();
        //verify new section is in the field editor
        if(contact_ScoreEdit.verifyNoText("Is subscribed to ")==null)
        {
            fail("didnt delet If Contact is not subscribed to Sequence");
        }
        if(contact_ScoreEdit.verifyDegradationPercent("0")==null)
        {
            fail("didnt enter point degredation");
        }
        
    }
}
