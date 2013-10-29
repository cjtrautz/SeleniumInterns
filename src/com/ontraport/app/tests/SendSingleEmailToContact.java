package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SendSingleEmailToContact extends AbstractTest
{
    @Test
    public void testDeleteContact ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("SelFirstName");
        contact_Create.enterLastName("SelLastName");
        contact_Create.enterEmail("Sel@email.com");
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find("Sel@email.com");
        
       //verify that the contact Exists
        if(contactListAll.verifyContact("Sel@email.com")==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_Edit = contactListAll.clickContact("Sel@email.com");
        if(contact_Edit.verifyFieldValue("Sel@email.com")==null)
        {
            fail("couldnt find contact email");
        }
        if(contact_Edit.verifyFieldValue("SelFirstName")==null)
        {
            fail("couldnt find contact first name");
        }
        if(contact_Edit.verifyFieldValue("SelLastName")==null)
        {
            fail("couldnt find contact last name");
        }

        contactListAll.formSearch.clear();
        contactListAll.formSearch.find("Sel@email.com");
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
