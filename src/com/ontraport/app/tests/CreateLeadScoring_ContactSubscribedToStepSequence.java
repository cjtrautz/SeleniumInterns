package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Import;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_ScoreEdit;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Field_Editor;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractTest;

public class CreateLeadScoring_ContactSubscribedToStepSequence extends AbstractTest
{
    @Test
    public void testCreateLeadScoring_ContactSubscribedToStepSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_ScoreEdit contact_ScoreEdit = contact_Settings.clickLeadScoring();
        contact_ScoreEdit.clickAddNewCondition();
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown("If Contact is subscribed to Sequence");
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown("SelEmailStepSequence");
        contact_ScoreEdit.enterPointScore("25");
        contact_ScoreEdit.enterDegradationPercent("10");
        contactListAll = contact_ScoreEdit.clickSave();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        contact_ScoreEdit = contact_Settings.clickLeadScoring();
        //verify new section is in the field editor
        if(contact_ScoreEdit.verifyText("If Contact is subscribed to Sequence:")==null)
        {
            fail("didnt Select If Contact is subscribed to Sequence");
        }
        if(contact_ScoreEdit.verifyConditionDrillDown("SelEmailStepSequence")==null)
        {
            fail("didnt Select step sequence");
        }
        if(contact_ScoreEdit.verifyPointScore("25")==null)
        {
            fail("didnt enter point score");
        }
        if(contact_ScoreEdit.verifyDegradationPercent("10")==null)
        {
            fail("didnt enter point degredation");
        }
        
    }
}