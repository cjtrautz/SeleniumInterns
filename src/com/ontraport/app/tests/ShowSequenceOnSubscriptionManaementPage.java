package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class ShowSequenceOnSubscriptionManaementPage extends AbstractTest
{
    @Test
    public void testShowSequenceOnSubscriptionManaementPage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();

        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        
        sequence_Edit.clickSettings();
        sequence_Edit.drawerActions.checkShowSequenceOnSubscriptionManaementPage();
        sequence_Edit.drawerActions.clickSaveSettings();
        sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));
        sequence_Edit = sequence_ListAll.clickSequence(value.get("Sequences", "step_rule_sequence"));
        sequence_Edit.clickSettings();
        
        if(sequence_Edit.drawerActions.verifyShowSequenceOnSubscriptionManaementPageChecked()==null)
        {
            fail("couldnt find checked Weekend box");
        }
        sequence_Edit.drawerActions.uncheckShowSequenceOnSubscriptionManaementPage();
        sequence_Edit.drawerActions.clickSaveSettings();
        sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "step_rule_sequence"));

    }
}
