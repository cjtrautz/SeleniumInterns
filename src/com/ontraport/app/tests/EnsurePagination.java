package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractTest;

public class EnsurePagination extends AbstractTest
{
    @Test
    public void testEnsurePagination ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        int i = 1;
        while(i<101){
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("SelPage" + String.valueOf(i));
        contactListAll = contact_Create.clickSave();
        i++;
        }
        String pages = contactListAll.paginator.getPages();
        System.out.println(pages);
        contactListAll.paginator.clickLastPage();
        if(contactListAll.paginator.verifyPageNumber(pages)==null)
        {
            
            fail("couldnt click last page");
        }
        contactListAll.paginator.clickFirstPage();
        if(contactListAll.paginator.verifyPageNumber("1")==null)
        {
            fail("couldnt click first page");
        }
        contactListAll.paginator.clickNextPage();
        if(contactListAll.paginator.verifyPageNumber("2")==null)
        {
            fail("couldnt click next page");
        }
        contactListAll.paginator.clickPreviousPage();
        if(contactListAll.paginator.verifyPageNumber("1")==null)
        {
            fail("couldnt click previous page");
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(100);
        if(contactListAll.verifyNumberOfContactsPerPage(100)==null)
        {
            fail("couldnt click 100 per page");
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(50);
        if(contactListAll.verifyNumberOfContactsPerPage(50)==null)
        {
            fail("couldnt click 50 per page");
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(25);
        if(contactListAll.verifyNumberOfContactsPerPage(25)==null)
        {
            fail("couldnt click 25 per page");
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(10);
        if(contactListAll.verifyNumberOfContactsPerPage(10)==null)
        {
            fail("couldnt click 10 per page");
        }
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        if(contactListAll.verifyNumberOfContactsPerPage(5)==null)
        {
            fail("couldnt click 5 per page");
        }
        contactListAll.paginator.goToPage("2");
        if(contactListAll.paginator.verifyPageNumber("2")==null)
        {
            fail("couldnt go to page");
        }
        contactListAll.paginator.goToPage("-5");
        if(contactListAll.paginator.verifyPageNumber("2")==null)
        {
            fail("couldnt enter negative number");
        }
        int j=1;
        contactListAll.paginator.toggleRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(25);
        while (j<10)
        {
            contactListAll.formSearch.clear();
            contactListAll.formSearch.find("SelPage" + String.valueOf(j));
            contactListAll.selectAllOnPage();
            contactListAll.drawerActions.clickDeleteContacts();
            contactListAll.dialogBox.clickOk();
            j++;
        }
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }

    }
}
