package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CopyDateSequence extends AbstractTest
{
    @Test
    public void testCopyDateSequence () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        sequence_ListAll.formSearch.find(value.get("Sequences", "date_rule_sequence"));
        sequence_ListAll.selectAllOnPage();
        Sequence_Edit sequence_Edit = sequence_ListAll.drawerActions.clickCopySequence();
        sequence_ListAll.dialogBox.clickOk();
        sequence_ListAll = sequence_Edit.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "copy_date_rule_sequence"));
        
        if(sequence_ListAll.verifySequence(value.get("Sequences", "copy_date_rule_sequence"))==null)
        {
            fail("didnt copy sequence");
        }
        sequence_ListAll.selectAllOnPage();
        sequence_ListAll.drawerActions.clickDeleteSequences();
        sequence_ListAll.dialogBox.clickOk();
        if(sequence_ListAll.verifyNoSequence()==null)
        {
            fail("didnt delete sequence");
        }
    }
}
