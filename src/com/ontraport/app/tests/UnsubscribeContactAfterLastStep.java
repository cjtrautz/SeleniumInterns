package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_CreateStep;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class UnsubscribeContactAfterLastStep extends AbstractTest
{
    @Test
    public void testUnsubscribeContactAfterLastStep ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();

        sequence_ListAll.formSearch.find("SelRuleDateSequence");
        Sequence_Edit sequence_Edit = sequence_ListAll.clickSequence("SelRuleDateSequence");
        
        sequence_Edit.clickSettings();
        sequence_Edit.drawerActions.checkUnsubscribeContactAfterLastStep();
        sequence_Edit.drawerActions.clickSaveSettings();
        sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find("SelRuleDateSequence");
        sequence_Edit = sequence_ListAll.clickSequence("SelRuleDateSequence");
        sequence_Edit.clickSettings();
        
        if(sequence_Edit.drawerActions.verifyUnsubscribeContactAfterLastStepChecked()==null)
        {
            fail("couldnt find checked Weekend box");
        }
        sequence_Edit.drawerActions.uncheckUnsubscribeContactAfterLastStep();
        sequence_Edit.drawerActions.clickSaveSettings();
        sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find("SelRuleDateSequence");

    }
}
