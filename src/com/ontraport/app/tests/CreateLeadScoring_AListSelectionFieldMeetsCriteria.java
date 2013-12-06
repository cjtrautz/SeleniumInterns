package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_ScoreEdit;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateLeadScoring_AListSelectionFieldMeetsCriteria extends AbstractTest
{
    @Test
    public void testCreateLeadScoring_AListSelectionFieldMeetsCriteria ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_ScoreEdit contact_ScoreEdit = contact_Settings.clickLeadScoring();
        contact_ScoreEdit.clickAddNewCondition();
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown("Field is this value");
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.enterDropDownCondition(1, value.get("Fields", "List_Field"));
        contact_ScoreEdit.selectDrillDown(value.get("Fields", "List_Field"));
        contact_ScoreEdit.clickDropDownCondition(2);
        contact_ScoreEdit.selectDrillDown("Equal To");
        contact_ScoreEdit.clickDropDownCondition(3);
        contact_ScoreEdit.selectDrillDown(value.get("Fields", "list_selection_first_option"));
        contact_ScoreEdit.enterPointScore("25");
        contact_ScoreEdit.enterDegradationPercent("10");
        contactListAll = contact_ScoreEdit.clickSave();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        contact_ScoreEdit = contact_Settings.clickLeadScoring();
        //verify new section is in the field editor
        if(contact_ScoreEdit.verifyConditionDrillDown(value.get("Fields", "List_Field"))==null)
        {
            fail("didnt Select date sequence");
        }
        if(contact_ScoreEdit.verifyConditionDrillDown("Equal To", 2)==null)
        {
            fail("didnt Select date sequence");
        }
        if(contact_ScoreEdit.verifyConditionDrillDown(value.get("Fields", "list_selection_first_option"), 3)==null)
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
