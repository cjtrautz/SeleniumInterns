package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SearchTest extends AbstractTest
{
    @Test
    public void testSearchTest ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("1");
        contact_Create.enterLastName("1");
        contact_Create.enterEmail("1@circle.com");
        contactListAll = contact_Create.clickSave();
        contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("jimmy");
        contact_Create.enterLastName("SearchForMe");
        contact_Create.enterEmail("circle@email.com");
        contactListAll = contact_Create.clickSave();
        contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("a");
        contact_Create.enterLastName("a");
        contact_Create.enterEmail("a@a.circle");
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find("SearchForMe");
        
       //verify that the contact Exists
        if(contactListAll.verifyContact("circle@email.com")==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_Edit = contactListAll.clickFirstContact();
        if(contact_Edit.verifyFieldValue("circle@email.com")==null)
        {
            fail("couldnt find contact email");
        }
        if(contact_Edit.verifyFieldValue("jimmy")==null)
        {
            fail("couldnt find contact first name");
        }
        if(contact_Edit.verifyFieldValue("SearchForMe")==null)
        {
            fail("couldnt find contact last name");
        }
        contactListAll = contact_Edit.clickBack();
        contactListAll.formSearch.find("blahblahblah");
        contactListAll.formSearch.clear();
        if(contactListAll.formSearch.verifyEmpty()==null)
        {
            fail("couldnt find empty search");
        }
        contactListAll.formSearch.findMagnifyingGlass("SearchForMe");
        contact_Edit = contactListAll.clickFirstContact();
        if(contact_Edit.verifyFieldValue("SearchForMe")==null)
        {
            fail("couldnt find contact title name");
        }
        contactListAll = contact_Edit.clickBack();
        contactListAll.formSearch.findClickingOff("SearchForMe");
        contact_Edit = contactListAll.clickFirstContact();
        if(contact_Edit.verifyFieldValue("SearchForMe")==null)
        {
            fail("couldnt find contact title name");
        }
        contactListAll = contact_Edit.clickBack();
        contactListAll.formSearch.find("circle");
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }

        contactListAll.formSearch.clear();
    }
}
