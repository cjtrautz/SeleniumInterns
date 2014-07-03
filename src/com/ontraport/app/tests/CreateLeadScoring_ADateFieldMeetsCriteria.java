package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_ScoreEdit;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateLeadScoring_ADateFieldMeetsCriteria extends AbstractTest
{
    @Test
    public void testCreateLeadScoring_ADateFieldMeetsCriteria ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_ScoreEdit contact_ScoreEdit = contact_Settings.clickLeadScoring();
        contact_ScoreEdit.clickAddNewCondition();
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown("Field is this value");
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.enterDropDownCondition(1, value.get("Fields", "Date_Field"));
        contact_ScoreEdit.selectDrillDown(value.get("Fields", "Date_Field"));
        contact_ScoreEdit.clickDropDownCondition(2);
        contact_ScoreEdit.selectDrillDown("Equal To");
        contact_ScoreEdit.enterDropDownConditionInput(3, "1/1/2016");
        contact_ScoreEdit.enterPointScore("25");
        contact_ScoreEdit.enterDegradationPercent("10");
        contactListAll = contact_ScoreEdit.clickSave();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        contact_ScoreEdit = contact_Settings.clickLeadScoring();
        //verify new section is in the field editor
        if(contact_ScoreEdit.verifyConditionDrillDown(value.get("Fields", "Date_Field"))==null)
        {
            fail("didnt Select date field");
        }
        if(contact_ScoreEdit.verifyConditionDrillDown("Equal To", 2)==null)
        {
            fail("didnt Select equal to");
        }
        if(contact_ScoreEdit.verifyConditionDrillDown("01/01/2016", 3)==null)
        {
            fail("didnt Select date");
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
