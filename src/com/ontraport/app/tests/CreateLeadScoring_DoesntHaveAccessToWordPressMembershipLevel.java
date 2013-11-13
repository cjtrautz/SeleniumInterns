package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_ScoreEdit;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateLeadScoring_DoesntHaveAccessToWordPressMembershipLevel extends AbstractTest
{
    @Test
    public void testCreateLeadScoring_DoesntHaveAccessToWordPressMembershipLevel ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Settings contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        Contact_ScoreEdit contact_ScoreEdit = contact_Settings.clickLeadScoring();
        contact_ScoreEdit.clickAddNewCondition();
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.enterDropDownCondition(1, "word");
        contact_ScoreEdit.selectDrillDown("Does not have access to WordPress Membership Level");
        contact_ScoreEdit.clickDropDownCondition();
        contact_ScoreEdit.selectDrillDown2(value.get("WordPress", "wordpress_domain"));
        contact_ScoreEdit.selectDrillDown(value.get("WordPress", "level"));
        contact_ScoreEdit.enterPointScore("25");
        contact_ScoreEdit.enterDegradationPercent("10");
        contactListAll = contact_ScoreEdit.clickSave();
        contact_Settings = contactListAll.menuPrimary.clickContactSettings();
        contact_ScoreEdit = contact_Settings.clickLeadScoring();
        //verify new section is in the field editor
        if(contact_ScoreEdit.verifyText("Does not have access to ")==null)
        {
            fail("didnt Select Has visited website");
        }
        if(contact_ScoreEdit.verifyConditionDrillDownContains(value.get("WordPress", "level"))==null)
        {
            fail("didnt Select ANY WEBSITE");
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
