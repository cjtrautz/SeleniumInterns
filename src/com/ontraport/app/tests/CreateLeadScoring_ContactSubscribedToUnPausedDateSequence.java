package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_ScoreEdit;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateLeadScoring_ContactSubscribedToUnPausedDateSequence extends AbstractTest
{
    @Test
    public void testCreateLeadScoring_ContactSubscribedToUnPausedDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_ScoreEdit contact_ScoreEdit = contact_Settings.clickLeadScoring();
        contact_ScoreEdit.clickAddNewCondition();
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown("Subscription to a sequence is unpaused");
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown(value.get("Sequences", "date_rule_sequence"));
        contact_ScoreEdit.enterPointScore("25");
        contact_ScoreEdit.enterDegradationPercent("10");
        contactListAll = contact_ScoreEdit.clickSave();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        contact_ScoreEdit = contact_Settings.clickLeadScoring();
        //verify new section is in the field editor
        if(contact_ScoreEdit.verifyText("Subscription ")==null)
        {
            fail("didnt Select If Contact is subscribed to paused Sequence");
        }
        if(contact_ScoreEdit.verifyText(" is unpaused")==null)
        {
            fail("didnt Select If Contact is subscribed to unpaused Sequence");
        }
        if(contact_ScoreEdit.verifyConditionDrillDown(value.get("Sequences", "date_rule_sequence"))==null)
        {
            fail("didnt Select date sequence");
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
