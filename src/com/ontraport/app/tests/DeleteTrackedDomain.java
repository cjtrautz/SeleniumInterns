package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.TrackedDomain_Create;
import com.ontraport.app.pages.TrackedDomain_Edit;
import com.ontraport.app.pages.TrackedDomain_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteTrackedDomain extends AbstractTest
{
    @Test
    public void testDeleteTrackedDomain () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackedDomain_ListAll trackedDomain_ListAll = contactListAll.menuPrimary.clickTrackedDomainListAll();
        trackedDomain_ListAll.formSearch.find(AbstractSuite.UNIQUE + ".com");
        trackedDomain_ListAll.selectAll();
        trackedDomain_ListAll.drawerActions.clickDeleteTrackedDomain();
        trackedDomain_ListAll.dialogBox.clickOk();
        
        if(trackedDomain_ListAll.verifyNoDomain()==null)
        {
            fail("couldnt find url");
        }
    }
}
