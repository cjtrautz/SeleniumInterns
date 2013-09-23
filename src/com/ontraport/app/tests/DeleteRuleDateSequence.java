package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRuleDateSequence extends AbstractTest
{
    @Test
    public void testDeleteRuleDateSequence ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        sequence_ListAll.formSearch.find("SelRuleDateSequence");
        sequence_ListAll.selectAllOnPage();
        sequence_ListAll.drawerActions.clickDeleteSequences();
        sequence_ListAll.dialogBox.clickOk();
        //verify
        
    }
}
