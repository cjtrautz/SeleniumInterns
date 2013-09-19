package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateContact extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("SelFirstName");
        contact_Create.enterLastName("SelLastName");
        contact_Create.enterEmail("Sel@email.com");
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find("SelFirstName");
        
       //verify that the contact Exists
        if(contactListAll.verifyContact("SelFirstName " + "SelLastName")==null)
        {
            fail("couldnt find created contact");
        }
        
    }
}
