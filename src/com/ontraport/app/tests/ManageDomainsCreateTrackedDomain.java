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

public class ManageDomainsCreateTrackedDomain extends AbstractTest
{
    @Test
    public void testManageDomainsCreateTrackedDomain () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        TrackedDomain_ListAll trackedDomain_ListAll = contactListAll.menuPrimary.clickTrackedDomainListAll();
        TrackedDomain_Create trackedDomain_Create = trackedDomain_ListAll.clickNewTrackedDomain();
//        trackedDomain_Create.enterURL(AbstractSuite.UNIQUE + ".com");
//        trackedDomain_ListAll = trackedDomain_Create.clickSave();
//        trackedDomain_ListAll.formSearch.find(AbstractSuite.UNIQUE + ".com");
//        if(trackedDomain_ListAll.verifyDomain(AbstractSuite.UNIQUE + ".com")==null)
//        {
//            fail("couldnt find domain");
//        }
//        TrackedDomain_Edit trackedDomain_Edit = trackedDomain_ListAll.clickDomain(AbstractSuite.UNIQUE + ".com");
//        if(trackedDomain_Edit.verifyURL(AbstractSuite.UNIQUE + ".com")==null)
//        {
//            fail("couldnt find url");
//        }
    }
}
